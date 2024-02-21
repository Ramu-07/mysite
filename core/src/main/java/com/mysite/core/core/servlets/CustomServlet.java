package com.mysite.core.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component (service=Servlet.class,
 property={"sling.servlet.methods=GET","sling.servlet.paths=/bin/myCustomServlet"})

public class CustomServlet extends SlingSafeMethodsServlet {
@Override
protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) 
throws ServletException, IOException{
String path=req.getParameter("path");
if (path==null||path.isEmpty()){
    resp.getWriter().write("please provide a valid path");
    return;

}

String contentFromRepository=getContentFromRepository(path);
}

private String getContentFromRepository(String path) {
    return "content from repository for path "+path;
}
    
}
