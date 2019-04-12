package com.restFul.webServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restFul.webServices.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
