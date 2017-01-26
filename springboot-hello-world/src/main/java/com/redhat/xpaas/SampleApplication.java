package com.redhat.xpaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
@SpringBootApplication
public class SampleApplication {
    public static void main(final String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args);
    }
}
