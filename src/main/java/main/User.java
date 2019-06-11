package main;

import main.utils.Values;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @NotNull
    @Column(name = "name", columnDefinition = "VARCHAR(20)")
    private String name;

    @NotNull
    @Column(name = "surname", columnDefinition = "VARCHAR(20)")
    private String surname;

    @Column(name = "password", columnDefinition = "VARCHAR(30)")
    private String password;

    @NotNull
    @Column(name = "email", columnDefinition = "VARCHAR(30)")
    private String email;

    // Inits default logo base64 string
    @Column(name = "avatar", columnDefinition = "TEXT")
    private String avatar = Values.defaultLogo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, lastname: %s, email: %s, password: %s",
                this.id, this.name, this.surname, this.email, this.password);
    }
}
