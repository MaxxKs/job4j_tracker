package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) ->
                Integer.compare(left.getSize(), right.getSize());
        Comparator<String> comparatorSize = (left, right) ->
                Integer.compare(left.length(), right.length());
        System.out.println(Arrays.toString(attachments));
        Arrays.sort(attachments, comparator);
        System.out.println(Arrays.toString(attachments));
    }
}