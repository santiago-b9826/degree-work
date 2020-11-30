package com.udea.degreework;

import java.util.List;

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

}
