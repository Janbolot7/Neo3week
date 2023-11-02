package com.example.Neo3week.controller;

import com.example.Neo3week.models.Users;
import com.example.Neo3week.models.UsersInfo;
import com.example.Neo3week.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Tag(name = "User controller", description = "Использование основных методов к нашим пользователям")
public class UserController {
    private final UsersService userService;

    @GetMapping
    @Operation(summary = "Покажи всех пользователей", description = "Получить информацию о пользователях")
    public List<UsersInfo> showAllUsers() {
        return userService.showAllUsers();
    }

    @PostMapping
    @Operation(summary = "Сохранить пользователя", description = "Сохранение нового пользователя")
    public ResponseEntity<String> saveUser(@RequestBody Users users) {
        return userService.saveUsers(users);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получить по ID", description = "Получение пользователя по ID номеру")
    public UsersInfo getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Изменение данных пользователя", description = "Изменения пользователя по ID номеру")
    public ResponseEntity<String> updateUser(@RequestBody UsersInfo info,
                                             @PathVariable Long id) {
        return userService.updateUser(info, id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление пользователя", description = "Удаление пользователя по ID номеру")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}
