package com.mysite.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.*;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.core.core.services.WeatherService;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialMedia{

    private static final Logger LOG = LoggerFactory.getLogger(Header.class);

    
@Inject
private String title;

public String getTitle(){
    return title;
}


    @Inject
    private List<SocialMediaImpl> products;

    public List<SocialMediaImpl> getProducts() {
        return new ArrayList<>(products);
    }

    @OSGiService
    WeatherService weatherService;

    public String getData() {
        return weatherService.getWeatherData();
    }

    //ramuuu

}

