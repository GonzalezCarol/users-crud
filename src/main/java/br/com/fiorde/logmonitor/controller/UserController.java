package br.com.fiorde.logmonitor.controller;
import br.com.fiorde.logmonitor.model.User;
import br.com.fiorde.logmonitor.service.UserService;
import br.com.fiorde.logmonitor.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired //injeção de dependencia (instancia a classe)
    private UserService userService;

    @GetMapping("/user")
    public List<User> users() {
//        UserService userService = new UserService();
        List<User> usersList = userService.findUsers();
        return usersList;
    }

    @GetMapping("/user/{id}")
    public Optional<User> users(@PathVariable Long id) {
        Optional<User> user = userService.findUsersById(id);
        return user;
    }
    
    @PostMapping("/user")
    public ResponseEntity<User> usersInsert(@RequestBody User user){
        Optional<User> useCpf = userService.findUserByCpf(user.getCpf());
        if (useCpf != null) {
            throw new ServiceException("Usuário já criado!");
        } else {
            User userObj = userService.insertUser(user);
            return ResponseEntity.ok(userObj);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> userDelete(@PathVariable Long id){
        Optional<User> userFindById = userService.findUsersById(id);
        if (userFindById.isPresent()){
            userService.deleteUser(id);
            return ResponseEntity.ok("Usuário excluido com sucesso");
        } else {
            throw new ServiceException("Usuário não encontrado");
        }
    }
}