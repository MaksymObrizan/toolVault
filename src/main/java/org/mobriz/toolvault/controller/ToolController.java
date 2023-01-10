package org.mobriz.toolvault.controller;

import org.mobriz.toolvault.model.Tool;
import org.mobriz.toolvault.model.ToolType;
import org.mobriz.toolvault.model.WorkingArea;
import org.mobriz.toolvault.service.ToolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/tool-vault")
public class ToolController {

    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public Mono<Tool> create() throws NoSuchAlgorithmException {
        System.out.println("Controller create");
        Tool tool = Tool.builder().build();
        tool.setMachineName("some machine name");
        tool.setType(ToolType.PRINTER_SLA);
        tool.setPricePerWorkingUnit(SecureRandom.getInstanceStrong().nextFloat());
        tool.setWorkingArea(WorkingArea.builder()
                .x_plane(SecureRandom.getInstanceStrong().nextFloat())
                .y_plane(SecureRandom.getInstanceStrong().nextFloat())
                .z_plane(SecureRandom.getInstanceStrong().nextFloat())
                .build());
        return Mono.just(toolService.createTool(tool));
    }

    @GetMapping
    public Flux<Tool> findAll() {
        System.out.println("Controller findAll");
        return Flux.fromIterable(toolService.findAll());
    }

    @GetMapping("/tool-type")
    public List<ToolType> getToolTypeList() {
        System.out.println("Controller getToolTypeList");
        return toolService.getToolTypeList();
    }
}
