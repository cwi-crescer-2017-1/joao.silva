/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5.Servlet;

import br.com.crescer.Cliente;
import br.com.crescer.Funcionario;
import br.com.crescer.aula5.Bean.FuncionarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpedr
 */
@WebServlet(name = "funcionario", urlPatterns = "/funcionario")
public class FuncionarioServlet extends HttpServlet{
    @EJB
    private FuncionarioBean funcionarioBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<Funcionario> listFuncionario = funcionarioBean.findAll();
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table class=\"table table-hover\"><thead><tr><th> Nome </th><th> RG </th></tr></thead><tbody>");
            listFuncionario.forEach(funcionario -> out.append("<tr><td>").append(funcionario.getNome()).append("</td><td>").append(funcionario.getRg()).append("</td></tr>"));
            out.append("</tbody></table>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        final String rg = req.getParameter("rg");
        if (nome != null && rg != null) {
            final Funcionario funcionario = new Funcionario(nome,rg);
            funcionarioBean.save(funcionario);
        }
        resp.sendRedirect("/Aula5/html/funcionario.jsp");
    }
}
