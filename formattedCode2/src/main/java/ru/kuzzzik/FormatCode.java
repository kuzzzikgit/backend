package ru.kuzzzik;

import ru.kuzzzik.formatter.FormatterMy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class FormatCode {
    public static void main(String[] args) throws Exception {
//      IReader inString = new StringReader("h{e( ll )oe(gf)iegf }ieGF");

        FileReader fReaderCode = new FileReader(args[0]);
        BufferedReader readFile = new BufferedReader(fReaderCode);
//      IReader inFile = (IReader) new FileReader(String.valueOf(readFile));  //предлагает (String.valueOf(readFile)), если сделать, то;
                                                                            //IReader inFile = (IReader) new FileReader(String.valueOf(readFile))
                                                                            //ошибка java.io.FileNotFoundException: java.io.BufferedReader@330bedb4 (No such file or directory)
        List<Character> listArray = new ArrayList<>();
//      while (inFile.hasNext()) {
//            listArray.add(inFile.reading());
//        }

        int i;
        while ((i = readFile.read()) != -1) {
            listArray.add((char) i);
        }

//        while (inString.hasNext()) {
//            listArray.add(inString.reading());
//        }

        FormatterMy format = new FormatterMy((ArrayList<Character>) listArray);
        format.formatArr();


//        IWriter outString = new StringWriter((ArrayList<Character>) listArray);
//        while (outString.hasNextW()) {
//            System.out.print(outString.readW());
//        }

            FileWriter writeFormat = new FileWriter(args[1]);
            BufferedWriter bWriterFormat = new BufferedWriter(writeFormat);

        for (Character aListArray : listArray) {// пишет из ArrayList в файл
            bWriterFormat.write(aListArray);
            bWriterFormat.flush();
        }

//            while (outFile.hasNextW()) {
//                System.out.print(outFile.readW());
//            }


//        BufferedReader bReaderCode = null;
//        try {
//            String readerCode = args[0];//input.java
//
//            FileReader fReaderCode = new FileReader(readerCode);
//            bReaderCode = new BufferedReader(fReaderCode);
//        }
//        catch(IOException IOEx) {
//            System.out.println(IOEx.toString() + "Ошибка чтения файла");
//        }
//        catch (Exception e) {
//            System.out.println(e.toString() + "Произошло ещё какое-то исключение при чтении файла");
//        }
//        ArrayList<Character> list = new ArrayList<>();//пишет массив из буфера в ArrayList
//
//        int i;
//        assert bReaderCode != null;
//        while ((i = bReaderCode.read()) != -1) {
//            list.add((char) i);
//        }
//
//        System.out.println(list);
//
//        try {
//            for (int p = 0; p<list.size(); p++) {
//
//                FormatCode.Inner inner = new FormatCode().new Inner();
//
//                inner.bracketCurlOpen(list, p);// проверяем {
//                inner.bracketCurlClose(list, p);// проверяем }
//                inner.bracketOpen(list, p);// проверяем (
//                inner.bracketClose(list, p);// проверяем )
//            }
//        }
//        catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.toString() + "Выход индекса за границу массива");
//        }
//        catch (Exception e) {
//            System.out.println("Произошло ещё какое-то исключение при изменении массива");
//        }
//        System.out.println(list);
//
//        BufferedWriter bWriterFormat = null;
//        try {
//            String writerCode = args[1];//output.java
//
//            FileWriter writeFormat = new FileWriter(writerCode);
//            bWriterFormat = new BufferedWriter(writeFormat);
//
//            for (Character aList : list) {// пишет из ArrayList в файл
//                bWriterFormat.write(aList);
//            }
//        }
//        catch(IOException IOEx) {
//            System.out.println(IOEx.toString() + "Ошибка записи файла");
//        }
//        catch (Exception e) {
//            System.out.println(e.toString() + "Произошло ещё какое-то исключение при записи файла");
//        }
//        finally{
//            try {
//                bReaderCode.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (bWriterFormat != null) {
//                try {
//                    bWriterFormat.flush();
//                    bWriterFormat.close();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }

        }//main

    }




