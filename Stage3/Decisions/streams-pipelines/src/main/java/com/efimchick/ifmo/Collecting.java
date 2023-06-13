package com.efimchick.ifmo;

import com.efimchick.ifmo.util.CourseResult;
import com.efimchick.ifmo.util.Person;
import com.efimchick.ifmo.util.PrintableString;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Collecting {
    public int sum(IntStream numbers) {
        int sum = numbers.reduce((accumulator, element) -> accumulator + element).getAsInt();
        return sum;
    }

    public int production(IntStream numbers) {
        int prod = numbers.reduce((accumulator, element) -> accumulator * element).getAsInt();
        return prod;
    }

    public int oddSum(IntStream numbers) {
        int odd = numbers.filter(element -> element % 2 != 0).reduce(0, (accumulator, element) -> accumulator + element);
        return odd;
    }

    public Map<Integer, Integer> sumByRemainder(int i, IntStream numbers) {
        List<Integer> list = numbers.boxed().collect(toList());
        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(element -> {
            if (map.containsKey(element % i)) {
                map.put(element % i, element + map.get(element % i));
            } else {
                map.put(element % i, element);
            }
        });
        return map;
    }

    public Map<Person, Double> totalScores(Stream<CourseResult> programmingResults) {
        Map<Person, Double> map = new HashMap<>();
        List<CourseResult> list = programmingResults.collect(toList());
        list.forEach(e -> {
            int size = (check(e.getTaskResults().keySet()) ? 4 : e.getTaskResults().values().size());
            double sum = e.getTaskResults().values().stream().reduce(0, (ac, el) -> ac + el);
            map.put(e.getPerson(), sum / size);
        });
        return map;
    }

    public double averageTotalScore(Stream<CourseResult> programmingResults) {
        List<CourseResult> list = programmingResults.collect(toList());
        Collection<Integer> result = new ArrayList<>();
        list.forEach(el -> {
            if (check(el.getTaskResults().keySet())) {
                el.getTaskResults().put("0", 0);
            }
        });
        list.forEach(el -> result.addAll(el.getTaskResults().values()));
        double average = result.stream().collect(Collectors.averagingDouble(num -> num));
        return average;
    }

    public Map<String, Double> averageScoresPerTask(Stream<CourseResult> programmingResults) {
        Map<String, Double> map = new LinkedHashMap<>();
        List<CourseResult> list = programmingResults.collect(toList());
        list.forEach(elem -> elem.getTaskResults().forEach((k, v) -> map.merge(k, (double) v, Double::sum)));
        map.forEach((k, v) -> map.put(k, map.get(k) / list.stream().count()));
        return map;
    }

    public Map<Person, String> defineMarks(Stream<CourseResult> programmingResults) {
        List<CourseResult> list = programmingResults.collect(toList());
        Map<Person, Double> map = new HashMap<>();
        Map<Person, String> mapResult = new HashMap<>();
        list.forEach(e -> {
            int size = (check(e.getTaskResults().keySet()) ? 4 : e.getTaskResults().values().size());
            double sum = e.getTaskResults().values().stream().reduce(0, (ac, el) -> ac + el);
            map.put(e.getPerson(), sum / size);
        });
        map.forEach((k, v) -> mapResult.put(k, choice(map.get(k))));
        return mapResult;
    }

    public String easiestTask(Stream<CourseResult> programmingResults) {
        Map<String, Double> map = new LinkedHashMap<>();
        List<CourseResult> list = programmingResults.collect(toList());
        list.forEach(elem -> elem.getTaskResults().forEach((k, v) -> map.merge(k, (double) v, Double::sum)));
        map.forEach((k, v) -> map.put(k, map.get(k) / list.stream().count()));
        String max = map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        return max;
    }

    public Collector<CourseResult, ?, String> printableStringCollector() {
        return Collectors.collectingAndThen(
                toList(),
                PrintableString::printableString
        );
    }

    public boolean check(Set<String> keySet) {
        for (String s : keySet) {
            return (s == "Phalanxing" || s == "Wedging" || s == "Shieldwalling" || s == "Tercioing" && s.length() != 4);
        }
        return false;
    }

    public String letter(Stream<CourseResult> courseResults) {
        return choice(averageTotalScore(courseResults));
    }

    public double averageTotalScore(Stream<CourseResult> courseResults, List<String> tasks) {
        List<CourseResult> resultList = courseResults.collect(toList());
        return resultList.stream()
                .flatMap(courseResult -> {
                            Map<String, Integer> task = courseResult.getTaskResults();
                            return tasks.stream().map(taskName -> task.getOrDefault(taskName, 0));
                        }
                )
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public String choice(Double element) {
        if (element < 60) return "F";
        if (element >= 60 && element < 68) return "E";
        if (element >= 68 && element < 75) return "D";
        if (element >= 75 && element < 83) return "C";
        if (element >= 83 && element <= 90) return "B";
        if (element > 90 && element <= 100) return "A";
        return "G";
    }
}
