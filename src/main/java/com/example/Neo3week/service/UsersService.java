package com.example.Neo3week.service;

import com.example.Neo3week.models.Users;
import com.example.Neo3week.models.UsersInfo;
import com.example.Neo3week.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    @Autowired
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public ResponseEntity<?> getUserById(Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such user found by id = \" + id"));
        return ResponseEntity.ok().body(users);
    }

    public ResponseEntity<String> createUser(Users users) {
        if (usersRepository.findByUserName(users.getUserName()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body("Customer with username \"" + users.getUserName() + "\" already exist!");
        }
        usersRepository.save(users);
        return ResponseEntity.ok("Customer saved fine!");
    }

    public ResponseEntity<String> updateUser(UsersInfo info, Long id) {
        Users users1 = usersRepository.findById(id).orElse(null);
        if (users1 == null) {
            return ResponseEntity.badRequest().body("No such user found by id = " + id);
        }
        users1.setInfo(info);
        usersRepository.save(users1);
        return ResponseEntity.ok("Customer successfully saved!");
    }

    public ResponseEntity<String> deleteUserById(Long id) {
        if (usersRepository.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("No such user found by id = " + id);
        }
        usersRepository.deleteById(id);
        return ResponseEntity.ok("Customer successfully deleted!");
    }
}
