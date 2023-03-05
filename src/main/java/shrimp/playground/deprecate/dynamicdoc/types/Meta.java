package shrimp.playground.deprecate.dynamicdoc.types;

public enum Meta {

    AUTHOR("author"),
    VIEWPORT("viewport"),
    KEYWORDS("keywords"),
    DESCRIPTION("description");

    private final String description;

    Meta(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}