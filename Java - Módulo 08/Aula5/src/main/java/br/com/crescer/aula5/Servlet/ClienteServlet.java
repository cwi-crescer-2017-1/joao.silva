/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5.Servlet;

/**
 *
 * @author jpedr
 */
import br.com.crescer.Cliente;
import br.com.crescer.aula5.Bean.ClienteBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author carloshenrique
 */
@WebServlet(name = "cliente", urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteBean clienteBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        final List<Cliente> listCliente = clienteBean.findAll();
        
        try (final PrintWriter out = resp.getWriter();) {

            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            
            out.append("<label>Cadastro Cliente</label>");
            out.append("<br/><br/>");
            out.append("<form action=\"/Aula5/cliente\" method=\"POST\">\n");
            out.append("Nome <input name=\"nome\"/>\n");
            out.append("CPF <input name=\"cpf\" />\n");
            out.append("Celular <input name=\"celular\" />\n");
            out.append("<input type=\"submit\" value=\"Enviar\" />    \n");
            out.append("</form>");
            out.append("<br/><br/><br/>");
            out.append("<table class=\"table table-hover\"><thead><tr><th> Nome </th><th> CPF </th><th> Celular </th></tr></thead><tbody>");
            listCliente.forEach(cliente -> out.append("<tr><td>").append(cliente.getNome()).append("</td><td>").append(cliente.getCpf()).append("</td><td>").append(cliente.getCelular()).append("</td></tr>"));
            out.append("</tbody></table>");

            out.append("</body>");
            out.append("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        final String cpf = req.getParameter("cpf");
        final String celular = req.getParameter("celular");
        if (nome != null && cpf != null && celular != null) {
            final Cliente cliente = new Cliente(nome,cpf,celular);
            clienteBean.save(cliente);
        }
        resp.sendRedirect("/Aula5/cliente");
    }

}