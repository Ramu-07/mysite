package com.mysite.core.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
 
import java.util.*;

import javax.inject.Inject;
 
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {
 
    private static final Logger LOG = LoggerFactory.getLogger(Header.class);

    @Inject
    private String fileReference;
 
    public String getFileReference() {
        return fileReference;
    }

    @Inject
    private List<HeaderImpl> products;

    public List<HeaderImpl> getProducts() {
        return new ArrayList<>(products);
    }
 
   
}

