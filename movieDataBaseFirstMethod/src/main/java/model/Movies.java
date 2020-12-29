package model;

public class Movies {
    private int movieId;
    private String title;
    private int yearOfRelease;
    private String videos;
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getVideos() {
        return videos;
    }
    public Movies(String videos, int movieId)
    {
        this.videos=videos;
        this.movieId=movieId;
    }
    public Movies(String title, String videos) {
        this.title = title;
        this.videos = videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }


    public Movies(int movieId, String title, int yearOfRelease) {
        this.movieId = movieId;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Movies() {
    }



    public Movies(String title) {
        this.title = title;
    }

//    public Movies(String title, int yearOfRelease) {
//        this.title = title;
//        this.yearOfRelease = yearOfRelease;
//    }

    public Movies(int movieId, int yearOfRelease) {
        this.movieId = movieId;
        this.yearOfRelease = yearOfRelease;
    }

    public Movies(int movieId, String title, int yearOfRelease, String videos, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.videos = videos;
        this.genre = genre;
    }

    public Movies(int movieId, String genre)
    {
        this.movieId=movieId;
        this.genre=genre;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", videos='" + videos + '\'' +
                ", genre='" + genre + '\'' +
                '}'+"\n";
    }
}

