package com.udea.degreework.interpreter.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Worker implements ASTNode {

	private ASTNode quantity;
	private List<ASTNode> body;

	public Worker(ASTNode quantity, List<ASTNode> body) {
		super();
		this.quantity = quantity;
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) throws Exception {
		for (int i = 0; i < (int) this.quantity.execute(null); i++) {
			Map<String, Object> localSymbolTable = new HashMap<String, Object>();
			for (ASTNode assign : body) {
				assign.execute(localSymbolTable);
			}
		}

		return null;
	}

}
