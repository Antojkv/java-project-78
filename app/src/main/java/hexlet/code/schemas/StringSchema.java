package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired;
    private int minLength;
    private String mustContain;

    public StringSchema() {
        this.isRequired = false;
        this.minLength = 0;
        this.mustContain = null;
    }

    public StringSchema required() {
        this.isRequired = true;
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

    public boolean isValid(String value) {
        if (isRequired) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        } else {
            if (value == null || value.isEmpty()) {
                return true;
            }
        }
        if (minLength > 0 && value.length() < minLength) {
            return false;
        }
        if (mustContain != null && !value.contains(mustContain)) {
            return false;
        }
        return true;
    }
}
