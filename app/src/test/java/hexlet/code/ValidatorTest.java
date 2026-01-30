package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {

    @Test
    public void testValidatorCreatesStringSchema() {

        Validator v = new Validator();
        StringSchema schema = v.string();

        assertEquals(StringSchema.class, schema.getClass());
    }

    @Test
    public void testValidatorCreatesNumberSchema() {

        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertEquals(NumberSchema.class, schema.getClass());
    }

    @Test
    public void testValidatorCreatesMapSchema() {

        Validator v = new Validator();
        MapSchema schema = v.map();

        assertEquals(MapSchema.class, schema.getClass());
    }
    @Test
    public void testShapeExample() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        StringSchema firstNameSchema = v.string();
        firstNameSchema.required();
        firstNameSchema.contains("ya");
        schemas.put("firstName", firstNameSchema);

        StringSchema lastNameSchema = v.string();
        lastNameSchema.required();
        lastNameSchema.contains("ov");
        schemas.put("lastName", lastNameSchema);

        schema.shape(schemas);

        Map<String, String> human = new HashMap<>();
        human.put("firstName", "Maxim");
        human.put("lastName", "Ivanov");

        assertFalse(schema.isValid(human));
    }
}
