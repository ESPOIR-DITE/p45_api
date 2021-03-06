package org.example.domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Images {
    @Id
    private String id;
    private byte[] images;

    private Images() {
    }

    public Images(Builder builder) {
        this.id = builder.id;
        this.images = builder.images;
    }

    public String getId() {
        return id;
    }

    public byte[] getImages() {
        return images;
    }
    public static class Builder{
        private String id;
        private byte[] images;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildImage( byte[] images){
            this.images = images;
            return this;
        }
        public Images build(){
            return new Images(this);
        }
    }
}
