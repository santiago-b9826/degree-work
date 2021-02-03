package com.udea.degreework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.udea.degreework.model.QAPModel;

public class Execution {
	private static final Logger LOGGER = Logger.getLogger( Execution.class.getName() );
	private List<Team> teams = new ArrayList<Team>();
	private Map<String, Object> config = new HashMap<String, Object>();
	private int[] bestConf;
	private int sampleSize;
	private double sumTimes;
	private int sumCosts;

	public Execution(List<Team> teams) {
		this.teams = teams;
	}

	public void loadConfig(Map<String, Object> config) {
		this.config = config;
		validateData();
	}

	public void start() {
		
        QAPModel model = new QAPModel((int)config.get("size"));
        model.loadData(String.valueOf(config.get("filePath")));
        AtomicBoolean kill = new AtomicBoolean(false);
        Object valOrNull = config.get("sampleSize");
    	sampleSize = valOrNull == null ? 1 : (int) valOrNull;
		
    	LOGGER.log(Level.INFO, "Solving QAP instance "+sampleSize+" times");
    	
    	int nProc = Runtime.getRuntime().availableProcessors();
    	ForkJoinPool myPool = new ForkJoinPool(nProc);

    	System.out.println("|-----|----|-----|-----|---------|------------|");
    	System.out.println("|Rep. | MH | TID | WID | Time(s) |    Cost    | sol");
    	System.out.println("|-----|----|-----|-----|---------|------------|");

    	sumTimes = 0;
    	sumCosts = 0;
    	
    	for(int rep = 0; rep < sampleSize; rep++) {
    		
    	
    		double initialTime = System.nanoTime();
        
    		for (int i = 0; i < teams.size(); i++) {
    			teams.get(i).setTeam(i+1, model, config, kill);
    			myPool.submit(teams.get(i));
    		    //teams.get(i).fork();
    		}
        
    		for (int i = 0; i < teams.size(); i++) {
    			teams.get(i).join();
    		}
        
    		int bestCost = Integer.MAX_VALUE;
    		int bestWId = -1;
    		int bestTId = -1;
    		String bestMeta="";
        
    		for (int i = 0; i < teams.size(); i++)  {
    			if(teams.get(i).getBestCost() < bestCost) {
    				bestCost = teams.get(i).getBestCost();
    				bestWId = teams.get(i).getBestWId();
    				bestTId = teams.get(i).getId();
    				bestMeta = teams.get(i).getBestMeta();
    			}
    		}
        
    		bestConf = teams.get(bestTId-1).getBestConf();
              
    		double endTime = System.nanoTime();
    		double time = (endTime-initialTime)/1e9;
    		sumTimes += time;
    		sumCosts += bestCost;
    		
    		System.out.format("| %3d |%4s| %3s | %3s |%9.4f| %10d |" , rep, bestMeta, bestTId, bestWId, time, bestCost);
    		
    		for(int i = 0; i < bestConf.length; i++) {
    			System.out.print(" "+bestConf[i]);
    		}
    		System.out.println("");
    		
    		model.verify(bestConf.length, bestConf);
    		LOGGER.log(Level.INFO,"\nExecution "+rep+": all teams have finished");
    		LOGGER.log(Level.INFO,"Best worker of whole execution is TeamID: "+ bestTId+" workerID: "+bestWId+"-"+bestMeta+" BestCost: "+bestCost);
    		LOGGER.log(Level.INFO,"Execution time: "+time+" ms");
    		for (int i = 0; i < teams.size(); i++)  {
    			teams.get(i).clean();
    			teams.get(i).reinitialize();
    		}
    		kill.set(false);
    	}
    	System.out.println("|-----|----|-----|-----|---------|------------|");
    	System.out.format( "| AVG |    |     |     |%9.4f| %10.1f |\n" ,  sumTimes/sampleSize, sumCosts/(double)sampleSize);
	}

	private void validateData() {
		try {
			if (config.get("target") == null) {
				throw new Exception("Config: target is Expected");
			} else if (config.get("errorRange") == null) {
				throw new Exception("Config: errorRange is Expected");
			} 
//			else if (config.get("") == null) {
//				throw new Exception("Config:  is Expected");
//			}
			
			if (config.get("numberOfTeams") != null) {
				if(teams.size() != (int)config.get("numberOfTeams")) {
					throw new Exception("Config: the expected numberOfTeams is different from the declared teams");
				}
			}
			
			if (config.get("equalNumberOfWorkersPerTeam") != null) {
				boolean equalNumberOfWorkersPerTeam = Boolean.valueOf(String.valueOf(config.get("equalNumberOfWorkersPerTeam")));
			
				if (config.get("numberOfWorkersPerTeam") != null && equalNumberOfWorkersPerTeam) {
					int numberOfWorkersPerTeam = (int) config.get("numberOfWorkersPerTeam");
					for (Team team : teams) {
						if (team.getWorkers().size() != numberOfWorkersPerTeam) {
							throw new Exception("Config: the expected numberOfWorkersPerTeam("+ numberOfWorkersPerTeam +") is different from the declared workers per team(Total: " + team.getWorkers().size() + ")");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, e.toString(), e);
			System.exit(1);
		}
	}
}
