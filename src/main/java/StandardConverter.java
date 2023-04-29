public abstract class StandardConverter {
    public abstract String getType();
    public abstract String getFirstLabel();
    public abstract String getSecondLabel();
    public abstract Double convertFirstValueToSecondValue(Double firstValue);
    public abstract Double convertSecondValueToFirstValue(Double secondValue);
}
