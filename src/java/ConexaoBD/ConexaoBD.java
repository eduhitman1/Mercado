
package ConexaoBD;
import java.sql.Connection;
import java.sql.DriverManager;



public class ConexaoBD {

public Connection getConexao(){
    try{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/webmercado","postgres","eduhit00");
        
        
    }catch(Exception ex){
    throw new RuntimeException("Erro: "+ex);    
    }
    
}


    
}
