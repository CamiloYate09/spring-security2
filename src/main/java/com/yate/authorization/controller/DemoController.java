package com.yate.authorization.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String showDemo() {
        return "Hello word";
    }


    /**
     * Example 8:
     * validamos con los matchers de spring security
     */

    @GetMapping("/admin")
    public String admin() {
        return "Hello word Admin";
    }

    @GetMapping("/dba")
    public String user() {
        return "Hello word dba";
    }


    /***
     * Example 9:
     * ejemplo validando los métodos por el usuario pasado por parametro
     */

    @PostMapping("/add")
    public String add() {
        return "Hello word add User";
    }

    @GetMapping("/add")
    public String addGet() {
        return "Hello word get User";
    }


}
