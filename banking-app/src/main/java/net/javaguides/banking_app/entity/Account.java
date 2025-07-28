package net.javaguides.banking_app.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // This annotation marks the class as a JPA entity
@Table(name = "accounts") // This annotation specifies the table name in the database
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    @Id // This annotation specifies the primary key of the entity
    @GeneratedValue // This annotation indicates that the value of the primary key will be generated automatically
    private Long id;

    @Column(name = "account_holder_name") // This annotation specifies the column name in the database
    private String accountHolderName;
    private double balance;


}
