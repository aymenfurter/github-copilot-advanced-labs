package com.example.insurance.controller;

import com.example.insurance.dao.MotorPolicyDAO;
import com.example.insurance.model.MotorPolicy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MotorPolicyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MotorPolicyDAO motorPolicyDAO;

    @InjectMocks
    private MotorPolicyController motorPolicyController;

    private SimpleDateFormat dateFormat;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(motorPolicyController).build();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Test
    public void listPolicies_ShouldReturnAllPolicies() throws Exception {
        // Given
        MotorPolicy policy1 = createSamplePolicy(1L);
        MotorPolicy policy2 = createSamplePolicy(2L);
        when(motorPolicyDAO.findAll()).thenReturn(Arrays.asList(policy1, policy2));

        // When & Then
        mockMvc.perform(get("/policies"))
               .andExpect(status().isOk())
               .andExpect(view().name("policy/list"))
               .andExpect(model().attributeExists("policies"));

        verify(motorPolicyDAO).findAll();
    }

    @Test
    public void newPolicyForm_ShouldReturnFormView() throws Exception {
        mockMvc.perform(get("/policies/new"))
               .andExpect(status().isOk())
               .andExpect(view().name("policy/form"))
               .andExpect(model().attributeExists("policy"));
    }

    @Test
    public void savePolicy_WhenNewPolicy_ShouldSaveAndRedirect() throws Exception {
        // When & Then
        mockMvc.perform(post("/policies")
               .param("policyNumber", "POL-001")
               .param("customerName", "John Doe")
               .param("vehicleNumber", "ABC-123")
               .param("vehicleModel", "Toyota Camry")
               .param("manufacturingYear", "2020")
               .param("insuranceAmount", "50000.00")
               .param("startDate", "2023-01-01")
               .param("endDate", "2024-01-01")
               .param("status", "ACTIVE"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/policies"));

        verify(motorPolicyDAO).save(any(MotorPolicy.class));
    }

    @Test
    public void updatePolicy_ShouldUpdateAndRedirect() throws Exception {
        // When & Then
        mockMvc.perform(post("/policies")
               .param("id", "1")
               .param("policyNumber", "POL-001")
               .param("customerName", "John Doe")
               .param("vehicleNumber", "ABC-123")
               .param("vehicleModel", "Toyota Camry")
               .param("manufacturingYear", "2020")
               .param("insuranceAmount", "50000.00")
               .param("startDate", "2023-01-01")
               .param("endDate", "2024-01-01")
               .param("status", "ACTIVE"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/policies"));

        verify(motorPolicyDAO).update(any(MotorPolicy.class));
    }

    @Test
    public void editPolicy_ShouldReturnFormWithExistingPolicy() throws Exception {
        // Given
        Long policyId = 1L;
        MotorPolicy policy = createSamplePolicy(policyId);
        when(motorPolicyDAO.findById(policyId)).thenReturn(policy);

        // When & Then
        mockMvc.perform(get("/policies/{id}/edit", policyId))
               .andExpect(status().isOk())
               .andExpect(view().name("policy/form"))
               .andExpect(model().attributeExists("policy"));

        verify(motorPolicyDAO).findById(policyId);
    }

    @Test
    public void deletePolicy_ShouldDeleteAndRedirect() throws Exception {
        // Given
        Long policyId = 1L;

        // When & Then
        mockMvc.perform(get("/policies/{id}/delete", policyId))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/policies"));

        verify(motorPolicyDAO).delete(policyId);
    }

    private MotorPolicy createSamplePolicy(Long id) {
        MotorPolicy policy = new MotorPolicy();
        policy.setId(id);
        policy.setPolicyNumber("POL-" + String.format("%03d", id));
        policy.setCustomerName("John Doe");
        policy.setVehicleNumber("ABC-123");
        policy.setVehicleModel("Toyota Camry");
        policy.setManufacturingYear(2020);
        policy.setInsuranceAmount(new BigDecimal("50000.00"));
        try {
            policy.setStartDate(dateFormat.parse("2023-01-01"));
            policy.setEndDate(dateFormat.parse("2024-01-01"));
        } catch (Exception e) {
            // Handle parse exception
        }
        policy.setStatus("ACTIVE");
        return policy;
    }
}