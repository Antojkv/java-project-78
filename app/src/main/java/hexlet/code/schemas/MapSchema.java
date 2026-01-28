package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer size = null;

    public MapSchema() {
        super();
    }

    public MapSchema sizeof(int value) {
        this.size = value;
        return this;
    }

    @Override
    protected boolean checkRules(Map<?, ?> map) {
        if (size != null && map.size() != size) {
            return false;
        }
        return true;
    }
}
