package com.udea.degreework;

import com.udea.degreework.model.QAPModel;
import com.udea.degreework.solver.Metaheuristic;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicBoolean;

public class Team extends RecursiveAction{
	private List<Worker> workers;
	private List<Pool> pools;
	private int id;
	private QAPModel myModel;
	private Map<String, Object> configuration;
	private int bestCost = Integer.MAX_VALUE;
	
	private AtomicBoolean kill;
	
	private int[] bestConf;
    private int bestWId = -1;
    private String bestMeta="";
	
	public int getBestCost() {
		return bestCost;
	}

	public int[] getBestConf() {
		return bestConf;
	}

	public int getBestWId() {
		return bestWId;
	}

	public String getBestMeta() {
		return bestMeta;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team(List<Worker> workers, List<Pool> pools) {
		this.workers = workers;
		this.pools = pools;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public List<Pool> getPools() {
		return pools;
	}
	
	public void setTeam(int i, QAPModel model, Map<String, Object> configuration, AtomicBoolean kill) {
		id = i;
		myModel = model;
		this.configuration = configuration;
		this.kill = kill;
	}
	
	public void start() {
		this.bestConf = new int[myModel.getSize()];
        int targetCost = (int)configuration.get("target");
        boolean strictLow = false;
        int nProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Número de procesos = " + nProc);

        //ExecutorService EXEC = Executors.newCachedThreadPool();
        
        ForkJoinPool myPool = new ForkJoinPool(nProc);
        //AtomicBoolean kill = new AtomicBoolean(false);

        for (int i = 0; i < workers.size(); i++) {        
        	workers.get(i).setWorker((id*100)+i, new QAPModel(myModel), pools, configuration, kill, targetCost, strictLow);
            myPool.submit(workers.get(i));
            //workers.get(i).compute();
            //w.fork();
        }

        for (int i = 0; i < workers.size(); i++)  {
            workers.get(i).join();
        }

        bestCost = Integer.MAX_VALUE;
        bestWId = -1;
        bestMeta="";
        
        for (int i = 0; i < workers.size(); i++)  {
        	if(workers.get(i).getBestCost() < bestCost) {
        		bestCost = workers.get(i).getBestCost();
        		bestWId = workers.get(i).getId();
        		bestMeta = workers.get(i).getMHType().toString();
        	}
        }
        
        //bestConf = new int[myModel.getSize()];
        //bestConf = workers.get(bestWId).getBestConf().clone(); 
        
        bestConf = workers.get(bestWId-(id*100)).getBestConf();
        
        //workers.parallelStream().map(w -> w.solve()).collect(Collectors.toList());
        System.out.println("Team: all workers in team "+ id +" have finished");
        System.out.println("Best worker of TEAM "+id+" is  workerID: "+bestWId+"-"+bestMeta+" BestCost: "+bestCost);
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		start();
		
	}

}
