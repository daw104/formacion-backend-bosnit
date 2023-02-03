package com.example.block6pathvariableheaders.block6pathvariableheaders.configurations;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class UserConfiguration {


    HashMap<String,String> post = new HashMap<>();


    public HashMap createMap(String var1, String var2){
        post.put("var1",var1);
        post.put("var2",var2);
        return post;
    }


}
