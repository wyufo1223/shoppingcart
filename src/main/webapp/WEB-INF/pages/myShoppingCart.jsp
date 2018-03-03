<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My shopping cart</title>
	
	<%@include file="../../static/js/common/common.jsp"%>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${jsPath }/bootstrap-4.0.0/css/bootstrap.min.css">  
	<script type="text/javascript" src="${jsPath }/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${jsPath }/bootstrap-4.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">

		function deleteOrderItem(id){
			console.log(id)
			var data = {"id": id};
            $.ajax({
                url : "delProdFromCart",
                data: id,
                type: "post",
                dataType: "json",
                contentType: "application/json",
				success : function(result){
					location.reload();
				},
				complete : function(XMLHttpRequest, textStatus, errorThrown){
				}
			});
		}
		
	</script>
</head>
<body>		
	<div class="container">
		<div class="page-header">
		    <h1>My Shopping Cart</h1>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
					<thead>
						<tr>
							<th>OrderItem Id</th>
							<th>Product Name</th>
							<th>Numbers </th> 
							<th>Unit Price </th> 
							<th>Discount </th>						
							<th>SubTotal Discount </th> 
							<th>SubTotal Price</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderItems}" var="orderItem">
							<tr>
								<th>${orderItem.id } </th>
								<th>${orderItem.prodName } </th>
								<th>
									<form role="form">
										<div class="form-group">
											<input type="text" value="${orderItem.numbers }" readonly class="form-control" placeholder="edit numbers">
										</div>
									 </form>
								</th>
								<th>${orderItem.prodUnitPrice }</th>
								<th>${orderItem.discRate } </th>
								<th>${orderItem.subTotalPrice }</th>	
								<th>${orderItem.subTotalDiscount }</th>								
								<th><button onclick="deleteOrderItem('${orderItem.id }')">Delete</button></th>
							</tr>
						</c:forEach>
						<tr>
							<th><button onclick="" disabled>Clear Cart</button></th>
							<th><button onclick="window.location.href='/shoppingcart/products'">Go on Shopping</button></th>
							<th><button onclick="">Set Order</button></th>
							<th colspan=5>Total:</th>							
						</tr>		
						
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>