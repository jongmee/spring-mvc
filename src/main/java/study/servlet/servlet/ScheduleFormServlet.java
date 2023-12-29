package study.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import study.servlet.domain.ScheduleRepository;

@WebServlet(name = "scheduleFormServlet", urlPatterns = "/servlet/schedules/form")
public class ScheduleFormServlet extends HttpServlet {
    private ScheduleRepository scheduleRepository = ScheduleRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();
        w.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/schedules/save\" method=\"post\">\n" +
                "    title: <input type=\"text\" name=\"title\" />\n" +
                "    date:      <input type=\"text\" name=\"date\" />\n" +
                "    tag:      <input type=\"text\" name=\"tag\" />\n" +
                " <button type=\"submit\">전송</button>\n" + "</form>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
