package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer sizeMap = null;
    private Map<String, BaseSchema<String>> shapeSchemas = null;

    @Override
    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int value) {
        this.sizeMap = value;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    protected boolean checkRules(Map<?, ?> map) {
        if (sizeMap != null && map.size() != sizeMap) {
            return false;
        }
        if (shapeSchemas != null) {
            for (Map.Entry<String, BaseSchema<String>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> schema = entry.getValue();
                Object value = map.get(key);

                if (value != null && !schema.isValid(value.toString())) {
                    return false;
                }
                if (value == null && !schema.isValid(null)) {
                    return false;
                }
            }
        }
        return true;
    }
}
