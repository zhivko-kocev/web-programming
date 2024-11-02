package mk.ukim.finki.lab.web;

import java.io.IOException;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.SongService;

@WebServlet(name = "SongListServlet", urlPatterns = { "/listSongs" })
public class SongListServlet extends HttpServlet {
    private final SongService songs;

    public SongListServlet(SongService songs) {
        this.songs = songs;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s = songs.listSongs().stream().map(song -> song.toString()).collect(Collectors.joining("\n"));

        resp.getWriter().write(s);
        resp.getWriter().flush();
    }

}
