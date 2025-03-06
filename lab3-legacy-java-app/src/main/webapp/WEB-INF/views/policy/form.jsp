<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Motor Insurance Policy Form</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], input[type="number"], input[type="date"] { 
            width: 300px; 
            padding: 5px;
            margin-bottom: 10px;
        }
        .button { 
            padding: 8px 15px; 
            background-color: #4CAF50; 
            color: white; 
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .cancel { 
            background-color: #f44336;
            text-decoration: none;
            display: inline-block;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <h2>${policy.id == null ? 'New' : 'Edit'} Motor Insurance Policy</h2>
    
    <form action="<c:url value='/policies'/>" method="post">
        <input type="hidden" name="id" value="${policy.id}"/>
        
        <div class="form-group">
            <label for="policyNumber">Policy Number:</label>
            <input type="text" id="policyNumber" name="policyNumber" value="${policy.policyNumber}" required/>
        </div>
        
        <div class="form-group">
            <label for="customerName">Customer Name:</label>
            <input type="text" id="customerName" name="customerName" value="${policy.customerName}" required/>
        </div>
        
        <div class="form-group">
            <label for="vehicleNumber">Vehicle Number:</label>
            <input type="text" id="vehicleNumber" name="vehicleNumber" value="${policy.vehicleNumber}" required/>
        </div>
        
        <div class="form-group">
            <label for="vehicleModel">Vehicle Model:</label>
            <input type="text" id="vehicleModel" name="vehicleModel" value="${policy.vehicleModel}" required/>
        </div>
        
        <div class="form-group">
            <label for="manufacturingYear">Manufacturing Year:</label>
            <input type="number" id="manufacturingYear" name="manufacturingYear" value="${policy.manufacturingYear}" required/>
        </div>
        
        <div class="form-group">
            <label for="insuranceAmount">Insurance Amount:</label>
            <input type="number" id="insuranceAmount" name="insuranceAmount" step="0.01" value="${policy.insuranceAmount}" required/>
        </div>
        
        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" 
                   value="<fmt:formatDate value="${policy.startDate}" pattern="yyyy-MM-dd"/>" required/>
        </div>
        
        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" 
                   value="<fmt:formatDate value="${policy.endDate}" pattern="yyyy-MM-dd"/>" required/>
        </div>
        
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="ACTIVE" ${policy.status == 'ACTIVE' ? 'selected' : ''}>Active</option>
                <option value="PENDING" ${policy.status == 'PENDING' ? 'selected' : ''}>Pending</option>
                <option value="EXPIRED" ${policy.status == 'EXPIRED' ? 'selected' : ''}>Expired</option>
                <option value="CANCELLED" ${policy.status == 'CANCELLED' ? 'selected' : ''}>Cancelled</option>
            </select>
        </div>
        
        <div class="form-group">
            <button type="submit" class="button">Save Policy</button>
            <a href="<c:url value='/policies'/>" class="button cancel">Cancel</a>
        </div>
    </form>
</body>
</html>