package study.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import study.servlet.domain.Schedule;
import study.servlet.domain.ScheduleRepository;

@WebServlet(name = "scheduleSaveServlet", urlPatterns = "/servlet/schedules/save")
public class ScheduleSaveServlet extends HttpServlet {
    private ScheduleRepository scheduleRepository = ScheduleRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String tag = req.getParameter("tag");

        Schedule schedule = new Schedule(title, date, tag);
        scheduleRepository.save(schedule);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter w = resp.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "    <li>id="+schedule.getId()+"</li>\n" +
                "    <li>title="+schedule.getTitle()+"</li>\n" +
                "    <li>date="+schedule.getDate()+"</li>\n" +
                "    <li>tag="+schedule.getTag()+"</li>\n" + "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                "</html>");

    }
}
