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
        "sling.servlet.paths=/bin/feedback"
    })
public class FeedbackServlet extends SlingAllMethodsServlet {
 
   
 
    @Override
    protected void doPost(final SlingHttpServletRequest req,
                          final SlingHttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("fname");
        String email = req.getParameter("femail");
        String feedback = req.getParameter("ffeedback");
        String trip = req.getParameter("ftrip");
        String group = req.getParameter("fgroup");
        String rating = req.getParameter("frating");
        String family = req.getParameter("ffamily");
 
        try {
            ResourceResolver resolver=req.getResourceResolver();
            Resource resource =resolver.getResource("/apps/mysite/components/feedback/formvalues");
            Node node = resource.adaptTo(Node.class);
            Node nameNode = node.addNode(name);
         Resource noderesource = resolver.getResource(nameNode.getPath());
   
        ModifiableValueMap map = noderesource.adaptTo(ModifiableValueMap.class);
        map.put("fullname", name);
        map.put("email", email);
        map.put("feedback", feedback);
        map.put("rating", rating);
        map.put("trip", trip);
        map.put("family", family);
        map.put("group", group);
       
        resolver.commit();
        resp.setContentType("text/plain");
                    resp.getWriter().write("Feedback received and stored in the repository.");
                    resp.getWriter().flush();
   
} catch (Exception e) {
    e.printStackTrace();
}
        
    }
 
   
}