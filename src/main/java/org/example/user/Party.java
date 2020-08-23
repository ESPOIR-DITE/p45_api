package org.example.user;

public class Party {
    private String id;
    private String name;
    private String description;

    public Party(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String name;
        private String description;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Party build(){
            return new Party(this);
        }
    }
}
