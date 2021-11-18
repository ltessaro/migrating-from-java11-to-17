package switchCommand;

public enum SampleEnum {
    VALUE_1, VALUE_2, ANOTHER_VALUE;

    public static String toStringUsingSwitchExpressions(SampleEnum input) {
        return switch(input) {
            case VALUE_1 -> "VALUE1";
            case VALUE_2 -> "VALUE2";
            case ANOTHER_VALUE -> "ANOTHER_VALUE";
            default -> null;
        };
    }

    public static String toStringUsingSwitchCase(SampleEnum input) {
        String result = null;
        switch(input) {
            case VALUE_1: result = "VALUE1";
            case VALUE_2: result = "VALUE2";
            case ANOTHER_VALUE: result = "ANOTHER_VALUE";
            default: result = null;
        };
        return result;
    }

    public static String toStringUsingSwitchCaseWithBreak(SampleEnum input) {
        String result = null;
        switch(input) {
            case VALUE_1:
                result = "VALUE1";
                break;
            case VALUE_2:
                result = "VALUE2";
                break;
            case ANOTHER_VALUE:
                result = "ANOTHER_VALUE";
                break;
            default:
                result = null;
        }
        return result;
    }
}
