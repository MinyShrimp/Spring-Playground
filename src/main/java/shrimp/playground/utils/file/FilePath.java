package shrimp.playground.utils.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilePath {

    public static String BASE_DIR = "";

    public FilePath(
            @Value("${file.dir}")
            String fileDir
    ) {
        FilePath.BASE_DIR = fileDir;
    }
}
