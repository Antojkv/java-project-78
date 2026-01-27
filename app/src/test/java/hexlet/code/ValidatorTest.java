package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    @Test
    public void testValidatorCreatesStringSchema() {

        Validator validator = new Validator();

        StringSchema schema = validator.string();
        assertEquals(StringSchema.class, schema.getClass());
    }

    @Test
    public void testValidatorCreatesNumberSchema() {

        Validator validator = new Validator();

        NumberSchema schema = validator.number();
        assertEquals(NumberSchema.class, schema.getClass());
    }
}
