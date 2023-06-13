package com.epam.upskill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//2.  Дана строка, содержащая следующий текст (xml-документ):
// Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа
// и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
// Пользоваться готовыми парсерами XML для решения данной задачи нельзя.

public class Task3_2 {
    public static void main(String[] args) {

        String xml = "<notes>\n" +
                "<note id = \"1\">\n" +
                "<to>Вася</to>\n" +
                "<from>Света</from>\n" +
                "<heading>Напоминание</heading>\n" +
                "<body>Позвони мне завтра!</body>\n" +
                "</note>\n" +
                "<note id = \"2\">\n" +
                "<to>Петя</to>\n" +
                "<from>Маша</from>\n" +
                "<heading>Важное напоминание</heading>\n" +
                "<body/>\n" +
                "</note>\n" +
                "</notes>";

        String[] xmlDoc = xml.split("\\n");
        StringBuilder stringBuilder = new StringBuilder();
        Pattern openTag = Pattern.compile("<[\\w=\"\\s]+>");
        Pattern closeTag = Pattern.compile("<(/+[\\w]+?)>");
        Pattern emptyTag = Pattern.compile("<([\\w]+/)>");
        Pattern contentTag = Pattern.compile("[а-яА-яЁё\\s]+[!.?,]?");

        for (String xmlText : xmlDoc) {

            Matcher openTagMatcher = openTag.matcher(xmlText);
            if (openTagMatcher.find()) {
                stringBuilder.append("Открывающий тег: ");
                stringBuilder.append(openTagMatcher.group());
            }

            Matcher contentTagMatcher = contentTag.matcher(xmlText);
            if (contentTagMatcher.find() && !contentTagMatcher.group().equals(" ")) {
                stringBuilder.append(" Содержимое тега: ");
                stringBuilder.append(contentTagMatcher.group());
                stringBuilder.append(" ");
            }

            Matcher emptyTagMatcher = emptyTag.matcher(xmlText);
            if (emptyTagMatcher.find()) {
                stringBuilder.append(emptyTagMatcher.group());
                stringBuilder.append(" Пустой тег ");
            }

            Matcher closeTagMatcher = closeTag.matcher(xmlText);
            if (closeTagMatcher.find()) {
                stringBuilder.append("Закрывающий тег: ");
                stringBuilder.append(closeTagMatcher.group());
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

}
