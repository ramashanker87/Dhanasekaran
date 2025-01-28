package com.dhana.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenSpringBootApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MavenSpringBootApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
