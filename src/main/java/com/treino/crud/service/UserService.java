package com.treino.crud.service;

import com.treino.crud.model.User;
import com.treino.crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injeção de dependência via construtor (padrão moderno do Spring e NestJS)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User criarUsuario(User user) {
        return userRepository.save(user);
    }

    public User atualizarUsuario(Long id, User userAtualizado) {
        Optional<User> usuarioExistente = userRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            User user = usuarioExistente.get();
            user.setEmail(userAtualizado.getEmail());
            user.setName(userAtualizado.getName());
            user.setAge(userAtualizado.getAge());
            return userRepository.save(user);
        }
        throw new RuntimeException("Usuário não encontrado com o ID: " + id);
    }

    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}