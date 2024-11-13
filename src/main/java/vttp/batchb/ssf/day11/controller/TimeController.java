package vttp.batchb.ssf.day11.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http request - verb + noun
// GET /time

// make this a request handler
// annotate this class as a controller
@Controller
// handles the /time resource
// localhost:5000/time
// the following resources should be handled by this controller
@RequestMapping(path = "/time")

public class TimeController {
    
    // localhost:5000/time/gmt
    // invoke GetMapping when the http method is GET
    @GetMapping("/gmt")
    public String getTimeGMT(Model model){
        // business logic
        String currentTime = (new Date()).toString();

        // bind data to model
        // key-value pair
        // key will go inside the template
        model.addAttribute("currTime", "this is the GMT time: %s".formatted(currentTime));

        // always return a template
        return "time";
    }

    // this method to handle GET /time
    // inject the model into the handler
    @GetMapping()
    public String getTime(Model model){
        // generate some data for your view
        String currentTime = new Date().toString();

        // bind the data to the model
        model.addAttribute("currTime", currentTime);

        // display the template/view
        return "time";
    }
}
