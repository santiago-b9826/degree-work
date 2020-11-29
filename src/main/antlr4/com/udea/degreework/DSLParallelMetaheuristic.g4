grammar DSLParallelMetaheuristic;

@parser::header {
	import java.util.Map;
	import java.util.HashMap;

	import com.udea.degreework.interpreter.ast.ASTNode;
	import com.udea.degreework.interpreter.ast.Assign;
	import com.udea.degreework.interpreter.ast.Constant;
	import com.udea.degreework.interpreter.ast.Pool;
	import com.udea.degreework.interpreter.ast.Worker;
	import com.udea.degreework.interpreter.ast.Team;
}

start: 
	{ 
		List<ASTNode> configBody = new ArrayList<ASTNode>();
		List<ASTNode> executionBody = new ArrayList<ASTNode>();
		Map<String, Object> symbolTable = new HashMap<String, Object>();
	}
	CONFIG OPEN_CURLY_BRACKET 
		(s1=assign { configBody.add($s1.node); })*
	CLOSE_CURLY_BRACKET

	EXECUTION OPEN_CURLY_BRACKET 
		(s2=team { executionBody.add($s2.node); })+
	CLOSE_CURLY_BRACKET
	{ 
		for(ASTNode n : configBody) {
			n.execute(symbolTable);
		}
	}
	{ 
		for(ASTNode n : executionBody) {
			n.execute(symbolTable);
		}
	};

team returns [ASTNode node]: 
	{ 
		Constant quantity = new Constant(1);
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	TEAM 
		(LESS_THAN 
			NUMBER { quantity = new Constant(Integer.parseInt($NUMBER.text)); }
		GREATER_THAN)? 
	OPEN_CURLY_BRACKET
		(s1=worker { body.add($s1.node); })+
		(s2=pool { body.add($s2.node); })*
	CLOSE_CURLY_BRACKET
	{ $node = new Team(quantity, body); };

worker returns [ASTNode node]: 
		{ 
			Constant quantity = new Constant(1);
			List<ASTNode> body = new ArrayList<ASTNode>();
		}
		WORKER 
			(LESS_THAN 
				NUMBER { quantity = new Constant(Integer.parseInt($NUMBER.text)); } 
			GREATER_THAN)? 
		OPEN_CURLY_BRACKET 
			(s1=assign { body.add($s1.node); })*
		CLOSE_CURLY_BRACKET
		{ $node = new Worker(quantity, body); };
	
pool returns [ASTNode node]: 
	POOL OPEN_CURLY_BRACKET
		{ List<ASTNode> body = new ArrayList<ASTNode>(); }
		(s1=assign { body.add($s1.node); })*
	CLOSE_CURLY_BRACKET
	{ $node = new Pool(body); };
	
assign  returns [ASTNode node]:
	{ 
		String key;
		Constant value;
	}
	 STRING { key = String.valueOf($STRING.text); } COLON 
	(
		STRING  { value = new Constant(String.valueOf($STRING.text)); }
		| 
		NUMBER { value = new Constant(Integer.parseInt($NUMBER.text)); } 
	)
	{ $node = new Assign(key, value); };

CONFIG: 'Config';
EXECUTION: 'Execution';
TEAM: 'Team';
WORKER: 'Worker';
POOL: 'Pool';

OPEN_CURLY_BRACKET: '{';
CLOSE_CURLY_BRACKET: '}';
GREATER_THAN: '>';
LESS_THAN: '<';

NUMBER_SIGN: '#';
COLON: ':';
COMMA: ',';

NUMBER: [0-9]+;
STRING: [a-zA-Z0-9_\-]+;

WS :[ \t\r\n]+ -> skip;