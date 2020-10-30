package org.example.domain.location;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidateLocation {
    @Id
    private String id;
    private String candidateId;
    private String locationId;

    public CandidateLocation() {
    }

    public CandidateLocation(Builder builder) {
        this.candidateId = builder.candidateId;
        this.id = builder.id;
        this.locationId = builder.locationId;
    }

    public String getId() {
        return id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getLocationId() {
        return locationId;
    }
    public static class Builder{
        private String id;
        private String candidateId;
        private String locationId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildCandidateId(String candidateId){
            this.candidateId = candidateId;
            return this;
        }
        public Builder buildLocationId(String locationId){
            this.locationId = locationId;
            return this;
        }
        public CandidateLocation build(){
            return new CandidateLocation(this);
        }
    }
}
