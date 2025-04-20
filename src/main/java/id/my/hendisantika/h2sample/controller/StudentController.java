package id.my.hendisantika.h2sample.controller;

import id.my.hendisantika.h2sample.entity.Student;
import id.my.hendisantika.h2sample.service.LoadDataIntoDB;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-h2-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 20/04/25
 * Time: 21.13
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@AllArgsConstructor
public class StudentController {
    private final LoadDataIntoDB ldb;
    private final KafkaTemplate<String, Student> template;
    private final NewTopic topic;

    @GetMapping("/save")
    public String save() {
        log.info("---> Starting synchronous data load at {}", Instant.now());
        ldb.saveData();
        log.info("---> Synchronous data load completed at {}", Instant.now());
        return "Starting synchronous data load " + LocalDateTime.now();
    }

    @GetMapping("/send-to-kafka-broker")
    public String sendToKafka() {
        List<Student> list = ldb.fetchAll();
        list.stream().forEach(x -> template.send(topic.name(), x));
        return "Send to kafka broker " + LocalDateTime.now();
    }
}
