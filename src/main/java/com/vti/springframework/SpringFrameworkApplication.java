package com.vti.springframework;

import com.vti.springframework.form.UserCreateForm;
import com.vti.springframework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@AllArgsConstructor
public class SpringFrameworkApplication implements CommandLineRunner {
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringFrameworkApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500")
                        .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE");
            }
        };
    }

    @Override
    public void run(String... args) {
        var form = new UserCreateForm();
        form.setName("Nguyễn Văn Khoa");
        form.setUsername("khoa.nv");
        form.setEmail("khoa.nv@gmail.com");
        form.setPassword("123456");
        form.setRole("ADMIN");
        userService.create(form);
    }
}
