package com.example.FreeMarkerPOC.controller;

import com.example.FreeMarkerPOC.entity.TemplateEntity;
import com.example.FreeMarkerPOC.service.TemplateService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api")

public class TemplateController {
    private final Configuration cfg ;
    public TemplateController(Configuration cfg, TemplateService templateService) {
        this.cfg = cfg;
        this.templateService = templateService;
    }

    @GetMapping()
    public String test(Model model) {
        model.addAttribute("name","hello");
        return "homepage";
    }

    private final TemplateService templateService;


    @GetMapping("/all")
    public ResponseEntity<List<TemplateEntity>> getTemplates(){
        List<TemplateEntity> list = templateService.getTemplates();
        return new ResponseEntity<List<TemplateEntity>>(list, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getTemplate(@PathVariable String name,Model model) throws TemplateException, IOException {


        Template template = cfg.getTemplate(name);

        StringWriter stringWriter = new StringWriter();
        model.addAttribute("condition",true);
        model.addAttribute("name","Waseem");

        template.process(model, stringWriter);

        return new ResponseEntity<String>(stringWriter.toString(), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<TemplateEntity> saveContent(@RequestBody TemplateEntity contentDTO){
        return new ResponseEntity<>(templateService.addContent(contentDTO),HttpStatus.CREATED);
    }

}
