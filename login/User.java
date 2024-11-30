package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost:3306/test?user=root&password=hanglose1";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();

        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "'";
        sql += " AND senha = '" + senha + "';";
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        User user = new User();
        boolean isValidUser = user.verificarUsuario("usuario1", "senha1");
        if (isValidUser) {
            System.out.println("Usuário válido: " + user.nome);
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }
    }
}
