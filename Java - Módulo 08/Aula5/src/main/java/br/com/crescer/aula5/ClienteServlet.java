package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author carloshenrique
 */
public class ClienteServlet extends HttpServlet {

    private Set<String> clientes = new HashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try (final PrintWriter out = resp.getWriter();) {

            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");

            out.append("<form action=\"/Aula5/cliente\" method=\"POST\">\n");
            out.append(" <input name=\"nome\" autofocus/>\n");
            out.append(" <input type=\"submit\" value=\"Enviar\" />    \n");
            out.append("</form>");

            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            clientes.forEach(nome -> out.append("<tr><td>").append(nome).append("</td></tr>"));
            out.append("</tbody></table>");

            out.append("</body>");
            out.append("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String nome = req.getParameter("nome");
        if (nome != null) {
            clientes.add(nome);
        }
        resp.sendRedirect("/Aula5/cliente");
    }

}
