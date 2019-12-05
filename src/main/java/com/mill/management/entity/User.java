package com.mill.management.entity;

import com.mill.management.entity.commonfields.TableCommonFields;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@ToString
public class User extends TableCommonFields {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;

    private String firstName;
    private String middleName;
    private String lastName;

    private String address;
    private String zipCode;
    private String email;
    private String password;
    private boolean isActive;
    private boolean isAdmin;

}
