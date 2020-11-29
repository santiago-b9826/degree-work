package com.udea.degreework.interpreter.ast;

import java.util.Map;

public class Assign implements ASTNode {

	private String key;
	private ASTNode value;
	
	public Assign(String key, ASTNode value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable) {
		System.out.printf("%s: %s\n",key, String.valueOf(value.execute(symbolTable)));
		symbolTable.put(key, value.execute(symbolTable));
		return null;
	}

}
