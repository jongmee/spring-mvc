package study.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import study.servlet.domain.Schedule;
import study.servlet.domain.ScheduleRepository;

@WebServlet(name = "schedulesServlet", urlPatterns = "/servlet/schedules")
        public class SchedulesServlet extends HttpServlet {
    private ScheduleRepository scheduleRepository = ScheduleRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Schedule> schedules = scheduleRepository.findAll();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("    <thead>");
        w.write("    <th>id</th>");
        w.write("    <th>title</th>");
        w.write("    <th>date</th>");
        w.write("    <th>tag</th>");
        w.write("    </thead>");
        w.write("    <tbody>");

        for (Schedule schedule : schedules) {
            w.write("    <tr>");
            w.write("        <td>"+schedule.getId()+"</td>");
            w.write("        <td>"+schedule.getTitle()+"</td>");
            w.write("        <td>"+schedule.getDate()+"</td>");
            w.write("        <td>"+schedule.getTag()+"</td>");
            w.write("    </tr>");
        }

        w.write("    </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}
