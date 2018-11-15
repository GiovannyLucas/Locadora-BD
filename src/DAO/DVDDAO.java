package DAO;

import Modelo.DVD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DVDDAO extends ExecuteSQL {

    public DVDDAO(Connection con) {
        super(con);
    }

    public String Inserir_DVD(DVD a) {
        String sql = "INSERT INTO dvd VALUES (0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql); 

            ps.setInt(1, a.getCod_filme());
            ps.setString(2, a.getNome_filme());
            ps.setDouble(3, a.getPreco());
            ps.setString(4, a.getData_compra());
            ps.setString(5, a.getSituacao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<DVD> ListarDVD() {
        String sql = "SELECT iddvd,idfilme,nome_filme,preco_compra,data_compra,situacao FROM dvd";
        List<DVD> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setNome_filme(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setData_compra(rs.getString(5));
                    a.setSituacao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    
    }
    
    public List<DVD> Pesquisar_Cod_iddvd(int id){
        String sql = "SELECT iddvd,idfilme,nome_filme,preco_compra,data_compra,situacao "
                + "FROM dvd WHERE iddvd = "+ id +"";
       
        List<DVD> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setNome_filme(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setData_compra(rs.getString(5));
                    a.setSituacao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }

    public List<DVD> Pesquisar_Cod_idfilme(int cod){
        String sql = "SELECT iddvd,idfilme,nome_filme,preco_compra,data_compra,situacao "
                + "FROM dvd WHERE idfilme = '"+ cod +"'";
       
        List<DVD> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setNome_filme(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setData_compra(rs.getString(5));
                    a.setSituacao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }   
    }

    public boolean Testar_DVD(int cod){
        Boolean Resultado = false;
        try {
            String sql = "SELECT * FROM dvd WHERE iddvd = "+ cod +"";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return Resultado;
    }
    
    public boolean Testar_Situacao(int cod){
        Boolean teste = false;
        try {
            String sql = "SELECT * FROM dvd WHERE iddvd = "+ cod +" AND "
                    + "situacao = 'Disponível'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    teste = true;
                }
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return teste;
    }
    
    public List<DVD> CapturarDVD(int cod){
        String sql = "SELECT * FROM dvd WHERE iddvd = "+ cod +"";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setNome_filme(rs.getString(3));
                    a.setPreco(rs.getDouble(4));
                    a.setData_compra(rs.getString(5));
                    a.setSituacao(rs.getString(6));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public String Alterar_DVD(DVD a){
        String sql = "UPDATE dvd SET idfilme = ?, nome_filme = ?, preco_compra = ?, data_compra = ?, situacao = ? WHERE iddvd = ?";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setString(2, a.getNome_filme());
            ps.setDouble(3, a.getPreco());
            ps.setString(4, a.getData_compra());
            ps.setString(5, a.getSituacao());
            ps.setInt(6, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao atualizar!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<DVD> ListarComboDVD(){
        String sql = "SELECT nome_filme FROM dvd ORDER BY nome_filme";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setNome_filme(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<DVD> ConsultaCodigoDVD(String nome){
        String sql = "SELECT iddvd FROM dvd WHERE nome_filme = '"+ nome +"'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_DVD(DVD a){
        String sql = "DELETE FROM dvd WHERE iddvd = ? AND nome_filme = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome_filme());
            
            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso!";
            } else {
                return "Erro ao excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<DVD> ListarCodFilme(int cod){
        String sql = "SELECT idfilme FROM dvd WHERE iddvd = '"+ cod +"'";
        List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    DVD a = new DVD();
                    a.setCod_filme(rs.getInt(1));
                    
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
