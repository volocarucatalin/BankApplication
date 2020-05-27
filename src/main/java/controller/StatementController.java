package controller;

import model.Statement;
import service.StatementService;

import java.sql.SQLException;
import java.util.List;

public class StatementController {
    private StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }
    public List<Statement> getStatementBySortCode(int sortCode) throws SQLException {
        try {
            return   statementService.getStatementBySortCode(sortCode);
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }

    }
}
