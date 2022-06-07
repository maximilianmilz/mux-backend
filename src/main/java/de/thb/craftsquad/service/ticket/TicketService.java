package de.thb.craftsquad.service.ticket;

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
}
