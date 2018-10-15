package com.amuse.frametwo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AccessController
 * @Description 资源访问总结
 * @Author 刘培振
 * @Date 2018/6/9 14:42
 * @Version 1.0
 */
@Controller
public class AccessController {


    /**
     * springboot默认将 /** 静态资源访问映射到如下目录：
     * classpath:/static
     * classpath:/public
     * classpath:/resources
     * classpath:/META-INF/resources
     *
     */

    /**
     * 接口的return "index.html"默认是跳转到/static/index.html，当在pom.xml中引入了thymeleaf组件，
     * 就会跳转到 /templates/index.html，也可通过配置修改路径 thymeleaf:prefix: classpath:/static/
     * 注意看两者return代码也有区别，后者没有html后缀。
     *
     *
     * 警告:thymeleaf对html格式进行了严格的校验，thymeleaf的版本请用3.0以上的版本
     * 		<thymeleaf.version>3.0.2.RELEASE</thymeleaf.version>
     * 		<thymeleaf-layout-dialect.version>2.0.5</thymeleaf-layout-dialect.version>
     *
     */

    /*
     * 静态文件可以通过地址 http://localhost:8003/index.html、http://localhost:8003/img/my.jpg 直接访问
     * 但是网站的静态资源是不能够被别人随意访问，所以在spring security拦截这些请求；
     *
     * 资源访问方式: 首先查找classpath下的资源，
     * 如果没有，则查找对应的接口，
     * 接口又分为该项目有没有使用thymeleaf组件，
     *
     */

    //跳转到动态页面
    @RequestMapping(value = "/dynamic")
    public String dynamic(){
        return "index";
    }

    //跳转到静态页面(引入thymeleaf之前可以正常访问，会跳转到 index.html.html)
    @RequestMapping(value = "/static")
    public String staticHtml(){
        return "index.html";
    }

    //重定向(引入thymeleaf之前可以访问)
    @RequestMapping(value = "/redirect")
    public String redirect(){
        return "redirect:/index.html";
    }

    //返回字符串
    @RequestMapping(value = "/resString")
    @ResponseBody //加上他返回字符串,不加就会跳转页面
    public String resString(){
        return "abcdefg";
    }


    /**
     * 登陆跳转处理
     * @return
     */
//    @RequestMapping(value = "/login")
//    public String login(){
//        return "login";
//    }

    @RequestMapping(value = "/resJson",method = RequestMethod.GET)
    @ResponseBody
    public Map resJson(@RequestParam String personName){
        Map<String,Object> map = new HashMap<>();
        map.put("name",personName);
        map.put("age",21);
        map.put("address","beijing");
        return map;
    }

}
