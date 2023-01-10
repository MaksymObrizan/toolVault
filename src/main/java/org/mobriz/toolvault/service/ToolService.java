package org.mobriz.toolvault.service;

import lombok.extern.slf4j.Slf4j;
import org.mobriz.toolvault.model.Tool;
import org.mobriz.toolvault.model.ToolType;
import org.mobriz.toolvault.repository.ToolPostgresRepository;
import org.mobriz.toolvault.util.ToolConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ToolService {

    private final ToolPostgresRepository repository;

    @Autowired
    public ToolService(ToolPostgresRepository repository) {
        this.repository = repository;
    }

    public Tool createTool(Tool tool) {
        System.out.println("create tool");
        return ToolConverter.convertToModel(repository.save(ToolConverter.convertToDTO(tool)));
    }

    public Iterable<Tool> findAll() {
        return repository.findAll().stream()
                .map(ToolConverter::convertToModel)
                .collect(Collectors.toList());
    }

    public List<ToolType> getToolTypeList() {
        return List.of(ToolType.values());
    }
}
