package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> list1 = movieLists.stream()
                .flatMap(ele -> ele.getVideos().stream())
                .map(ele ->ImmutableMap.of("id", ele.getId(),
                "title", ele.getTitle(),"boxart", ele.getBoxarts().stream()
                                .filter(item -> item.getHeight().equals(200)&&item.getWidth().equals(150)
                                        ).findAny().orElseThrow()))
                .collect(Collectors.toUnmodifiableList());

        System.out.println(list1);

        return list1; //ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }
}
