package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User{
    @Id
    @Column(name="USER_ID")
    @GeneratedValue
    private long userId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="LOGIN_NAME")
    private String loginName;
    @Column(name="PASS")
    private String pass;
    @Column(name="IS_BLOQUED")
    private int isBloqued;
    @Column(name="LAST_LOGIN")
    private Date lastLogin;
    @Column(name="LAST_BAD_LOGIN")
    private Date lastBadLogin;
    @Column(name="BAD_LOGIN_COUNT")
    private int badLoginCount;


    public User() {
    }

    public User(long userId, String firstName, String lastName, String loginName, String pass, int isBloqued, Date lastLogin, Date lastBadLogin, int badLoginCount) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginName = loginName;
        this.pass = pass;
        this.isBloqued = isBloqued;
        this.lastLogin = lastLogin;
        this.lastBadLogin = lastBadLogin;
        this.badLoginCount = badLoginCount;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsBloqued() {
        return this.isBloqued;
    }

    public void setIsBloqued(int isBloqued) {
        this.isBloqued = isBloqued;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastBadLogin() {
        return this.lastBadLogin;
    }

    public void setLastBadLogin(Date lastBadLogin) {
        this.lastBadLogin = lastBadLogin;
    }

    public int getBadLoginCount() {
        return this.badLoginCount;
    }

    public void setBadLoginCount(int badLoginCount) {
        this.badLoginCount = badLoginCount;
    }

    public User userId(long userId) {
        this.userId = userId;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User loginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public User pass(String pass) {
        this.pass = pass;
        return this;
    }

    public User isBloqued(int isBloqued) {
        this.isBloqued = isBloqued;
        return this;
    }

    public User lastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public User lastBadLogin(Date lastBadLogin) {
        this.lastBadLogin = lastBadLogin;
        return this;
    }

    public User badLoginCount(int badLoginCount) {
        this.badLoginCount = badLoginCount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(loginName, user.loginName) && Objects.equals(pass, user.pass) && isBloqued == user.isBloqued && Objects.equals(lastLogin, user.lastLogin) && Objects.equals(lastBadLogin, user.lastBadLogin) && badLoginCount == user.badLoginCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, loginName, pass, isBloqued, lastLogin, lastBadLogin, badLoginCount);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", loginName='" + getLoginName() + "'" +
            ", pass='" + getPass() + "'" +
            ", isBloqued='" + getIsBloqued() + "'" +
            ", lastLogin='" + getLastLogin() + "'" +
            ", lastBadLogin='" + getLastBadLogin() + "'" +
            ", badLoginCount='" + getBadLoginCount() + "'" +
            "}";
    }
    
    
}