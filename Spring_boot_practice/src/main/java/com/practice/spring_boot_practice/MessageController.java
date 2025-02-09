package com.practice.spring_boot_practice;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("message")
@RestController
public class MessageController {
    private List<MessageInfo> messageInfoList = new ArrayList<>();

    @RequestMapping(value = "publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo){
        if (!StringUtils.hasLength(messageInfo.getFrom())
                || !StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())){
            return "{\"ok\": 0}";
        }

        messageInfoList.add(messageInfo);
        return "{\"ok\": 1}";
    }


    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        return messageInfoList;
    }
}
