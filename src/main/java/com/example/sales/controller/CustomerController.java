package com.example.sales.controller;

import com.example.sales.dto.UserCreateDto;
import com.example.sales.dto.UserRespDto;
import com.example.sales.dto.UserUpdateDto;
import com.example.sales.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserRespDto> create(@RequestBody UserCreateDto createDto) {
        return ResponseEntity.status(CREATED).body(userService.create(createDto));
    }

    @PostMapping("/confirm")
    public ResponseEntity<UserRespDto> confirm(@RequestParam("username") String username,
                                               @RequestParam("code") String code) {
        return ResponseEntity.ok(userService.confirm(username, code));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRespDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRespDto> update(@PathVariable("id") Long id, @RequestBody UserUpdateDto updateDto) {
        return ResponseEntity.ok(userService.update(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
