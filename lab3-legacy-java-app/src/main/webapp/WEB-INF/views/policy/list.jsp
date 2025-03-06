<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Motor Insurance Policies</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .button { padding: 5px 10px; text-decoration: none; background-color: #4CAF50; color: white; border-radius: 3px; }
        .delete { background-color: #f44336; }
    </style>
</head>
<body>
    <h2>Motor Insurance Policies</h2>
    <p><a href="<c:url value='/policies/new'/>" class="button">New Policy</a></p>
    
    <table>
        <thead>
            <tr>
                <th>Policy Number</th>
                <th>Customer Name</th>
                <th>Vehicle Number</th>
                <th>Vehicle Model</th>
                <th>Insurance Amount</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${policies}" var="policy">
                <tr>
                    <td>${policy.policyNumber}</td>
                    <td>${policy.customerName}</td>
                    <td>${policy.vehicleNumber}</td>
                    <td>${policy.vehicleModel}</td>
                    <td>${policy.insuranceAmount}</td>
                    <td><fmt:formatDate value="${policy.startDate}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${policy.endDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${policy.status}</td>
                    <td>
                        <a href="<c:url value='/policies/${policy.id}/edit'/>" class="button">Edit</a>
                        <a href="<c:url value='/policies/${policy.id}/delete'/>" class="button delete" 
                           onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>