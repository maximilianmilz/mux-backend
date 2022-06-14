package de.thb.craftsquad.service.account.mapper;

import de.thb.craftsquad.service.account.jooq.tables.records.AccountRecord;
import de.thb.craftsquad.service.account.model.Account;

import java.time.ZoneId;

public class AccountMapper {

    public static Account map(AccountRecord record) {
        return Account.builder()
                .id(record.getId())
                .created(record.getCreated().atZone(ZoneId.systemDefault()))
                .description(record.getDescription())
                .firstname(record.getFirstname())
                .lastname(record.getLastname())
                .email(record.getEmail())
                .imageId(record.getImageId())
                .verified(record.getVerified())
                .build();
    }
}
