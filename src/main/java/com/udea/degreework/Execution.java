package com.udea.degreework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import com.udea.degreework.model.QAPModel;

public class Execution {
	private List<Team> teams = new ArrayList<Team>();
	private Map<String, Object> config = new HashMap<String, Object>();
	private int[] bestConf;

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
		
        double initialTime = System.nanoTime();
        
        for (int i = 0; i < teams.size(); i++) {
        	teams.get(i).setTeam(i+1, model, config, kill);
			teams.get(i).fork();
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
        
        for(int i = 0; i < bestConf.length; i++) {
        	System.out.print(" "+bestConf[i]);
        }
        
        double endTime = System.nanoTime();
        
        System.out.print("");
        model.verify(bestConf.length, bestConf);
        System.out.println("\nExecution: all teams have finished");
        System.out.println("Best worker of whole execution is TeamID: "+ bestTId+" workerID: "+bestWId+"-"+bestMeta+" BestCost: "+bestCost);
        System.out.println("Execution time: "+(endTime-initialTime)/1e6+" ms");
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
			System.exit(1);
		}
	}
}
