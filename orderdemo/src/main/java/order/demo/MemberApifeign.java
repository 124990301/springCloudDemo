package order.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
   feign调用接口
 */
@FeignClient(name = "app-member")
public interface  MemberApifeign {

    @RequestMapping("/getMember")
    public String getMember(JSONObject json);
}
