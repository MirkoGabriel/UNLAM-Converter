public class TemperatureConverter extends StandardConverter{
    private static final String TYPE = "Temperature Converter";
    private static final String FIRST_LABEL = "Celsius";
    private static final String SECOND_LABEL = "Fahrenheit";
    private static final double FAHARENHEIT_ADITION = 32;
    private static final double FAHARENHEIT_MULT = 1.8;
    private static final double CELSIUS_MULT = 0.55;
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
    public Double convertFirstValueToSecondValue(Double celsius) {
        return (celsius * FAHARENHEIT_MULT) + FAHARENHEIT_ADITION;
    }
    @Override
    public Double convertSecondValueToFirstValue(Double fahrenheit) {
        return (fahrenheit - FAHARENHEIT_ADITION) * CELSIUS_MULT;
    }
}
