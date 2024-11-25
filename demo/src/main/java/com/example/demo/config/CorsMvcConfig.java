package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    // @Override
    // public void addCorsMappings(CorsRegistry corsRegistry) {
    //     corsRegistry.addMapping("/**")
    //             .allowedOrigins("http://localhost:3000");
    // }


    // @Override
    // public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    //     configurer.favorPathExtension(true)
    //               .ignoreAcceptHeader(true)
    //               .defaultContentType(MediaType.TEXT_HTML)
    //               .mediaType("css", MediaType.valueOf("text/css"));
    // }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/assets/")  // 리소스가 위치한 경로
                .setCachePeriod(3600);
    }
}
