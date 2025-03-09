package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data")
                .message()
                .isNotEmpty();
    }

    @Test
    void checkNames() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }

    @Test
    void checkName() {
        NameLoad nameLoad = new NameLoad();
        String word = "Daniyar";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                /*проверяем, что в сообщении есть соответствующие параметры:*/
                .hasMessageContaining(word)
                /*проверяем наличие конкретного слова в сообщении:*/
                .hasMessageContaining("Daniyar does not contain the symbol '='");
    }

    @Test
    void checkNam() {
        NameLoad nameLoad = new NameLoad();
        String word = "=Petr";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                /*проверяем, что в сообщении есть соответствующие параметры:*/
                .hasMessageContaining(word)
                /*проверяем наличие конкретного слова в сообщении:*/
                .hasMessageContaining("=Petr does not contain a key");
    }

    @Test
    void checkNa() {
        NameLoad nameLoad = new NameLoad();
        String word = "Marat=";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                /*проверяем, что в сообщении есть соответствующие параметры:*/
                .hasMessageContaining(word)
                /*проверяем наличие конкретного слова в сообщении:*/
                .hasMessageContaining("Marat= does not contain a value");
    }
}