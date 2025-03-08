package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void checkNumberOfVertices() {
        Box box = new Box(4, 1);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void checkTypeIsExist() {
        Box box = new Box(3, 12);
        boolean result = box.isExist();
        int vertex = box.getNumberOfVertices();
        assertThat(result).isFalse();
        assertThat(vertex).isEqualTo(-1);
    }

    @Test
    void getArea() {
        Box box = new Box(4, 2);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
        double result = box.getArea();
        assertThat(result).isEqualTo(6.93d, withPrecision(0.008d))
                .isCloseTo(6.92d, withPrecision(0.01d))
                .isCloseTo(6.92d, Percentage.withPercentage(1.0d))
                .isGreaterThan(6.92d)
                .isLessThan(6.93d);

    }
}