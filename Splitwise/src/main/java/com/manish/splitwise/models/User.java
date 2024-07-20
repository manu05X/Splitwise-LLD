package com.manish.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String userName;
    // As i have used name as phoneNumber here and while saving in db or repo is am using phone
    // so error was their to resolve it is used this @Column(name = "phone")
    //@Column(name = "phone")
    private String phone;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;

    @ManyToMany(mappedBy = "members") //As this relation is already represented in other class,
    //so we mention that attribute by whom this relation is being represented
    private List<Group> groups;
}
