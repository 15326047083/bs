package com.leiyuan.bs;

import com.leiyuan.bs.entity.Message;
import com.leiyuan.bs.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void addReply(){
        Message message=new Message();
        message.setInfo("yes");
        message.setUserId(1);
        message.setReplyId(1);
    }

    @Test
    public void getList(){
        System.out.println(messageService.getList());
    }
}
