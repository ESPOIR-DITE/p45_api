package org.example.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidateType {
    @Id
    private String id;
    private String name;
    private String description;

    private CandidateType() {
    }

    public CandidateType(Builder builder) {
        this.description = builder.description;
        this.id = builder.id;
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
        public CandidateType build(){
            return new CandidateType(this);
        }
    }
}
