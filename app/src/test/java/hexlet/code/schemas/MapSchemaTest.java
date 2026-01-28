package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapSchemaTest {
    @Test
    public void testWithoutRequired() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }
    @Test
    public void testWithRequired() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        assertTrue(schema.isValid(data));
    }
    @Test
    public void testSizeof() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        schema.sizeof(2);

        Map<String, String> data = new HashMap<>();
        data.put("key", "value");
        data.put("key1", "value2");
        assertTrue(schema.isValid(data));
    }
}
