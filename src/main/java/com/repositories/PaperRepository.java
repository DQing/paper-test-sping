package com.repositories;


import com.entities.Paper;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaperRepository extends JpaRepository<Paper, Integer> {

}
