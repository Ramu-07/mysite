package com.mysite.core.core.servlets;

/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import com.day.cq.commons.jcr.JcrConstants;
import com.mysite.core.core.services.MyCustomService;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
 
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
 
import org.osgi.service.component.annotations.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=GET",
    "sling.servlet.paths=/bin/customservlet"
})
public class StockDataServlet extends SlingAllMethodsServlet {

@Override
protected void doGet(SlingHttpServletRequest req,
        SlingHttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");

    try {
        // Fetch stock data from an external API (replace with actual logic)
        String stockData = fetchStockDataFromApi();

        // Write the stock data to the response
        resp.getWriter().write(stockData);
    } catch (Exception e) {

        // Handle any exceptions (e.g., API request failure)
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.getWriter().write("{\"error\":\"Failed to fetch stock data\"}");
    }
}
private String fetchStockDataFromApi() {
    // Implement logic to make API request and return stock data
    HttpURLConnection con = null;
    try {
        URL url = new URL("https://api.iextrading.com/1.0/tops?symbols=aapl");
        con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        int status = con.getResponseCode();
        if (status == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } else {
            throw new Exception("Invalid response from API: " + status);
        }
    } catch (Exception e) {
        throw new RuntimeException("Failed to fetch stock data", e);
    } finally {
        if (con != null) {
            con.disconnect();
        }
    }
    // Example: Make an HTTP request to a stock data provider
    // and parse the response to extract relevant info.
    // Return the data as a JSON string.
    // Replace this placeholder with actual implementation.
  //  return "{\"stock\":\"XYZ\"}";
}
}



