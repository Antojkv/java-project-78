package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean required = false;

    public abstract BaseSchema<T> required();

    protected void setRequired(boolean required) {
        this.required = required;
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
