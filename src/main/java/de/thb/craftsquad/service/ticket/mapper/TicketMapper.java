package de.thb.craftsquad.service.ticket.mapper;

import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketRecord;
import de.thb.craftsquad.service.ticket.model.Status;
import de.thb.craftsquad.service.ticket.model.Tag;
import de.thb.craftsquad.service.ticket.model.Ticket;

import java.time.ZoneId;

public class TicketMapper {

    public static Ticket mapTicket(TicketRecord record) {
        return Ticket.builder()
                .id(record.getId())
                .title(record.getTitle())
                .description(record.getDescription())
                .status(mapStatus(record.getStatus()))
                .accountId(record.getAccountId())
                .assignedTo(record.getAssignedTo())
                .created(record.getCreated().atZone(ZoneId.systemDefault()))
                // TODO tags
                .build();
    }

    public static Status mapStatus(de.thb.craftsquad.service.ticket.jooq.enums.Status status) {
        return switch (status) {
            case open -> Status.OPEN;
            case assign -> Status.ASSIGNED;
            case done -> Status.DONE;
        };
    }

    public static de.thb.craftsquad.service.ticket.jooq.enums.Status mapStatus(Status status) {
        return switch (status) {
            case OPEN -> de.thb.craftsquad.service.ticket.jooq.enums.Status.open;
            case ASSIGNED -> de.thb.craftsquad.service.ticket.jooq.enums.Status.assign;
            case DONE -> de.thb.craftsquad.service.ticket.jooq.enums.Status.done;
        };
    }

    public static de.thb.craftsquad.service.ticket.jooq.enums.Tag mapTag(Tag tag) {
        return switch (tag) {
            case ELECTRICIAN -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.electrician;
        };
    }
}
