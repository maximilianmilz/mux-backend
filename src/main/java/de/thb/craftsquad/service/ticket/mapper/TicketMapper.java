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
            case SANITARY -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.sanitary;
            case WOOD -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.wood;
            case METAL -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.metal;
            case ELECTRIC -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.electric;
            case MOVING -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.moving;
            case PAINTER -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.painter;
            case RENOVATION -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.renovation;
            case GARDENING -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.gardening;
            case MONTAGE -> de.thb.craftsquad.service.ticket.jooq.enums.Tag.montage;
        };
    }
}
