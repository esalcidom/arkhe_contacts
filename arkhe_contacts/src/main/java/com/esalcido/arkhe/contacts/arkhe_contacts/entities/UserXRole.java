package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserXRole implements Serializable {

    @Id
    @Column(name = "X_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long xId;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "ROLE_ID")
    private long roleId;

    public UserXRole() {
    }

    public UserXRole(long xId, long userId, long roleId) {
        this.xId = xId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public long getXId() {
        return this.xId;
    }

    public void setXId(long xId) {
        this.xId = xId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public UserXRole xId(long xId) {
        this.xId = xId;
        return this;
    }

    public UserXRole userId(long userId) {
        this.userId = userId;
        return this;
    }

    public UserXRole roleId(long roleId) {
        this.roleId = roleId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserXRole)) {
            return false;
        }
        UserXRole userXRole = (UserXRole) o;
        return xId == userXRole.xId && userId == userXRole.userId && roleId == userXRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xId, userId, roleId);
    }

    @Override
    public String toString() {
        return "{" + " xId='" + getXId() + "'" + ", userId='" + getUserId() + "'" + ", roleId='" + getRoleId() + "'"
                + "}";
    }

}