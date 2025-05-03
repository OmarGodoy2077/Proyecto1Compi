grammar MiniLang;

// ================= Parser Rules =================

program: statement* EOF;

statement
    : varDecl ';'
    | assignment ';'
    | functionDecl
    | ifStatement
    | whileStatement
    | forStatement
    | returnStatement ';'
    | printStatement ';'
    | expression ';'
    | block
    ;

block: '{' statement* '}';

varDecl: (VAR | CONST) ID (':' type)? ('=' expression)?;

assignment: ID '=' expression;

functionDecl: FUNCTION ID '(' parameters? ')' block;

parameters: parameter (',' parameter)*;
parameter: ID ':' type;

ifStatement: IF '(' expression ')' block (ELSE block)?;

whileStatement: WHILE '(' expression ')' block;

forStatement: FOR '(' assignment ';' expression ';' assignment ')' block;

returnStatement: RETURN expression?;

printStatement: PRINT '(' expression ')';

expression
    : expression op=('*'|'/') expression
    | expression op=('+'|'-') expression
    | expression op=('>'|'<'|'>='|'<='|'=='|'!=') expression
    | expression op=('&&'|'||') expression
    | '!' expression
    | '(' expression ')'
    | functionCall
    | atom
    ;

functionCall: ID '(' (expression (',' expression)*)? ')';

atom
    : ID
    | INT_LITERAL
    | FLOAT_LITERAL
    | BOOL_LITERAL
    | STRING_LITERAL
    | INPUT '(' ')'
    ;

type: INT | FLOAT | BOOL;

// ================= Lexer Rules =================


IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
RETURN: 'return';
FUNCTION: 'function';
VAR: 'var';
CONST: 'const';
PRINT: 'print';
INPUT: 'input';
INT: 'int';
FLOAT: 'float';
BOOL: 'bool';
TRUE: 'true';
FALSE: 'false';

// Literales
INT_LITERAL: [0-9]+;
FLOAT_LITERAL: [0-9]+'.'[0-9]+;
BOOL_LITERAL: TRUE | FALSE;
STRING_LITERAL: '"' ( ~["\\] | '\\' . )* '"';


ID: [a-zA-Z_][a-zA-Z_0-9]*;


PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
EQ: '==';
NEQ: '!=';
AND: '&&';
OR: '||';
NOT: '!';
ASSIGN: '=';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMI: ';';
COMMA: ',';

// Ignorar espacios, tabs y saltos de línea
WS: [ \t\r\n]+ -> skip ;

// Ignorar comentarios
LINE_COMMENT: '//' ~[\r\n]* -> skip ;
ERROR: . ; // Esto se puede usar para capturar errores léxicos si lo necesitas.

INVALID_ID : [0-9]+ [a-zA-Z_]+ -> type(ERROR); // Identificadores inválidos que empiezan con número

ERROR_CHAR: . -> type(ERROR); // Captura cualquier otro carácter no válido

