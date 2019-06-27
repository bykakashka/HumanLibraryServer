package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.UserToBook;
import com.byka.humanlibrary.entity.UserToBookPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToBoardRepository extends JpaRepository<UserToBook, UserToBookPK> {
}
