package com.trashzero.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wasteSummary")
public class WasteSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "gen_wetWaste")
    private Double genWetWaste;

    @Column(name = "gen_DryWaste")
    private Double genDryWaste;

    @Column(name = "gen_DirRejects")
    private Double genDirRejects;

    @Column(name = "total_InWaste")
    private Double totalInWaste;


}
