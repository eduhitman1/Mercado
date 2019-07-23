<%@page import="dao.DaoProduto"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
            try{
            DaoProduto proDao = new DaoProduto();
            proDao.excluir(Integer.parseInt(request.getParameter("codigo")));
            response.sendRedirect("index.jsp");
        }catch(Exception ex){
            throw new RuntimeException("Erro ao EXCLUIR PAGE: "+ex);
        }
            
            
        
            %>
        
    </body>
</html>
