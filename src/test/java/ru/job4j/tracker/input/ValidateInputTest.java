package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("one", "1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("3")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("1", "2", "3")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected1 = input.askInt("Выбрать: ");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Выбрать: ");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Выбрать: ");
        assertThat(selected3).isEqualTo(3);
    }

    @Test
    void whenValidInputNegativ() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(-1);
    }
}