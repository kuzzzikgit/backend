package ru.kuzzzik.formatter;

import ru.kuzzzik.io.reader.ReaderException;
import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.io.writer.WriterException;
import ru.kuzzzik.lexer.ILexer;
import ru.kuzzzik.lexer.IToken;

import java.io.IOException;

public class FormatterMy implements IFormatter{
    public FormatterMy() {
    }

    private StringBuilder bufNameLex = new StringBuilder();
    private StringBuilder bufLexeme = new StringBuilder();

    private String beforeNameLex = bufNameLex.toString();
    private String beforeLexeme = bufLexeme.toString();

    private void cleadBuilder () {
        bufNameLex.setLength(0);
        bufLexeme.setLength(0);
    }

    private StringBuilder bufNameNewLineSpace = new StringBuilder();
    private StringBuilder bufLexemeNewLineSpace = new StringBuilder();

    private String bufnameNLS = bufNameNewLineSpace.toString();
    private String bufLexemeNLS = bufLexemeNewLineSpace.toString();

    public void format(ILexer in, IWriter out) throws FormatterException {
        try {
            IToken token;
            while (in.hasMoreTokens()) {
                token = in.readToken();
                String lexeme = token.getLexeme();
                String nameLex = token.getName();

                if (nameLex.equals("openCurlBracket")) {
                    if (beforeNameLex.equals("space")) {
                        lexeme = beforeLexeme + lexeme;
                    } else {
                        lexeme = beforeLexeme + ' ' + lexeme;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    bufNameLex.append("openCurlBracket");
                    bufLexeme.append("{");
                    continue;
                }

                if (nameLex.equals("closeCurlBracket")) {
                    if (beforeNameLex.equals("newLine")) {
                        lexeme = beforeLexeme + lexeme;
                    } else {
                        lexeme = beforeLexeme + '\n' + lexeme;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    bufNameLex.append("closeCurlBracket");
                    bufLexeme.append("}");
                    continue;
                }

                if (nameLex.equals("semicilone")) {
                    if (!beforeNameLex.equals("space")) {
                        lexeme = beforeLexeme + lexeme;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    bufNameLex.append("semicilone");
                    bufLexeme.append(";");
                    continue;
                }

                if (nameLex.equals("newLine")) {
                    switch (beforeNameLex) {
                        case "openCurlBracket": lexeme = beforeLexeme + lexeme; break;
                        case "closeCurlBracket": lexeme = beforeLexeme + lexeme; break;
                        case "semicilone": lexeme = beforeLexeme + lexeme; break;
                        default: lexeme = beforeLexeme;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    bufNameLex.append("newLine");
                    bufLexeme.append('\n');
                    continue;
                }

                if (nameLex.equals("space")) {
                    switch (beforeNameLex) {
                        case "newLine": lexeme = beforeNameLex + lexeme + "   "; bufNameNewLineSpace.append("newLineSpace"); bufLexemeNewLineSpace.append("'\n'    "); break;
                        case "space": lexeme = " "; break;
                        default: lexeme = beforeLexeme + lexeme;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    bufNameLex.append("space");
                    bufLexeme.append(" ");
                    if (bufnameNLS.equals("newLineSpace")) {
                        lexeme = bufLexemeNLS;
                        lexing(out, lexeme);
                    }
                    bufNameNewLineSpace.setLength(0);
                    bufLexemeNewLineSpace.setLength(0);
                    continue;
                }

                if (!nameLex.equals("newLine")) {
                    String afterNameLex = bufNameLex.toString();
                    switch (afterNameLex) {
                        case "openCurlBracket": lexeme = '\n' + lexeme; break;
                        case "closeCurlBracket": lexeme = '\n' + lexeme; break;
                        case "semicilone": lexeme = '\n' + lexeme; break;
                    }
                    lexing(out, lexeme);
                    cleadBuilder ();
                    continue;
                }

//                if (nameLex.equals("noFormat")) {
//                    lexing(out, lexeme);
//                    continue;
//                }

            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void lexing(IWriter writer, String lexeme) throws WriterException {
            for (int i = 0; i < lexeme.length(); i++) {
                char lex = lexeme.charAt(i);
                writer.writeChar(lex);
            }
        }
    }




















