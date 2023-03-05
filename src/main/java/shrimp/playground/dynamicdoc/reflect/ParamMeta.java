package shrimp.playground.dynamicdoc.reflect;

import lombok.Getter;

import java.lang.reflect.Parameter;

@Getter
public class ParamMeta {
    private final Parameter param;

    private final String type;
    private final String name;

    public ParamMeta(Parameter param) {
        this.param = param;
        this.type = param.getType().getSimpleName();
        this.name = param.getName();
    }

    @Override
    public String toString() {
        return "{ type: \"" + type + "\", name: \"" + name + "\" },";
    }
}