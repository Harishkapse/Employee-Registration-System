<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
   
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
   
   <h1 style="color:purple;text-align:center"> Search Data Dynamicaly</h1>
   <frm:form action="search" modelAttribute="emp">
   <table align="center" bgcolor="teal">
   <tr>
   <td>Emp Name</td>
   <td><frm:input path="ename"/></td>
   </tr>
   
    <tr>
   <td>Emp Job</td>
   <td><frm:input path="job"/></td>
   </tr>
   
    <tr>
   <td>Emp salary</td>
   <td><frm:input path="sal"/></td>
   </tr>
   
    <tr>
   <td>Emp DeptNo:</td>
   <td><frm:select path="deptno">
   <frm:option value="10">10</frm:option>
   <frm:option value="20">20</frm:option>
   <frm:option value="30">30</frm:option>
   </frm:select>
   </td>
   </tr>
   
    <tr>
   <td><input type="submit" value="search with data"></td>
   <td><input type="reset" value="cancel"> </td>
   </tr>
   </table>
   
   
   </frm:form>
   
 <hr><hr><br><br>  
   
   
   
 <c:choose>
 <c:when test="${!empty list}">
 <h1 style="color:green;text-align:center">Employee Report</h1>
 <table border="1" align="center" bgcolor="plum">
 <tr style="background-color:darkgray; color:white;">
 <th>EmpNO</th>
  <th>EmpName</th>
   <th>Job</th>
    <th>Salary</th>
     <th>DeptNO</th>
      <th>Operations</th>
 </tr>
 <c:forEach var="emp" items="${list}">
 <tr style="background-color:lightblue; color:blue;">
 <td>${emp.empno}</td>
  <td>${emp.ename}</td>
   <td>${emp.job}</td>
    <td>${emp.sal}</td>
     <td>${emp.deptno}</td>
     <td><a href="edit?no=${emp.empno}"><img src="images/edit.jpg" width="30px" height="40px"></a>
        <a href="delete?no=${emp.empno}" onclick="return confirm('DO you want to delete employee')"><img src="images/delete.jpg" width="30px" height="40px"></a>
     </td>
 </tr>
 </c:forEach>
 </table>
 </c:when>
 <c:otherwise>
 <h1 style="color:red;text-align:center">Employees Not Found</h1>
 </c:otherwise>
 </c:choose>
 <center>
 <h1 style="color:orange;text-align:center">${msg}</h1>
 <a href="add"><img src="images/add.png" width="70px" height="80px"></a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="./"><img src="images/home.jpg" width="70px" height="80px"></a>
 </center>