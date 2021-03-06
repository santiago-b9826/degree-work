package com.udea.degreework;

import com.udea.degreework.model.QAPModel;
import com.udea.degreework.solver.Metaheuristic;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Team extends RecursiveAction{
	private static final Logger LOGGER = Logger.getLogger( Team.class.getName() );
	
	private List<Worker> workers;
	private List<Pool> pools;
	private int id;
	private QAPModel myModel;
	private Map<String, Object> configuration;
	private int bestCost = Integer.MAX_VALUE;
	
	private AtomicBoolean kill;
	
	private SolverStats bestWorkerStats;
    
	
	public SolverStats getBestWorkerStats() {
		return bestWorkerStats;
	}


	public int getBestCost() {
		return bestCost;
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
		int targetCost = (int)configuration.get("target");
        boolean strictLow = false;
        int nProc = Runtime.getRuntime().availableProcessors();
        
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
        int bestIndex = -1;
        
        // Search best worker in team
        for (int i = 0; i < workers.size(); i++)  {
        	if(workers.get(i).getBestCost() < bestCost) {
        		bestCost = workers.get(i).getBestCost();
        		bestIndex = i;
        	}
        }
        bestWorkerStats = workers.get(bestIndex).getSolverStats();  
        bestWorkerStats.setWId(id);
                
        //workers.parallelStream().map(w -> w.solve()).collect(Collectors.toList());
        LOGGER.log(Level.FINE, "Team: all workers in team "+ id +" have finished");
        LOGGER.log(Level.FINE,
        		"Best worker of TEAM "+id+" is  workerID: "+bestWorkerStats.getWId()
        		+"-"+bestWorkerStats.getMhtype() +" BestCost: "	
        				+bestWorkerStats.getBestCost());
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		start();
		
	}
	
	public void clean() {
		bestWorkerStats = null;
		for(Pool p: pools) {
			p.clean();
		}
		for(Worker w: workers) {
			w.clean();
			w.reinitialize();
		}
		
	}

}
