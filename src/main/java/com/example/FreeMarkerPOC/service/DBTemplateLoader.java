package com.example.FreeMarkerPOC.service;

import com.example.FreeMarkerPOC.entity.TemplateEntity;
import com.example.FreeMarkerPOC.repo.TemplateRepo;
import freemarker.cache.TemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Optional;

@Component
public class DBTemplateLoader implements TemplateLoader {

    @Autowired
    private  TemplateRepo templateRepo;

    public DBTemplateLoader() {

    }
    @Override
    public Object findTemplateSource(String name) throws IOException {
        Optional<TemplateEntity> templateEntity = templateRepo.findByName(name);
        return templateEntity.map(entity -> new StringReader(entity.getContent())).orElse(null);
    }

    @Override
    public long getLastModified(Object templateSource) {
        // Not needed for this example
        return -1;
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        return (Reader) templateSource;
    }

    @Override
    public void closeTemplateSource(Object templateSource) throws IOException {
        // Not needed for this example
    }
}
