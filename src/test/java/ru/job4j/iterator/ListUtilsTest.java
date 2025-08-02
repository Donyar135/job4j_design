package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIfLengthEquals4() {
        List<String> list = new ArrayList<>(List.of("tree", "rock", "mountain", "sky"));
        ListUtils.removeIf(list, s -> s.length() == 4);
        assertThat(list).containsExactly("mountain", "sky");
    }

    @Test
    void whenReplaceIfLengthEquals3() {
        List<String> list = new ArrayList<>(List.of("cat", "dog", "tiger", "cow"));
        ListUtils.replaceIf(list, s -> s.length() == 3, "pet");
        assertThat(list).containsExactly("pet", "pet", "tiger", "pet");
    }

    @Test
    void whenRemoveAll() {
        List<String> list = new ArrayList<>(List.of("apple", "banana", "cherry", "date"));
        List<String> toRemove = List.of("banana", "date");
        ListUtils.removeAll(list, toRemove);
        assertThat(list).containsExactly("apple", "cherry");
    }

    @Test
    void whenAddBeforeWithInvalidIndexThenException() {
        List<String> list = new ArrayList<>(List.of("one"));
        assertThatThrownBy(() -> ListUtils.addBefore(list, 2, "fail"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfterWithInvalidIndexThenException() {
        List<String> list = new ArrayList<>(List.of("one"));
        assertThatThrownBy(() -> ListUtils.addAfter(list, 1, "fail"))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}