package com.example.demo.GestionConge.repository;

import com.example.demo.GestionConge.model.entity.CompteConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompteCongeRepo  extends  JpaRepository<CompteConge, Long>{
//    @Query("select NomberJoure from CompteConge    ")
//   public Long findBycomptID(int NomberJoure );
//    //"select  from Employee inner join CompteConge on Employee.id =CompteConge.employee_id ")
}

