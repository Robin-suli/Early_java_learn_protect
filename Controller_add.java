package befor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("calc")
@RestController
public class Controller_add {
    @RequestMapping("sum")
    public String calc(Integer num1, Integer num2){
        if (num1 == null || num2 == null){
            return "返回参数错误";
        }
        Integer sum = num1 + num2;
        return "<h1>计算机返回的结果"+ sum + "</h1>";
    }
}
