package in.sysventure.contactappwithrecyclerview.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private int serialNumber;
    private String phoneNumber;
    private String name;

    public Contact(int serialNumber, String phoneNumber, String name) {
        this.serialNumber = serialNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "serialNumber=" + serialNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
