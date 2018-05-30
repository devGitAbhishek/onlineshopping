<div class="container">

	<div class="row">

		<!--to display side bar  -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!--to display actual products  -->
		<div class="col-md-9">
			<!--To display breadcrumb  -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickProducts eq true}">
						<script>
						   window.categoryId = ''; //Keep it empty if user is seeing all the products
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts eq true}">
						<script>
						   window.categoryId = '${categoryId}';  //Assign value if user is seeing one of the products
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>

				</div>

			</div>

			<div class="row">

				<div class="col-lg-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
							    <th></th>
								<th> Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>
						</thead>

						<tfoot>

							<tr>
							    <th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity Available</th>
						        <th></th> 	
							</tr>

						</tfoot>

					</table>

				</div>

			</div>

		</div>

	</div>

</div>