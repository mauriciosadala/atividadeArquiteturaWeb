package com.example.Fipe.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Fipe.model.FipeEntity;

@Repository
public interface FipeRepository extends MongoRepository<FipeEntity, String>{
}
