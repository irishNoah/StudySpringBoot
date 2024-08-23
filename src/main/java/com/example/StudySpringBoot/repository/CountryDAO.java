package com.example.StudySpringBoot.repository;

import com.example.StudySpringBoot.entity.Country;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDAO {

    private final String url = "jdbc:mysql://192.168.1.106:3306/OPENAPI";
    private final String username = "usertest";
    private final String password = "usertest1234";

    // 모든 국가 조회
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM Country";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getLong("id"));
                country.setName(rs.getString("name"));
                country.setPopulation(rs.getLong("population"));
                country.setRegion(rs.getString("region"));
                countries.add(country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    // 특정 국가 조회
    public Country findById(Long id) {
        Country country = null;
        String query = "SELECT * FROM Country WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                country = new Country();
                country.setId(rs.getLong("id"));
                country.setName(rs.getString("name"));
                country.setPopulation(rs.getLong("population"));
                country.setRegion(rs.getString("region"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }

    // 국가 추가
    public void save(Country country) {
        String query = "INSERT INTO Country (name, population, region) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, country.getName());
            pstmt.setLong(2, country.getPopulation());
            pstmt.setString(3, country.getRegion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 국가 수정
    public void update(Country country) {
        String query = "UPDATE Country SET name = ?, population = ?, region = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, country.getName());
            pstmt.setLong(2, country.getPopulation());
            pstmt.setString(3, country.getRegion());
            pstmt.setLong(4, country.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 국가 삭제
    public void deleteById(Long id) {
        String query = "DELETE FROM Country WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}