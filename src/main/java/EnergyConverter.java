public class EnergyConverter extends StandardConverter{
    private static final String TYPE = "Energy Converter";
    private static final String FIRST_LABEL = "Julio";
    private static final String SECOND_LABEL = "kilocalorie";
    private static final double TO_CONVERT = 4184;
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
    public Double convertFirstValueToSecondValue(Double julio) {
        return julio / TO_CONVERT;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double kilocalorie) {
        return kilocalorie * TO_CONVERT;
    }
}
