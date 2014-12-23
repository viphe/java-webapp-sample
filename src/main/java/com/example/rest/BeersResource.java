package com.example.rest;
import com.example.beer.Beers;
import com.example.beer.QBeers;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.SQLiteTemplates;

import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("/beers")
@Consumes(Constants.UTF_8_JSON)
@Produces(Constants.UTF_8_JSON)
public class BeersResource {

    private Connection getConnection() throws SQLException {
        return new org.sqlite.JDBC().connect("jdbc:sqlite:db/beers.db", new java.util.Properties());
    }

    @GET
    public List<Beers> getBeers() throws SQLException {
        QBeers beers = QBeers.beers;
        SQLTemplates dialect = new SQLiteTemplates();
        try (Connection conn = getConnection()) {
            SQLQuery query = new SQLQuery(conn, dialect);
            return query.from(beers).limit(10).list(beers);
        }
    }

    @GET
    @Path("/{name}")
    public Beers getBeers(@PathParam("name") String name) throws SQLException {
        QBeers beers = QBeers.beers;
        SQLTemplates dialect = new SQLiteTemplates();
        try (Connection conn = getConnection()) {
            SQLQuery query = new SQLQuery(conn, dialect);
            return query.from(beers).where(beers.name.eq(name)).list(beers).get(0);
        }
    }

}