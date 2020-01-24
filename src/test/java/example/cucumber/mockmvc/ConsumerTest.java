package example.cucumber.mockmvc;

import example.ConsumerService;
import example.KafkaPublisher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ConsumerTest {

    @InjectMocks
    ConsumerService consumerService;

    @Mock
    KafkaPublisher kafkaPublisher;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testKafkaRecieveNull(){
        when(kafkaPublisher.ingest()).thenReturn(null);
        Assert.assertNull(consumerService.receive());
    }

    @Test
    public void testKafkaRecieveNotNull(){
        String s = "2215672043486|true|24";
        when(kafkaPublisher.ingest()).thenReturn(s);
        Assert.assertNotNull(consumerService.receive());
    }
}
