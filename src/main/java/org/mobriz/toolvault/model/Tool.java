package org.mobriz.toolvault.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tool {

    private Long id;
    private String machineName;
    private ToolType type;
    private WorkingArea workingArea;
    private Float pricePerWorkingUnit;
}

