package main.java.example;

import main.java.example.ConsumerEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<ConsumerEntry, Long> {
}