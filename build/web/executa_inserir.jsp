<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produto"%>
<%@page import="dao.DaoProduto"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%   // COMO SE FOSSE O CODIGO DO JFRAME// INSERT
        try{
            Produto pro = new Produto();
            DaoProduto proDao = new DaoProduto();
            
            if(request.getParameter("descricao").equals("") || request.getParameter("preco").equals("")){
                response.sendRedirect("index.jsp"); // caso o campo fica limpo será redirecionado para o principal
            }else{
                pro.setDescricao_produto(request.getParameter("descricao"));
                pro.setPreco_produto(Double.parseDouble(request.getParameter("preco"))); 
                proDao.inserir(pro);
                
                response.sendRedirect("index.jsp"); 
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao INSERIR PAGE: "+ex);
        } 
        %>
        
        
        
    </body>
</html>
