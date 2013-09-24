package jogoanatomia.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organ {
    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty("image_file_name")
    private String imageFileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
