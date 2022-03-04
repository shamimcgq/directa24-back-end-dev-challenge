package com.directa24.main.challenge;

import com.directa24.main.challenge.entity.MovieData;
import com.directa24.main.challenge.entity.Movies;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> directors = getDirectors(3);
        System.out.println(String.join("\n", directors));
    }

    /*
     * Complete the 'getDirectors' function below.
     *
     * The function is expected to return a List<String>.
     * The function accepts int threshold as parameter.
     *
     * URL
     * https://directa24-movies.mocklab.io/api/movies/search?page=<pageNumber>
     */

    public static List<String> getDirectors(int threshold) {
        GetData getData = new GetData();
        String url = "https://directa24-movies.mocklab.io/api/movies/search?page=";
        int pageNo = 1;

        //Get the data of first page
        Movies movies = getData.GetMovies(url, pageNo);
        assert movies != null;
        List<MovieData> movieData = movies.getData();
        List<String> directors = new ArrayList<>();

        // Adding the directors name to the list
        for (MovieData data : movieData) {
            directors.add(data.getDirector());
        }

        //Get the data from rest of the pages
        for (int i = pageNo + 1; i <= movies.getTotal_pages(); i++) {
            List<MovieData> data = getData.GetMovies(url, i).getData();
            for (MovieData movieData1 : data) {
                directors.add(movieData1.getDirector());
            }

        }
        //Get the name of directors and the number of movies they directed by counting the number of times they appeared
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String name : directors) {
            map.put(name, Collections.frequency(directors, name));
        }
        //Sort the map Ascending order alphabetically using Treemap
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);

        //Find the directors name who has directed movies more than the provided threshold value;
        List<String> list = new ArrayList<String>(treeMap.keySet());
        List<String> finalList = new ArrayList<String>();
        for (String string : list) {
            if (treeMap.get(string) > threshold) {
                finalList.add(string);
            }
        }

        return finalList;
    }


}
