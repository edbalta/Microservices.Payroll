package com.BilgeAdam.Microservices.Payroll.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name="Payrolls")
public class Payroll {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long Id;
    private int Year;
    private int Month;
}
