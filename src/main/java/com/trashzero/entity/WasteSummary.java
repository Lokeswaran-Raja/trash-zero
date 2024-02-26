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
@Table(name = "waste_summary")
public class WasteSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "gen_wet_waste")
    private Double genWetWaste;

    @Column(name = "gen_dry_waste")
    private Double genDryWaste;

    @Column(name = "gen_dir_rejects")
    private Double genDirRejects;

    @Column(name = "total_in_waste")
    private Double totalInWaste;


}
