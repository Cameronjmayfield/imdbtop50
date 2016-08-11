package com.disney.data;

public class Title {
    public String Title;
    private String imdbRating;
    public String imdbID;

    public Double getRating(){
        try {
            return Double.parseDouble(imdbRating);
        } catch (Exception e){
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + Title + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbID='" + imdbID + '\'' +
                '}';
    }
}
