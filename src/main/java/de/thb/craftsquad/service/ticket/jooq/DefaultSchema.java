/*
 * This file is generated by jOOQ.
 */
package de.thb.craftsquad.service.ticket.jooq;


import de.thb.craftsquad.service.ticket.jooq.tables.Ticket;
import de.thb.craftsquad.service.ticket.jooq.tables.TicketImage;
import de.thb.craftsquad.service.ticket.jooq.tables.TicketTag;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>ticket</code>.
     */
    public final Ticket TICKET = Ticket.TICKET;

    /**
     * The table <code>ticket_image</code>.
     */
    public final TicketImage TICKET_IMAGE = TicketImage.TICKET_IMAGE;

    /**
     * The table <code>ticket_tag</code>.
     */
    public final TicketTag TICKET_TAG = TicketTag.TICKET_TAG;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Ticket.TICKET,
            TicketImage.TICKET_IMAGE,
            TicketTag.TICKET_TAG);
    }
}
