package com.exemplo.emprestimo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmprestimoRepository {

    @Autowired
    private static JdbcTemplate jdbc;

    public static void salvar(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo (id, idUsuario,idEpi, dataRetirada, dataPrevistaDevolucao, confirmacaoRetirada) VALUES (?, ?)";
        jdbc.update(sql, emprestimo.getId(), emprestimo.getIdUsuario(), emprestimo.getIdEpi(), emprestimo.getDataRetirada(),emprestimo.getDataPrevistaDevolucao(), emprestimo.getConfirmacaoRetirada());
    }

    public static List<Emprestimo> buscarTodos() {
        return jdbc.query("SELECT * FROM emprestimo", new RowMapper<Emprestimo>() {
            @Override
            public Emprestimo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emprestimo(rs.getInt("id"), rs.getInt("idUsuario"), rs.getInt("idEpi"), rs.getString("dataRetirada"), rs.getString("dataPrevistaDevolucao"), rs.getBoolean("confirmacaoRetirada"));
            }
        });
    }
}
