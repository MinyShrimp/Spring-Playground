package shrimp.playground.dynamicdoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.test.web.servlet.ResultHandler;

@Slf4j
public class Document {

    public static ResultHandler document(
            String filename
    ) {
        return new ProcessResultHandler(filename);
    }
}
