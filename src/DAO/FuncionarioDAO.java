package DAO;

import Modelo.Funcionario;
import java.sql.*;

public class FuncionarioDAO extends ExecuteSQL {

    public FuncionarioDAO(Connection con){
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        
        try {
            String consulta  = "SELECT login, senha FROM funcionario" +
                    "WHERE login = '"+ login + "' AND senha = '"+ senha +"'";
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Funcionario a = new Funcionario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return finalResult;
    }
    
}