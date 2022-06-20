package de.thb.craftsquad.controller;

import de.thb.craftsquad.service.account.AccountService;
import de.thb.craftsquad.service.account.model.Account;
import de.thb.craftsquad.service.ticket.TicketService;
import de.thb.craftsquad.service.ticket.model.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final TicketService ticketService;

    @Operation(summary = "Find all accounts.")
    @ApiResponses({
            @ApiResponse(responseCode = "200")
    })
    @GetMapping
    public List<Account> findAll() {
        return List.of();
    }

    @Operation(summary = "Find account.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Account not found.", content = @Content)
    })
    @GetMapping("/{id}")
    public Account findById(@PathVariable String id) {
        return Account.builder().build();
    }

    @Operation(summary = "Find projects of account.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Account not found.", content = @Content)
    })
    @GetMapping("/{id}/projects")
    public List<Ticket> findProjectsOfAccount(@PathVariable("id") Long accountId) {
        return ticketService.findProjectsOfAccount(accountId);
    }

    @Operation(summary = "Find tickets of account.")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Account not found.", content = @Content)
    })
    @GetMapping("/{id}/tickets")
    public List<Ticket> findTicketsOfAccount(@PathVariable("id") Long accountId) {
        return ticketService.findTicketsOfAccount(accountId);
    }
}
