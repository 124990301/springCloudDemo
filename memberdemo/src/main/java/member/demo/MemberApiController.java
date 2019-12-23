package member.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableFeignClients
//@EnableZuulProxy
public class MemberApiController {

    @Autowired
    OrderFeign orderFeign;

    @RequestMapping("/getMember")
    public String getMember(@RequestBody JSONObject json){
        return "我是member"+json.getString("name");
    }

    @PostMapping("/getMember2")
    public String getMember2(@RequestBody JSONObject json){
        Map<String,String> map = new HashMap<>();
        map.put("name",json.getString("name"));
        return orderFeign.feignHello(JSONObject.parseObject(JSONObject.toJSONString(map)));
    }

    @GetMapping("/getMember3")
    public String getMember3(String name){
        return orderFeign.getOrder4(name);
    }
}
