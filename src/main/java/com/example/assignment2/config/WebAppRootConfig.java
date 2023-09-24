package com.example.assignment2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@ComponentScan
@Import(HibernateConfig.class)
public class WebAppRootConfig {

}
