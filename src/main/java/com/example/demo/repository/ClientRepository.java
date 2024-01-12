package com.example.demo.repository;

import com.example.demo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM clienti", (resultSet, rowNum) -> {
            Client client = new Client();
            client.setId(resultSet.getString("ID_client"));
            client.setNume(resultSet.getString("Nume"));
            client.setPrenume(resultSet.getString("Prenume"));
            client.setDataNasterii(resultSet.getString("DataNasterii"));
            client.setTelefon(resultSet.getString("Telefon"));
            client.setMedic(resultSet.getString("Medic"));
            return client;
        });
    }

    public Client findById(String id) {
        String sql = "SELECT * FROM clienti WHERE ID_client = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Client(
                        rs.getString("ID_client"),
                        rs.getString("Nume"),
                        rs.getString("Prenume"),
                        rs.getString("DataNasterii"),
                        rs.getString("Telefon"),
                        rs.getString("Medic")
                ));
    }

    public void create(Client client) {
        String sql = "INSERT INTO clienti(ID_client, Nume, Prenume, DataNasterii, Telefon, Medic) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, client.getId(), client.getNume(), client.getPrenume(),
                client.getDataNasterii(), client.getTelefon(), client.getMedic());
    }

    public void update(String id, Client client) {
        String sql = "UPDATE clienti SET Nume = ?, Prenume = ?, DataNasterii = ?, Telefon = ?, Medic = ? WHERE ID_client = ?";

        jdbcTemplate.update(sql, client.getNume(), client.getPrenume(),
                client.getDataNasterii(), client.getTelefon(), client.getMedic(), id);
    }

    public void delete(String id) {
        String sql = "DELETE FROM clienti WHERE ID_client = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(String id) {
        String sql = "SELECT COUNT(*) FROM clienti WHERE ID_client = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }
}
