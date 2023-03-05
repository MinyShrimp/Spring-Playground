package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import shrimp.playground.dynamicdoc.file.FileWrite;
import shrimp.playground.dynamicdoc.fixed.HtmlBuilder;
import shrimp.playground.dynamicdoc.reflect.ClassMeta;
import shrimp.playground.dynamicdoc.reflect.RequestClassMeta;
import shrimp.playground.dynamicdoc.types.HeadMetaData;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;

@Slf4j
@Component
public class ProcessResultHandler implements ResultHandler {

    private final FileWrite fileWrite;
    private RequestClassMeta requestInfo;
    private ClassMeta<MockHttpServletResponse> responseInfo;
    private HtmlBuilder htmlBuilder;

    public ProcessResultHandler(
            FileWrite fileWrite
    ) {
        HeadMetaData headMetaData = HeadMetaData.MetaDataBuilder.builder()
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .title("Test")
                .build();
        this.htmlBuilder = new HtmlBuilder(headMetaData);

        this.fileWrite = fileWrite;
    }

    @Override
    public void handle(
            MvcResult result
    ) throws Exception {
        MockHttpServletRequest request = result.getRequest();
        MockHttpServletResponse response = result.getResponse();

        Enumeration<String> headerNames = request.getHeaderNames();
        headerNames.asIterator().forEachRemaining(name -> {
            log.info("Request {}: {}", name, request.getHeader(name));
        });

        Collection<String> headerNames1 = response.getHeaderNames();
        headerNames1.forEach(name -> {
            log.info("Response {}: {}", name, response.getHeader(name));
        });

        this.requestInfo = new RequestClassMeta(request);
        fileWrite.writeJson("request", requestInfo.toString());

        this.responseInfo = new ClassMeta<>(response);
        fileWrite.writeJson("response", responseInfo.toString());
    }
}
