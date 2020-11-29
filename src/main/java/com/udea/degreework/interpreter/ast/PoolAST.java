package com.udea.degreework.interpreter.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.udea.degreework.Pool;

public class PoolAST implements ASTNode {

	private List<ASTNode> body;

	public PoolAST(List<ASTNode> body) {
		super();
		this.body = body;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) throws Exception {
		Map<String, Object> localSymbolTable = new HashMap<String, Object>();
		for (ASTNode assign : body) {
			assign.execute(localSymbolTable);
		}
		return formatPool(localSymbolTable);
	}

	private Pool formatPool(Map<String, Object> mapObject) {
		
		validateData(mapObject);
		
		String id = String.valueOf(mapObject.get("ID"));
		String policy = String.valueOf(mapObject.get("policy"));
		int size = (int)mapObject.get("size");

		return new Pool(size, id, policy);
	}
	
	private void validateData(Map<String, Object> mapObject) {
		try {
			if (mapObject.get("ID") == null) {
				throw new Exception("Pool: ID is Expected");
			} else if (mapObject.get("policy") == null) {
				throw new Exception("Pool: policy is Expected");
			} else if (mapObject.get("size") == null) {
				throw new Exception("Pool: size is Expected");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
