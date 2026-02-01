package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean required = false;

    public final BaseSchema<T> isRequired() {
        this.required = true;
        return this;
    }
    public final boolean isValid(T value) {
        if (required && value == null) {
            return false;
        }
        if (!required && value == null) {
            return true;
        }
        return checkRules(value);
    }

    protected abstract boolean checkRules(T value);
}
