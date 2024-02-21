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
import org.slf4j.LoggerFactory;
 
@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class KiteCarousel {
 
    @Inject
    private List<ProductModel> products;

    public List<ProductModel> getProducts() {
        return new ArrayList<>(products);
    }
 
   
}
