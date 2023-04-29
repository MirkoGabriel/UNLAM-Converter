public class MeToKmConverter extends StandardConverter{
    private static final String TYPE = "M - KM";
    private static final String FIRST_LABEL = "M";
    private static final String SECOND_LABEL = "KM";
    private static final double ONE_KILOMETER = 1000;
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
    public Double convertFirstValueToSecondValue(Double kilometer) {
        return kilometer / ONE_KILOMETER;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double meter) {
        return meter * ONE_KILOMETER;
    }
}
