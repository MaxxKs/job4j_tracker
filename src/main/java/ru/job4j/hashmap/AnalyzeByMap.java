package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int subjectsCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                subjectsCount++;
            }
        }
        return (double) totalScore / subjectsCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int totalScore = 0;
        int subjectsCount = 0;
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                subjectsCount++;
            }
            result.add(new Label(pupil.name(), (double) totalScore / subjectsCount));
            totalScore = 0;
            subjectsCount = 0;
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = subject.score();
                map.put(name, map.getOrDefault(name, 0) + score);
            }
        }
        List<Label> result = new ArrayList<>();
        int pupilCount = pupils.size();
        for (String key : map.keySet()) {
            result.add(new Label(key, (double) map.get(key) / pupilCount));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int totalScore = 0;
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            result.add(new Label(pupil.name(), (double) totalScore));
            totalScore = 0;
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int totalScore = subject.score();
                map.put(name,
                        map.getOrDefault(name, 0) + totalScore);
            }
        }
        List<Label> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(new Label(key, (double) map.get(key)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}