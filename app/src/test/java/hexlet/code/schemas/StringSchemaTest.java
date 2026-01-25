package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    public void testWithoutRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("text"));
    }

    @Test
    public void testWithRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void testMinLength() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.minLength(5);

        assertFalse(schema.isValid("pig"));
        assertTrue(schema.isValid("hexlet"));
    }

    @Test
    public void testContain() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.contains("world");

        assertFalse(schema.isValid("hello"));
        assertTrue(schema.isValid("hello world"));
    }

    @Test
    public void testAllParameters() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required().minLength(4).contains("world");

        assertFalse(schema.isValid("hello"));
        assertTrue(schema.isValid("hello world"));
    }
}
