package ru.kuzzzik;

import java.io.*;
import java.util.*;

/**
 * Class to correct placement of brackets
 * @author kuzzzik (Kuzovleva Oksana)
 * @version 1.0
 */

public class FormatCode {
    public static void main(String[] args) throws IOException {
        BufferedReader bReaderCode = null;
        try {
            String readerCode = args[0];//input.java

            FileReader fReaderCode = new FileReader(readerCode);
            bReaderCode = new BufferedReader(fReaderCode);
        }
        catch(IOException IOEx) {
            System.out.println(IOEx.toString() + "Ошибка чтения файла");
        }
        catch (Exception e) {
            System.out.println(e.toString() + "Произошло ещё какое-то исключение при чтении файла");
        }
        ArrayList<Character> list = new ArrayList<>();//пишет массив из буфера в ArrayList

        int i;
        assert bReaderCode != null;
        while ((i = bReaderCode.read()) != -1) {
            list.add((char) i);
        }

        System.out.println(list);

        try {
            for (int p = 0; p<list.size(); p++) {

                FormatCode.Inner inner = new FormatCode().new Inner();

                inner.bracketCurlOpen(list, p);// проверяем {
                inner.bracketCurlClose(list, p);// проверяем }
                inner.bracketOpen(list, p);// проверяем (
                inner.bracketClose(list, p);// проверяем )
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString() + "Выход индекса за границу массива");
        }
        catch (Exception e) {
            System.out.println("Произошло ещё какое-то исключение при изменении массива");
        }
        System.out.println(list);

        BufferedWriter bWriterFormat = null;
        try {
            String writerCode = args[1];//output.java

            FileWriter writeFormat = new FileWriter(writerCode);
            bWriterFormat = new BufferedWriter(writeFormat);

            for (Character aList : list) {// пишет из ArrayList в файл
                bWriterFormat.write(aList);
            }
        }
        catch(IOException IOEx) {
            System.out.println(IOEx.toString() + "Ошибка записи файла");
        }
        catch (Exception e) {
            System.out.println(e.toString() + "Произошло ещё какое-то исключение при записи файла");
        }
        finally{
            try {
                bReaderCode.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bWriterFormat != null) {
                try {
                    bWriterFormat.flush();
                    bWriterFormat.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }//main

    private class Inner {
        /**
         * method checks the placement of opening curly brackets, fixes
         * @param list from ArrayList
         * @param p the element number of the array
         */
        void bracketCurlOpen(ArrayList<Character>list, int p) {
            if (list.get(p) == '{') {
                --p;
                if (list.get(p) != ' ') {
                    p++;
                    list.add(p, ' ');// добавляет пробел перед {
                    p += 2;
                } else {
                    p += 2;
                }

                if (list.get(p) != '\n') {
                    list.add(p, '\n');// добавляет перенос после {

                }
            }
        }
        /**
         * method checks the placement of closed curly brackets, fixes
         * @param list from ArrayList
         * @param p the element number of the array
         */
        void bracketCurlClose(ArrayList<Character>list, int p) {
            if (list.get(p) == '}') {
                --p;
                if (list.get(p) != '\n') {
                    p++;
                    list.add(p, '\n');// добавляет перенос перед }
                    p += 2;
                } else {
                    p += 2;
                }

                if (list.get(p) != '\n') {
                    list.add(p, '\n');// добавляет перенос после }

                }
            }
        }
        /**
         * method checks the placement of opened brackets, fixes
         * @param list from ArrayList
         * @param p the element number of the array
         */
        void bracketOpen(ArrayList<Character>list, int p) {
            if (list.get(p) == '(') {
                --p;
                if (list.get(p) != ' ') {
                    p++;
                    list.add(p, ' ');// добавляет пробел перед (
                    p += 2;
                } else {
                    p += 2;
                }

                if (list.get(p) == ' ') {// убирает пробел после (
                    list.remove(p);
                }

            }
        }
        /**
         * method checks the placement of closed brackets, fixes
         * @param list from ArrayList
         * @param p the element number of the array
         */
        void bracketClose(ArrayList<Character>list, int p) {
            if (list.get(p) == ')') {
                --p;
                if (list.get(p) == ' ') {// убирает пробел перед (
                    list.remove(p);

                } else {
                    p += 1;
                }
                p++;
                if (list.get(p) != ' ') {
                    list.add(p, ' ');// добавляет пробел после (
                }
            }
        }
    }
}
