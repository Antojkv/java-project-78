package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NumberSchemaTest {
    @Test
    public void testWithoutRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));
    }
    @Test
    public void testWithRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required();

        assertFalse(schema.isValid(null));
    }
    @Test
    public void testPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.positive();

        assertFalse(schema.isValid(-1));
    }
    @Test
    public void testRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.range(10, 20);

        assertTrue(schema.isValid(15));
    }
    @Test
    public void testAllParameters() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        schema.required();
        schema.positive().range(11, 13);

        assertTrue(schema.isValid(12));
    }
}
