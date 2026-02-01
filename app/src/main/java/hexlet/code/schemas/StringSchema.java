package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema minLength(int length) {
        addCheck("minLength", val -> val == null || val.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", val -> val == null || val.contains(substring));
        return this;
    }

    @Override
    public StringSchema required() {
        super.required();
        addCheck("notEmpty", val -> !val.isEmpty());
        return this;
    }
}
