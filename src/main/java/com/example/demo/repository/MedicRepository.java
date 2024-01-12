package com.example.demo.repository;

import com.example.demo.entity.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Medic> findAll() {
        return jdbcTemplate.query("SELECT * FROM medici", (resultSet, rowNum) -> {
            Medic medic = new Medic();
            medic.setId(resultSet.getString("ID_medic"));
            medic.setNume(resultSet.getString("Nume"));
            medic.setPrenume(resultSet.getString("Prenume"));
            medic.setDataNasterii(resultSet.getDate("DataNasterii"));
            medic.setTelefon(resultSet.getString("Telefon"));
            medic.setSpecializare(resultSet.getInt("Specializare"));
            medic.setSpital(resultSet.getInt("Spital"));
            medic.setExperienta(resultSet.getInt("Experienta"));
            return medic;
        });
    }

    public Medic findById(String id) {
        String sql = "SELECT * FROM medici WHERE ID_medic = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Medic(
                        rs.getString("ID_medic"),
                        rs.getString("Nume"),
                        rs.getString("Prenume"),
                        rs.getDate("DataNasterii"),
                        rs.getString("Telefon"),
                        rs.getInt("Specializare"),
                        rs.getInt("Spital"),
                        rs.getInt("Experienta")
                ));
    }

    public void create(Medic medic) {
        String sql = "INSERT INTO medici(ID_medic, Nume, Prenume, DataNasterii, Telefon, Specializare, Spital, Experienta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, medic.getId(), medic.getNume(), medic.getPrenume(), medic.getDataNasterii(), medic.getTelefon(), medic.getSpecializare(), medic.getSpital(), medic.getExperienta());
    }

    public void update(String id, Medic medic) {
        String sql = "UPDATE medici SET Nume = ?, Prenume = ?, DataNasterii = ?, Telefon = ?, Specializare = ?, Spital = ?, Experienta = ? WHERE ID_medic = ?";
        jdbcTemplate.update(sql, medic.getNume(), medic.getPrenume(), medic.getDataNasterii(), medic.getTelefon(), medic.getSpecializare(), medic.getSpital(), medic.getExperienta(), id);
    }

    public void delete(String id) {
        String sql = "DELETE FROM medici WHERE ID_medic = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean existById(String id) {
        String sql = "SELECT count(*) FROM medici WHERE ID_medic = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
