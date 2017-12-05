package ru.kuzzzik.lexer;

public class Token implements IToken {

    private String nameLex;
    private String lexeme;

    public Token(String nameLex, String lexeme) {
        this.nameLex = nameLex;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return nameLex;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
