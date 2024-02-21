package com.mysite.core.core.services;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.cq.wcm.core.components.models.Page;

@Component(service=MyCustomService.class, immediate = true)

public class MyCustomServiceImpl  implements MyCustomService {


   

    @Override
    public String myMethod() {
        // TODO Auto-generated method stub
        return "my custom service method called";

    }

   



    

  
    
}
