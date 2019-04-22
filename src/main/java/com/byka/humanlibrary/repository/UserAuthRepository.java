package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.UserAuth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuth, String> {
}
