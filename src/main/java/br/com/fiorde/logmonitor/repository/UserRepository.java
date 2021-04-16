package br.com.fiorde.logmonitor.repository;

import br.com.fiorde.logmonitor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, Long >{
        User findUserByCpf(Long cpf);
}
