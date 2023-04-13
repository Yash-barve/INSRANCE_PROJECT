<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
     integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Document</title>
   <style>
    body {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	background-color: white;
	font-family: "lato", sans-serif;
         }
         h1{
         text-align:center !important;
         color:gold;
         }
         input{
         padding:10px;
         width:100%;
         border-radius:7px;
         border:.1px solid lightgrey;
         outline:none;
         font-weight:500;
         }
    </style>
</head>
<body>
<div class="container">
 <h1 class="p-2 text-uppercase border border-primary bg-dark">Insurance report application</h1>
         <form:form action="search" modelAttribute="search" method="POST" class="py-4 px-2 bg-light text-emphasis-warning" >
         <div class="row g-3">
                   <div class="col-sm-4">
                 Plan Name <form:select path="planName" class="form-select form-select-lg">
                 <form:option value="">--select--</form:option>
                 <form:options items="${pname}"/>
                 </form:select>
                 </div>
                 <div class="col-sm-4">
                 Plan Status <form:select path="planStatus" class="form-select form-select-lg">
                 <form:option value="">--select--</form:option>
                 <form:options items="${pstatus}"/>
                 </form:select>
                 </div>
                  <div class="col-sm-4">
                                  Gender <form:select path="gender" class="form-select form-select-lg">
                                  <form:option value="">--select--</form:option>
                                  <form:option value="Male">Male</form:option>
                                  <form:option value="Female">Female</form:option>
                                  </form:select>
                   </div>
                   <div class='col-md-6'>
                         Plan Start Date<form:input type="date" class="form control date" path="planStartDate"
                         pattern="(?:19|20)\[0-9\]{2}-(?:(?:0\[1-9\]|1\[0-2\])-(?:0\[1-9\]|1\[0-9\]|2\[0-9\])|(?:(?!02)(?:0\[1-9\]|1\[0-2\])-(?:30))|(?:(?:0\[13578\]|1\[02\])-31))"
                         />
                      </div>
                      <div class='col-md-6'>
                         Plan End Date<form:input type="date" class="" path="planEndDate"
                         pattern="(?:19|20)\[0-9\]{2}-(?:(?:0\[1-9\]|1\[0-2\])-(?:0\[1-9\]|1\[0-9\]|2\[0-9\])|(?:(?!02)(?:0\[1-9\]|1\[0-2\])-(?:30))|(?:(?:0\[13578\]|1\[02\])-31))"
                         />
                      </div>
                  </div>
                  <div class="d-flex pt-3">
                 <input type="submit" value="SEARCH" class="btn btn-primary" />
                 <input type="reset" value="CLEAR" class="btn btn-danger " />
                 </div>
             </form:form>
             <hr/>
            <div class="">
            <table class="table  table-hover">
              <thead>
                <tr>
                  <th scope="col">No.</th>
                  <th scope="col">Name</th>
                  <th scope="col">gender</th>
                  <th scope="col">Plan Name</th>
                  <th scope="col">Plan Status</th>
                  <th scope="col">Start Date</th>
                  <th scope="col">End Date</th>
                  <th scope="col">BenefitAmt</th>
                  <th scope="col">denialReason</th>
                  <th scope="col">terminatedDate</th>
                  <th scope="col">terminationRsn</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${plans}" var="plan" varStatus="index">
                <tr>
                <td>${index.count}</td>
                <td>${plan.citizenName}</td>
                <td>${plan.gender}</td>
                <td>${plan.planName}</td>
                <td>${plan.planStatus}</td>
                <td>${plan.planStartDate}</td>
                <td>${plan.planEndDate}</td>
                <td>${plan.benefitAmt}</td>
                <td>${plan.denialReason}</td>
                <td>${plan.terminatedDate}</td>
                <td>${plan.terminationRsn}</td>
                </tr>
                </c:forEach>
                <tr>
                <td colspan="11" style="text-align:center">
                <c:if test="${empty plans}">
                <p class="text-danger fs-3 fw-bolder mt-2">NO RECORDS HERE</p>
                </c:if>
                </td>
                </tr>
              </tbody>
            </table>
            </div>
             <div class="d-flex justify-content-evenly align-items-center">
             <a href="excel" class="btn text-white btn-dark">EXCEL</a>
             <a href="pdf" class="btn text-white btn-dark">PDF</a>
             </div>
         </div>





     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>