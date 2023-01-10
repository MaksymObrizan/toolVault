package org.mobriz.toolvault.util;

import org.mobriz.toolvault.model.Tool;
import org.mobriz.toolvault.model.WorkingArea;
import org.mobriz.toolvault.model.dto.ToolDTO;

public class ToolConverter {

    public static Tool convertToModel(ToolDTO toolDTO) {
        return Tool.builder()
                .id(toolDTO.getId())
                .machineName(toolDTO.getMachineName())
                .type(toolDTO.getType())
                .workingArea(WorkingArea.builder()
                        .x_plane(toolDTO.getX_plane())
                        .y_plane(toolDTO.getY_plane())
                        .z_plane(toolDTO.getZ_plane())
                        .build())
                .pricePerWorkingUnit(toolDTO.getPricePerWorkingUnit())
                .build();
    }

    public static ToolDTO convertToDTO(Tool tool) {
        ToolDTO toolDTO = new ToolDTO();
        toolDTO.setId(tool.getId());
        toolDTO.setMachineName(tool.getMachineName());
        toolDTO.setType(tool.getType());
        if (tool.getWorkingArea() != null) {
            toolDTO.setX_plane(tool.getWorkingArea().getX_plane());
            toolDTO.setY_plane(tool.getWorkingArea().getY_plane());
            toolDTO.setZ_plane(tool.getWorkingArea().getZ_plane());
        }
        toolDTO.setPricePerWorkingUnit(tool.getPricePerWorkingUnit());
        return toolDTO;
    }
}
