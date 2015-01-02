package com.example.beer;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBreweries is a Querydsl query type for Breweries
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QBreweries extends com.mysema.query.sql.RelationalPathBase<Breweries> {

    private static final long serialVersionUID = 497545979;

    public static final QBreweries breweries = new QBreweries("breweries");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final NumberPath<Integer> addUser = createNumber("addUser", Integer.class);

    public final StringPath city = createString("city");

    public final StringPath code = createString("code");

    public final StringPath country = createString("country");

    public final StringPath descript = createString("descript");

    public final StringPath filepath = createString("filepath");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastMod = createString("lastMod");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath state = createString("state");

    public final StringPath website = createString("website");

    public final com.mysema.query.sql.PrimaryKey<Breweries> breweriesPK = createPrimaryKey(id);

    public QBreweries(String variable) {
        super(Breweries.class, forVariable(variable), "null", "breweries");
        addMetadata();
    }

    public QBreweries(String variable, String schema, String table) {
        super(Breweries.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBreweries(Path<? extends Breweries> path) {
        super(path.getType(), path.getMetadata(), "null", "breweries");
        addMetadata();
    }

    public QBreweries(PathMetadata<?> metadata) {
        super(Breweries.class, metadata, "null", "breweries");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(address1, ColumnMetadata.named("address1").withIndex(2).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(address2, ColumnMetadata.named("address2").withIndex(3).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(addUser, ColumnMetadata.named("add_user").withIndex(12).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(city, ColumnMetadata.named("city").withIndex(4).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(code, ColumnMetadata.named("code").withIndex(6).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(country, ColumnMetadata.named("country").withIndex(7).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(descript, ColumnMetadata.named("descript").withIndex(11).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(filepath, ColumnMetadata.named("filepath").withIndex(10).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(0).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(lastMod, ColumnMetadata.named("last_mod").withIndex(13).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(1).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(phone, ColumnMetadata.named("phone").withIndex(8).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(state, ColumnMetadata.named("state").withIndex(5).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(website, ColumnMetadata.named("website").withIndex(9).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
    }

}

