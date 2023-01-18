package com.smarteducation.smarteducation.model.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.smarteducation.smarteducation.model.Schema.Aluno;

public interface AlunoRepository extends MongoRepository <Aluno, String>{
    
    
}
