package com.springboot.bankbackend.controller;

import com.springboot.bankbackend.bo.*;
import com.springboot.bankbackend.entity.TransactionEntity;
import com.springboot.bankbackend.service.UserService;
import com.springboot.bankbackend.service.auth.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/")
public class UserController {

  private final UserService userService;
  private final CustomUserDetailsService userDetailsService;

  public UserController(UserService userService, CustomUserDetailsService userDetailsService) {
    this.userService = userService;
    this.userDetailsService = userDetailsService;
  }

  @GetMapping("/sayHi")
  public String sayHi() {
    return "Hi, you are an authenticated user";
  }

  // Update profile for logged in user
  @PutMapping("/update-profile")
  ResponseEntity<UserResponse> updateProfile(@RequestBody UpdateProfileRequest request) {
    UserResponse response = userService.updateProfile(request);

    // Check if the response is not null (indicating a successful update)
    if (response != null) {
      // Return a 201 Created status code along with some of the updated user data
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } else {
      // Handle the case where the update was not successful (e.g., validation failed)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  // Add defined transaction to user
  @PostMapping("/transactions")
  ResponseEntity<TransactionEntity> addTransaction(@RequestBody TransactionRequest request) {
    TransactionEntity response = userService.addTransaction(request);

    // Check if the response is not null (indicating a successful update)
    if (response != null) {
      // Return a 201 Created status code along with some of the updated user data
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } else {
      // Handle the case where the update was not successful (e.g., validation failed)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  // Get user transactions
  @GetMapping("/transactions")
  ResponseEntity<List<TransactionEntity>> getTransactions() {
    List<TransactionEntity> response = userService.getTransactions();

    // Check if the response is not null (indicating a successful get)
    if (response != null) {
      // Return a 200 OK status code along with some of the user data
      return ResponseEntity.status(HttpStatus.OK).body(response);
    } else {
      // Handle the case where the get was not successful (e.g., validation failed)
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
  }

}
