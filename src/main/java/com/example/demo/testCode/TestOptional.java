package com.example.demo.testCode;

import java.util.Optional;

/**
 * Author: Yi-tong Gao
 * Date: Created in 11:35 2018/3/6
 * Description:
 * Modified By:
 */
public class TestOptional {
    public static void main(String args[]) throws Exception{
        User user=new User();
        Name name=new Name();
        name.setFirstName("John");
        user.setName(name);
        Optional <User>optional=Optional.ofNullable(user);
        System.out.print(optional.flatMap(u->Optional.ofNullable(u.getName().getLastName())));
        Optional.ofNullable(user.getName().getLastName()).orElseThrow(()->new Exception("1"));



    }

    public static class User{
        Name name;
        String idCard;
        int phoneNumber;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
    public static class Name{
        String firstName;
        String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
