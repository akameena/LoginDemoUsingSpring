<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
  <%@ page isELIgnored="false" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
  


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<table class="table table-striped " id="example">
	  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">Name</th>
	      <th scope="col">Roll No</th>
	    </tr>
	  </thead>
	  <tbody>
	  		<c:forEach var="dummy" items="${list}">  
			<tr>
			<td> ${dummy.id} </td>
			<td> ${dummy.name} </td>
			<td> ${dummy.rollno}</td>
			</tr>
		
			</c:forEach>
	  </tbody>
	 </table>
	
	<!-- <a href="/Login_Demo/dummy/1">1</a>
	<a href="/Login_Demo/dummy/2">2</a>
	<a href="/Login_Demo/dummy/3">3</a>
	<a href="/Login_Demo/dummy/4">4</a>
	<a href="/Login_Demo/dummy/5">5</a>
	<a href="/Login_Demo/dummy/6">6</a>
	<a href="/Login_Demo/dummy/7">7</a>
	<a href="/Login_Demo/dummy/8">8</a>
	<a href="/Login_Demo/dummy/9">9</a>
	<a href="/Login_Demo/dummy/10">10</a> -->
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>


	<script type="text/javascript">
		var count=0;
		function Count1(){
			
			}
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#example').DataTable({
	    	pagingType: 'full',
	        language: {
	            paginate: {
	                first:    '«',
	                previous: '‹',
	                next:     '›',
	                last:     '»'
	            },
	            aria: {
	                paginate: {
	                    first:    'First',
	                    previous: 'Previous',
	                    next:     'Next',
	                    last:     'Last'
	                }
	            }
	        }
		    });
	    
	     $("#example_last").click(function(){
			//alert("hello")
			var url=window.location.href;
			var start=url.lastIndexOf("/");
			var no = url.slice(start+1,url.length);
			//alert(url1);
			
			no = parseInt(no)+parseInt(1);
			window.location.replace("/Login_Demo/dummy/"+no);
		    });

		    
			
			
	$("#example_first").click(function(){
		//alert("hello")
		var url=window.location.href;
		var start=url.lastIndexOf("/");
		var no = url.slice(start+1,url.length);
		//alert(url1);
		if(no>1){
		no = parseInt(no)-parseInt(1);
		window.location.replace("/Login_Demo/dummy/"+no);}
	    });

	    
		});
	</script>
	
</body>


</html>
