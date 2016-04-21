package net.lightbody.bmp.core.har;

public class HarNameVersion {
    private String name;
    private String version;
    private volatile String comment = "";

    public HarNameVersion() {
    }    
    
    public HarNameVersion(String name, String version) {
        this.setName(name);
        this.setVersion(version);
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
