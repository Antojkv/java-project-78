package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema positive() {
        addCheck("positive", val ->  val == null || val > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", val -> val == null || (val >= min && val <= max));
        return this;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }
}
