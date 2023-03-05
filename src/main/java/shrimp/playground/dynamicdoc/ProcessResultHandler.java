package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import shrimp.playground.dynamicdoc.fixed.HtmlBuilder;
import shrimp.playground.dynamicdoc.reflect.RequestClassMeta;
import shrimp.playground.dynamicdoc.types.HeadMetaData;

import java.util.Locale;

@Slf4j
@Component
public class ProcessResultHandler implements ResultHandler {

    private RequestClassMeta requestInfo;
    private HtmlBuilder htmlBuilder;

    public ProcessResultHandler() {
        HeadMetaData headMetaData = HeadMetaData.MetaDataBuilder.builder()
                .lang(Locale.KOREA)
                .charset("UTF-8")
                .title("Test")
                .build();
        this.htmlBuilder = new HtmlBuilder(headMetaData);
    }

    private void setRequestInfos(
            MockHttpServletRequest request
    ) {
        this.requestInfo = new RequestClassMeta(request);
        log.info("{}", requestInfo);
    }

    @Override
    public void handle(
            MvcResult result
    ) throws Exception {
        MockHttpServletRequest request = result.getRequest();
        MockHttpServletResponse response = result.getResponse();

        setRequestInfos(request);
    }
}
