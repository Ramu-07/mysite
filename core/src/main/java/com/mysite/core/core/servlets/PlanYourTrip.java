package com.mysite.core.core.servlets;
 
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
@Component(service=Servlet.class,
    property={
        "sling.servlet.methods=POST",
        "sling.servlet.paths=/bin/planyourtrip"
    })
public class PlanYourTrip extends SlingAllMethodsServlet {
 
   
 
    @Override
    protected void doPost(final SlingHttpServletRequest req,
                          final SlingHttpServletResponse resp) throws ServletException, IOException {
                            String name = req.getParameter("pname");
                            String phone = req.getParameter("phone");
        String destination = req.getParameter("destination");
        String startdate = req.getParameter("startdate");
        String enddate = req.getParameter("enddate");
        String groupsize = req.getParameter("groupsize");
        String tripwith = req.getParameter("tripwith");
       
 
        try {
            ResourceResolver resolver=req.getResourceResolver();
            Resource resource =resolver.getResource("/apps/mysite/components/planyourtrip/customerdetails");
            Node node = resource.adaptTo(Node.class);
            Node nameNode = node.addNode(name);
         Resource noderesource = resolver.getResource(nameNode.getPath());
   
        ModifiableValueMap map = noderesource.adaptTo(ModifiableValueMap.class);
        map.put("fullname", name);
        map.put("phone no", phone);
        map.put("destination", destination);
        map.put("startdate", startdate);
        map.put("enddate", enddate);
        map.put("groupsize", groupsize);
        map.put("tripwith", tripwith);
        
       
        resolver.commit();
        resp.setContentType("text/plain");
                    resp.getWriter().write("Details received, Thank you !");
                    resp.getWriter().flush();
   
} catch (Exception e) {
    e.printStackTrace();
}
        
    }
 
   
}
