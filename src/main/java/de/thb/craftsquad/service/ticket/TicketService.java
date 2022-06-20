package de.thb.craftsquad.service.ticket;

import de.thb.craftsquad.controller.exception.ResourceNotFoundException;
import de.thb.craftsquad.service.ticket.model.Tag;
import de.thb.craftsquad.service.ticket.jooq.enums.Status;
import de.thb.craftsquad.service.ticket.jooq.tables.records.TicketRecord;
import de.thb.craftsquad.service.ticket.mapper.TicketMapper;
import de.thb.craftsquad.service.ticket.model.Ticket;
import de.thb.craftsquad.service.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    public List<Ticket> findAll(Optional<String> searchTerm, Optional<List<Tag>> tags,
                                Optional<de.thb.craftsquad.service.ticket.model.Status> status,
                                Optional<Long> accountId, Optional<Long> assignedTo) {
        return repository.findAll(searchTerm, tags, status, accountId, assignedTo)
                .stream()
                .map(TicketMapper::mapTicket)
                .toList();
    }

    public Optional<Ticket> findById(long id) {
        return repository.findById(id)
                .map(TicketMapper::mapTicket);
    }

    public Optional<Ticket> markTicketAsAssigned(Long id, Long assignedTo) {
        // TODO check if ticket status is open or assign
        repository.assignTo(id, assignedTo);

        return repository.updateStatus(id, Status.assign)
                .map(TicketMapper::mapTicket);
    }

    public Optional<Ticket> markTicketAsDone(Long id) {
        return repository.updateStatus(id, Status.done)
                .map(TicketMapper::mapTicket);
    }

    public Optional<Ticket> delete(long id) {
        return repository.delete(id)
                .map(TicketMapper::mapTicket);
    }

    public Optional<Ticket> update(Long id, String title, String description) {
        var record = repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        record.setTitle(title);
        record.setDescription(description);

        // TODO tags and images

        return repository.update(id, record)
                .map(TicketMapper::mapTicket);
    }

    public Ticket create(long accountId, Ticket ticket) {
        TicketRecord record = new TicketRecord();

        record.setTitle(ticket.getTitle());
        record.setDescription(ticket.getDescription());
        record.setCreated(LocalDateTime.now());
        record.setStatus(Status.open);
        record.setAccountId(accountId);

        return TicketMapper.mapTicket(repository.create(record));
    }

    public List<Ticket> findTicketsOfAccount(long accountId) {
        return repository.findTicketsOfAccount(accountId)
                .stream()
                .map(TicketMapper::mapTicket)
                .toList();
    }

    public List<Ticket> findProjectsOfAccount(long accountId) {
        return repository.findProjectsOfUser(accountId)
                .stream()
                .map(TicketMapper::mapTicket)
                .toList();
    }
}
