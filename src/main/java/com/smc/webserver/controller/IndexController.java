package com.smc.webserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author seshu
 */

@Controller
@SuppressWarnings("UnusedDeclaration")
public class IndexController {

    @Value("${example.message}")
    private String message;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String responseAsString = "{ \"status\": \"ok\", \"message\":" + message + "}";
        return responseAsString;
    }

}