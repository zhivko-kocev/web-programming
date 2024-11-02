package mk.ukim.finki.lab.web;

import java.io.IOException;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.ArtistService;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final ArtistService performers;

    public ArtistServlet(ArtistService performers) {
        this.performers = performers;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String p = performers.listArtists().stream().map(artist -> artist.toString()).collect(Collectors.joining("\n"));

        resp.getWriter().write(p);
        resp.getWriter().flush();
    }
}
