package shrimp.playground.dynamicdoc.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralMetaData extends MetaData {
    private String name;

    public GeneralMetaData(String id, String className, String style, String name) {
        super(id, className, style);
        this.name = name;
    }

    public static GeneralMetaData defaultGeneralMetaData(String name) {
        return new GeneralMetaData(null, null, null, name);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getClassName() {
        return super.getClassName();
    }

    @Override
    public void setClassName(String className) {
        super.setClassName(className);
    }
}
