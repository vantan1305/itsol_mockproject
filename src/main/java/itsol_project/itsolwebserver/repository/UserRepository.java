package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
