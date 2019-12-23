package member.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="app-order")
public interface OrderFeign {

    @PostMapping(value = "/getOrder3")
    String feignHello(JSONObject json);

    @GetMapping("/getOrder4")
    String getOrder4(@RequestParam String name);
}
