package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import shrimp.playground.dynamicdoc.file.FileWrite;
import shrimp.playground.dynamicdoc.fixed.HtmlBuilder;
import shrimp.playground.dynamicdoc.process.RequestProcess;
import shrimp.playground.dynamicdoc.process.ResponseProcess;
import shrimp.playground.dynamicdoc.types.HeadMetaData;

@Slf4j
public class ProcessResultHandler implements ResultHandler {

    private final String filename;
    private final HtmlBuilder htmlBuilder;

    public ProcessResultHandler(String filename) {
        HeadMetaData headMetaData = HeadMetaData.defaultHeadMetaData();
        this.htmlBuilder = new HtmlBuilder(headMetaData);
        this.filename = filename;
    }

    @Override
    public void handle(
            MvcResult result
    ) {
        MockHttpServletRequest request = result.getRequest();
        MockHttpServletResponse response = result.getResponse();
        response.setCharacterEncoding("UTF-8");

        RequestProcess requestProcess = new RequestProcess(request);
        htmlBuilder.setTagProcess(requestProcess);
        FileWrite.writeHtml(filename + "-request", htmlBuilder.build());

        ResponseProcess responseProcess = new ResponseProcess(request, response);
        htmlBuilder.setTagProcess(responseProcess);
        FileWrite.writeHtml(filename + "-response", htmlBuilder.build());
    }
}
