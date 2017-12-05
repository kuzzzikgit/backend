package ru.kuzzzik;

import ru.kuzzzik.formatter.FormatterMy;
import ru.kuzzzik.formatter.IFormatter;
import ru.kuzzzik.io.reader.FileReader;
import ru.kuzzzik.io.writer.FileWriter;
import ru.kuzzzik.lexer.ILexer;
import ru.kuzzzik.lexer.Lexer;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class FormatCode {

    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */

    public static void main(String[] args) throws Exception {
        FileReader in = new FileReader(args[0]);
        FileWriter out = new FileWriter(args[1]);

        ILexer lexer = new Lexer(in);
        IFormatter formatter = new FormatterMy();
        {
//            formatter.format(in, out);
           formatter.format(lexer, out);
        }
    }
}




