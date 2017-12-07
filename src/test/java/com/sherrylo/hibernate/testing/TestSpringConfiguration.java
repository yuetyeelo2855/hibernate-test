package com.sherrylo.hibernate.testing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.sherrylo.hibernate.testing")
@ImportResource(locations = "classpath:applicationContext.xml")
public class TestSpringConfiguration {
}
