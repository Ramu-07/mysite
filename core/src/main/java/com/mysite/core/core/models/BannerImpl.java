package com.mysite.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.day.cq.wcm.api.Page;
import com.mysite.core.core.services.MyCustomService;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Banner.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BannerImpl implements Banner {

    @Inject
    @OSGiService
    MyCustomService myCustomService;

    @Override
    public String getServiceClass() {
        return myCustomService.myMethod();
    }

    @Inject
    @ScriptVariable
    Page currentPage;

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @Inject
    @Via("resource")
    String fileReference;

    @Inject
    @Via("resource")
    String bannerText;

    @Inject
    @Via("resource")
    String link;

    @Inject
    @Via("resource")
    String text;

    @Inject
    @Via("resource")
    String description;

    @Override
    public String getFileReference() {
        return fileReference;
    }

    @Override
    public String getBannerText() {
        return bannerText;
    }

    @Override
    public String getLink() {
        return link+".html";
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
