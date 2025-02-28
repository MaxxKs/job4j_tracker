package ru.job4j.tracker;

    public class MockInput implements Input {
        @Override
        public String askScr(String question) {
            return null;
        }

        @Override
        public int askInt(String question) {
            return 0;
        }
    }
