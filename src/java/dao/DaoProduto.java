
package dao;


import ConexaoBD.ConexaoBD;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Eduardo
 */
public class DaoProduto {
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Produto> lista = new ArrayList<>();
    
    public DaoProduto(){
    conn = new ConexaoBD().getConexao();
    }
    
public void inserir(Produto produto){
    String sql ="insert into produto (descricao_produto, preco_produto)values(?,?) ";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,produto.getDescricao_produto());
        stmt.setDouble(2, produto.getPreco_produto());
        stmt.execute();
        stmt.close();
    }catch(Exception ex){
        throw new RuntimeException("Erro ao inserir: "+ex);    
    }
    
}

public void alterar(Produto produto){
    String sql ="update produto set descricao_produto = ?, preco_produto = ? where codigo_produto=?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,produto.getDescricao_produto());
        stmt.setDouble(2, produto.getPreco_produto());
        stmt.setInt(3,produto.getCodigo_produto());
        stmt.execute();
        stmt.close();
    }catch(Exception ex){
        throw new RuntimeException("Erro ao alterar: "+ex);    
    }
    
}


public void excluir(int valor){
    String sql ="delete from produto where codigo_produto= "+valor;
    try{
        st = conn.createStatement();
        st.execute(sql);
        st.close();
    }catch(Exception ex){
        throw new RuntimeException("Erro ao excluir: "+ex);    
    }   
}
// LISTA TODOS
 public ArrayList<Produto> listaTodos(){
     String sql = "select * from produto";
     try{
         st = conn.createStatement();
         rs = st.executeQuery(sql);
         while(rs.next()){
             Produto produto = new Produto();
             produto.setCodigo_produto(rs.getInt("codigo_produto"));
             produto.setDescricao_produto(rs.getString("descricao_produto"));
             produto.setPreco_produto(rs.getDouble("preco_produto"));
             lista.add(produto);
         }
     }catch(Exception ex){
         throw new RuntimeException("Erro ao Listar: "+ex);    
     }
     return lista;
 }
// LISTA POR DESCRIÇÃO
 public ArrayList<Produto> listaTodosDescricao(String valor){
     String sql = "select * from produto where descricao_produto like '%"+valor+"'";
     try{
         st = conn.createStatement();
         rs = st.executeQuery(sql);
         while(rs.next()){
             Produto produto = new Produto();
             produto.setCodigo_produto(rs.getInt("codigo_produto"));
             produto.setDescricao_produto(rs.getString("descricao_produto"));
             produto.setPreco_produto(rs.getDouble("preco_produto"));
             lista.add(produto);
         }
     }catch(Exception ex){
         throw new RuntimeException("Erro ao Listar: "+ex);    
     }
     return lista;
 }
 
 
 


}
