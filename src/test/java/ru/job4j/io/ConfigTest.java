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
        assertThat(config.value("age")).isEqualTo("35");
    }

    @Test
    void whenWithCommentsAndEmptyLines() {
        String path = "./data/with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("user")).isEqualTo("Daniyar");
        assertThat(config.value("lang")).isEqualTo("Java");
    }

    @Test
    void whenLineHasExtraEqualSign() {
        String path = "./data/extra_equal.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("url")).isEqualTo("jdbc=postgresql");
        assertThat(config.value("token")).isEqualTo("");
    }

    @Test
    void whenInvalidLineNoEquals() {
        String path = "./data/invalid_no_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("without '='");
    }

    @Test
    void whenInvalidLineEmptyKey() {
        String path = "./data/invalid_empty_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Key is missing");
    }
}
