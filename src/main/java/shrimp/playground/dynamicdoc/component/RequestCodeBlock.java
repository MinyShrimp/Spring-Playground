package shrimp.playground.dynamicdoc.component;

import org.springframework.mock.web.MockHttpServletRequest;

import java.io.UnsupportedEncodingException;

public class RequestCodeBlock {

    public static String build(
            MockHttpServletRequest request
    ) {
        try {
            String header = request.getMethod() + " " + request.getPathInfo() + " " + request.getProtocol();
            String contentType = "Content-Type: " + request.getContentType();
            String contentLength = "Content-Length: " + request.getContentLength();
            String host = "Host: " + request.getRemoteHost() + ":" + request.getRemotePort();
            String contentBody = request.getContentAsString();

            String content = header + "\n" + contentType + "\n" + contentLength + "\n" + host + "\n\n" + contentBody;

            GeneralTag codeBlock = new GeneralTag("pre", content);
            return codeBlock.build();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
