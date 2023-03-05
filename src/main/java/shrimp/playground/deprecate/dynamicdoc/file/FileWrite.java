package shrimp.playground.deprecate.dynamicdoc.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Slf4j
public class FileWrite {

    private static void write(
            String fullPath, String contents
    ) {
        File file = Paths.get(fullPath).toFile();
        try (
                FileOutputStream stream = new FileOutputStream(file)
        ) {
            stream.write(contents.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFullPath(String filename, String ext) {
        return FilePath.BASE_DIR + "/" + filename + "." + ext;
    }

    public static void writeJson(String filename, String contents) {
        write(getFullPath(filename, "json"), contents);
    }

    public static void writeHtml(String filename, String contents) {
        write(getFullPath(filename, "html"), contents);
    }
}
