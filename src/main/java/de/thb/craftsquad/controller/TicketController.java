package de.thb.craftsquad.controller;

import de.thb.craftsquad.service.ticket.TicketService;
import de.thb.craftsquad.service.ticket.model.Ticket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/tickets/")
@RequiredArgsConstructor
public class TicketController extends BaseController {

    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> findAll(@RequestParam(required = false, name = "seek", defaultValue = DEFAULT_SEEK) Long seek,
                                @RequestParam(required = false, name = "size", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        return ticketService.findAll(seek, pageSize);
    }
}
