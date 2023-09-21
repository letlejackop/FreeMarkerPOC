package com.example.FreeMarkerPOC.service;

import com.example.FreeMarkerPOC.entity.TemplateEntity;
import com.example.FreeMarkerPOC.repo.TemplateRepo;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.List;

@Service
public class TemplateService {
    private final TemplateRepo templateRepo;

    private final Configuration cfg ;
    public TemplateService(TemplateRepo templateRepo, Configuration cfg) {
        this.templateRepo = templateRepo;
        this.cfg = cfg;
    }


    public TemplateEntity addContent(TemplateEntity template) {

        return templateRepo.save(template);
    }

    public List<TemplateEntity> getTemplates() {

        return templateRepo.findAll();
    }
    public String getTemplate(String name,TemplateEntity templateModel) throws IOException, TemplateException {

        return FreeMarkerTemplateUtils.processTemplateIntoString(cfg.getTemplate("test"),templateModel );
    }
}
