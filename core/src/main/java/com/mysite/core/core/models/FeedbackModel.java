package com.mysite.core.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

@Model(adaptables = Resource.class)
public class FeedbackModel {

    @SlingObject
    private ResourceResolver resourceResolver;


   
    

    public List<Feedback> getFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>(); 
        Resource resource = resourceResolver.getResource("/apps/mysite/components/feedback/formvalues");
        if (resource != null) {
            Iterator<Resource> children = resource.listChildren();
            while (children.hasNext()) {
                feedbacks.add(children.next().adaptTo(Feedback.class));
           

           
            }

      //      while(children.hasNext()){
       //         feedbacks.add(children.next().adaptTo(Feedback.class));
       // }


        }
        Collections.reverse(feedbacks);
        return feedbacks;

        
    }

    public double getAverageRating() {
        List<Feedback> feedbacks = getFeedbacks();
        if (feedbacks.isEmpty()) {
            return 0;
        }
    
        double sum = 0;
        for (Feedback feedback : feedbacks) {
            try {
                sum += Double.parseDouble(feedback.getRating());
            } catch (NumberFormatException e) {
                // Handle the case where the rating is not a number
            }
        }
    
        
        return sum / feedbacks.size();


    }

    @Model(adaptables = Resource.class)
    public static class Feedback {



        @Inject
        private String email;

        @Inject
        private String feedback;

        @Inject
        private String trip;

        @Inject
        private String group;

        @Inject
        private String rating;

        @Inject
        private String family;

        @Inject
        private String fullname;

        public String getEmail() {
            return email;
        }

        public String getFeedback() {
            return feedback;
        }

        public String getFullname() {
            return fullname;
        }

        public String getTrip() {
            return trip;
        }

        public String getFamily() {
            return family;
        }
        public String getGroup() {
            return group;
        }

        public String getRating() {
            return rating;
        }

     
    }
}
