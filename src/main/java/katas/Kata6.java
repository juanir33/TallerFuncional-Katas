package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String url = movies.stream()
                        .map(Movie::getBoxarts)
                                .flatMap(i -> i.stream())
                                        .reduce(((boxArt, boxArt2) ->
                                          boxArt.getWidth()> boxArt2.getWidth()? boxArt:boxArt2
                                        )).get().getUrl();

        System.out.println(url);
        return url;
    }
}
