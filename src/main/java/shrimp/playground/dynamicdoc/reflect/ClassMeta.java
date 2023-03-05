package shrimp.playground.dynamicdoc.reflect;

import lombok.Getter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class ClassMeta<T> {
    protected final Map<String, MethodMeta> info = new HashMap<>();
    protected final Class<?> clazz;
    protected final T object;

    private String stringCache;

    public ClassMeta(T object) {
        this.object = object;
        this.clazz = object.getClass();

        init(object);
    }

    protected void init(T object) {
        Method[] methods = clazz.getMethods();

        Arrays.stream(methods)
                .forEach(method -> {
                    info.put(method.getName(), new MethodMeta(method));
                });
    }

    protected void setStringCache() {
        this.stringCache = "{\n" + info.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\": " + entry.getValue().toString())
                .collect(Collectors.joining(",\n")) + "\n}";
    }

    @Override
    public String toString() {
        if (stringCache == null) {
            setStringCache();
        }
        return stringCache;
    }
}
