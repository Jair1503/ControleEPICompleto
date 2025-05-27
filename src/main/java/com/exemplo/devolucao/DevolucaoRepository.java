package com.exemplo.devolucao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.exemplo.devolucao.Devolucao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class DevolucaoRepository {

    @Autowired
    private static JdbcTemplate jdbc;

    public static void salvar(Devolucao devolucao) {
        String sql = "INSERT INTO devolucao (id, idEmprestimo,dataDevolucao) VALUES (?, ?)";
        jdbc.update(sql, devolucao.getId(), devolucao.getIdEmprestimo(), devolucao.getDataDevolucao());
    }

    public static List<Devolucao> buscarTodos() {
        return jdbc.query("SELECT * FROM devolucao", new RowMapper<Devolucao>() {
            @Override
            public Devolucao mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Devolucao(rs.getInt("id"), rs.getInt("idEmprestimo"), rs.getString("dataDevolucao"));
            }
        });
    }
}
