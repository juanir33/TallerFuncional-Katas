package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> list = movieLists.stream()
                .flatMap(i -> i.getVideos().stream())
                .map(ele -> ImmutableMap.of("id", ele.getId(),"title", ele.getTitle(),"boxart",
                        ele.getBoxarts().stream()
                                .min(Comparator.comparing(BoxArt::getWidth)).map(i -> i.getUrl()).orElseThrow()))
                .collect(Collectors.toUnmodifiableList());
        System.out.println(list);

        return list; // ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }
}
