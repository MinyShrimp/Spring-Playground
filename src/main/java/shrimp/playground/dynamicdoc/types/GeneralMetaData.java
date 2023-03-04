package shrimp.playground.dynamicdoc.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralMetaData extends MetaData {
    private String name;

    GeneralMetaData(String id, String className, String name) {
        super(id, className);
        this.name = name;
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
