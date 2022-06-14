/*
 * This file is generated by jOOQ.
 */
package de.thb.craftsquad.service.ticket.jooq.enums;


import de.thb.craftsquad.service.ticket.jooq.DefaultSchema;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum Tag implements EnumType {

    electrician("electrician");

    private final String literal;

    private Tag(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public String getName() {
        return "tag";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}