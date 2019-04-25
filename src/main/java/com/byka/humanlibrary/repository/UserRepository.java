package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT u from User as u where u.nickname = :nickname")
    List<User> getByNickname(@Param("nickname") final String nickname);
}
