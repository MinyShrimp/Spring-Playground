package shrimp.playground.dynamicdoc.reflect;

import lombok.Getter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MethodMeta {
    protected final Method method;
    protected final List<ParamMeta> params;
    protected ReturnValue returnValue;

    protected String stringCache;

    public MethodMeta(Method method) {
        this.method = method;
        this.params = Arrays.stream(method.getParameters()).map(ParamMeta::new).collect(Collectors.toList());
        this.returnValue = null;
    }

    public void setReturnValue() {
        this.returnValue = null;
    }

    private void setStringCache() {
        StringBuilder builder = new StringBuilder("{\n\tparams: [");

        if (params.size() != 0) {
            String paramsString = params.stream()
                    .map(ParamMeta::toString)
                    .collect(Collectors.joining());

            builder.append("\n\t\t")
                    .append(paramsString)
                    .append("\n\t");
        }

        builder.append("],\n\treturnValue: ");

        if (returnValue == null) {
            builder.append("null");
        } else {
            builder.append(returnValue);
        }

        this.stringCache = builder.append("\n}").toString();
    }

    @Override
    public String toString() {
        if (stringCache == null) {
            setStringCache();
        }
        return stringCache;
    }
}