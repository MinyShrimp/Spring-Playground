package shrimp.playground.dynamicdoc.component;

import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.UnsupportedEncodingException;

public class ResponseCodeBlock {

    public static String build(
            MockHttpServletRequest request,
            MockHttpServletResponse response
    ) {
        try {
            String header = request.getProtocol() + " " + response.getStatus() + " " + HttpStatus.valueOf(response.getStatus()).getReasonPhrase();
            String contentType = "Content-Type: " + response.getContentType();
            String contentLength = "Content-Length: " + response.getContentLength();
            String contentBody = response.getContentAsString();

            String content = header + "\n" + contentType + "\n" + contentLength + "\n\n" + contentBody;

            GeneralTag codeBlock = new GeneralTag("pre", content);
            return codeBlock.build();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
