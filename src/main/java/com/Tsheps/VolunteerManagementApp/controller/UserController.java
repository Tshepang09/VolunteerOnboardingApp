package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.dto.auth.UserResponse;
import com.Tsheps.VolunteerManagementApp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        log.info("Attempting to delete User: {}", userId);
        userService.deleteUser(userId);

        return ResponseEntity.ok().body("Successfully deleted UserId: " + userId);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
