<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Product List</title>
	
	<%@include file="../../static/js/common/common.jsp"%>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${jsPath }/bootstrap-4.0.0/css/bootstrap.min.css">  
	<script type="text/javascript" src="${jsPath }/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${jsPath }/bootstrap-4.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">

		function addProductToCart(id) {
			var data = {"id": id};
            $.ajax({
                url : "addProductToCart",
                data: id,
                type: "post",
                dataType: "json",
                contentType: "application/json",
				success : function(result){
					window.location.href='/shoppingcart/myShoppingCart';
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
		    <h1>Product List</h1>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
					<thead>
						<tr>
							<th>Product Name</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Status</th>
							<th>Operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<th>${product.name } </th>
								<th>
									<form role="form">
										<div class="form-group">
											<input type="text" value="1" readonly class="form-control" placeholder="edit quantity">
										</div>
									 </form>
								</th>
								<th>${product.unitPrice }</th>
								<th>${product.status }</th>
								<th><button onclick="addProductToCart('${product.id }')">Add to Cart</button></th>
							</tr>
						</c:forEach>			
						
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>