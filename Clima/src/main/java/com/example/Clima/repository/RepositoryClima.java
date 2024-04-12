package com.example.Clima.repository;
import com.example.Clima.model.ClimaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryClima extends MongoRepository<ClimaModel, String> {

}