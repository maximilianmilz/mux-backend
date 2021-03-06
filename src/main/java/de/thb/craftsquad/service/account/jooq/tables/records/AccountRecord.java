/*
 * This file is generated by jOOQ.
 */
package de.thb.craftsquad.service.account.jooq.tables.records;


import de.thb.craftsquad.service.account.jooq.tables.Account;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record9<Long, String, String, String, String, String, Boolean, LocalDateTime, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>account.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>account.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>account.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>account.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>account.password</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>account.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>account.firstname</code>.
     */
    public void setFirstname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>account.firstname</code>.
     */
    public String getFirstname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>account.lastname</code>.
     */
    public void setLastname(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>account.lastname</code>.
     */
    public String getLastname() {
        return (String) get(4);
    }

    /**
     * Setter for <code>account.description</code>.
     */
    public void setDescription(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>account.description</code>.
     */
    public String getDescription() {
        return (String) get(5);
    }

    /**
     * Setter for <code>account.verified</code>.
     */
    public void setVerified(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>account.verified</code>.
     */
    public Boolean getVerified() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>account.created</code>.
     */
    public void setCreated(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>account.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>account.image_id</code>.
     */
    public void setImageId(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>account.image_id</code>.
     */
    public Long getImageId() {
        return (Long) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, String, String, Boolean, LocalDateTime, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, String, String, Boolean, LocalDateTime, Long> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Account.ACCOUNT.ID;
    }

    @Override
    public Field<String> field2() {
        return Account.ACCOUNT.EMAIL;
    }

    @Override
    public Field<String> field3() {
        return Account.ACCOUNT.PASSWORD;
    }

    @Override
    public Field<String> field4() {
        return Account.ACCOUNT.FIRSTNAME;
    }

    @Override
    public Field<String> field5() {
        return Account.ACCOUNT.LASTNAME;
    }

    @Override
    public Field<String> field6() {
        return Account.ACCOUNT.DESCRIPTION;
    }

    @Override
    public Field<Boolean> field7() {
        return Account.ACCOUNT.VERIFIED;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return Account.ACCOUNT.CREATED;
    }

    @Override
    public Field<Long> field9() {
        return Account.ACCOUNT.IMAGE_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public String component4() {
        return getFirstname();
    }

    @Override
    public String component5() {
        return getLastname();
    }

    @Override
    public String component6() {
        return getDescription();
    }

    @Override
    public Boolean component7() {
        return getVerified();
    }

    @Override
    public LocalDateTime component8() {
        return getCreated();
    }

    @Override
    public Long component9() {
        return getImageId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public String value4() {
        return getFirstname();
    }

    @Override
    public String value5() {
        return getLastname();
    }

    @Override
    public String value6() {
        return getDescription();
    }

    @Override
    public Boolean value7() {
        return getVerified();
    }

    @Override
    public LocalDateTime value8() {
        return getCreated();
    }

    @Override
    public Long value9() {
        return getImageId();
    }

    @Override
    public AccountRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public AccountRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AccountRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public AccountRecord value4(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public AccountRecord value5(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public AccountRecord value6(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public AccountRecord value7(Boolean value) {
        setVerified(value);
        return this;
    }

    @Override
    public AccountRecord value8(LocalDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public AccountRecord value9(Long value) {
        setImageId(value);
        return this;
    }

    @Override
    public AccountRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Boolean value7, LocalDateTime value8, Long value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Long id, String email, String password, String firstname, String lastname, String description, Boolean verified, LocalDateTime created, Long imageId) {
        super(Account.ACCOUNT);

        setId(id);
        setEmail(email);
        setPassword(password);
        setFirstname(firstname);
        setLastname(lastname);
        setDescription(description);
        setVerified(verified);
        setCreated(created);
        setImageId(imageId);
    }
}
