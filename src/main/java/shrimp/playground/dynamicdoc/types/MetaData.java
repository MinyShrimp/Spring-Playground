package shrimp.playground.dynamicdoc.types;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MetaData {

    private String id;
    private String className;
}
