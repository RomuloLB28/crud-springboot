package com.treino.crud.controller;

import com.treino.crud.model.User;
import com.treino.crud.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listar() {
        return userService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User user) {
        User novoUser = userService.criarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user) {
        User userAtualizado = userService.atualizarUsuario(id, user);
        return ResponseEntity.ok(userAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}