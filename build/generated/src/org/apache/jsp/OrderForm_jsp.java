package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class OrderForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Order form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"/WebApp/OrderServlet\" method=\"POST\" style=\"background:#AAAAAA; width:295px; margin:auto;\">\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Enter first name: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type = \"text\" name = \"firstName\" placeholder = \"last\"><br>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Gender: \n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type = \"radio\" name = \"gender\"> male\n");
      out.write("                        <input type = \"radio\" name = \"gender\"> female\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td style=\"vertical-align:top\">Description:\n");
      out.write("                    </td>\t\n");
      out.write("                    <td>\n");
      out.write("                        <textarea rows = \"5\" columns = \"10\" name = \"text\">Enter Description.\n");
      out.write("                        </textarea>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <input type = \"checkbox\" name = \"checkbox\"> checkbox <br>\n");
      out.write("            <select name=\"person\">\n");
      out.write("                <option> item 1 </option>\n");
      out.write("                <option > item 2 </option>\n");
      out.write("                <option > item 3 </option>\n");
      out.write("            </select><br>\n");
      out.write("            <input type = \"submit\" name = \"submitButton\" value=\"login\"><br>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
