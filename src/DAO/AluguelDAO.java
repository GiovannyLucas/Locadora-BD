package DAO;

import Modelo.Aluguel;
import Modelo.DVD;
import Modelo.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AluguelDAO extends ExecuteSQL {

    public AluguelDAO(Connection con){
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a) {
        String sql = "INSERT INTO aluguel VALUES (0,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);

            ps.setInt(1, a.getCoddvd());
            ps.setInt(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir.";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Aluguel> ListarAluguel() {
        String sql = "SELECT idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao"
                + " FROM aluguel";
        List<Aluguel> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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
    
    public List<Funcionario> Pesquisar_Nome_Funcionario(String nome){
        String sql = "SELECT idfuncionario,nome,login "
                + "FROM funcionario WHERE nome LIKE '%"+ nome +"%'";
       
        List<Funcionario> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    
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

    public List<Aluguel> Pesquisa_Cod_Aluguel(int id){
        String sql = "SELECT idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao"
                + " FROM aluguel WHERE idaluguel = '"+ id +"'";
       
        List<Aluguel> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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
    
    public List<Aluguel> Pesquisa_Coddvd_Aluguel(int iddvd){
        String sql = "SELECT idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao"
                + " FROM aluguel WHERE iddvd = '"+ iddvd +"'";
       
        List<Aluguel> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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

    public List<Aluguel> Pesquisa_Codcli_Aluguel(int idCli){
        String sql = "SELECT idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao"
                + " FROM aluguel WHERE idcliente = '"+ idCli +"'";
       
        List<Aluguel> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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

    public List<Aluguel> Pesquisa_Nome_Aluguel(String cliente){
        String sql = "SELECT idaluguel,iddvd,idcliente,hora_aluguel,data_aluguel,data_devolucao"
                + " FROM aluguel WHERE idcliente = '"+ cliente +"'";
       
        List<Aluguel> lista = new ArrayList<>();
            
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                    
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

    public boolean Testar_Classificacao(int cod){
        Boolean Resultado = false;
        try {
            String sql = "SELECT * FROM funcionario WHERE idfuncionario = "
                    + cod + "";
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
    
    public List<Funcionario> CapturarFuncionario(int cod){
        String sql = "SELECT * FROM funcionario WHERE idfuncionario = "+ cod +"";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {                    
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
                    a.setNome(rs.getString(2));
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
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
    
    public String Atualizar_Situacao(String situacao, int coddvd){
        String sql = "UPDATE dvd SET situacao = '"+ situacao +"' WHERE iddvd = "+ coddvd +"";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso!";
            } else {
                return "Erro ao atualizar!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Funcionario> ListarComboFuncionario(){
        String sql = "SELECT nome FROM funcionario ORDER BY nome";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Funcionario a = new Funcionario();
                    a.setNome(rs.getString(1));
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
    
    public List<Funcionario> ConsultaCodigoFuncionario(String nome){
        String sql = "SELECT idfuncionario FROM funcionario WHERE nome = '"+ nome +"'";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Funcionario a = new Funcionario();
                    a.setCod(rs.getInt(1));
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
    
    public String Excluir_Funcionario(Funcionario a){
        String sql = "DELETE FROM funcionario WHERE idfuncionario = ? AND nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod());
            ps.setString(2, a.getNome());
            
            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso!";
            } else {
                return "Erro ao excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
