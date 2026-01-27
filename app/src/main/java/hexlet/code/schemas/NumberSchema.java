package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean mustBePositive = false;
    private Integer rangeMin = null;
    private Integer rangeMax = null;

    public NumberSchema() {
        super();
    }

    public NumberSchema positive() {
        this.mustBePositive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.rangeMin = min;
        this.rangeMax = max;
        return this;
    }

    @Override
    protected boolean checkRules(Integer value) {
        if (mustBePositive && value <= 0) {
            return false;
        }
        if (rangeMin != null && rangeMax != null) {
            if (value < rangeMin || value > rangeMax) {
                return false;
            }
        }
        return true;
    }

}
