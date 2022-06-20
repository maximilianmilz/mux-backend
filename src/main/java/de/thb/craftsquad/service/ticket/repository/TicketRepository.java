package de.thb.craftsquad.service.ticket.repository;

import de.thb.craftsquad.service.ticket.jooq.enums.Status;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketRecord;
import de.thb.craftsquad.service.ticket.mapper.TicketMapper;
import de.thb.craftsquad.service.ticket.model.Tag;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static de.thb.craftsquad.service.account.jooq.tables.Account.ACCOUNT;
import static de.thb.craftsquad.service.ticket.jooq.tables.Ticket.TICKET;
import static de.thb.craftsquad.service.ticket.jooq.tables.TicketTag.TICKET_TAG;

@Repository
@RequiredArgsConstructor
public class TicketRepository {

    private final DSLContext context;

    public List<TicketRecord> findAll(Optional<String> searchTerm, Optional<List<Tag>> tags,
                                      Optional<de.thb.craftsquad.service.ticket.model.Status> status,
                                      Optional<Long> accountId, Optional<Long> assignedTo) {
        Condition condition = createFilterCondition(searchTerm, tags, status, accountId, assignedTo);

        return context.select().from(TICKET)
                .leftJoin(TICKET_TAG).on(TICKET_TAG.TICKET_ID.eq(TICKET.ID))
                .leftJoin(ACCOUNT).on(TICKET.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(condition)
                .orderBy(TICKET.ID.asc())
                .fetchInto(TICKET);
    }

    private Condition createFilterCondition(Optional<String> searchTerm, Optional<List<Tag>> tags,
                                            Optional<de.thb.craftsquad.service.ticket.model.Status> status,
                                            Optional<Long> accountId, Optional<Long> assignedTo) {
        Condition condition = DSL.noCondition();

        if (searchTerm.isPresent()) {
            condition = condition.and(TICKET.TITLE.contains(searchTerm.get()))
                    .or(TICKET.DESCRIPTION.contains(searchTerm.get()));
        }
        if (tags.isPresent()) {
            for (Tag tag : tags.get()) {
                condition = condition.and(TICKET_TAG.TAG.eq(TicketMapper.mapTag(tag)));
            }
        }
        if (status.isPresent()) {
            condition = condition.and(TICKET.STATUS.eq(TicketMapper.mapStatus(status.get())));
        }
        if (accountId.isPresent()) {
            condition = condition.and(TICKET.ACCOUNT_ID.eq(accountId.get()));
        }
        if (assignedTo.isPresent()) {
            condition = condition.and(TICKET.ASSIGNED_TO.eq(assignedTo.get()));
        }

        return condition;
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

    public Optional<TicketRecord> updateStatus(Long id, Status status) {
        return context.update(TICKET)
                .set(TICKET.STATUS, status)
                .where(TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public Optional<TicketRecord> assignTo(Long id, Long assignedTo) {
        return context.update(TICKET)
                .set(TICKET.ASSIGNED_TO, assignedTo)
                .where(TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public List<TicketRecord> findTicketsOfAccount(long accountId) {
        return context.selectFrom(TICKET)
                .where(TICKET.ACCOUNT_ID.eq(accountId))
                .orderBy(TICKET.CREATED.desc())
                .fetch();
    }

    public List<TicketRecord> findProjectsOfUser(long accountId) {
        return context.selectFrom(TICKET)
                .where(TICKET.ASSIGNED_TO.eq(accountId))
                .orderBy(TICKET.CREATED.desc())
                .fetch();
    }
}
