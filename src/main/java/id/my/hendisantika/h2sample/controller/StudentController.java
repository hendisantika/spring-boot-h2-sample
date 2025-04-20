package id.my.hendisantika.h2sample.controller;

import id.my.hendisantika.h2sample.entity.Student;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@AllArgsConstructor
public class StudentController {
    private final LoadDataIntoDB ldb;
    private final KafkaTemplate<String, Student> template;
    private final NewTopic topic;
}
