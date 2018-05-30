<div class="container">

	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
			<!-- Display the Image -->
			<div class="col-md-6 col-xs-6 col-sm-4 col-lg-5">

				<div class="thumbnail">

					<img src="${images}/${product.code}.jpg" class="img img-responsive" />

				</div>

			</div>

			<div class="col-md-12 col-xs-12 col-sm-4 col-lg-5">

				<h3>${product.name}</h3>
				<hr />

				<p>${product.description}</p>
				<hr />

				<h4>
					Price <strong>&#8377; ${product.unitPrice}/-</strong>
				</h4>
				<hr />


				<c:choose>
					<c:when test='${product.quantity < 1}'>
						<h6>
							Qty. Available : <span style="color: red">Product out of
								stock!</span>
						</h6>
					</c:when>
					<c:otherwise>

						<h6>Qty. Available : ${product.quantity}</h6>

					</c:otherwise>

				</c:choose>
				<hr />
				<c:choose>
					<c:when test='${product.quantity < 1}'>
						<a href="javascript:void(0)" class="btn btn-success disabled">
							<span class="glyphicon glyphicon-shopping-cart"><strike>Add to Cart</strike></span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${contextRoot}/cart/add/${product.id}/product"
							class="btn btn-success"><span
							class="glyphicon glyphicon-shopping-cart">Add to Cart</span></a>
					</c:otherwise>
				</c:choose>
				<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back
					To Products</a>

			</div>

		</div>


		</ol>

	</div>

</div>


</div>