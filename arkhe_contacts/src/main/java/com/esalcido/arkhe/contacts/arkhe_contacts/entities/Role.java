package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Role
 */
@Entity
@Table(name = "TABLE_ROLE")
public class Role {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @ManyToMany
    Set<User> users;


    public Role() {
    }

    public Role(long roleId, String roleName, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role roleId(long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Role roleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public Role users(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return roleId == role.roleId && Objects.equals(roleName, role.roleName) && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, users);
    }

    @Override
    public String toString() {
        return "{" +
            " roleId='" + getRoleId() + "'" +
            ", roleName='" + getRoleName() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
    

}