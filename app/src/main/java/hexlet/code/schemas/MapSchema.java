package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema sizeof(int size) {
        addCheck("sizeof", val -> val == null || val.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema> schemas) {
        Predicate<Map<?, ?>> shapeCheck = map -> {
            for (Map.Entry<String, ? extends BaseSchema> entry : schemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema schema = entry.getValue();
                Object value = map.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        };

        addCheck("shape", shapeCheck);
        return this;
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }
}
