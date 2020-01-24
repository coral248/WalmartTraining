package example;

import example.EventDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<EventDomain, String> {

}