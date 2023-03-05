package shrimp.playground.deprecate.dynamicdoc.handler;

import lombok.extern.slf4j.Slf4j;
import shrimp.playground.deprecate.dynamicdoc.reflect.MethodMeta;
import shrimp.playground.deprecate.dynamicdoc.reflect.ReturnValue;

import java.lang.reflect.Method;

@Slf4j
public class ResultMethodMeta<T> extends MethodMeta {

    private final T request;

    public ResultMethodMeta(
            T request,
            Method method
    ) {
        super(method);
        this.request = request;
    }

    public void setReturnValue() {
        try {
            Object invoke = this.method.invoke(request);
            if (invoke != null) {
                this.returnValue = new ReturnValue(invoke);
            }
        } catch (Exception e) {
            this.returnValue = new ReturnValue(e);
        }
    }
}
