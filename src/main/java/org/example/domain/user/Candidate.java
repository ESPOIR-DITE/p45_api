package org.example.domain.user;

public class Candidate {
    private String id;
    private String name;
    private String surname;
    private String partyId;

    public Candidate(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.partyId = builder.partyId;
        this.surname = builder.surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPartyId() {
        return partyId;
    }
    public static class Builder{
        private String id;
        private String name;
        private String surname;
        private String partyId;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder buildPartyId(String partyId){
            this.partyId = partyId;
            return this;
        }
        public Candidate build(){
            return  new Candidate(this);
        }
    }

}
