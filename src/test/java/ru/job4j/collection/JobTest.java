package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    void whenComparatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int result = cmpDescName.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorIncrByName() {
        Comparator<Job> cmpIncrName = new JobIncrByName();
        int result = cmpIncrName.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenComparatorDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByPriority();
        int result = cmpDescPriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorIncrByPriority() {
        Comparator<Job> cmpIncrPriority = new JobIncrByPriority();
        int result = cmpIncrPriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenComparatorIncrByPriorityEqual() {
        Comparator<Job> cmpIncrPriority = new JobIncrByPriority();
        int result = cmpIncrPriority.compare(
                new Job("A", 1),
                new Job("B", 1)
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    void whenComparatorDescByNameLength() {
        Comparator<Job> cmpDescNameLength = new JobDescByNameLength();
        int result = cmpDescNameLength.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rs1 = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rs1).isLessThan(0);
    }

    @Test
    void whenComparatorByNameLengthAndNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameLength().
                thenComparing(new JobDescByName()).
                thenComparing(new JobDescByPriority());
        int rs1 = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rs1).isGreaterThan(0);
    }
}