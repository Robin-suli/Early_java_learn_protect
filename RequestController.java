package befor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequestMapping("request")
@RestController
public class RequestController {



    @RequestMapping("r1")
    public String r1(String keyword){
        return "接受的参数 "+ keyword;
    }

    @RequestMapping("r2")
    public String r2(String userName,String passWords){
        return "接受的参数 "+ "userName:"+ userName + " passWords:" + passWords;
    }


    @RequestMapping("r3")
    public String r3(Integer number){
        return "接收的参数 "+ number;
    }

    @RequestMapping("r4")
    public String r4(int number){
        return "接收的参数 "+ number;
    }

    @RequestMapping("r5")
    public String r4(UserInfo userInfo){
        return "接收的参数 ：userInfo "+ userInfo.toString();
    }


    //参数重命名：(参数绑定)RequestParam;  required属性设置为false，表示前端传递参数时，该请求路径不用必须传参数
    @RequestMapping("r6")
    public String r5(@RequestParam(value = "k",required = false) String keyword){
        return "接收的参数 "+ keyword;
    }


    //RequestParam：把数组绑定为，list
    @RequestMapping("r7")
    public String r7(@RequestParam List<Integer> list){
        return "接收的参数: list "+ list;
    }

    //传递json对象
    @RequestMapping("r8")
    public String r8(@RequestBody UserInfo userInfo){
        return userInfo.toString();
    }

    /**
     * 从url中取值：
     */
    @RequestMapping("article/{articleId}")
    public String r9(@PathVariable Integer articleId){
        return "获取文章Id "+ articleId;
    }

    @RequestMapping("article/{type}/{articleId}")
    public String r9(@PathVariable Integer articleId, @PathVariable String type){
        return "获取文章Id "+ articleId +" " + "文章类型 "+ type;
    }

    //注意：就算required = false，不传参数也会报错，PathVariable修饰后，必须是必传参数
    @RequestMapping("test/article/{type}/{articleId}")
    public String r10(@PathVariable(required = false) Integer articleId, @PathVariable(required = false) String type){
        return "获取文章Id "+ articleId +" " + "文章类型 "+ type;
    }

    /**
     * 上传文件：
     */
    @RequestMapping("r11")
    public String r11(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("D:\\新建文件夹\\" + file.getOriginalFilename()));
        return "文件获取成功";
    }

    //获取Cookie
    @RequestMapping("r12")
    public String r12(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "返回 Cookie成功";
    }

    @RequestMapping("r13")
    public String r13(@CookieValue("java") String java){
        return "返回Cookie的值"+ java;
    }

    //存储session
    @RequestMapping("setSession")
    public String r14(HttpServletRequest request){
        //从Cookie中获取sessionId，再根据sessionId来获取session对象
        //session不存在就获取session
        HttpSession session = request.getSession();
        //默认存储在内存中
        //登录的用户名称
        session.setAttribute("userName","张三");
        session.setAttribute("age","13");
        return "设置session成功";
    }

    //获取session
    @RequestMapping("getSession")
    public String r15(HttpServletRequest request){
        //从cookie中获取sessionId, 根据sessionId 获取Session对象
        HttpSession session = request.getSession(false);//设置为false，表示没有获取到session返回null；为true表示：没有获取到session返回一个空对象
        if (session == null){
            return "用户未登录";
        }else{
            //从session中获取登录用户的信息
            String userName = (String) session.getAttribute("userName");
            return "用户为"+ userName;
        }
    }

    //获取session
    @RequestMapping("getSession2")
    public String r16(HttpSession session){//在参数这里就相当于，HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("userName");
        return "用户为"+ userName;
    }

    //用注解获取session
    @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute(value = "userName",required = false) String userName){
        return "登录用户为: " + userName;
    }

    //获取header
    @RequestMapping("getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent = request.getHeader("user-Agent");
        return userAgent;
    }

    //用注解获取header
    @RequestMapping("getHeader2")
    public String getHeader2(@RequestHeader("user-Agent") String userAgent){
        return userAgent;
    }
}
