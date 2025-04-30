// Generated from C:/Users/Omar Godoy/IdeaProjects/untitled/src/main/javagen/MiniLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniLangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniLangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MiniLangParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MiniLangParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MiniLangParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MiniLangParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MiniLangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MiniLangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MiniLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MiniLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MiniLangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MiniLangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MiniLangParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MiniLangParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniLangParser.TypeContext ctx);
}