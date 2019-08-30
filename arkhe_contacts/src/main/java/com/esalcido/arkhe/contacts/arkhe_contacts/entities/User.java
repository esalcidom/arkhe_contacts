package com.esalcido.arkhe.contacts.arkhe_contacts.entities;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


// @Table(name = "TABLE_USER") 
// @NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class User implements UserDetails{
    
    private static final long serialVersionUID = 1L;
    // @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    // private String firstName;
    // private String lastName;
    // private String isActive;
    // @Column(name = "FIRST_NAME")
    
    // @Column(name = "LAST_NAME")
    
    // @Column(name = "USERNAME")
    
    // @Column(name = "PASSWORD")
    
    // @Column(name = "IS_ACTIVE")
    
    // @Column(name = "LAST_LOGIN")
    // private Date lastLogin;
    // @Column(name = "LAST_BAD_LOGIN")
    // private Date lastBadLogin;
    // @Column(name = "BAD_LOGIN_COUNT")
    // private int badLoginCount;

    // @ManyToMany
    // @JoinTable(name = "TABLE_USER_X_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    // Set<Role> roles;

	public User(String username, String password) {
        this.username = username;
        this.password = password;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
		return true;
	}

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // public User() {
    // }

    // public User(long userId, String firstName, String lastName, String username, String password, int isActive, Date lastLogin, Date lastBadLogin, int badLoginCount) {
    //     this.userId = userId;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.username = username;
    //     this.password = password;
    //     this.isActive = isActive;
    //     this.lastLogin = lastLogin;
    //     this.lastBadLogin = lastBadLogin;
    //     this.badLoginCount = badLoginCount;
    //     // this.roles = roles;
    // }

    // public long getUserId() {
    //     return this.userId;
    // }

    // public void setUserId(long userId) {
    //     this.userId = userId;
    // }

    // public String getFirstName() {
    //     return this.firstName;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // public String getLastName() {
    //     return this.lastName;
    // }

    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }

    // public String getUsername() {
    //     return this.username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getPassword() {
    //     return this.password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public int getIsActive() {
    //     return this.isActive;
    // }

    // public void setIsActive(int isActive) {
    //     this.isActive = isActive;
    // }

    // public Date getLastLogin() {
    //     return this.lastLogin;
    // }

    // public void setLastLogin(Date lastLogin) {
    //     this.lastLogin = lastLogin;
    // }

    // public Date getLastBadLogin() {
    //     return this.lastBadLogin;
    // }

    // public void setLastBadLogin(Date lastBadLogin) {
    //     this.lastBadLogin = lastBadLogin;
    // }

    // public int getBadLoginCount() {
    //     return this.badLoginCount;
    // }

    // public void setBadLoginCount(int badLoginCount) {
    //     this.badLoginCount = badLoginCount;
    // }

    // // public Set<Role> getRoles() {
    // //     return this.roles;
    // // }

    // // public void setRoles(Set<Role> roles) {
    // //     this.roles = roles;
    // // }

    // public User userId(long userId) {
    //     this.userId = userId;
    //     return this;
    // }

    // public User firstName(String firstName) {
    //     this.firstName = firstName;
    //     return this;
    // }

    // public User lastName(String lastName) {
    //     this.lastName = lastName;
    //     return this;
    // }

    // public User username(String username) {
    //     this.username = username;
    //     return this;
    // }

    // public User password(String password) {
    //     this.password = password;
    //     return this;
    // }

    // public User isActive(int isActive) {
    //     this.isActive = isActive;
    //     return this;
    // }

    // public User lastLogin(Date lastLogin) {
    //     this.lastLogin = lastLogin;
    //     return this;
    // }

    // public User lastBadLogin(Date lastBadLogin) {
    //     this.lastBadLogin = lastBadLogin;
    //     return this;
    // }

    // public User badLoginCount(int badLoginCount) {
    //     this.badLoginCount = badLoginCount;
    //     return this;
    // }

    // // public User roles(Set<Role> roles) {
    // //     this.roles = roles;
    // //     return this;
    // // }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof User)) {
    //         return false;
    //     }
    //     User user = (User) o;
    //     return userId == user.userId && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && isActive == user.isActive && Objects.equals(lastLogin, user.lastLogin) && Objects.equals(lastBadLogin, user.lastBadLogin) && badLoginCount == user.badLoginCount;
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(userId, firstName, lastName, username, password, isActive, lastLogin, lastBadLogin, badLoginCount);
    // }

    // @Override
    // public String toString() {
    //     return "{" +
    //         " userId='" + getUserId() + "'" +
    //         ", firstName='" + getFirstName() + "'" +
    //         ", lastName='" + getLastName() + "'" +
    //         ", username='" + getUsername() + "'" +
    //         ", password='" + getPassword() + "'" +
    //         ", isActive='" + getIsActive() + "'" +
    //         ", lastLogin='" + getLastLogin() + "'" +
    //         ", lastBadLogin='" + getLastBadLogin() + "'" +
    //         ", badLoginCount='" + getBadLoginCount() + "'" + "}";
    //             // ", roles='" + getRoles() + "'" + "}";
    // }
    

}