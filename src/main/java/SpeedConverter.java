public class SpeedConverter extends StandardConverter{
    private static final String TYPE = "Speed Converter";
    private static final String FIRST_LABEL = "Meter per second";
    private static final String SECOND_LABEL = "kilometer per hour";
    private static final double TO_CONVERT = 3.6;
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
    public Double convertFirstValueToSecondValue(Double meterPerSecond) {
        return meterPerSecond * TO_CONVERT;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double kilometerPerHour) {
        return kilometerPerHour / TO_CONVERT;
    }
}
