package bni.co.id.ujian1.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
@ComponentScan(value = "bni.co.id.ujian1.service")
public class ApplicationConfig {
}
