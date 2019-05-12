package com.example.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assesment.domain.Option;
import com.example.assesment.domain.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long>{

}
