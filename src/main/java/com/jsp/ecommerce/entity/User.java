package com.jsp.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.ecommerce.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    @SequenceGenerator(name="user_sequence",initialValue = 10, allocationSize=1)
    private long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(unique = true)
    private long phone;
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Address> addresses;

}
