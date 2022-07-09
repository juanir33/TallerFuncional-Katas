package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.*;
import util.DataUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> listVideo = movieLists.stream()
                .flatMap(i -> i.getVideos().stream())
                .map(ele -> ImmutableMap.of("id", ele.getId(),"title", ele.getTitle(),
                        "time", ele.getInterestingMoments().stream()
                                .filter(item -> item.getType().matches("Middle"))
                                .map(InterestingMoment::getTime).findFirst().orElseThrow(),
                        "url", ele.getBoxarts().stream()
                        .min(Comparator.comparing(BoxArt::getWidth)).map(i -> i.getUrl()).orElseThrow()))
                .collect(Collectors.toList());
        System.out.println(listVideo);
        return listVideo; //ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
