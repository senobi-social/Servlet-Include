package chapter9;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// includeのサンプルコードです
@WebServlet(urlPatterns={"/chapter9/include"})
public class Include extends HttpServlet {

  public void doGet (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    response.setContentType("text/html; charset=UTF-8");

    // HttpServletResponseインタフェースのgetWriter()
    // 出力ストリームを取得する
    PrintWriter out = response.getWriter();

    Page.header(out);

    // getRequestDispatcherメソッドでRequestDispatcherオブジェクトを取得
    // そのあとにincludeメソッドを使う
    request.getRequestDispatcher("include1.jsp")
      .include(request, response);
    request.getRequestDispatcher("include2.jsp")
      .include(request, response);

    Page.footer(out);
  }
}
