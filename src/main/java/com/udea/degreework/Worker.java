package com.udea.degreework;

import java.util.Date;

public class Worker {
    private double seed;
    String metaheuristicType;
    int poolRequestId;
    int poolUpdateId;
    
    private Date startTime;
    private Date endTime;

    public Worker(double seed) {
        this.seed = seed;
    }
    
    public Worker(double seed, String metaheuristicType, int poolRequestId, int poolUpdateId) {
		this.seed = seed;
		this.metaheuristicType = metaheuristicType;
		this.poolRequestId = poolRequestId;
		this.poolUpdateId = poolUpdateId;
	}
    
	public double getSeed() {
        return seed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
