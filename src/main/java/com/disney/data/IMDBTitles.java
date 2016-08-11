package com.disney.data;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMDBTitles {

    private List<Title> top50Titles;

    public List<Title> getTop50Titles() {
        return top50Titles;
    }

    public void setTitles(List<Title> top50Titles) {
        this.top50Titles = top50Titles;
    }

}
