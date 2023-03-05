package shrimp.playground.dynamicdoc.process;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import shrimp.playground.dynamicdoc.component.RequestCodeBlock;

@Slf4j
@RequiredArgsConstructor
public class RequestProcess implements TagProcess {

    private final MockHttpServletRequest request;

    @Override
    public String process() {
        return RequestCodeBlock.build(request);
    }
}
