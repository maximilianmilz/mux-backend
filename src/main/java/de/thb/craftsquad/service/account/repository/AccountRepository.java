package de.thb.craftsquad.service.account.repository;

import de.thb.craftsquad.service.account.jooq.tables.records.AccountRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static de.thb.craftsquad.service.account.jooq.tables.Account.ACCOUNT;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final DSLContext context;

    public List<AccountRecord> findAll() {
        return context.selectFrom(ACCOUNT)
                .orderBy(ACCOUNT.ID.asc())
                .fetch();
    }

    public Optional<AccountRecord> findById(long id) {
        return context.selectFrom(ACCOUNT)
                .where(ACCOUNT.ID.eq(id))
                .fetchOptional();
    }
}
