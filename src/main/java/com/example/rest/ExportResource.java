package com.example.rest;

import com.example.beer.Beers;
import com.example.beer.Breweries;
import com.example.beer.QBeers;
import com.example.beer.QBreweries;
import com.google.common.base.Strings;
import com.mysema.query.SearchResults;
import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.SQLiteTemplates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.schedulers.Schedulers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/export")
public class ExportResource {

    private static final Logger logger = LoggerFactory.getLogger(ExportResource.class);


    private Connection getConnection() throws SQLException {
        return new org.sqlite.JDBC().connect("jdbc:sqlite:db/beers.db", new java.util.Properties());
    }

    @GET
    @Path("/beers")
    @Produces("text/plain")
    public void exportBeers(@Suspended final AsyncResponse asyncResponse) {
        Schedulers.io().createWorker().schedule(() -> {
            logger.info("export starting");
            String sb = exportBeersToCsv();

            asyncResponse.resume(sb);

            logger.info("export finished");
        });
        logger.info("export scheduled");
    }

    private String exportBeersToCsv() {
        QBeers beers = QBeers.beers;
        QBreweries breweries = QBreweries.breweries;

        SQLTemplates dialect = new SQLiteTemplates();
        try (Connection conn = getConnection()) {

            StringBuilder sb = new StringBuilder();

            final int pageSize = 100;
            int offset = 0;
            while (true) {
                SQLQuery query = new SQLQuery(conn, dialect);
                SearchResults<Tuple> searchResults =
                    query.from(beers)
                        .leftJoin(breweries).on(beers.breweryId.eq(breweries.id))
                        .offset(offset).limit(pageSize).listResults(beers, breweries);

                for (Tuple tuple : searchResults.getResults()) {
                    Beers beer = tuple.get(0, Beers.class);
                    Breweries brewery = tuple.get(1, Breweries.class);
                    sb.append(beer.getName() + "," + (brewery == null ? "" : brewery.getName())).append("\n");
                }

                offset += searchResults.getResults().size();
                if (offset >= (searchResults.getTotal() - 1)) {
                    break;
                }
            }

            return sb.toString();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
