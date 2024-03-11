package com.mysite.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.LoggerFactory;

import com.mysite.core.core.services.WeatherService;
 
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialMediaImpl {
 
    

   


    
    @Inject
    private String link;
    



    



    public String getLink() {
        return link;
    }

    @Inject
    private String fileReference;

    public String getFileReference() {
        return fileReference;
    }
   
}
