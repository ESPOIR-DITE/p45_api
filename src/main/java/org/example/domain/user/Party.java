package org.example.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Party {
    @Id
    private String id;
    private String name;
    private String abbreviation;
    private byte[] flag;

    private Party() {
    }

    public Party(Builder builder) {
        this.id = builder.id;
        this.abbreviation = builder.abbreviation;
        this.name = builder.name;
        this.flag = builder.flag;
    }

    public byte[] getFlag() {
        return flag;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public static class Builder{
        private String id;
        private String name;
        private String abbreviation;
        private byte[] flag;


        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildDescription(String description){
            this.abbreviation = description;
            return this;
        }
        public Builder buildFlag(byte[] flag){
            this.flag = flag;
            return this;
        }
        public Party build(){
            return new Party(this);
        }
    }
}
