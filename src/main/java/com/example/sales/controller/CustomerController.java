package com.example.sales.controller;

import com.example.sales.dto.CustomerCreateDto;
import com.example.sales.dto.UserRespDto;
import com.example.sales.dto.UserUpdateDto;
import com.example.sales.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CustomerController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserRespDto> create(@RequestBody CustomerCreateDto createDto) {
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
