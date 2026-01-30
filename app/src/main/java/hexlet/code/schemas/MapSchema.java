package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer size = null;
    private Map<String, BaseSchema> shapeSchemas = null;

    public MapSchema() {
        super();
    }

    public MapSchema sizeof(int value) {
        this.size = value;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    protected boolean checkRules(Map<?, ?> map) {
        if (size != null && map.size() != size) {
            return false;
        }
        if (shapeSchemas != null) {
            for (Map.Entry<String, BaseSchema> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema schema = entry.getValue();
                Object value = map.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
