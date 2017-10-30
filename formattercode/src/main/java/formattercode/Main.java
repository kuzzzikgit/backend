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

/**
 * Вызовы метода форматирования кода. Первое выражение - возмодное нежелательное форматирование, второе - вариант его замены.
 */
        formatCode("\\{(?=.)", "\\{\n    ");/**переносит символы после { на новую строку и добавляет отступ*/
        formatCode("\\}(?<=.)", "\n    \\}");/**переностит } на новую строку и добавляет отступ*/
        formatCode("[ \t\n\\x0B\f\r]+\\{", " \\{");/**убирает пробелы перед {*/
        formatCode("\\}(?!\n)", "\\}\n");/**переносит символы после } на новую строку*/
        formatCode("[ \t\n\\x0B\f\r]+\\)", "\\)");/**убирает пробелы перед)*/
        formatCode("[ \t\n\\x0B\f\r]+\\]", "\\]");/**убирает пробелы перед]*/
        formatCode("[ \t\n\\x0B\f\r]{2,}\\(", " \\(");/**оставляет один пробел перед (*/
        formatCode("[ \t\n\\x0B\f\r]{2,}\\[", " \\[");/**оставляет один пробел перед [*/
        formatCode("\\)[ \t\n\\x0B\f\r]{2,}", "\\) ");/**оставляет один пробел после )*/
        formatCode("\\][ \t\n\\x0B\f\r]{2,}", "\\] ");/**оставляет один пробел после ]*/
        formatCode("\\([ \t\n\\x0B\f\r]+", "\\(");/**убирает пробелы после(*/
        formatCode("\\[[ \t\n\\x0B\f\r]+", "\\[");/**убирает пробелы после[*/


    }

/**
* Метод посимвольно читает код из файла, исправляет его и записывает в новый файл
* @param regexp возмодный нежелательное форматирование
* @param replace вариант замены
* @throws Exception базовое родительское исключение
*/

     static void formatCode(String regexp, String replace) throws Exception {
/**
* Чтение из файла
*/

        FileReader readerCode = new FileReader("file22.txt");
        BufferedReader bReaderCode = new BufferedReader(readerCode);

/**
* Запись в новый файл
*/

        FileWriter writeFormat = new FileWriter("file23.txt", true);
        BufferedWriter bWriterFormat = new BufferedWriter(writeFormat);

/**
* Цикл, читающий из потока и заменяющий выражения
*/

        while (bReaderCode.ready()) {
            String str = bReaderCode.readLine();
            str = str.replaceAll(regexp, replace);
            bWriterFormat.write(str);
            bWriterFormat.newLine();
        }
/**
* Закрываем потоки чтения и записи
*/

        readerCode.close();
        bWriterFormat.close();

     }

}



