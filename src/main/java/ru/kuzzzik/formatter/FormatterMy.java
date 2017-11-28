package ru.kuzzzik.formatter;

import ru.kuzzzik.io.reader.IReader;
import ru.kuzzzik.io.reader.ReaderException;
import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.io.writer.WriterException;

import java.util.ArrayList;
import java.util.List;

public class FormatterMy implements IFormatter {
    public FormatterMy() {
    }

//    @Override
//    public void format(final ILexer lexer, final IWriter out) {
//        while (lexer.hasMoreTokens()) {
//            IToken token = lexer.readToken();
//            String lexeme = token.getLexeme();
//            // do something
//            write(writer, lexeme);
//        }
//    }

    public void format(IReader in, IWriter out) throws FormatterException {
//        try {
//            char charForFormat;
//            while (in.hasChars()) {
//                charForFormat = in.readChar();
//                out.writeChar(charForFormat);
//            }
//        } catch (ReaderException e) {
//            throw new FormatterException("Reading error", e);
//        } catch (WriterException e) {
//            throw new FormatterException("Writing error", e);
//        }
        List<Character> listArray = new ArrayList<>();

        try {
            while (in.hasChars()) {
                listArray.add(in.readChar());
            }
        } catch (ReaderException e) {
            e.printStackTrace();
        }

        for (int p = 0; p < listArray.size(); p++) {

            if (listArray.get(p) == '{') {
                --p;
                if (listArray.get(p) != ' ') {
                    p++;
                    listArray.add(p, ' ');// добавляет пробел перед {
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) != '\n') {
                    listArray.add(p, '\n');// добавляет перенос после {
                }
            }

            if (listArray.get(p) == '}') {
                --p;
                if (listArray.get(p) != '\n') {
                    p++;
                    listArray.add(p, '\n');// добавляет перенос перед }
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) != '\n') {
                    listArray.add(p, '\n');// добавляет перенос после }
                }
            }

            if (listArray.get(p) == '(') {
                --p;
                if (listArray.get(p) != ' ') {
                    p++;
                    listArray.add(p, ' ');// добавляет пробел перед (
                    p += 2;
                } else {
                    p += 2;
                }

                if (listArray.get(p) == ' ') {// убирает пробел после (
                    listArray.remove(p);
                }
            }

            if (listArray.get(p) == ')') {
                --p;
                if (listArray.get(p) == ' ') {// убирает пробел перед (
                    listArray.remove(p);

                } else {
                    p += 1;
                }
                p++;
                if (listArray.get(p) != ' ') {
                    listArray.add(p, ' ');// добавляет пробел после (
                }
            }
        }
        for (Character aListArray : listArray) {
            try {
                out.writeChar(aListArray);
            } catch (WriterException e) {
                throw new FormatterException("Writing error", e);
            }
        }
    }

    @Override
    public boolean hasMoreTokens() {
        return false;
    }

    @Override
    public String readToken() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLexeme() {
        return null;
    }
}



















