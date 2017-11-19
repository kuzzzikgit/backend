package ru.kuzzzik;

import ru.kuzzzik.io.FileIo.FileReader;
import ru.kuzzzik.io.FileIo.FileWriter;
import ru.kuzzzik.io.IReader;
import ru.kuzzzik.io.IWriter;
import ru.kuzzzik.io.StringIo.StringReader;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class FormatCode {
    public static void main(String[] args) throws Exception {
      IReader inString = new StringReader("h{e( ll )oe(gf)iegf }ieGF");

        FormatterMy formatS = new FormatterMy(inString);
        formatS.format(inString);

      IReader inFile = new FileReader(args[0]);
      IWriter outFile = new FileWriter(args[1]);

        FormatterMy formatF = new FormatterMy(inFile, outFile);
        formatF.format(inFile, outFile);
    }//main

}




