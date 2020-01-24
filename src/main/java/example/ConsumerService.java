package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsumerService {

    KafkaPublisher publisher = new KafkaPublisher();

    EventDomain eventDomain = new EventDomain();



    private ConsumerRepository repository;

    ConsumerService(ConsumerRepository repository){
        this.repository = repository;
    }

    public String receive() {
        return publisher.ingest();
    }

    public void process(String record) {
        System.out.println("record: " + record);
        String[] recordArr = record.split("\\|");
        eventDomain.setSkuId(recordArr[0]);
        eventDomain.setActiveStatus(recordArr[1]);
        eventDomain.setMaxQty(recordArr[2]);
        repository.save(eventDomain);
    }

}
