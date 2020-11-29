// Generated from com/udea/degreework/DSLParallelMetaheuristic.g4 by ANTLR 4.5.1
package com.udea.degreework;

	import java.util.Map;
	import java.util.HashMap;

	import com.udea.degreework.interpreter.ast.ASTNode;
	import com.udea.degreework.interpreter.ast.Assign;
	import com.udea.degreework.interpreter.ast.Constant;
	import com.udea.degreework.interpreter.ast.Pool;
	import com.udea.degreework.interpreter.ast.Worker;
	import com.udea.degreework.interpreter.ast.Team;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DSLParallelMetaheuristicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONFIG=1, EXECUTION=2, TEAM=3, WORKER=4, POOL=5, OPEN_CURLY_BRACKET=6, 
		CLOSE_CURLY_BRACKET=7, GREATER_THAN=8, LESS_THAN=9, NUMBER_SIGN=10, COLON=11, 
		COMMA=12, NUMBER=13, STRING=14, WS=15;
	public static final int
		RULE_start = 0, RULE_team = 1, RULE_worker = 2, RULE_pool = 3, RULE_assign = 4;
	public static final String[] ruleNames = {
		"start", "team", "worker", "pool", "assign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Config'", "'Execution'", "'Team'", "'Worker'", "'Pool'", "'{'", 
		"'}'", "'>'", "'<'", "'#'", "':'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CONFIG", "EXECUTION", "TEAM", "WORKER", "POOL", "OPEN_CURLY_BRACKET", 
		"CLOSE_CURLY_BRACKET", "GREATER_THAN", "LESS_THAN", "NUMBER_SIGN", "COLON", 
		"COMMA", "NUMBER", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DSLParallelMetaheuristic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DSLParallelMetaheuristicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public AssignContext s1;
		public TeamContext s2;
		public TerminalNode CONFIG() { return getToken(DSLParallelMetaheuristicParser.CONFIG, 0); }
		public List<TerminalNode> OPEN_CURLY_BRACKET() { return getTokens(DSLParallelMetaheuristicParser.OPEN_CURLY_BRACKET); }
		public TerminalNode OPEN_CURLY_BRACKET(int i) {
			return getToken(DSLParallelMetaheuristicParser.OPEN_CURLY_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_CURLY_BRACKET() { return getTokens(DSLParallelMetaheuristicParser.CLOSE_CURLY_BRACKET); }
		public TerminalNode CLOSE_CURLY_BRACKET(int i) {
			return getToken(DSLParallelMetaheuristicParser.CLOSE_CURLY_BRACKET, i);
		}
		public TerminalNode EXECUTION() { return getToken(DSLParallelMetaheuristicParser.EXECUTION, 0); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<TeamContext> team() {
			return getRuleContexts(TeamContext.class);
		}
		public TeamContext team(int i) {
			return getRuleContext(TeamContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLParallelMetaheuristicVisitor ) return ((DSLParallelMetaheuristicVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
					List<ASTNode> configBody = new ArrayList<ASTNode>();
					List<ASTNode> executionBody = new ArrayList<ASTNode>();
					Map<String, Object> symbolTable = new HashMap<String, Object>();
				
			setState(11);
			match(CONFIG);
			setState(12);
			match(OPEN_CURLY_BRACKET);
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(13);
				((StartContext)_localctx).s1 = assign();
				 configBody.add(((StartContext)_localctx).s1.node); 
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(21);
			match(CLOSE_CURLY_BRACKET);
			setState(22);
			match(EXECUTION);
			setState(23);
			match(OPEN_CURLY_BRACKET);
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				((StartContext)_localctx).s2 = team();
				 executionBody.add(((StartContext)_localctx).s2.node); 
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEAM );
			setState(31);
			match(CLOSE_CURLY_BRACKET);
			 
					for(ASTNode n : configBody) {
						n.execute(symbolTable);
					}
				
			 
					for(ASTNode n : executionBody) {
						n.execute(symbolTable);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TeamContext extends ParserRuleContext {
		public ASTNode node;
		public Token NUMBER;
		public WorkerContext s1;
		public PoolContext s2;
		public TerminalNode TEAM() { return getToken(DSLParallelMetaheuristicParser.TEAM, 0); }
		public TerminalNode OPEN_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.OPEN_CURLY_BRACKET, 0); }
		public TerminalNode CLOSE_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.CLOSE_CURLY_BRACKET, 0); }
		public TerminalNode LESS_THAN() { return getToken(DSLParallelMetaheuristicParser.LESS_THAN, 0); }
		public TerminalNode NUMBER() { return getToken(DSLParallelMetaheuristicParser.NUMBER, 0); }
		public TerminalNode GREATER_THAN() { return getToken(DSLParallelMetaheuristicParser.GREATER_THAN, 0); }
		public List<WorkerContext> worker() {
			return getRuleContexts(WorkerContext.class);
		}
		public WorkerContext worker(int i) {
			return getRuleContext(WorkerContext.class,i);
		}
		public List<PoolContext> pool() {
			return getRuleContexts(PoolContext.class);
		}
		public PoolContext pool(int i) {
			return getRuleContext(PoolContext.class,i);
		}
		public TeamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_team; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).enterTeam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).exitTeam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLParallelMetaheuristicVisitor ) return ((DSLParallelMetaheuristicVisitor<? extends T>)visitor).visitTeam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TeamContext team() throws RecognitionException {
		TeamContext _localctx = new TeamContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_team);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
					Constant quantity = new Constant(1);
					List<ASTNode> body = new ArrayList<ASTNode>();
				
			setState(36);
			match(TEAM);
			setState(41);
			_la = _input.LA(1);
			if (_la==LESS_THAN) {
				{
				setState(37);
				match(LESS_THAN);
				setState(38);
				((TeamContext)_localctx).NUMBER = match(NUMBER);
				 quantity = new Constant(Integer.parseInt((((TeamContext)_localctx).NUMBER!=null?((TeamContext)_localctx).NUMBER.getText():null))); 
				setState(40);
				match(GREATER_THAN);
				}
			}

			setState(43);
			match(OPEN_CURLY_BRACKET);
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				((TeamContext)_localctx).s1 = worker();
				 body.add(((TeamContext)_localctx).s1.node); 
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORKER );
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POOL) {
				{
				{
				setState(51);
				((TeamContext)_localctx).s2 = pool();
				 body.add(((TeamContext)_localctx).s2.node); 
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(CLOSE_CURLY_BRACKET);
			 ((TeamContext)_localctx).node =  new Team(quantity, body); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WorkerContext extends ParserRuleContext {
		public ASTNode node;
		public Token NUMBER;
		public AssignContext s1;
		public TerminalNode WORKER() { return getToken(DSLParallelMetaheuristicParser.WORKER, 0); }
		public TerminalNode OPEN_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.OPEN_CURLY_BRACKET, 0); }
		public TerminalNode CLOSE_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.CLOSE_CURLY_BRACKET, 0); }
		public TerminalNode LESS_THAN() { return getToken(DSLParallelMetaheuristicParser.LESS_THAN, 0); }
		public TerminalNode NUMBER() { return getToken(DSLParallelMetaheuristicParser.NUMBER, 0); }
		public TerminalNode GREATER_THAN() { return getToken(DSLParallelMetaheuristicParser.GREATER_THAN, 0); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public WorkerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_worker; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).enterWorker(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).exitWorker(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLParallelMetaheuristicVisitor ) return ((DSLParallelMetaheuristicVisitor<? extends T>)visitor).visitWorker(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WorkerContext worker() throws RecognitionException {
		WorkerContext _localctx = new WorkerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_worker);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
						Constant quantity = new Constant(1);
						List<ASTNode> body = new ArrayList<ASTNode>();
					
			setState(63);
			match(WORKER);
			setState(68);
			_la = _input.LA(1);
			if (_la==LESS_THAN) {
				{
				setState(64);
				match(LESS_THAN);
				setState(65);
				((WorkerContext)_localctx).NUMBER = match(NUMBER);
				 quantity = new Constant(Integer.parseInt((((WorkerContext)_localctx).NUMBER!=null?((WorkerContext)_localctx).NUMBER.getText():null))); 
				setState(67);
				match(GREATER_THAN);
				}
			}

			setState(70);
			match(OPEN_CURLY_BRACKET);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(71);
				((WorkerContext)_localctx).s1 = assign();
				 body.add(((WorkerContext)_localctx).s1.node); 
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			match(CLOSE_CURLY_BRACKET);
			 ((WorkerContext)_localctx).node =  new Worker(quantity, body); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PoolContext extends ParserRuleContext {
		public ASTNode node;
		public AssignContext s1;
		public TerminalNode POOL() { return getToken(DSLParallelMetaheuristicParser.POOL, 0); }
		public TerminalNode OPEN_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.OPEN_CURLY_BRACKET, 0); }
		public TerminalNode CLOSE_CURLY_BRACKET() { return getToken(DSLParallelMetaheuristicParser.CLOSE_CURLY_BRACKET, 0); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public PoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).enterPool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).exitPool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLParallelMetaheuristicVisitor ) return ((DSLParallelMetaheuristicVisitor<? extends T>)visitor).visitPool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PoolContext pool() throws RecognitionException {
		PoolContext _localctx = new PoolContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(POOL);
			setState(83);
			match(OPEN_CURLY_BRACKET);
			 List<ASTNode> body = new ArrayList<ASTNode>(); 
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING) {
				{
				{
				setState(85);
				((PoolContext)_localctx).s1 = assign();
				 body.add(((PoolContext)_localctx).s1.node); 
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(CLOSE_CURLY_BRACKET);
			 ((PoolContext)_localctx).node =  new Pool(body); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ASTNode node;
		public Token STRING;
		public Token NUMBER;
		public List<TerminalNode> STRING() { return getTokens(DSLParallelMetaheuristicParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(DSLParallelMetaheuristicParser.STRING, i);
		}
		public TerminalNode COLON() { return getToken(DSLParallelMetaheuristicParser.COLON, 0); }
		public TerminalNode NUMBER() { return getToken(DSLParallelMetaheuristicParser.NUMBER, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DSLParallelMetaheuristicListener ) ((DSLParallelMetaheuristicListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DSLParallelMetaheuristicVisitor ) return ((DSLParallelMetaheuristicVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
					String key;
					Constant value;
				
			setState(97);
			((AssignContext)_localctx).STRING = match(STRING);
			 key = String.valueOf((((AssignContext)_localctx).STRING!=null?((AssignContext)_localctx).STRING.getText():null)); 
			setState(99);
			match(COLON);
			setState(104);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(100);
				((AssignContext)_localctx).STRING = match(STRING);
				 value = new Constant(String.valueOf((((AssignContext)_localctx).STRING!=null?((AssignContext)_localctx).STRING.getText():null))); 
				}
				break;
			case NUMBER:
				{
				setState(102);
				((AssignContext)_localctx).NUMBER = match(NUMBER);
				 value = new Constant(Integer.parseInt((((AssignContext)_localctx).NUMBER!=null?((AssignContext)_localctx).NUMBER.getText():null))); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 ((AssignContext)_localctx).node =  new Assign(key, value); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21o\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\7\2\23\n\2\f\2\16\2"+
		"\26\13\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2\36\n\2\r\2\16\2\37\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\6\3\62\n\3\r\3\16"+
		"\3\63\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4G\n\4\3\4\3\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6k\n\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2r\2\f\3"+
		"\2\2\2\4%\3\2\2\2\6@\3\2\2\2\bT\3\2\2\2\nb\3\2\2\2\f\r\b\2\1\2\r\16\7"+
		"\3\2\2\16\24\7\b\2\2\17\20\5\n\6\2\20\21\b\2\1\2\21\23\3\2\2\2\22\17\3"+
		"\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\27\3\2\2\2\26\24\3"+
		"\2\2\2\27\30\7\t\2\2\30\31\7\4\2\2\31\35\7\b\2\2\32\33\5\4\3\2\33\34\b"+
		"\2\1\2\34\36\3\2\2\2\35\32\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2"+
		"\2\2 !\3\2\2\2!\"\7\t\2\2\"#\b\2\1\2#$\b\2\1\2$\3\3\2\2\2%&\b\3\1\2&+"+
		"\7\5\2\2\'(\7\13\2\2()\7\17\2\2)*\b\3\1\2*,\7\n\2\2+\'\3\2\2\2+,\3\2\2"+
		"\2,-\3\2\2\2-\61\7\b\2\2./\5\6\4\2/\60\b\3\1\2\60\62\3\2\2\2\61.\3\2\2"+
		"\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64:\3\2\2\2\65\66\5\b\5\2"+
		"\66\67\b\3\1\2\679\3\2\2\28\65\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;"+
		"=\3\2\2\2<:\3\2\2\2=>\7\t\2\2>?\b\3\1\2?\5\3\2\2\2@A\b\4\1\2AF\7\6\2\2"+
		"BC\7\13\2\2CD\7\17\2\2DE\b\4\1\2EG\7\n\2\2FB\3\2\2\2FG\3\2\2\2GH\3\2\2"+
		"\2HN\7\b\2\2IJ\5\n\6\2JK\b\4\1\2KM\3\2\2\2LI\3\2\2\2MP\3\2\2\2NL\3\2\2"+
		"\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\t\2\2RS\b\4\1\2S\7\3\2\2\2TU\7\7"+
		"\2\2UV\7\b\2\2V\\\b\5\1\2WX\5\n\6\2XY\b\5\1\2Y[\3\2\2\2ZW\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\7\t\2\2`a\b\5\1\2"+
		"a\t\3\2\2\2bc\b\6\1\2cd\7\20\2\2de\b\6\1\2ej\7\r\2\2fg\7\20\2\2gk\b\6"+
		"\1\2hi\7\17\2\2ik\b\6\1\2jf\3\2\2\2jh\3\2\2\2kl\3\2\2\2lm\b\6\1\2m\13"+
		"\3\2\2\2\13\24\37+\63:FN\\j";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}