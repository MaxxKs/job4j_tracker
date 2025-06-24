package ru.job4j.collection;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
        Collections.sort(jobs, new SortDescByNameJob());
        System.out.println(jobs);
    }
}
