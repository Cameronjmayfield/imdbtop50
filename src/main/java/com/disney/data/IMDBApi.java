package com.disney.data;

import retrofit.http.GET;
import retrofit.http.Query;

public interface IMDBApi {
    @GET("/")
    public Title getTitleById(@Query("i") String id);
}
