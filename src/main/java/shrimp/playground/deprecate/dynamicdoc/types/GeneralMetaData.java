package shrimp.playground.deprecate.dynamicdoc.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralMetaData extends MetaData {
    private String name;
    private String content;

    public GeneralMetaData(String name, String content) {
        super(null, null, null);
        this.name = name;
        this.content = content;
    }

    public GeneralMetaData(String name, String content, String id, String className, String style) {
        super(id, className, style);
        this.name = name;
        this.content = content;
    }
}
