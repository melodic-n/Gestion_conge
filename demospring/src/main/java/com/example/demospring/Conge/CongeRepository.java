package com.example.demospring.Conge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository  extends JpaRepository<Conge,Long> {

}
