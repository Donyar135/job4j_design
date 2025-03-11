package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void toList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list)
                .containsExactly("first", "second", "three", "four", "five")
                .containsExactlyInAnyOrder("three", "four", "five", "first", "second")
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("second", "three");
    }

    @Test
    void toSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("one", "two", "three");
        assertThat(set).first().isEqualTo("one");
        assertThat(set).element(1).isNotNull()
                .isEqualTo("two");
        assertThat(set).last().isNotNull()
                .isEqualTo("three");
    }

    @Test
    void toMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "2", "3");
        assertThat(map).hasSize(3)
                .containsKeys(String.valueOf(1))
                .containsValues(Integer.valueOf("2"))
                .doesNotContainKey(String.valueOf(0))
                .doesNotContainValue(Integer.valueOf("3"))
                .containsEntry("2", 1);
    }
}