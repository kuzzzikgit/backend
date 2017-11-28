package ru.kuzzzik;

import ru.kuzzzik.formatter.FormatterMy;
import ru.kuzzzik.formatter.IFormatter;
import ru.kuzzzik.io.reader.FileReader;
import ru.kuzzzik.io.writer.FileWriter;

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
//        ILexer lexer = new Lexer(in);
        IFormatter formatter = new FormatterMy();
        try (
                FileReader in = new FileReader(args[0]);
                FileWriter out = new FileWriter(args[1])
        )
        {
            formatter.format(in, out);
//           formatF.format(lexer, out);
        }
    }
}




