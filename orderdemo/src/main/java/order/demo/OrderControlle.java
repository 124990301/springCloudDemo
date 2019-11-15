package order.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderControlle {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberApifeign memberApifeign;


    @RequestMapping("getOrder")
    public String getOrder(){
        // order 使用rpc 远程调用技术 调用 会员服务
        String memberUrl = "http://app-member/getMember";
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        String result = restTemplate.postForObject(memberUrl, JSONObject.parseObject(JSONObject.toJSONString(user)), String.class);
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;

    }

    //使用feign客户端
    @RequestMapping("/getOrder2")
    public  String getOrder2(){
        User user = new User();
        user.setName("李四");
        user.setAge(20);
        String result = memberApifeign.getMember(JSONObject.parseObject(JSONObject.toJSONString(user)));
        System.out.println("会员服务调用订单服务,result:" + result);
        return result;
    }

}
