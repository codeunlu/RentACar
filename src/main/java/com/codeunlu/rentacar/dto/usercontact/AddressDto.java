package com.codeunlu.rentacar.dto.usercontact;

import com.codeunlu.rentacar.model.users.User;
import com.codeunlu.rentacar.model.enums.AddressType;

public class AddressDto {
    private User users;
    private AddressType addressTypeId;
    private String title;
    private String content;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public AddressType getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(AddressType addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
