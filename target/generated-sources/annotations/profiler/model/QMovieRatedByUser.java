package profiler.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMovieRatedByUser is a Querydsl query type for MovieRatedByUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieRatedByUser extends EntityPathBase<MovieRatedByUser> {

    private static final long serialVersionUID = 1818642432L;

    public static final QMovieRatedByUser movieRatedByUser = new QMovieRatedByUser("movieRatedByUser");

    public final StringPath id = createString("id");

    public QMovieRatedByUser(String variable) {
        super(MovieRatedByUser.class, forVariable(variable));
    }

    public QMovieRatedByUser(Path<? extends MovieRatedByUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovieRatedByUser(PathMetadata metadata) {
        super(MovieRatedByUser.class, metadata);
    }

}

