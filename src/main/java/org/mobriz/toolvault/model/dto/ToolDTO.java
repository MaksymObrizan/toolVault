package org.mobriz.toolvault.model.dto;

import lombok.Builder;
import lombok.Data;
import org.mobriz.toolvault.model.ToolType;

import javax.persistence.*;

@Entity
@Table(name = "Tool")
//@Builder
@Data

public class ToolDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "machine_name")
    private String machineName;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ToolType type;

    @Column(name = "working_plane_x")
    private Float x_plane;

    @Column(name = "working_plane_y")
    private Float y_plane;

    @Column(name = "working_plane_z")
    private Float z_plane;

    @Column(name = "price_per_unit")
    private Float pricePerWorkingUnit;
}
