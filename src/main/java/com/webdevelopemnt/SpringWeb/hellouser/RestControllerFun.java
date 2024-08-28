package com.webdevelopemnt.SpringWeb.hellouser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestControllerFun {

    @RequestMapping("/say_hello")
    @ResponseBody
    public String sayHello(){
        return " Hello World ";
    }


    @RequestMapping("/say_hello_html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1> Heading 1 </h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }


    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHelloJsp";
    }


}
