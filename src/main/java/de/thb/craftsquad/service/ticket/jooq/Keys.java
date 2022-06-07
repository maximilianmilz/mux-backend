/*
 * This file is generated by jOOQ.
 */
package de.thb.craftsquad.service.ticket.jooq;


import de.thb.craftsquad.service.ticket.jooq.tables.Ticket;
import de.thb.craftsquad.service.ticket.jooq.tables.TicketImage;
import de.thb.craftsquad.service.ticket.jooq.tables.TicketTag;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketImageRecord;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketRecord;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketTagRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TicketRecord> TICKET_PKEY = Internal.createUniqueKey(Ticket.TICKET, DSL.name("ticket_pkey"), new TableField[] { Ticket.TICKET.ID }, true);
    public static final UniqueKey<TicketImageRecord> TICKET_IMAGE_PKEY = Internal.createUniqueKey(TicketImage.TICKET_IMAGE, DSL.name("ticket_image_pkey"), new TableField[] { TicketImage.TICKET_IMAGE.TICKET_ID, TicketImage.TICKET_IMAGE.IMAGE_ID }, true);
    public static final UniqueKey<TicketTagRecord> TICKET_TAG_PKEY = Internal.createUniqueKey(TicketTag.TICKET_TAG, DSL.name("ticket_tag_pkey"), new TableField[] { TicketTag.TICKET_TAG.TICKET_ID, TicketTag.TICKET_TAG.TAG }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<TicketImageRecord, TicketRecord> TICKET_IMAGE__TICKET_IMAGE_TICKET_ID_FKEY = Internal.createForeignKey(TicketImage.TICKET_IMAGE, DSL.name("ticket_image_ticket_id_fkey"), new TableField[] { TicketImage.TICKET_IMAGE.TICKET_ID }, Keys.TICKET_PKEY, new TableField[] { Ticket.TICKET.ID }, true);
    public static final ForeignKey<TicketTagRecord, TicketRecord> TICKET_TAG__TICKET_TAG_TICKET_ID_FKEY = Internal.createForeignKey(TicketTag.TICKET_TAG, DSL.name("ticket_tag_ticket_id_fkey"), new TableField[] { TicketTag.TICKET_TAG.TICKET_ID }, Keys.TICKET_PKEY, new TableField[] { Ticket.TICKET.ID }, true);
}
