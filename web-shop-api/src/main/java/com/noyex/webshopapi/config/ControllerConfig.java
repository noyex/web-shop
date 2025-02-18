package com.noyex.webshopapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.noyex.webshopdata",
        "com.noyex.webshopservice",
        "com.noyex.webshopapi"
})
public class ControllerConfig {
}
