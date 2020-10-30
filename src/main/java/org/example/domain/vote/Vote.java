package org.example.domain.vote;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote {
    @Id
    private String id;
    private String candidateId;
    private String date;
    private String locationId;

    private Vote() {
    }

    public Vote(Builder builder) {
        this.candidateId = builder.candidateId;
        this.date = builder.date;
        this.id = builder.id;
        this.locationId = builder.locationId;
    }

    public String getId() {
        return id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getDate() {
        return date;
    }

    public String getLocationId() {
        return locationId;
    }
    public static class Builder{
        private String id;
        private String candidateId;
        private String date;
        private String locationId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildCandidateId(String candidateId){
            this.candidateId = candidateId;
            return this;
        }
        public Builder Date(String date){
            this.date = date;
            return this;
        }
        public Builder buildLocation(String locationId){
            this.locationId = locationId;
            return this;
        }
        public Vote build(){
            return new Vote(this);
        }
    }
}
