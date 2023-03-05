package shrimp.playground.utils.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ResultClassMeta<T> extends ClassMeta<T> {

    public ResultClassMeta(
            T request
    ) {
        super(request);
    }

    @Override
    protected void init(T request) {
        Method[] methods = clazz.getMethods();

        Arrays.stream(methods)
                .filter(method -> method.getParameterCount() == 0)
                .forEach(method -> {
                    info.put(method.getName(), new ResultMethodMeta<>(object, method));
                });

        info.values().forEach(MethodMeta::setReturnValue);
    }
}
