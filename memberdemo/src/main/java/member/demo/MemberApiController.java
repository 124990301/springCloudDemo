package member.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableZuulProxy
public class MemberApiController {

    @RequestMapping("/getMember")
    public String getMember(@RequestBody JSONObject json){
        return "我是member"+json.getString("name");
    }
}
