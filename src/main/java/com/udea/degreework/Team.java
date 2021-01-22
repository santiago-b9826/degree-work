package com.udea.degreework;

import com.udea.degreework.model.QAPModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicBoolean;

public class Team {
	private List<Worker> workers;
	private List<Pool> pools;
	
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
	
	public void start(QAPModel model, Map<String, Object> configuration) {
        int targetCost = (int)configuration.get("target");
        boolean strictLow = false;
        int nProc = Runtime.getRuntime().availableProcessors();
        System.out.println("Número de procesos = " + nProc);

        //ExecutorService EXEC = Executors.newCachedThreadPool();
        
        ForkJoinPool myPool = new ForkJoinPool(nProc);
        AtomicBoolean kill = new AtomicBoolean(false);

        for (int i = 0; i < workers.size(); i++) {        
        	workers.get(i).setWorker(i, new QAPModel(model), pools, configuration, kill, targetCost, strictLow);
            myPool.submit(workers.get(i));
            //workers.get(i).compute();
            //w.fork();
        }

        for (int i = 0; i < workers.size(); i++)  {
            workers.get(i).join();
        }

        //workers.parallelStream().map(w -> w.solve()).collect(Collectors.toList());
        System.out.println("Team: all workers have finished");
	}

}
