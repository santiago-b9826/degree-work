// Generated from DSLParallelMetaheuristic.g4 by ANTLR 4.4
package com.udea.degreework;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DSLParallelMetaheuristicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONFIG=1, EXECUTION=2, TEAM=3, WORKER=4, POOL=5, OPEN_CURLY_BRACKET=6, 
		CLOSE_CURLY_BRACKET=7, GREATER_THAN=8, LESS_THAN=9, NUMBER_SIGN=10, COLON=11, 
		COMMA=12, NUMBER=13, STRING=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"CONFIG", "EXECUTION", "TEAM", "WORKER", "POOL", "OPEN_CURLY_BRACKET", 
		"CLOSE_CURLY_BRACKET", "GREATER_THAN", "LESS_THAN", "NUMBER_SIGN", "COLON", 
		"COMMA", "NUMBER", "STRING", "WS"
	};


	public DSLParallelMetaheuristicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DSLParallelMetaheuristic.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21b\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16S\n\16\r\16\16\16T\3\17\6"+
		"\17X\n\17\r\17\16\17Y\3\20\6\20]\n\20\r\20\16\20^\3\20\3\20\2\2\21\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"\3\2\5\3\2\62;\b\2$$/;C\\^^aac|\5\2\13\f\17\17\"\"d\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5(\3\2\2\2\7\62\3\2\2\2\t"+
		"\67\3\2\2\2\13>\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2"+
		"\25K\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33R\3\2\2\2\35W\3\2\2\2\37\\\3\2"+
		"\2\2!\"\7E\2\2\"#\7q\2\2#$\7p\2\2$%\7h\2\2%&\7k\2\2&\'\7i\2\2\'\4\3\2"+
		"\2\2()\7G\2\2)*\7z\2\2*+\7g\2\2+,\7e\2\2,-\7w\2\2-.\7v\2\2./\7k\2\2/\60"+
		"\7q\2\2\60\61\7p\2\2\61\6\3\2\2\2\62\63\7V\2\2\63\64\7g\2\2\64\65\7c\2"+
		"\2\65\66\7o\2\2\66\b\3\2\2\2\678\7Y\2\289\7q\2\29:\7t\2\2:;\7m\2\2;<\7"+
		"g\2\2<=\7t\2\2=\n\3\2\2\2>?\7R\2\2?@\7q\2\2@A\7q\2\2AB\7n\2\2B\f\3\2\2"+
		"\2CD\7}\2\2D\16\3\2\2\2EF\7\177\2\2F\20\3\2\2\2GH\7@\2\2H\22\3\2\2\2I"+
		"J\7>\2\2J\24\3\2\2\2KL\7%\2\2L\26\3\2\2\2MN\7<\2\2N\30\3\2\2\2OP\7.\2"+
		"\2P\32\3\2\2\2QS\t\2\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\34\3"+
		"\2\2\2VX\t\3\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\36\3\2\2\2["+
		"]\t\4\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\b\20\2"+
		"\2a \3\2\2\2\6\2TY^\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}