package org.example.springboothibernate;

import org.example.springboothibernate.controller.StudentController;
import org.example.springboothibernate.dao.StudentDao;
import org.example.springboothibernate.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringBootHibernateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootHibernateApplication.class, args);

//        StudentDao studentDao = applicationContext.getBean(StudentDao.class);


        StudentController studentController = applicationContext.getBean(StudentController.class);
        Student student = Student.builder()
                .email("rushi@gmail.com")
                .name("rushi warade")
                .mobile("907506379")
                .build();


//        studentController.save(student);


//        boolean byId = studentController.getById(2);
//        System.out.println(byId);

//        Student student1 = studentController.findById(2);
//        System.out.println(student1);


//        System.out.println(studentController.count());


//        studentController.deleteById(102);


        Student update = studentController.update(2, student);

        System.out.println(update);


    }


}
