package org.example.repository;

import org.example.Conexao;
import org.example.model.UnidadeCurricular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnidadeCurricularDAO {
    public void create (String nome, String codigo) {
        String query = "INSERT INTO unidades_curriculares (nome, codigo) VALUES (?,?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, nome);
            stmt.setString(2, codigo);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
