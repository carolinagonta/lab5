package com.example.demo.repository;

import com.example.demo.entity.Client;
import com.example.demo.entity.Spital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpitalRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean existByDenumire(String denumire) {
        String sql = "SELECT COUNT(*) FROM spitale WHERE Denumire_spital = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, denumire);
        return count > 0;
    }

    public List<Spital> findAll() {
        return jdbcTemplate.query("SELECT * FROM spitale", (resultSet, rowNum) -> {
            Spital spital = new Spital();
            spital.setId(resultSet.getInt("ID_spital"));
            spital.setDenumire(resultSet.getString("Denumire_spital"));
            spital.setAdresa(resultSet.getString("Adresa_spital"));
            return spital;
        });
    }

    public Spital findById(int id) {
        String sql = "SELECT * FROM spitale WHERE ID_spital = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Spital(
                        rs.getInt("ID_spital"),
                        rs.getString("Denumire_spital"),
                        rs.getString("Adresa_spital")
                ));
    }

    public void create(Spital spital) {
        String sql = "INSERT INTO spitale(ID_spital,Denumire_spital, Adresa_spital) VALUES (?,?, ?)";

        jdbcTemplate.update(sql, spital.getId(),spital.getDenumire(), spital.getAdresa());
    }

    public void update(int id, Spital spital) {
        String sql = "UPDATE spitale SET Denumire_spital = ?, Adresa_spital = ? WHERE ID_spital = ?";

        jdbcTemplate.update(sql, spital.getDenumire(), spital.getAdresa(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM spitale WHERE ID_spital = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT count(*) FROM spitale WHERE ID_spital = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }
}
