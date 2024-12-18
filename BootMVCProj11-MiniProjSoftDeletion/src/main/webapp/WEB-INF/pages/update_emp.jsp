<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
 
 <h1 style="color:red;text-align:center">Edit Employee</h1>
 <frm:form modelAttribute="emp">
 <table align="center" bgcolor="cyan">
 
 <tr>
 <td>Employee No</td>
 <td><frm:input path="empno" readonly="true"/></td>
 </tr>
 
 <tr>
 <td>Employee Name</td>
 <td><frm:input path="ename"/></td>
 </tr>
 
 <tr>
 <td>Job</td>
 <td><frm:input path="job"/></td>
 </tr>
 
 <tr>
 <td>Salary</td>
 <td><frm:input path="sal"/></td>
 </tr>
 
 <tr>
 <td>Dept No:</td>
 <td><frm:input path="deptno"/></td>
 </tr>
  
 
 <tr>
 <td><input type="submit" value="update"></td>
 <td><input type="reset" value="cancel"></td>
 </tr>
 </table>
 </frm:form>