package shrimp.playground.deprecate.dynamicdoc.fixed;

import lombok.RequiredArgsConstructor;
import shrimp.playground.deprecate.dynamicdoc.process.TagProcess;
import shrimp.playground.deprecate.dynamicdoc.types.Components;

@RequiredArgsConstructor
public class BodyBuilder {

    private final TagProcess process;

    public String build() {
        return Components.BODYSTART + process.process() + Components.BODYEND;
    }
}
