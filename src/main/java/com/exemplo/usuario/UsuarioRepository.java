package com.exemplo.usuario;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.exemplo.usuario.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email,senha, perfil) VALUES (?, ?)";
        jdbc.update(sql, usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfil());
    }

    public List<Usuario> buscarTodos() {
        return jdbc.query("SELECT * FROM usuario", new RowMapper<Usuario>() {
            @Override
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Usuario(rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("perfil"));
            }
        });
    }
}
