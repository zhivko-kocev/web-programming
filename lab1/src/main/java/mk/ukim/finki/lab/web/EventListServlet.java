package mk.ukim.finki.lab.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.EventService;

@WebServlet(name = "EventListServlet", urlPatterns = { "" })
@Controller
public class EventListServlet extends HttpServlet {

    private final SpringTemplateEngine engine;
    private final EventService events;

    public EventListServlet(SpringTemplateEngine engine, EventService events) {
        this.engine = engine;
        this.events = events;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);

        String text = req.getParameter("text");

        if (text == null) {
            context.setVariable("events", events.listAll());

            engine.process("listEvents", context, resp.getWriter());
            return;
        }

        context.setVariable("events", events.searchEvents(text));

        engine.process("listEvents", context, resp.getWriter());
    }

}
