package com.udea.degreework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pool {

    private int size;
    private int id;
    private String policy;
    private List<ContextInformation> pool;

    public Pool(int size) {
        this.size = size;
    }

    public Pool(int size, int id, String policy) {
		this.size = size;
		this.id = id;
		this.policy = policy;
		pool = new ArrayList<>(size);
	}
    
	public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public synchronized void sendInfo(ContextInformation message){
        if (pool.size() < size){
            pool.add(message);
        }else{
            //pool is full
            //int index = pool.stream().min(Comparator.comparing(ContextInformation::getCost)).hashCode();
            int maxCost = -1;
            int maxIndex = -1;
            for(int i = 0; i < pool.size(); i++){
                if(pool.get(i).getCost() > maxCost){
                    maxCost = pool.get(i).getCost();
                    maxIndex = i;
                }
            }
            pool.set(maxIndex, message);
        }
    }

    public synchronized ContextInformation getInfo(){
        return pool.get(ThreadLocalRandom.current().nextInt(pool.size()));
    }
}
