package com.exemplo.Emprestimo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.exemplo.epi.Epi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmprestimoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void salvar(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo (idUsuario, idEpi, dataRetirada, dataDevolucao, confirmacaoRetirada) VALUES (?, ?)";
        jdbc.update(sql, emprestimo.get(), epi.getQuantidade());
    }

    public List<Epi> buscarTodos() {
        return jdbc.query("SELECT * FROM emprestimo", new RowMapper<Epi>() {
            @Override
            public Epi mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emprestimo(rs.getString("idUsuario"), rs.getString("quantidade"));
            }
        });
    }
}
