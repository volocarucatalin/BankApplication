package service;

import model.Statement;
import repository.StatementRepository;

import java.sql.SQLException;
import java.util.List;

public class StatementService {
    private StatementRepository statementRepository;

    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    public List<Statement> getStatementBySortCode(int sortCode) {
        try {
            return statementRepository.getStatement(sortCode);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
