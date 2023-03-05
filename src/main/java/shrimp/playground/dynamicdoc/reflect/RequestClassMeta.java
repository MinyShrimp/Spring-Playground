package shrimp.playground.dynamicdoc.reflect;

import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Method;
import java.util.Arrays;

public class RequestClassMeta extends ClassMeta<MockHttpServletRequest> {

    public RequestClassMeta(
            MockHttpServletRequest request
    ) {
        super(request);
    }

    @Override
    protected void init(MockHttpServletRequest request) {
        Method[] methods = clazz.getMethods();

        Arrays.stream(methods)
                .filter(method -> method.getName().contains("get"))
                .forEach(method -> {
                    info.put(method.getName(), new RequestMethodMeta(object, method));
                });

        info.values().stream().filter(param -> param.getParams().size() == 0)
                .forEach(MethodMeta::setReturnValue);
    }
}
