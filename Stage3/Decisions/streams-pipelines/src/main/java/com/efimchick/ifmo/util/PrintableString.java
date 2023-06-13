package com.efimchick.ifmo.util;

import com.efimchick.ifmo.Collecting;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PrintableString {
    private final static String student = "Student";
    private final static String mark = "Mark";
    private final static String total = "Total";
    private final static String average = "Average";
    static int width;

    public static String printableString(List<CourseResult> courseResults) {
        List<String> tasks = sort(courseResults);
        width = widthNames(courseResults);
        StringBuilder table = header(tasks);
        table.append(courseResults.stream()
                .sorted(Comparator.comparing(o -> o.getPerson().getLastName()))
                .map(courseRes -> mark(courseRes, tasks))
                .collect(joining()));
        table.append(averageResult(courseResults));
        return table.toString();
    }

    private static String averageResult(List<CourseResult> courseResults) {
        StringBuilder sb = new StringBuilder();
        Collecting collect = new Collecting();
        sb.append(average)
                .append(" ".repeat(width - average.length() + 1))
                .append("|");
        sb.append(collect.averageScoresPerTask(courseResults.stream())
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    String average = String.format("%.2f", entry.getValue()).replace(',', '.');
                    return " ".repeat(entry.getKey().length() - average.length() + 1) + average;
                })
                .collect(joining(" |", "", " |")));
        String totalAverageScore = String.format("%.2f", collect.averageTotalScore(courseResults.stream())).replace(',', '.');
        sb.append(" ".repeat(total.length() - totalAverageScore.length() + 1))
                .append(totalAverageScore)
                .append(" |");
        String totalAverageMark = collect.letter(courseResults.stream());
        sb.append(" ".repeat(mark.length() - totalAverageMark.length() + 1))
                .append(totalAverageMark)
                .append(" |");
        return sb.toString();
    }

    private static StringBuilder header(List<String> tasks) {
        StringBuilder sb = new StringBuilder(student + " ".repeat(width + 1 - student.length()) + "|");
        StringJoiner result = new StringJoiner(" | ", " ", " |");
        tasks.forEach(result::add);
        sb.append(result)
                .append(" " + total + " |")
                .append(" " + mark + " |")
                .append("\n");
        return sb;
    }

    private static List<String> sort(List<CourseResult> courseResults) {
        return courseResults.stream()
                .flatMap(courseRes -> courseRes
                        .getTaskResults()
                        .keySet()
                        .stream())
                .distinct()
                .sorted()
                .collect(toList());
    }

    private static int widthNames(List<CourseResult> courseResults) {
        return courseResults.stream()
                .map(el -> el.getPerson())
                .mapToInt(person -> (person.getLastName() + person.getFirstName() + 1).length())
                .max().getAsInt();
    }

    private static String mark(CourseResult courseResults, List<String> tasks) {
        StringBuilder sb = new StringBuilder();
        Person person = courseResults.getPerson();
        sb.append(person.getLastName())
                .append(" ")
                .append(person.getFirstName())
                .append(" ".repeat(width - (person.getFirstName().length() + person.getLastName().length())))
                .append("|");
        sb.append(collectMark(courseResults, tasks));
        Collecting collecting = new Collecting();
        String averageTotal = String.format("%.2f", collecting.averageTotalScore(Stream.of(courseResults), tasks)).replace(',', '.');
        sb.append(" ".repeat(total.length() - averageTotal.length() + 1))
                .append(averageTotal)
                .append(" |");
        String avgMark = collecting.choice(Double.valueOf(averageTotal));
        sb.append(" ".repeat(mark.length() - avgMark.length() + 1))
                .append(avgMark)
                .append(" |");
        return sb.append("\n").toString();
    }

    private static String collectMark(CourseResult courseResults, List<String> tasks) {
        return Stream.of(courseResults)
                .flatMap(courseResult ->
                {
                    Map<String, Integer> task = courseResult.getTaskResults();
                    return tasks.stream().
                            map(taskName -> Map.entry(taskName, task.getOrDefault(taskName, 0)));
                })
                .map(entry -> " ".repeat(entry.getKey().length() - String.valueOf(entry.getValue()).length() + 1) + entry.getValue() + " |")
                .collect(joining(""));
    }
}