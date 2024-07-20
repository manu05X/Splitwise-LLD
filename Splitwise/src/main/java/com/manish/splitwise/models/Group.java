package com.manish.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groups") // as group is a reserve keyword so sql will not allow us to create table.
// by using @Entity(name = "Groups") we can create or bypass it
public class Group extends BaseModel {
    private String groupName;
    private String description;

    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User createdBy;
    private String name;
}
