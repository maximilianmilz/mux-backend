/*
 * This file is generated by jOOQ.
 */
package de.thb.craftsquad.service.ticket.jooq.tables;


import de.thb.craftsquad.service.ticket.jooq.DefaultSchema;
import de.thb.craftsquad.service.ticket.jooq.Keys;
import de.thb.craftsquad.service.ticket.jooq.enums.Tag;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketTagRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TicketTag extends TableImpl<TicketTagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ticket_tag</code>
     */
    public static final TicketTag TICKET_TAG = new TicketTag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TicketTagRecord> getRecordType() {
        return TicketTagRecord.class;
    }

    /**
     * The column <code>ticket_tag.ticket_id</code>.
     */
    public final TableField<TicketTagRecord, Long> TICKET_ID = createField(DSL.name("ticket_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>ticket_tag.tag</code>.
     */
    public final TableField<TicketTagRecord, Tag> TAG = createField(DSL.name("tag"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(de.thb.craftsquad.service.ticket.jooq.enums.Tag.class), this, "");

    private TicketTag(Name alias, Table<TicketTagRecord> aliased) {
        this(alias, aliased, null);
    }

    private TicketTag(Name alias, Table<TicketTagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>ticket_tag</code> table reference
     */
    public TicketTag(String alias) {
        this(DSL.name(alias), TICKET_TAG);
    }

    /**
     * Create an aliased <code>ticket_tag</code> table reference
     */
    public TicketTag(Name alias) {
        this(alias, TICKET_TAG);
    }

    /**
     * Create a <code>ticket_tag</code> table reference
     */
    public TicketTag() {
        this(DSL.name("ticket_tag"), null);
    }

    public <O extends Record> TicketTag(Table<O> child, ForeignKey<O, TicketTagRecord> key) {
        super(child, key, TICKET_TAG);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<TicketTagRecord> getPrimaryKey() {
        return Keys.TICKET_TAG_PKEY;
    }

    @Override
    public List<UniqueKey<TicketTagRecord>> getKeys() {
        return Arrays.<UniqueKey<TicketTagRecord>>asList(Keys.TICKET_TAG_PKEY);
    }

    @Override
    public List<ForeignKey<TicketTagRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TicketTagRecord, ?>>asList(Keys.TICKET_TAG__TICKET_TAG_TICKET_ID_FKEY);
    }

    private transient Ticket _ticket;

    public Ticket ticket() {
        if (_ticket == null)
            _ticket = new Ticket(this, Keys.TICKET_TAG__TICKET_TAG_TICKET_ID_FKEY);

        return _ticket;
    }

    @Override
    public TicketTag as(String alias) {
        return new TicketTag(DSL.name(alias), this);
    }

    @Override
    public TicketTag as(Name alias) {
        return new TicketTag(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TicketTag rename(String name) {
        return new TicketTag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TicketTag rename(Name name) {
        return new TicketTag(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Tag> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
