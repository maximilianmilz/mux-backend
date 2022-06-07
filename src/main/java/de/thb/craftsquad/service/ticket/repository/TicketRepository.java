package de.thb.craftsquad.service.ticket.repository;

import static de.thb.craftsquad.service.ticket.jooq.tables.Ticket.TICKET;

import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TicketRepository {

    private final DSLContext context;

    public List<TicketRecord> findAll(long seek, int limit) {
        return context.selectFrom(TICKET)
                .orderBy(TICKET.ID.asc())
                .seek(seek)
                .limit(limit)
                .fetch();
    }

    public Optional<TicketRecord> findById(long id) {
        return context.selectFrom(TICKET)
                .where(TICKET.ID.eq(id))
                .fetchOptional();
    }

    public TicketRecord create(TicketRecord record) {
        return context.insertInto(TICKET)
                .set(record)
                .returning()
                .fetchOne();
    }

    public Optional<TicketRecord> update(long id, TicketRecord record) {
        return context.update(TICKET)
                .set(record)
                .where(TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public Optional<TicketRecord> delete(long id) {
        return context.delete(TICKET)
                .where(TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }
}
