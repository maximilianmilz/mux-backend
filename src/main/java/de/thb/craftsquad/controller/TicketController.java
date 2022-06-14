package de.thb.craftsquad.controller;

import de.thb.craftsquad.controller.exception.ResourceNotFoundException;
import de.thb.craftsquad.service.ticket.TicketService;
import de.thb.craftsquad.service.ticket.model.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/tickets/")
@RequiredArgsConstructor
public class TicketController extends BaseController {

    private final TicketService ticketService;

    @Operation(summary = "Find all tickets.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
    })
    @GetMapping
    public List<Ticket> findAll(@RequestParam(required = false, name = "seek", defaultValue = DEFAULT_SEEK) Long seek,
                                @RequestParam(required = false, name = "size", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
        return ticketService.findAll(seek, pageSize);
    }

    @Operation(summary = "Update ticket.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Ticket not found.", content = @Content)
    })
    @PutMapping("/{id}")
    public Ticket update(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam String description) {
        return ticketService.update(id, title, description)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(summary = "Delete ticket.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Ticket not found.", content = @Content)
    })
    @DeleteMapping("/{id}")
    public Ticket delete(@PathVariable Long id) {
        return ticketService.delete(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(summary = "Find ticket by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Ticket not found.", content = @Content)
    })
    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return ticketService.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(summary = "Mark ticket as assigned.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Ticket not found.", content = @Content)
    })
    @PatchMapping("/{id}/assign")
    public Ticket markTicketAsAssigned(@PathVariable Long id,
                                       @RequestParam(required = false) Long assignedTo) {
        return ticketService.markTicketAsAssigned(id, assignedTo)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(summary = "Mark ticket as done.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Ticket not found.", content = @Content)
    })
    @PatchMapping("/{id}/done")
    public Ticket markTicketAsDone(@PathVariable Long id) {
        return ticketService.markTicketAsDone(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Operation(summary = "Create ticket.")
    @ApiResponses({
            @ApiResponse(responseCode = "200")
    })
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        // TODO get account from userAgent
        long accountId = 1L;

        return ticketService.create(accountId, ticket);
    }
}
