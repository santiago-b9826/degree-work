package com.udea.degreework.interpreter.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.udea.degreework.Pool;
import com.udea.degreework.Team;
import com.udea.degreework.Worker;

public class TeamAST implements ASTNode {

	private ASTNode quantity;
	private List<ASTNode> workersAST;
	private List<ASTNode> poolsAST;

	public TeamAST(ASTNode quantity, List<ASTNode> workersAST, List<ASTNode> poolsAST) {
		super();
		this.quantity = quantity;
		this.workersAST = workersAST;
		this.poolsAST = poolsAST;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) throws Exception {

		List<Worker> workers = new ArrayList<Worker>();
		List<Pool> pools = new ArrayList<Pool>();
		
		for (int i = 0; i < (int) this.quantity.execute(null); i++) {
			for (ASTNode worker : workersAST) {
				workers.addAll((ArrayList<Worker>) worker.execute(symbolTable));
			}
			for (ASTNode pool : poolsAST) {
				pools.add((Pool)pool.execute(symbolTable));
			}
		}

		return new Team(workers, pools);
	}

}
