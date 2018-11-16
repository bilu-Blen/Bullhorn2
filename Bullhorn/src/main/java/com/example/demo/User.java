package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User_Data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column(name="username")
    private String username;

    @Transient
    BCryptPasswordEncoder encoder;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name ="first_name")
    private String firstName;
    @NotEmpty
    @Column(name="last_name")
    private String lastName;

   @NotEmpty
    @Column(name="email", nullable = false)
    private String email;

    private String hobbie;

    private String image;

    @OneToMany(mappedBy = "postedBy")
    private Set<Post> posts;

    public User(@NotEmpty String username, @NotEmpty String password, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String email, String hobbie, String image, boolean enabled) {
        this.username = username;
        encoder = new BCryptPasswordEncoder();
        setPassword(password);
        this.setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hobbie = hobbie;
        this.image = image;
        this.enabled = enabled;
        this.roles = new HashSet<Role>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "enabled")
    private boolean enabled;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User() {
        this.roles = new HashSet<>();
        encoder = new BCryptPasswordEncoder();

    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
