package com.example.rahat.bot;
public class UserProfile {
    private String name, email, phone, userID, profilePicUrl, DOB, addr, inst;


    public UserProfile(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.userID = builder.userID;
        this.profilePicUrl = builder.profilePicUrl;
        this.DOB = builder.DOB;
        this.addr = builder.addr;
        this.inst = builder.inst;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }


    public String getUserID() {
        return userID;
    }


    public String getProfilePicUrl() {
        return profilePicUrl;
    }


    public String getDOB() {
        return DOB;
    }


    public String getAddr() {
        return addr;
    }


    public String getInst() {
        return inst;
    }


    public static class UserBuilder {
        private String name, email, phone, userID, profilePicUrl, DOB, addr, inst;


        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder userID(String userID) {
            this.userID = userID;
            return this;
        }

        public UserBuilder profilePicUrl(String profilePicUrl) {
            this.profilePicUrl = profilePicUrl;
            return this;
        }
        public UserBuilder DOB(String DOB) {
            this.DOB = DOB;
            return this;
        }
        public UserBuilder addr(String addr) {
            this.addr = addr;
            return this;
        }
        public UserBuilder inst(String inst) {
            this.inst = inst;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}
/*

class UserProfile2 implements Serializable {

    String name;
    String email;
    String userID;


    UserProfile2(String name, String email)
    {
        this.name=name;
        this.email=email;
    }

    public UserProfile2(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "UserProfile2{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
*/