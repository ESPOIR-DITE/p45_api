package org.example.domain.image;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VoterImage {
    @Id
    private String id;
    private String imageId;
    private String voterId;

    private VoterImage() {
    }

    public VoterImage(Builder builder) {
        this.id = builder.id;
        this.imageId = builder.imageId;
        this.voterId = builder.voterId;
    }

    public String getId() {
        return id;
    }

    public String getImageId() {
        return imageId;
    }

    public String getVoterId() {
        return voterId;
    }

    public static class Builder {
        private String id;
        private String imageId;
        private String voterId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildImageId(String imageId){
            this.imageId = imageId;
            return this;
        }
        public Builder buildVoterId(String voterId){
            this.voterId = voterId;
            return this;
        }

    public VoterImage build() {
        return new VoterImage(this);
    }
}
}
