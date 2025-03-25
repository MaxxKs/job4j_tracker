package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1", "2", "two", "3", "4", "-5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Выбрать: ");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Выбрать: ");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Выбрать: ");
        assertThat(selected3).isEqualTo(3);
        int selected4 = input.askInt("Выбрать: ");
        assertThat(selected4).isEqualTo(4);
        int selected5 = input.askInt("Выбрать: ");
        assertThat(selected5).isEqualTo(-5);
    }
}