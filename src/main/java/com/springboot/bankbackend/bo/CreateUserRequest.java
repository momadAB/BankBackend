package com.springboot.bankbackend.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {
    @NotNull
    @NotBlank(message = "Username must not be blank")
    private String username;
    @NotNull
    @NotBlank(message = "Email must not be blank")
    private String email;
    @NotNull
    @NotBlank(message = "Password must not be blank")
    private String password;
    private String profilePicture;
    private String role;

    public CreateUserRequest () {
        // Default constructor
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
