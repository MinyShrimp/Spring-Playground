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

        builder.append("\t\ttype: \"").append(type).append("\",\n");
        builder.append("\t\tvalue: \"");

        if (value instanceof Throwable) {
            builder.append(((Throwable) value).getMessage());
        } else if (value instanceof String) {
            builder.append(value);
        } else {
            builder.append(value.toString());
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