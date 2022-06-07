package de.thb.craftsquad.service.ticket;

import de.thb.craftsquad.controller.exception.ResourceNotFoundException;
import de.thb.craftsquad.service.ticket.jooq.enums.Status;
import de.thb.craftsquad.service.ticket.mapper.TicketMapper;
import de.thb.craftsquad.service.ticket.model.Ticket;
import de.thb.craftsquad.service.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    public List<Ticket> findAll(long seek, int limit) {
        return repository.findAll(seek, limit)
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
}
