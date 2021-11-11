package com.company;

import java.util.Objects;

public class User {
        private String name;
        private int pinCode;
        private int balance;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPinCode() {
            return pinCode;
        }

        public int setPinCode(int pinCode) {
            this.pinCode = pinCode;
            return pinCode;
        }

        public int getBalance() {
            return balance;
        }

        public int setBalance(int balance) {
            this.balance = balance;
            return balance;
        }

        public User() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.company.User user = (com.company.User) o;
            return pinCode == user.pinCode && balance == user.balance && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, pinCode, balance);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", pinCode=" + pinCode +
                    ", balance=" + balance +
                    '}';
        }
    }

