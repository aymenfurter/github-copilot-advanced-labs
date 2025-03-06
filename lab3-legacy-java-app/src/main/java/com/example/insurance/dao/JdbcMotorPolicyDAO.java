package com.example.insurance.dao;

import com.example.insurance.model.MotorPolicy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMotorPolicyDAO implements MotorPolicyDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public JdbcMotorPolicyDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS motor_policies (" +
            "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
            "policy_number VARCHAR(50) UNIQUE," +
            "customer_name VARCHAR(100)," +
            "vehicle_number VARCHAR(20)," +
            "vehicle_model VARCHAR(100)," +
            "manufacturing_year INT," +
            "insurance_amount DECIMAL(10,2)," +
            "start_date DATE," +
            "end_date DATE," +
            "status VARCHAR(20))");
    }

    @Override
    public void save(MotorPolicy policy) {
        jdbcTemplate.update(
            "INSERT INTO motor_policies (policy_number, customer_name, vehicle_number, vehicle_model, " +
            "manufacturing_year, insurance_amount, start_date, end_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            policy.getPolicyNumber(), policy.getCustomerName(), policy.getVehicleNumber(),
            policy.getVehicleModel(), policy.getManufacturingYear(), policy.getInsuranceAmount(),
            policy.getStartDate(), policy.getEndDate(), policy.getStatus()
        );
    }

    @Override
    public MotorPolicy findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM motor_policies WHERE id = ?",
            new Object[]{id},
            new MotorPolicyRowMapper()
        );
    }

    @Override
    public List<MotorPolicy> findAll() {
        return jdbcTemplate.query(
            "SELECT * FROM motor_policies",
            new MotorPolicyRowMapper()
        );
    }

    @Override
    public void update(MotorPolicy policy) {
        jdbcTemplate.update(
            "UPDATE motor_policies SET policy_number=?, customer_name=?, vehicle_number=?, " +
            "vehicle_model=?, manufacturing_year=?, insurance_amount=?, start_date=?, end_date=?, status=? WHERE id=?",
            policy.getPolicyNumber(), policy.getCustomerName(), policy.getVehicleNumber(),
            policy.getVehicleModel(), policy.getManufacturingYear(), policy.getInsuranceAmount(),
            policy.getStartDate(), policy.getEndDate(), policy.getStatus(), policy.getId()
        );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM motor_policies WHERE id = ?", id);
    }

    @Override
    public MotorPolicy findByPolicyNumber(String policyNumber) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM motor_policies WHERE policy_number = ?",
            new Object[]{policyNumber},
            new MotorPolicyRowMapper()
        );
    }

    private static class MotorPolicyRowMapper implements RowMapper<MotorPolicy> {
        @Override
        public MotorPolicy mapRow(ResultSet rs, int rowNum) throws SQLException {
            MotorPolicy policy = new MotorPolicy();
            policy.setId(rs.getLong("id"));
            policy.setPolicyNumber(rs.getString("policy_number"));
            policy.setCustomerName(rs.getString("customer_name"));
            policy.setVehicleNumber(rs.getString("vehicle_number"));
            policy.setVehicleModel(rs.getString("vehicle_model"));
            policy.setManufacturingYear(rs.getInt("manufacturing_year"));
            policy.setInsuranceAmount(rs.getBigDecimal("insurance_amount"));
            policy.setStartDate(rs.getDate("start_date"));
            policy.setEndDate(rs.getDate("end_date"));
            policy.setStatus(rs.getString("status"));
            return policy;
        }
    }
}