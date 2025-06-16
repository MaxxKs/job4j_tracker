package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder buffer = new StringBuilder();
        int originalSize = evenElements.size();
        for (int i = 0; i < originalSize; i++) {
            Character element = evenElements.poll();
            if (i % 2 == 0) {
                buffer.append(element);
            }
        }
        return buffer.toString();
    }

    private String getDescendingElements() {
        StringBuilder buffer = new StringBuilder();
        int originalSize = descendingElements.size();
        for (int i = 0; i < originalSize; i++) {
            buffer.append(descendingElements.pollLast());
        }
        return buffer.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}