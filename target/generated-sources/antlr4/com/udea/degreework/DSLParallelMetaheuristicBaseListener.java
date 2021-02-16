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


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link DSLParallelMetaheuristicListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class DSLParallelMetaheuristicBaseListener implements DSLParallelMetaheuristicListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStart(@NotNull DSLParallelMetaheuristicParser.StartContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStart(@NotNull DSLParallelMetaheuristicParser.StartContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPool(@NotNull DSLParallelMetaheuristicParser.PoolContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPool(@NotNull DSLParallelMetaheuristicParser.PoolContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTeam(@NotNull DSLParallelMetaheuristicParser.TeamContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTeam(@NotNull DSLParallelMetaheuristicParser.TeamContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWorker(@NotNull DSLParallelMetaheuristicParser.WorkerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWorker(@NotNull DSLParallelMetaheuristicParser.WorkerContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssign(@NotNull DSLParallelMetaheuristicParser.AssignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssign(@NotNull DSLParallelMetaheuristicParser.AssignContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}