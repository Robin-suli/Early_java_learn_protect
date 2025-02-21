package com.exercise.springiocdemo;

import com.exercise.springiocdemo.Component.UserComponent;
import com.exercise.springiocdemo.config.UserConfig;
import com.exercise.springiocdemo.learnController.HelloController;
import com.exercise.springiocdemo.learnService.UserService;
import com.exercise.springiocdemo.model.Student;
import com.exercise.springiocdemo.rep.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@ComponentScan("com.exercise.springiocdemo")//spring的扫描路径，为启动类所在的路径,这个注解可以设置路径
public class SpringIocDemoApplication {

    public static void main(String[] args) {
        //获取Spring上下文
       ApplicationContext context = SpringApplication.run(SpringIocDemoApplication.class, args);

      /* HelloController bean1 = (HelloController) context.getBean("helloController");
       bean1.print();

       HelloController bean2 = context.getBean(HelloController.class);
       bean2.print();

        HelloController bean3 = context.getBean("helloController",HelloController.class);
        bean3.print();

        //都是同一个对象
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);

        UserConfig bean4 = context.getBean(UserConfig.class);
        bean4.print();

        UserConfig bean5 = (UserConfig) context.getBean("reNameBean");
        bean5.print();

        UserRepository bean6 = context.getBean(UserRepository.class);
        bean6.print();

        UserService bean7 = context.getBean(UserService.class);
        bean7.print();

        UserComponent bean8 = context.getBean(UserComponent.class);
        bean8.print();

        Student bean9 = (Student) context.getBean("ss1");
        System.out.println(bean9);

        Student bean10 = (Student) context.getBean("s2");
        System.out.println(bean10);*/

        //DI测试
//        HelloController bean11 = context.getBean(HelloController.class);
//        bean11.print();

        UserService bean22 = context.getBean(UserService.class);
        bean22.print();


    }

}
