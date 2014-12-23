package com.example.beer;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBeers is a Querydsl query type for QBeers
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QBeers extends com.mysema.query.sql.RelationalPathBase<QBeers> {

    private static final long serialVersionUID = 735296895;

    public static final QBeers beers = new QBeers("beers");

    public final NumberPath<Float> abv = createNumber("abv", Float.class);

    public final NumberPath<Integer> addUser = createNumber("addUser", Integer.class);

    public final NumberPath<Integer> breweryId = createNumber("breweryId", Integer.class);

    public final NumberPath<Integer> catId = createNumber("catId", Integer.class);

    public final StringPath descript = createString("descript");

    public final StringPath filepath = createString("filepath");

    public final NumberPath<Float> ibu = createNumber("ibu", Float.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastMod = createString("lastMod");

    public final StringPath name = createString("name");

    public final NumberPath<Float> srm = createNumber("srm", Float.class);

    public final NumberPath<Integer> styleId = createNumber("styleId", Integer.class);

    public final NumberPath<Integer> upc = createNumber("upc", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<QBeers> beersPK = createPrimaryKey(id);

    public QBeers(String variable) {
        super(QBeers.class, forVariable(variable), "null", "beers");
        addMetadata();
    }

    public QBeers(String variable, String schema, String table) {
        super(QBeers.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBeers(Path<? extends QBeers> path) {
        super(path.getType(), path.getMetadata(), "null", "beers");
        addMetadata();
    }

    public QBeers(PathMetadata<?> metadata) {
        super(QBeers.class, metadata, "null", "beers");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(abv, ColumnMetadata.named("abv").withIndex(5).ofType(Types.FLOAT).withSize(2000000000).withDigits(10).notNull());
        addMetadata(addUser, ColumnMetadata.named("add_user").withIndex(11).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(breweryId, ColumnMetadata.named("brewery_id").withIndex(1).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(catId, ColumnMetadata.named("cat_id").withIndex(3).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(descript, ColumnMetadata.named("descript").withIndex(10).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(filepath, ColumnMetadata.named("filepath").withIndex(9).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(ibu, ColumnMetadata.named("ibu").withIndex(6).ofType(Types.FLOAT).withSize(2000000000).withDigits(10).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(0).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(lastMod, ColumnMetadata.named("last_mod").withIndex(12).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(2000000000).withDigits(10).notNull());
        addMetadata(srm, ColumnMetadata.named("srm").withIndex(7).ofType(Types.FLOAT).withSize(2000000000).withDigits(10).notNull());
        addMetadata(styleId, ColumnMetadata.named("style_id").withIndex(4).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
        addMetadata(upc, ColumnMetadata.named("upc").withIndex(8).ofType(Types.INTEGER).withSize(2000000000).withDigits(10).notNull());
    }

}

