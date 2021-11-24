package com.sparta.mini_project.repository;

import com.sparta.mini_project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();
    List<Comment> findAllByUserId(Long userId);
}

