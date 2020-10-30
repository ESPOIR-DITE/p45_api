package org.example.controller.user;

import java.io.File;

public class PartyHelper {
    private String id;
    private String name;
    private String description;
    private File flag;

    public PartyHelper() {
    }

    public PartyHelper(String id, String name, String description, File flag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.flag = flag;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFlag() {
        return flag;
    }

    public void setFlag(File flag) {
        this.flag = flag;
    }
}
