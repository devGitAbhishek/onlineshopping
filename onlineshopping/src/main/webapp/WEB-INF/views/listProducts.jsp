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
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts eq true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>

				</div>

			</div>

		</div>

	</div>

</div>