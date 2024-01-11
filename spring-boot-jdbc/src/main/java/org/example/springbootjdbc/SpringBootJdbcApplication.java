package org.example.springbootjdbc;

import org.example.springbootjdbc.controller.StudentController;
import org.example.springbootjdbc.dao.StudentDao;
import org.example.springbootjdbc.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcApplication.class, args);

        Student  student = Student.builder()
                .id(6)
                .name("Saurabh warade")
                .email("saurabhwarade@gmail.com")
                .mobile("9075063779")
                .build();

        StudentController studentController = applicationContext.getBean(StudentController.class);

//        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
        studentController.save(student);

    }

}
