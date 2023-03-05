package shrimp.playground.deprecate.dynamicdoc.process;

@FunctionalInterface
public interface TagProcess {

    TagProcess DefaultProcess = () -> "";

    String process();
}
