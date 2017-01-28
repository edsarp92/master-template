package com.master.template;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.master.template.config.DefaultProfileUtil;


public class ApplicationWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        DefaultProfileUtil.addDefaultProfile(application.application());
        return application.sources(ApplicationMain.class);
    }
}
