public class CmToInConverter extends StandardConverter{
    private static final String TYPE = "CM - IN";
    private static final String FIRST_LABEL = "CM";
    private static final String SECOND_LABEL = "IN";
    private static final double ONE_INCHE = 2.54;
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
    public Double convertFirstValueToSecondValue(Double centimeter) {
        return centimeter / ONE_INCHE;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double inches) {
        return inches * ONE_INCHE;
    }
}
