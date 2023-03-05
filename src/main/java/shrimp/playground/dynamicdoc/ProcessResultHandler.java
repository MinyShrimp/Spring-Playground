package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import shrimp.playground.dynamicdoc.file.FileWrite;
import shrimp.playground.dynamicdoc.fixed.HtmlBuilder;
import shrimp.playground.dynamicdoc.process.RequestProcess;
import shrimp.playground.dynamicdoc.process.ResponseProcess;
import shrimp.playground.dynamicdoc.types.HeadMetaData;

@Slf4j
@Component
public class ProcessResultHandler implements ResultHandler {

    private final FileWrite fileWrite;
    private final HeadMetaData headMetaData;

    public ProcessResultHandler(
            FileWrite fileWrite
    ) {
        this.headMetaData = HeadMetaData.defaultHeadMetaData();
        this.fileWrite = fileWrite;
    }

    @Override
    public void handle(
            MvcResult result
    ) throws Exception {
        MockHttpServletRequest request = result.getRequest();
        MockHttpServletResponse response = result.getResponse();
        response.setCharacterEncoding("UTF-8");

        RequestProcess requestProcess = new RequestProcess(request);
        HtmlBuilder htmlBuilder = new HtmlBuilder(headMetaData, requestProcess);
        fileWrite.writeHtml("request", htmlBuilder.build());

        ResponseProcess responseProcess = new ResponseProcess(request, response);
        htmlBuilder.setTagProcess(responseProcess);
        fileWrite.writeHtml("response", htmlBuilder.build());
    }
}
