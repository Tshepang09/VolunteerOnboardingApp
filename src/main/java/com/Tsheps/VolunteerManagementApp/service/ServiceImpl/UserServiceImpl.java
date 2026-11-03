package com.Tsheps.VolunteerManagementApp.service.ServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.auth.UserResponse;
import com.Tsheps.VolunteerManagementApp.exception.UserNotFoundException;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import com.Tsheps.VolunteerManagementApp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.Tsheps.VolunteerManagementApp.mappers.UserMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UsersRepo usersRepo;
    private final UserCredentialsRepo userCredentialsRepo;

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        Users user = usersRepo.findById(userId).orElseThrow(()->  new UserNotFoundException(userId));

        //retrieve the user
        usersRepo.deleteById(userId);
        userCredentialsRepo.deleteByUser_UserId(userId);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<Users> allUsers = usersRepo.findAll();

        return allUsers.stream().map(UserMapper::toUserResponse).toList();
    }
}
