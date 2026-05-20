package DAO;

import DAO.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankingDAO {

   public List<String> buscarTop10() {

       List<String> ranking =
               new ArrayList<>();

       String sql =
    "SELECT p.nome, r.pontuacao " +
    "FROM ranking r " +
    "JOIN player p ON p.id = r.player_id " +
    "ORDER BY r.pontuacao DESC " +
    "LIMIT 10";

       try (
           Connection conn =
               Conexao.getConnection();

           PreparedStatement stmt =
               conn.prepareStatement(sql)
       ) {

           ResultSet rs =
                   stmt.executeQuery();

           while (rs.next()) {

               ranking.add(
                   rs.getString("nome")
                   + " - "
                   + rs.getInt("pontuacao")
               );
           }

       } catch (Exception e) {

           e.printStackTrace();
       }

       return ranking;
   }
}
