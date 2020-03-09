package com.hyukje.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProfile is a Querydsl query type for Profile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfile extends EntityPathBase<Profile> {

    private static final long serialVersionUID = -1412672962L;

    public static final QProfile profile = new QProfile("profile");

    public final StringPath name = createString("name");

    public final NumberPath<Long> seqno = createNumber("seqno", Long.class);

    public final StringPath title = createString("title");

    public QProfile(String variable) {
        super(Profile.class, forVariable(variable));
    }

    public QProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfile(PathMetadata metadata) {
        super(Profile.class, metadata);
    }

}

