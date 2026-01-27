package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    private Integer minLength = 0;
    private String mustContain = null;

    public StringSchema() {
        super();
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.mustContain = substring;
        return this;
    }

    @Override
    protected boolean checkRules(String value) {
        if (isRequired && value.isEmpty()) {
            return false;
        }
        if (minLength != null && value.length() < minLength) {
            return false;
        }
        if (mustContain != null && !value.contains(mustContain)) {
            return false;
        }
        return true;
    }
}
