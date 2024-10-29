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
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.lab.service.EventBookingService;

@WebServlet(name = "EventBookingServlet", urlPatterns = { "/eventBooking" })
public class EventBookingServlet extends HttpServlet {

    private final SpringTemplateEngine engine;
    private final EventBookingService bookings;

    public EventBookingServlet(SpringTemplateEngine engine, EventBookingService bookings) {
        this.engine = engine;
        this.bookings = bookings;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(exchange);

        String text = req.getParameter("text");

        HttpSession session = req.getSession();

        context.setVariable("name", session.getAttribute("name"));
        context.setVariable("numTickets", session.getAttribute("numTickets"));
        context.setVariable("selectedEvent", session.getAttribute("selectedEvent"));
        context.setVariable("addr", session.getAttribute("addr"));

        if (text == null) {
            context.setVariable("bookings", bookings.listAll());

            engine.process("bookingConfirmation", context, resp.getWriter());
            return;
        }
        context.setVariable("bookings", bookings.searchBookings(text));

        engine.process("bookingConfirmation", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String attendeeName = req.getParameter("name");
        String eventName = req.getParameter("selectedEvent");
        String address = req.getParameter("addr");
        Integer tickets = Integer.parseInt(req.getParameter("numTickets"));

        HttpSession session = req.getSession();
        session.setAttribute("name", attendeeName);
        session.setAttribute("selectedEvent", eventName);
        session.setAttribute("addr", address);
        session.setAttribute("numTickets", tickets);

        bookings.placeBooking(eventName, attendeeName, address, tickets);

        resp.sendRedirect("/eventBooking");
    }

}
