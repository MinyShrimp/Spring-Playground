package shrimp.playground.dynamicdoc.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MetaData {

    private String id;
    private String className;
    private String style;
}
