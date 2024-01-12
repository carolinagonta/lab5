package com.example.demo.repository;

import com.example.demo.entity.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramareRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Programare> findAll() {
        return jdbcTemplate.query("SELECT * FROM programari", (resultSet, rowNum) -> {
            Programare programare = new Programare();
            programare.setIdProgramare(resultSet.getInt("ID_programare"));
            programare.setClient(resultSet.getString("Client"));
            programare.setMedic(resultSet.getString("Medic"));
            programare.setOra(resultSet.getTimestamp("Ora"));
            programare.setCabinetul(resultSet.getInt("Cabinetul"));
            return programare;
        });
    }

    public Programare findById(int id) {
        String sql = "SELECT * FROM programari WHERE ID_programare = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Programare(
                        rs.getInt("ID_programare"),
                        rs.getString("Client"),
                        rs.getString("Medic"),
                        rs.getTimestamp("Ora"),
                        rs.getInt("Cabinetul")
                ));
    }

    public void create(Programare programare) {
        String sql = "INSERT INTO programari(Client, Medic, Ora, Cabinetul) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, programare.getClient(), programare.getMedic(), programare.getOra(), programare.getCabinetul());
    }

    public void update(int id, Programare programare) {
        String sql = "UPDATE programari SET Client = ?, Medic = ?, Ora = ?, Cabinetul = ? WHERE ID_programare = ?";
        jdbcTemplate.update(sql, programare.getClient(), programare.getMedic(), programare.getOra(), programare.getCabinetul(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM programari WHERE ID_programare = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT count(*) FROM programari WHERE ID_programare = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
