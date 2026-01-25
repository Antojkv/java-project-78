package hexlet.code;

import org.junit.jupiter.api.Test;
import hexlet.code.schemas.StringSchema;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    @Test
    public void testValidatorCreatesStringSchema() {

        Validator validator = new Validator();

        hexlet.code.schemas.StringSchema schema = validator.string();
        assertEquals(StringSchema.class, schema.getClass());
    }
}
