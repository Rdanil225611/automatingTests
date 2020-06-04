import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest9 {

    @Test
    void isTriangleExist() {
        Triangle triangle = new Triangle();
        Boolean actual = triangle.isTriangleExist(5,6,Math.sqrt(2020));
        Boolean expected = false;
        assertEquals(expected, actual);

    }
}