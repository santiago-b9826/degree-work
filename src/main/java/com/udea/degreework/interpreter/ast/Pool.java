package com.udea.degreework.interpreter.ast;

import java.util.List;
import java.util.Map;

public class Pool implements ASTNode {

	private List<ASTNode> body;
	
	public Pool(List<ASTNode> body) {
		super();
		this.body = body;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		for(ASTNode n : body) {
			n.execute(symbolTable);
		}
		return null;
	}

}
