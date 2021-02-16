// Generated from DSLParallelMetaheuristic.g4 by ANTLR 4.4
package com.udea.degreework;

	import java.util.Map;
	import java.util.HashMap;

	import com.udea.degreework.interpreter.ast.ASTNode;
	import com.udea.degreework.interpreter.ast.Assign;
	import com.udea.degreework.interpreter.ast.Constant;
	import com.udea.degreework.Execution;
	import com.udea.degreework.Team;
	import com.udea.degreework.interpreter.ast.PoolAST;
	import com.udea.degreework.interpreter.ast.WorkerAST;
	import com.udea.degreework.interpreter.ast.TeamAST;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSLParallelMetaheuristicParser}.
 */
public interface DSLParallelMetaheuristicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSLParallelMetaheuristicParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull DSLParallelMetaheuristicParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParallelMetaheuristicParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull DSLParallelMetaheuristicParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParallelMetaheuristicParser#pool}.
	 * @param ctx the parse tree
	 */
	void enterPool(@NotNull DSLParallelMetaheuristicParser.PoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParallelMetaheuristicParser#pool}.
	 * @param ctx the parse tree
	 */
	void exitPool(@NotNull DSLParallelMetaheuristicParser.PoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParallelMetaheuristicParser#team}.
	 * @param ctx the parse tree
	 */
	void enterTeam(@NotNull DSLParallelMetaheuristicParser.TeamContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParallelMetaheuristicParser#team}.
	 * @param ctx the parse tree
	 */
	void exitTeam(@NotNull DSLParallelMetaheuristicParser.TeamContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParallelMetaheuristicParser#worker}.
	 * @param ctx the parse tree
	 */
	void enterWorker(@NotNull DSLParallelMetaheuristicParser.WorkerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParallelMetaheuristicParser#worker}.
	 * @param ctx the parse tree
	 */
	void exitWorker(@NotNull DSLParallelMetaheuristicParser.WorkerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParallelMetaheuristicParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull DSLParallelMetaheuristicParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParallelMetaheuristicParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull DSLParallelMetaheuristicParser.AssignContext ctx);
}