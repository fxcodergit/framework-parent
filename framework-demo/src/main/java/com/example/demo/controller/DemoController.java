package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.rest.service.DemoRestService;
import io.github.penn.rest.InjectWebContext;
import io.github.penn.rest.RestResponse;
import io.github.penn.rest.context.WebContext;
import io.github.penn.rest.WebJSON;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penn")
@InjectWebContext
public class DemoController {

    @Autowired
    private DemoRestService demoRestService;

    @PostMapping("/demo")
    public JSONObject demo() {
        //WebContext.bodyParamMustHas("name", "abc");
        HttpServletRequest request = WebContext.getRequest();

        return WebJSON.fromWebContext()
                .peekBodyParam("name")
                .peekBodyParam("age");
    }


    @PostMapping("/demo2")
    public RestResponse demo2(@RequestBody JSONObject jsonObject) {
        RestResponse<JSONObject> restResponse = demoRestService.demoMethod(WebJSON.fromWebContext().peekBodyParam("name"));
        return restResponse;
    }

    @PostMapping("/demo3")
    public RestResponse demo3(@RequestBody JSONObject jsonObject){
        return new RestResponse();
    }

    @PostMapping("/demo4")
    public RestResponse demo4(@RequestBody JSONObject jsonObject) {
        RestResponse<JSONObject> restResponse = demoRestService.demoMethod2(WebJSON.fromWebContext().peekBodyParam("name"));
        return restResponse;
    }

}
