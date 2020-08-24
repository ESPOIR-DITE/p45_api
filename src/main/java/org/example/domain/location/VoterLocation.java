package org.example.domain.location;

public class VoterLocation {
    private String id;
    private String voterId;
    private String locationId;

    public VoterLocation(Builder builder) {
        this.id = builder.id;
        this.locationId = builder.locationId;
        this.voterId = builder.voterId;
    }

    public String getId() {
        return id;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getLocationId() {
        return locationId;
    }
    public static class Builder{
        private String id;
        private String voterId;
        private String locationId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildVoterId(String voterId){
            this.voterId = voterId;
            return this;
        }
        public Builder buildLocationId(String locationId){
            this.locationId = locationId;
            return this;
        }
        public VoterLocation build(){
            return new VoterLocation(this);
        }
    }
}
