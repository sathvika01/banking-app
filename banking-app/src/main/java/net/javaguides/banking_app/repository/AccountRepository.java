package net.javaguides.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //JpaRepository is a generic class which takes two parameters:
    // 1. The entity type (Account in this case)
    // 2. The primary key type (Long in this case)
    // This interface will automatically provide CRUD operations for the Account entity
    // JpaRepository provides methods like save, findById, findAll, deleteById, etc.
    // You can define custom query methods here if needed
    

}
