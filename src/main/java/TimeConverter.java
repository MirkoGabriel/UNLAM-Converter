public class TimeConverter extends StandardConverter{
    private static final String TYPE = "Time Converter";
    private static final String FIRST_LABEL = "Minutes";
    private static final String SECOND_LABEL = "Hours";
    private static final double ONE_HOUR = 60;
    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getFirstLabel() {
        return FIRST_LABEL;
    }

    @Override
    public String getSecondLabel() {
        return SECOND_LABEL;
    }

    @Override
    public Double convertFirstValueToSecondValue(Double minutes) {
        return minutes / ONE_HOUR;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double hour) {
        return hour * ONE_HOUR;
    }
}
