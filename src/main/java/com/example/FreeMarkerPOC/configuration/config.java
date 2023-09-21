package com.example.FreeMarkerPOC.configuration;

import com.example.FreeMarkerPOC.repo.TemplateRepo;
import com.example.FreeMarkerPOC.service.DBTemplateLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
public class config {
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setPreTemplateLoaders(databaseTemplateLoader());
        return configurer;
    }
    @Bean
    public DBTemplateLoader databaseTemplateLoader() {
        return new DBTemplateLoader();
    }

}
