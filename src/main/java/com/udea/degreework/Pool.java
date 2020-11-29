package com.udea.degreework;

public class Pool {

    private int size;
    private String id;
    private String policy;

    public Pool(int size) {
        this.size = size;
    }

    public Pool(int size, String id, String policy) {
		this.size = size;
		this.id = id;
		this.policy = policy;
	}
    
	public String getId() {
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

//    public synchronized void comm(ContextInformation message){
//
//    }
}
