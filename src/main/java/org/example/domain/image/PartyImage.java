package org.example.domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PartyImage {
    @Id
    private String id;
    private String partyId;
    private String imageId;

    private PartyImage() {
    }

    public PartyImage(Builder builder) {
        this.id = builder.id;
        this.partyId = builder.partyId;
        this.imageId = builder.imageId;
    }

    public String getId() {
        return id;
    }

    public String getPartyId() {
        return partyId;
    }

    public String getImageId() {
        return imageId;
    }
    public static class Builder{
        private String id;
        private String partyId;
        private String imageId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildPartyId(String partyId){
            this.partyId = partyId;
            return this;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public PartyImage build(){
            return new PartyImage(this);
        }
    }
}
