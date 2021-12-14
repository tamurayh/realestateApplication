package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.condition1;

/**
 * ユーザー情報 Repository
 */
@Repository

public interface ConditionRepository extends JpaRepository<condition1,Long> {

}
