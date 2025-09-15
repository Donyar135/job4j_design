package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenFileWithCommentsAndEmptyLines() {
        String path = "./data/with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("job4j");
        assertThat(config.value("url")).isEqualTo("jdbc:postgresql://localhost:5432/test");
    }

    @Test
    void whenLineIsInvalidThenThrowException() {
        String path = "./data/invalid.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Некорректная строка");
    }

    @Test
    void whenLineHasExtraEquals() {
        String path = "./data/extra_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key")).isEqualTo("value=1");
        assertThat(config.value("another")).isEqualTo("value=");
    }
}
