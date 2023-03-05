package shrimp.playground.dynamicdoc.reflect;

import lombok.Getter;

@Getter
public class ReturnValue {
    private final String type;
    private final Object value;
    private String stringCache;

    public ReturnValue(Object value) {
        this.type = value.getClass().getSimpleName();
        this.value = value;
    }

    public void setStringCache() {
        StringBuilder builder = new StringBuilder("{\n");

        builder.append("\t\t\"type\": \"").append(type).append("\",\n");
        builder.append("\t\t\"value\": \"");

        if (value instanceof Throwable) {
            builder.append(((Throwable) value).getMessage());
        } else {
            builder.append(value.toString().replace("\"", "'"));
        }

        builder.append("\"\n\t}");
        this.stringCache = builder.toString();
    }

    @Override
    public String toString() {
        if (stringCache == null) {
            this.setStringCache();
        }
        return stringCache;
    }
}