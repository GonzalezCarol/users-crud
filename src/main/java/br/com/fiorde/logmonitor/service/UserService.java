package br.com.fiorde.logmonitor.service;

import br.com.fiorde.logmonitor.model.User;
import br.com.fiorde.logmonitor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUsersById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> findUserByCpf(Long cpf){
        return Optional.ofNullable(userRepository.findUserByCpf(cpf));
    }

    public User insertUser(User user){
        User userEnt = new User();
        userEnt.setId(user.getId());
        userEnt.setName(user.getName());
        userEnt.setAge(user.getAge());

        userEnt = userRepository.save(userEnt);

        return userEnt;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
