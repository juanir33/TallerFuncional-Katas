package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Integer> list1 =  movieLists.stream()
                .map(MovieList::getVideos)
                .flatMap(i -> i.stream().map(Movie::getId))
                .collect(Collectors.toList());
        System.out.println(list1);
        return  list1;     //ImmutableList.of(1, 2, 3);
    }
}
