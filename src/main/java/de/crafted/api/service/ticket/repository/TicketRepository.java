package de.crafted.api.service.ticket.repository;

import de.crafted.api.service.account.jooq.tables.Account;
import de.crafted.api.service.ticket.jooq.tables.Ticket;
import de.crafted.api.service.ticket.jooq.tables.records.TicketRecord;
import de.crafted.api.service.ticket.mapper.TicketMapper;
import de.crafted.api.service.ticket.model.Status;
import de.crafted.api.service.ticket.model.Tag;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static de.crafted.api.service.ticket.jooq.tables.TicketTag.TICKET_TAG;

@Repository
@RequiredArgsConstructor
public class TicketRepository {

    private final DSLContext context;

    public List<TicketRecord> findAll(Optional<String> searchTerm, Optional<List<Tag>> tags,
                                      Optional<Status> status,
                                      Optional<Long> accountId, Optional<Long> assignedTo) {
        Condition condition = createFilterCondition(searchTerm, tags, status, accountId, assignedTo);

        return context.select().from(Ticket.TICKET)
                .leftJoin(TICKET_TAG).on(TICKET_TAG.TICKET_ID.eq(Ticket.TICKET.ID))
                .leftJoin(Account.ACCOUNT).on(Ticket.TICKET.ACCOUNT_ID.eq(Account.ACCOUNT.ID))
                .where(condition)
                .orderBy(Ticket.TICKET.ID.asc())
                .fetchInto(Ticket.TICKET);
    }

    private Condition createFilterCondition(Optional<String> searchTerm, Optional<List<Tag>> tags,
                                            Optional<Status> status,
                                            Optional<Long> accountId, Optional<Long> assignedTo) {
        Condition condition = DSL.noCondition();

        if (searchTerm.isPresent()) {
            condition = condition.and(Ticket.TICKET.TITLE.contains(searchTerm.get()))
                    .or(Ticket.TICKET.DESCRIPTION.contains(searchTerm.get()));
        }
        if (tags.isPresent()) {
            for (Tag tag : tags.get()) {
                condition = condition.and(TICKET_TAG.TAG.eq(TicketMapper.mapTag(tag)));
            }
        }
        if (status.isPresent()) {
            condition = condition.and(Ticket.TICKET.STATUS.eq(TicketMapper.mapStatus(status.get())));
        }
        if (accountId.isPresent()) {
            condition = condition.and(Ticket.TICKET.ACCOUNT_ID.eq(accountId.get()));
        }
        if (assignedTo.isPresent()) {
            condition = condition.and(Ticket.TICKET.ASSIGNED_TO.eq(assignedTo.get()));
        }

        return condition;
    }

    public Optional<TicketRecord> findById(long id) {
        return context.selectFrom(Ticket.TICKET)
                .where(Ticket.TICKET.ID.eq(id))
                .fetchOptional();
    }

    public TicketRecord create(TicketRecord record) {
        return context.insertInto(Ticket.TICKET)
                .set(record)
                .returning()
                .fetchOne();
    }

    public Optional<TicketRecord> update(long id, TicketRecord record) {
        return context.update(Ticket.TICKET)
                .set(record)
                .where(Ticket.TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public Optional<TicketRecord> delete(long id) {
        return context.delete(Ticket.TICKET)
                .where(Ticket.TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public Optional<TicketRecord> updateStatus(Long id, de.crafted.api.service.ticket.jooq.enums.Status status) {
        return context.update(Ticket.TICKET)
                .set(Ticket.TICKET.STATUS, status)
                .where(Ticket.TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public Optional<TicketRecord> assignTo(Long id, Long assignedTo) {
        return context.update(Ticket.TICKET)
                .set(Ticket.TICKET.ASSIGNED_TO, assignedTo)
                .where(Ticket.TICKET.ID.eq(id))
                .returning()
                .fetchOptional();
    }

    public List<TicketRecord> findTicketsOfAccount(long accountId) {
        return context.selectFrom(Ticket.TICKET)
                .where(Ticket.TICKET.ACCOUNT_ID.eq(accountId))
                .orderBy(Ticket.TICKET.CREATED.desc())
                .fetch();
    }

    public List<TicketRecord> findProjectsOfUser(long accountId) {
        return context.selectFrom(Ticket.TICKET)
                .where(Ticket.TICKET.ASSIGNED_TO.eq(accountId))
                .orderBy(Ticket.TICKET.CREATED.desc())
                .fetch();
    }
}
