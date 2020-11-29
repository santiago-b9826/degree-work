package com.udea.degreework.interpreter.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pool implements ASTNode {

	private List<ASTNode> body;
	
	public Pool(List<ASTNode> body) {
		super();
		this.body = body;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) throws Exception {
		Map<String, Object> localSymbolTable = new HashMap<String, Object>();
		for(ASTNode assign : body) {
			assign.execute(localSymbolTable);
		}
		return null;
	}

}
