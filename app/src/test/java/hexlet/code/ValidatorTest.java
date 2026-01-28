package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
