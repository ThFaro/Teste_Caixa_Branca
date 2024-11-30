package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Classe responsável por gerenciar a autenticação de usuários.
 * Fornece métodos para conexão ao banco de dados e validação de credenciais.
 */
public class User {

    /**
     * Nome do usuário validado.
     */
    public String nome = "";

    /**
     * Resultado da validação de credenciais.
     */
    public boolean result = false;

    /**
     * Conecta ao banco de dados utilizando o driver JDBC.
     * 
     * @return Objeto Connection para manipulação do banco de dados.
     */
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

    /**
     * Método para verificar as credenciais do usuário.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
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

    /**
     * Método principal para execução do programa.
     * 
     * @param args Argumentos da linha de comando.
     */
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
