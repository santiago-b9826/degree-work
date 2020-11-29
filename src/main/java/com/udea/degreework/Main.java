
package com.udea.degreework;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	private static final String EXTENSION = "pmet";

	public static void main(String[] args) throws Exception {
		String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;

		System.out.println("Interpreting file " + program);

		DSLParallelMetaheuristicLexer lexer = new DSLParallelMetaheuristicLexer(new ANTLRFileStream(program));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DSLParallelMetaheuristicParser parser = new DSLParallelMetaheuristicParser(tokens);

		DSLParallelMetaheuristicParser.StartContext tree = parser.start();

		DSLParallelMetaheuristicCustomVisitor visitor = new DSLParallelMetaheuristicCustomVisitor();
		visitor.visit(tree);

		System.out.println("Interpretation finished");

	}

}
