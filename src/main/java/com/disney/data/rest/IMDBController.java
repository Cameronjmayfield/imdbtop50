package com.disney.data.rest;

import com.disney.data.IMDBTitles;
import com.disney.data.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IMDBController {

    @Autowired
    IMDBTitles imdbTitles;

    @RequestMapping("/api/top50")
    public @ResponseBody
    List<Title> getTop50Titles(){
        return imdbTitles.getTop50Titles().subList(0, 50);
    }
}
