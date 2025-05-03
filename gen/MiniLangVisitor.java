// Generated from C:/Users/omarg/IdeaProjects/Proyecto1Compi/src/main/javagen/MiniLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MiniLangParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MiniLangParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MiniLangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MiniLangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MiniLangParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MiniLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MiniLangParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MiniLangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MiniLangParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniLangParser.TypeContext ctx);
}