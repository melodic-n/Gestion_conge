package com.example.demospring.RH;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHRepository extends JpaRepository<RH, Long>  {

}
