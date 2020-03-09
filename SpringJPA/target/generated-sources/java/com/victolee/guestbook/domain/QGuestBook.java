package com.victolee.guestbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGuestBook is a Querydsl query type for GuestBook
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGuestBook extends EntityPathBase<GuestBook> {

    private static final long serialVersionUID = -609422812L;

    public static final QGuestBook guestBook = new QGuestBook("guestBook");

    public final StringPath message = createString("message");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath pwd = createString("pwd");

    public final DateTimePath<java.util.Date> regDate = createDateTime("regDate", java.util.Date.class);

    public QGuestBook(String variable) {
        super(GuestBook.class, forVariable(variable));
    }

    public QGuestBook(Path<? extends GuestBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuestBook(PathMetadata metadata) {
        super(GuestBook.class, metadata);
    }

}

