package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean isRequired;

    public BaseSchema() {
        this.isRequired = false;
    }

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    protected abstract boolean checkRules(T value);

    public boolean isValid(T value) {

        if (!isRequired && value == null) {
            return true;
        }
        if (isRequired && value == null) {
            return false;
        }
        return checkRules(value);
    }
}
