package org.example.domain.location;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    private String id;
    private String location;
    private String address;
    private String description;
    private String parentLocationId;

    private Location() {
    }

    public Location(Builder builder) {
        this.address = builder.address;
        this.description = builder.description;
        this.id = builder.id;
        this.location = builder.location;
        this.parentLocationId = builder.parentLocationId;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getParentLocationId() {
        return parentLocationId;
    }
    public static class Builder{
        private String id;
        private String location;
        private String address;
        private String description;
        private String parentLocationId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildLocation(String location){
            this.location = location;
            return this;
        }
        public Builder buildAddress(String address){
            this.address = address;
            return this;
        }
        public Builder buildDescription(String description){
            this.description = description;
            return this;
        }
        public Builder buildParentLocationId(String parentLocationId){
            this.parentLocationId = parentLocationId;
            return this;
        }
        public Location build(){
            return new Location(this);
        }
    }
}
