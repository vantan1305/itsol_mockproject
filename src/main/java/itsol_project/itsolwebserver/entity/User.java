package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class User extends BaseEntity implements UserDetails {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String role;
    private Date dob; // ngày sinh
    private String email;
    private String phoneNumber; // số điện thoại
    private String address; // địa chỉ
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default false")
    private Boolean isAdminAccount; // loại tài khoản: ADMIN: true || CLIENT: false, bạn sửa đi, cả tôi sợ sai vcl
    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

}
