package shrimp.playground.dynamicdoc.process;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import shrimp.playground.dynamicdoc.component.ResponseCodeBlock;

@Slf4j
@RequiredArgsConstructor
public class ResponseProcess implements TagProcess {

    private final MockHttpServletRequest request;
    private final MockHttpServletResponse response;

    @Override
    public String process() {
        return ResponseCodeBlock.build(request, response);
    }
}
