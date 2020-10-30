package org.example.domain.vote;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voter {
    @Id
    private String id;
    private String name;
    private String surname;
    private String phoneNumber;
    //private byte[] fingerPrint;
    private byte[] image;

    private Voter() {
    }

    public Voter(Builder builder) {
        //this.fingerPrint = builder.fingerPrint;
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.surname = builder.surname;
        this.image = builder.image;
    }

    public byte[] getImage() {
        return image;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    public byte[] getFingerPrint() {
//        return fingerPrint;
//    }
    public static class Builder{
        private String id;
        private String name;
        private String surname;
        private String phoneNumber;
        private byte[] image;

    //private byte[] fingerPrint;

        public Builder(String id){
            this.id = id;
        }
        public Builder buildName(String name){
            this.name = name;
            return this;
        }
        public Builder buildImage(byte[] image){
            this.image = image;
            return this;
        }
        public Builder buildSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder buildPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
//        public Builder buildFingerPrint(byte[] fingerPrint){
//            this.fingerPrint = fingerPrint;
//            return this;
//        }
        public Voter build(){
            return new Voter(this);
        }
    }
}
