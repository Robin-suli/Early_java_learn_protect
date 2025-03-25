package befor;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("resp")
//@org.springframework.web.bind.annotation.RestController
@Controller
public class RestController {
    /**
     * 返回页面
     * @return
     */

    @RequestMapping("r1")
    public String returnPage(){
        return "/index.html";
    }

    /**
     * 返回数据
     * @return
     */
    @ResponseBody //@Controller和@ResponseBody可以一起使用来返回数据---> (Controller+ResponseBody=RequestMapping)
    @RequestMapping("/r2")
    public String returnHTML(){
        return "<h1>我是一级标题</h1>";
    }

    //produces：指定返回的内容类型
    @ResponseBody
    @RequestMapping(value = "r3", produces = "text/plain")
    public String returnText(){
        return "<h1>我是一级标题</h1>";
    }


    //返回json
    @ResponseBody
    @RequestMapping(value = "r4")
    public UserInfo returnJson(){
        UserInfo userInfo = new UserInfo("zhangsan",2,true);
        return userInfo;
    }

    //设置状态码
    @ResponseBody
    @RequestMapping("r5")
    public UserInfo setStatus(HttpServletResponse response){
        response.setStatus(402);
        UserInfo userInfo = new UserInfo("zhangsan",2,true);
        return userInfo;
    }


    //设置Header
    @ResponseBody
    @RequestMapping("r6")
    public String setHeader(HttpServletResponse response){
        response.setHeader("Header","myHeader");
        return "设置Header成功";

    }
}
