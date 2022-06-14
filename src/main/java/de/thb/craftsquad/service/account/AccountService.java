package de.thb.craftsquad.service.account;

import de.thb.craftsquad.service.account.mapper.AccountMapper;
import de.thb.craftsquad.service.account.model.Account;
import de.thb.craftsquad.service.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public List<Account> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountMapper::map)
                .toList();
    }

    public Optional<Account> findById(long id) {
        return repository.findById(id)
                .map(AccountMapper::map);
    }
}
