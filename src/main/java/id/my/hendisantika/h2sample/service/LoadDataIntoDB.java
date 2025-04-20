package id.my.hendisantika.h2sample.service;

import id.my.hendisantika.h2sample.entity.Student;
import id.my.hendisantika.h2sample.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-h2-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 20/04/25
 * Time: 21.15
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class LoadDataIntoDB {

    private final StudentRepository studentRepository;

    private final int batch = 1000;
    private final int start = 0;

    public void saveData() {
        while (start < 100000) {
            List<Student> student = getNextStudentBatch(start);
            start += batch;
            studentRepository.saveAll(student);
        }
    }

    public List<Student> fetchAll() {
        return studentRepository.findAll();

    }
}
