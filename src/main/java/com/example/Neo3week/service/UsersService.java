package com.example.Neo3week.service;

import com.example.Neo3week.exception.NotFoundException;
import com.example.Neo3week.models.Users;
import com.example.Neo3week.models.UsersInfo;
import com.example.Neo3week.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<UsersInfo> showAllUsers() {
        return usersRepository.findAll().stream().map(Users::getInfo).toList();
    }

    public UsersInfo getUserById(Long id) {
        Users users = returnUserAfterCheck(id);
        return users.getInfo();
    }

    public ResponseEntity<String> saveUsers(Users users) {
        if (usersRepository.findByUserName(users.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("Пользователь с именем пользователя \""
                    + users.getUserName() + "\" уже существует!");
        }
        usersRepository.save(users);
        return ResponseEntity.ok("Пользователь успешно сохранен!");
    }

    public ResponseEntity<String> updateUser(UsersInfo info, Long id) {
        Users users = returnUserAfterCheck(id);
        users.setInfo(info);
        usersRepository.save(users);
        return ResponseEntity.ok("Пользователь успешно сохранен!");
    }

    public ResponseEntity<String> deleteUserById(Long id) {
        if (usersRepository.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("Пользователь с таким идентификатором не найден = " + id);
        }
        usersRepository.deleteById(id);
        return ResponseEntity.ok("Пользователь успешно удален!");
    }

    private Users returnUserAfterCheck(Long id) {
        return usersRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Пользователь с таким идентификатором не найден = " + id)
        );
    }
}
