package ru.job4j.cinema.store;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cinema.models.Ticket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class PsqlStoreImpl implements Store {

    private final BasicDataSource pool = new BasicDataSource();
    private static final Logger LOG = LoggerFactory.getLogger(PsqlStoreImpl.class.getName());
    private final static String FIND_ALL_TICKETS = "SELECT * FROM ticket;";
    private final static String CREATE_TICKET = "INSERT INTO ticket (session_id, row, cell, account_id) VALUES (?, ?, ?, ?);";

    private PsqlStoreImpl() {
        Properties cfg = new Properties();
        try (BufferedReader io = new BufferedReader(
                new FileReader("db.properties")
        )) {
            cfg.load(io);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        pool.setDriverClassName(cfg.getProperty("jdbc.driver"));
        pool.setUrl(cfg.getProperty("jdbc.url"));
        pool.setUsername(cfg.getProperty("jdbc.username"));
        pool.setPassword(cfg.getProperty("jdbc.password"));
        pool.setMinIdle(5);
        pool.setMaxIdle(10);
        pool.setMaxOpenPreparedStatements(100);
    }

    private static final class Lazy {
        private static final Store INST = new PsqlStoreImpl();
    }

    public static Store instOf() {
        return Lazy.INST;
    }

    @Override
    public List<Ticket> findAllTicket() {
        List<Ticket> tickets = new LinkedList<>();
        try (Connection cn = pool.getConnection();
             PreparedStatement ps = cn.prepareStatement(FIND_ALL_TICKETS)) {
                try(ResultSet rs = ps.executeQuery()){
                    while (rs.next()) {
                        tickets.add(new Ticket(rs.getInt("cell"), rs.getInt("row")));
                    }
                }
        } catch (SQLException e) {
            LOG.error("FIND ALL TICKET ERROR", e);
        }
        return null;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        try (Connection cn = pool.getConnection();
             PreparedStatement ps =  cn.prepareStatement(CREATE_TICKET, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, ticket.getSession_id());
            ps.setInt(2, ticket.getRow());
            ps.setInt(3, ticket.getPlace());
            ps.setInt(4, ticket.getAccount_id());
            ps.executeQuery();
            try (ResultSet id = ps.getGeneratedKeys()) {
                if (id.next()) {
                    ticket.setId(id.getInt(1));
                }
            }
        } catch (SQLException e) {
            LOG.error("create ticket error", e);
        }
        return ticket;
    }
}
