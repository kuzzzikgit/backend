/**
 * Пакет, содержащий форматтер кода из текстового файла file22.txt в файл file23.txt
 */
package ru.kuzzzik.formattercode;

import java.io.*;

/**
 * Класс служит для исправления расстановки скобок и отступов
 * @author kuzzzik (Кузовлева Оксана)
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws Exception {

        formatCode("\\{(?=.)", "\\{\n    ");
        formatCode("\\}(?<=.)", "\n    \\}");
        formatCode("[ \t\n\\x0B\f\r]+\\{", " \\{");
        formatCode("\\}(?!\n)", "\\}\n");
        formatCode("[ \t\n\\x0B\f\r]+\\)", "\\)");
        formatCode("[ \t\n\\x0B\f\r]+\\]", "\\]");
        formatCode("[ \t\n\\x0B\f\r]{2,}\\(", " \\(");
        formatCode("[ \t\n\\x0B\f\r]{2,}\\[", " \\[");
        formatCode("\\)[ \t\n\\x0B\f\r]{2,}", "\\) ");
        formatCode("\\][ \t\n\\x0B\f\r]{2,}", "\\] ");
        formatCode("\\([ \t\n\\x0B\f\r]+", "\\(");
        formatCode("\\[[ \t\n\\x0B\f\r]+", "\\[");


    }

/**
* Метод посимвольно читает код из файла, исправляет его и записывает в новый файл
* @param regexp возмодный нежелательное форматирование
* @param replace вариант замены
* @throws Exception базовое родительское исключение
*/

     static void formatCode(String regexp, String replace) throws Exception {

         FileReader readerCode = new FileReader("file22.txt");
        BufferedReader bReaderCode = new BufferedReader(readerCode);

         FileWriter writeFormat = new FileWriter("file23.txt", true);
        BufferedWriter bWriterFormat = new BufferedWriter(writeFormat);

         while (bReaderCode.ready()) {
            String str = bReaderCode.readLine();
            str = str.replaceAll(regexp, replace);
            bWriterFormat.write(str);
            bWriterFormat.newLine();
        }

         readerCode.close();
        bWriterFormat.close();

     }

}




