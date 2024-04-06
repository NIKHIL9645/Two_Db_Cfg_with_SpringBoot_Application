package com.Twdbs.accountdb.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    private String website;



}
