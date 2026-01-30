package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    private Integer minLength = null;
    private String mustContain = null;

    @Override
    public StringSchema required() {
        setRequired(true);
        return this;
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
        if (required && value.isEmpty()) {
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
