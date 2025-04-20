package id.my.hendisantika.h2sample.repository;

import id.my.hendisantika.h2sample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-h2-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 20/04/25
 * Time: 21.12
 * To change this template use File | Settings | File Templates.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
