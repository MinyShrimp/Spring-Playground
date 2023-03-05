package shrimp.playground.deprecate.dynamicdoc.handler;

import shrimp.playground.deprecate.dynamicdoc.reflect.ClassMeta;
import shrimp.playground.deprecate.dynamicdoc.reflect.MethodMeta;

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
                .filter(method -> method.getName().contains("get"))
                .forEach(method -> {
                    info.put(method.getName(), new ResultMethodMeta<>(object, method));
                });

        info.values().stream().filter(param -> param.getParams().size() == 0)
                .forEach(MethodMeta::setReturnValue);
    }
}
