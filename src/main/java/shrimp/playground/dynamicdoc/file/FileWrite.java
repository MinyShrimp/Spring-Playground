package shrimp.playground.dynamicdoc.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Slf4j
@Component
public class FileWrite {

    private final String fileDir;

    public FileWrite(
            @Value("${dynamicdoc.test.resource.path}") String fileDir
    ) {
        this.fileDir = fileDir;
    }

    private void write(String fullPath, String contents) {
        File file = Paths.get(fullPath).toFile();

        try (
                FileOutputStream stream = new FileOutputStream(file, false)
        ) {
            stream.write(contents.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getFullPath(String filename, String ext) {
        return fileDir + "/" + filename + "." + ext;
    }

    public void writeJson(String filename, String contents) {
        write(getFullPath(filename, "json"), contents);
    }

    public void writeHtml(String filename, String contents) {
        write(getFullPath(filename, "html"), contents);
    }
}
