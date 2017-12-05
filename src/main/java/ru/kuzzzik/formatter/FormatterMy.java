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

    public void format(ILexer in, IWriter out) throws FormatterException {
        try {
            IToken token;
            while (in.hasMoreTokens()) {
                token = in.readToken();
                String lexeme = token.getLexeme();

                StringBuilder lexBuffer = new StringBuilder(lexeme);
                for (int p = 0; p < lexBuffer.length(); p++) {

                    if (lexBuffer.equals("openCurlBracket")) {
                        --p;
                        if (!lexBuffer.equals("space")) {
                            p++;
                            lexBuffer.insert(p, lexeme += ' ');// добавляет пробел перед {
                            p += 2;
                        } else {
                            p += 2;
                        }

                         if (!lexBuffer.equals("newLine")) {
                             lexBuffer.insert(p, lexeme += '\n');// добавляет перенос после {
                         }
                    }

                    if (!lexBuffer.equals("closeCurlBracket")) {
                         --p;
                         if (!lexBuffer.equals("newLine")) {
                             p++;
                             lexBuffer.insert(p, lexeme += '\n');// добавляет перенос перед }
                             p += 2;
                    } else {
                         p += 2;
                    }

                    if (!lexBuffer.equals("newLine")) {
                        lexBuffer.insert(p, lexeme += '\n');// добавляет перенос после }
                        }
                    }
                    out.writeChar(lexBuffer.charAt(p));
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        List<Character> listArray = new ArrayList<>();
//
//        try {
//            while (in.hasChars()) {
//                listArray.add(in.readChar());
//            }
//        } catch (ReaderException e) {
//            e.printStackTrace();
//        }
//
//        for (int p = 0; p < listArray.size(); p++) {
//
//            if (listArray.get(p) == '{') {
//                --p;
//                if (listArray.get(p) != ' ') {
//                    p++;
//                    listArray.add(p, ' ');// добавляет пробел перед {
//                    p += 2;
//                } else {
//                    p += 2;
//                }
//
//                if (listArray.get(p) != '\n') {
//                    listArray.add(p, '\n');// добавляет перенос после {
//                }
//            }
//
//            if (listArray.get(p) == '}') {
//                --p;
//                if (listArray.get(p) != '\n') {
//                    p++;
//                    listArray.add(p, '\n');// добавляет перенос перед }
//                    p += 2;
//                } else {
//                    p += 2;
//                }
//
//                if (listArray.get(p) != '\n') {
//                    listArray.add(p, '\n');// добавляет перенос после }
//                }
//            }
//
//            if (listArray.get(p) == '(') {
//                --p;
//                if (listArray.get(p) != ' ') {
//                    p++;
//                    listArray.add(p, ' ');// добавляет пробел перед (
//                    p += 2;
//                } else {
//                    p += 2;
//                }
//
//                if (listArray.get(p) == ' ') {// убирает пробел после (
//                    listArray.remove(p);
//                }
//            }
//
//            if (listArray.get(p) == ')') {
//                --p;
//                if (listArray.get(p) == ' ') {// убирает пробел перед (
//                    listArray.remove(p);
//
//                } else {
//                    p += 1;
//                }
//                p++;
//                if (listArray.get(p) != ' ') {
//                    listArray.add(p, ' ');// добавляет пробел после (
//                }
//            }
//        }
//        for (Character aListArray : listArray) {
//            try {
//                out.writeChar(aListArray);
//            } catch (WriterException e) {
//                throw new FormatterException("Writing error", e);
//            }
//        }
//    }
    }
}



















