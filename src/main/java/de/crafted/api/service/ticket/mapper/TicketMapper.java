package de.crafted.api.service.ticket.mapper;

import de.crafted.api.service.ticket.jooq.enums.Tag;
import de.crafted.api.service.ticket.jooq.tables.records.TicketRecord;
import de.crafted.api.service.ticket.model.Status;
import de.crafted.api.service.ticket.model.Ticket;

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

    public static Status mapStatus(de.crafted.api.service.ticket.jooq.enums.Status status) {
        return switch (status) {
            case open -> Status.OPEN;
            case assign -> Status.ASSIGNED;
            case done -> Status.DONE;
        };
    }

    public static de.crafted.api.service.ticket.jooq.enums.Status mapStatus(Status status) {
        return switch (status) {
            case OPEN -> de.crafted.api.service.ticket.jooq.enums.Status.open;
            case ASSIGNED -> de.crafted.api.service.ticket.jooq.enums.Status.assign;
            case DONE -> de.crafted.api.service.ticket.jooq.enums.Status.done;
        };
    }

    public static Tag mapTag(de.crafted.api.service.ticket.model.Tag tag) {
        return switch (tag) {
            case SANITARY -> Tag.sanitary;
            case WOOD -> Tag.wood;
            case METAL -> Tag.metal;
            case ELECTRIC -> Tag.electric;
            case MOVING -> Tag.moving;
            case PAINTER -> Tag.painter;
            case RENOVATION -> Tag.renovation;
            case GARDENING -> Tag.gardening;
            case MONTAGE -> Tag.montage;
        };
    }
}
