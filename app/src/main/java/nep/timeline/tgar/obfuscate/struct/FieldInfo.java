package nep.timeline.tgar.obfuscate.struct;

public class FieldInfo {
    private final String className;
    private final String original;
    private final String resolved;

    public FieldInfo(String className, String original, String resolved)
    {
        this.className = className;
        this.original = original;
        this.resolved = resolved;
    }

    public String getClassName() {
        return this.className;
    }

    public String getOriginal() {
        return this.original;
    }

    public String getResolved() {
        return this.resolved;
    }
}
