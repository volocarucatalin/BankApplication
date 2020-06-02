package controller;

import model.Statement;
import org.modelmapper.ModelMapper;
import service.StatementService;
import view.AccountDTO;
import view.StatementDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class StatementController {
    private StatementService statementService;
    private ModelMapper modelMapper;

    public StatementController(StatementService statementService, ModelMapper modelMapper) {
        this.statementService = statementService;
        this.modelMapper = modelMapper;
    }

    public List<StatementDTO> getStatementBySortCode(int sortCode){
        List<Statement> statements = statementService.getStatementBySortCode(sortCode);
            return   statements
                .stream()
                .map(account -> modelMapper.map(account, StatementDTO.class))
                .collect(Collectors.toList());
    }
}
