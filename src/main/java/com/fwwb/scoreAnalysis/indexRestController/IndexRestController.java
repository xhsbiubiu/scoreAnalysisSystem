package com.fwwb.scoreAnalysis.indexRestController;

import com.fwwb.scoreAnalysis.common.response.RestResponse;
import com.fwwb.scoreAnalysis.common.response.RestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/21.
 */
@RestController
@RequestMapping("/login")
public class IndexRestController {

    @RequestMapping("/login")
    public RestResponse login(@RequestParam("username")String username,@RequestParam("password")String password){
        RestResponse response = RestUtil.getResponse();
        return response;
    }
}
