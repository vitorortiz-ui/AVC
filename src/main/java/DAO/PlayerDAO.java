
package DAO;

import DAO.Conexao;
import model.Player;

import java.sql.*;

public class PlayerDAO {

   public void salvar(Player player) {

       String sql =
       "INSERT INTO player(nome, skill_points) VALUES (?, ?)";

       try (
           Connection conn =
               Conexao.getConnection();

           PreparedStatement stmt =
               conn.prepareStatement(sql)
       ) {

           stmt.setString(1, player.getNome());

           stmt.setInt(2, player.getSkillPoints());

           stmt.execute();

       } catch (Exception e) {

           e.printStackTrace();
       }
   }

   public Player buscarPorId(int id) {

       String sql =
       "SELECT * FROM player WHERE id = ?";

       try (
           Connection conn =
               Conexao.getConnection();

           PreparedStatement stmt =
               conn.prepareStatement(sql)
       ) {

           stmt.setInt(1, id);

           ResultSet rs = stmt.executeQuery();

           if (rs.next()) {

               Player p = new Player();

               p.setId(rs.getInt("id"));

               p.setNome(rs.getString("nome"));

               p.setSkillPoints(
                   rs.getInt("skill_points")
               );

               p.setMetaVida(
                   rs.getInt("meta_vida")
               );

               p.setMetaDano(
                   rs.getInt("meta_dano")
               );

               p.setMetaSorte(
                   rs.getInt("meta_sorte")
               );

               return p;
           }

       } catch (Exception e) {

           e.printStackTrace();
       }

       return null;
   }
}
