package com.vhry.user.common.domain;

import com.vhry.common.JpaAccessor;
import com.vhry.dictionary.role.RoleJpa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class UserJpa extends JpaAccessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private BigInteger id;

    @Size(max = 128, message = "Username limit: 128 chars")
    @Column(name = "username", nullable = false, columnDefinition = "NOT NULL")
    private String username;

    @Size(max = 128, message = "Email limit: 128 chars")
    @Column(name = "email", nullable = false, columnDefinition = "NOT NULL")
    private String email;

    @OneToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, columnDefinition = "NOT NULL")
    private RoleJpa role;

}
