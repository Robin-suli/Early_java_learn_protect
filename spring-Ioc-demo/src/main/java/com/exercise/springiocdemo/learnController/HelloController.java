package com.exercise.springiocdemo.learnController;

import com.exercise.springiocdemo.config.UserConfig;
import com.exercise.springiocdemo.learnService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
    /*DI注入方式：
    * */

    //1.属性注入
    /*@Autowired
    private UserService us;

    @Autowired
    private UserConfig config;

*/

    /**2.构造方法注入：
     * 注意事项：当有一个构造方法时，没得选可以注入成功，但是有多个构造方法时注入会根据反射机制去获取无参数的构造方法；
     * 这个时候就要加上注解：@Autowired
     */
    /*private UserService us;
    private UserConfig config;


    public HelloController() {
    }

    public HelloController(UserService us) {
        this.us = us;
    }


    private UserService us;
    private UserConfig config;

    @Autowired
    public HelloController(UserService us, UserConfig config) {
        this.us = us;
        this.config = config;
    }*/

    //set方法注入：
    private UserService us;
    private UserConfig config;

    @Autowired
    public void setUs(UserService us) {
        this.us = us;
    }
    @Autowired
    public void setConfig(UserConfig config) {
        this.config = config;
    }

    public void print(){
        System.out.println("do Controller");
        us.print();
        config.print();
    }
}
