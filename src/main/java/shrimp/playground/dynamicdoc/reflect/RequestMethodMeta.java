package shrimp.playground.dynamicdoc.reflect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Method;

@Slf4j
public class RequestMethodMeta extends MethodMeta {

    private final MockHttpServletRequest request;


    public RequestMethodMeta(
            MockHttpServletRequest request,
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
