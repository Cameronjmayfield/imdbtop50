package com.disney.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import retrofit.RestAdapter;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IMDBUpdater {

    private final  IMDBTitles imdbTitles;
    private final List<String> imdbIds;
    private final IMDBApi imdbApi;

    @Autowired
    public IMDBUpdater(IMDBTitles imdbTitles, @Value("${id.file.location:imdb_id.json}") String fileLocation) throws IOException {
        File csvFile = new File(fileLocation);
        this.imdbIds = new ObjectMapper().readValue(csvFile, new TypeReference<List<String>>(){});
        this.imdbTitles = imdbTitles;
        this.imdbApi = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com/").build().create(IMDBApi.class);
    }

    @Scheduled(fixedRate = 10000L)
    public void updateTitles(){
        imdbTitles.setTitles(
                imdbIds.stream()
                .map(imdbApi::getTitleById)
                .sorted(((Comparator<Title>) (o1, o2) -> o1.getRating().compareTo(o2.getRating())).reversed())
                .collect(Collectors.toList()));
        System.out.println("Done");
    }
}
