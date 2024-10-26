package mk.ukim.finki.lab.web;

import java.io.IOException;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EventBookingServlet", urlPatterns = { "/eventBooking" })
public class EventBookingServlet extends HttpServlet {

    private final SpringTemplateEngine engine;
    String event = "undefined";
    Integer tickets = 0;

    public EventBookingServlet(SpringTemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);

        context.setVariable("event", event);
        context.setVariable("tickets", tickets);

        engine.process("bookingConfirmation", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.event = req.getParameter("selectedEvent");
        this.tickets = Integer.parseInt(req.getParameter("numTickets"));

        resp.sendRedirect("/eventBooking");

    }

}
