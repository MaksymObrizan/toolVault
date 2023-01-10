package org.mobriz.toolvault.repository;

import org.mobriz.toolvault.model.Tool;
import org.mobriz.toolvault.model.dto.ToolDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolPostgresRepository extends JpaRepository<ToolDTO, String> {
}
