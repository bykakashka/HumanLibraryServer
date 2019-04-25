package com.byka.humanlibrary.repository;

import com.byka.humanlibrary.entity.UserToBoard;
import com.byka.humanlibrary.entity.UserToBoardPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToBoardRepository extends JpaRepository<UserToBoard, UserToBoardPK> {
}
