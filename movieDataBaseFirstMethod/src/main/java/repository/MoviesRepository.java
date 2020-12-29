package repository;

import model.Department;
import model.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesRepository {


    private final Connection conn;

    public MoviesRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Movies> findAll() throws SQLException {
        Statement stmt = conn.createStatement();

        List<Movies> movies = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("Select * from movies");

        while (rs.next()) {
//            Department department = new Department();
//            department.setDepartmentId(rs.getInt("departmentId"));
//            department.setName(rs.getString("name"));
//            departments.add(department);

//            Department department = new Department(rs.getInt("departmentId"), rs.getString("name"));
//            departments.add(department);

            movies.add(new Movies(rs.getInt("movieId")
                    , rs.getString("title")
                    , rs.getInt("yearOfRelease")
                    , rs.getString("videos")
                    , rs.getString("genre")));
        }

        return movies;
    }


    public Movies findById(Integer id) throws SQLException {

        PreparedStatement pstmt = conn.prepareStatement("Select * from movies where movieId = ?");

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Movies movies = new Movies();
            movies.setMovieId(rs.getInt("movieId"));
            movies.setTitle(rs.getString("title"));
            movies.setYearOfRelease(rs.getInt("yearOfRelease"));
            movies.setVideos(rs.getString("videos"));
            movies.setGenre(rs.getString("genre"));
            return movies;
        }

        return null;
    }

    public Movies findByTitle(String title) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Select * from movies where title = ?");

        pstmt.setString(1, title);

        ResultSet rs = pstmt.executeQuery();



        if (rs.next()) {
            Movies movies = new Movies();
            movies.setMovieId(rs.getInt("movieId"));
            movies.setTitle(rs.getString("title"));
            movies.setYearOfRelease(rs.getInt("yearOfRelease"));
            movies.setVideos(rs.getString("videos"));
            movies.setGenre(rs.getString("genre"));
            return movies;
        }

        return null;


    }

    public void deleteById(Integer id) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Delete from movies where movieId = ?");

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
    }


    public void save(Movies movies) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("Insert into movies(title) values(?)");

        pstmt.setString(1, movies.getTitle());
        pstmt.executeUpdate();
    }

    public void update(Movies movies) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update movies set title = ? where movieId = ?");

        pstmt.setString(1, movies.getTitle());
        pstmt.setInt(2, movies.getMovieId());

        pstmt.executeUpdate();
    }

    public void updateAColumn(Movies movies) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update movies set videos = ? where movieId = ?");

        pstmt.setString(1,movies.getVideos());
        pstmt.setInt(2, movies.getMovieId());


        pstmt.executeUpdate();
    }

    public void updateByTitle(Movies movies) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update movies set yearOfRelease = ? where movieId = ?");

        pstmt.setInt(1, movies.getYearOfRelease());
        pstmt.setInt(2, movies.getMovieId());

        pstmt.executeUpdate();
    }

    public void updateGenre(Movies movies) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("update movies set genre = ? where movieId = ?");

        pstmt.setString(1,movies.getGenre());
        pstmt.setInt(2, movies.getMovieId());

        pstmt.executeUpdate();
    }




}


