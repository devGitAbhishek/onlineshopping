$(function() {

	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;	
		
	default:
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a-'+menu).addClass('active');
		break;
	}




// code for J query Data tables
// create dataset
var products = [
	
	['1','ABC'],
	['2','DEF'],
	['3','GHI'],
	['4','JKL'],
	['5','MNO'],
	['6','PQR']
];

var $table = $('#productListTable');

if($table.length){
	debugger;
	console.log('Inside the table');
	var jsonUrl = '';
	if(window.categoryId == ''){
		jsonUrl = window.contextRoot + '/json/data/all/products';
	}else{
		debugger;
		jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId+ '/products';
	}
	console.log('jsonurl' + jsonUrl);
	
	$table.DataTable({
		lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
		pageLength:5,
		ajax:{
			url : jsonUrl,
			dataSrc : ''
		},
		columns:[ 
			{
				data : 'code',
				mRender: function(data,type,row){
				  return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"></img>';	
				}
			},
			{
				data : 'name'
			},
			{
				data : 'brand'
			},
            {
				data : 'unitPrice',
				mRender : function(data,type,row){
					return '&#8377;' + data
				}
			},
			{
				data : 'quantity',
				mRender : function(data,type,row){
					if(data <1){
						debugger;
					  return '<span style="color:red">Out of Stock!</span>'	
					}
					return data;
					
				}
			},
			{
				data : 'id',
				bSortable: false,
				mRender: function(data,type,row){
					var url = '';
					url += '<a href = "'+window.contextRoot + '/show/' +data+ '/product" class = "btn btn-primary ">  <span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
					
					if(row.quantity < 1){
						url += '<a href = "javascript:void(0)" class = "btn btn-success disabled">  <span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}else{
						
						url += '<a href = "'+window.contextRoot + '/cart/add/' +data+ '/product" class = "btn btn-success">  <span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}
					
					return url
				}
			}
		] 
	});
	
 }

 var $alert = $('.alert');

if($alert.length){
	
	setTimeout(function(){
		
		$alert.fadeOut('slow');
		
	},3000);
}

// ---------------For activating and deactivating



// ---------DATATABLE FOR ADMIN STarts-------------//
var $adminTable = $('#productsTable');
 
if($adminTable.length){

	var jsonURL = window.contextRoot + '/json/data/manage/all/products';
	
	$adminTable.DataTable({
		lengthMenu:[[10,30,50,-1],['10 Records','30 Records','50 Records','All Records']],
		pageLength:30,
		ajax:{
			url : jsonURL,
			dataSrc : ''
		},
		columns:[
			{
				data: 'id'
			},
			{
				data : 'code',
				mRender: function(data,type,row){
				  return '<img src = "'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"></img>';	
				}
			},
			{
				data : 'name'
			},
			{
				data : 'brand'
			},
			{
				data : 'quantity',
				mRender : function(data,type,row){
					if(data <1){
						debugger;
					  return '<span style="color:red">Out of Stock!</span>'	
					}
					return data;
					
				}
			},
            {
				data : 'unitPrice',
				mRender : function(data,type,row){
					return '&#8377;' + data
				}
			},
			{
				data : 'active',
				bSortable: false,
				mRender: function(data,type,row){
			
					var str = '';
					str+='<label class="switch">';
					if(data){
						str+= '<input type= "checkbox" checked="checked" value="'+row.id+'">';
						
					}else{
						str+= '<input type= "checkbox" value="'+row.id+'">';
					}
					str+= '<div class="slider round"></div></label>';
				return str;	
				}
			},
			
			{
				data : 'id',
				bSortable: false,
				mRender: function(data,type,row){
			
					var str = '';
					str+='<a href ="${contextRoot}/manage/'+data+'/product" class="btn btn-warning">';
					str+='<span class ="glyphicon glyphicon-pencil"></span></a>';
					return str;	
				}
			}
		],
		
		initComplete: function(){
			var  api = $.fn.dataTable.Api();
			console.log('api' , api);
			$('.switch input[type="checkbox"]').change(function () {
				debugger;
				var checkbox= $(this);
				var checked = checkbox.prop('checked');
				var dmsg = (checked)? 'You want to activate the product?' : 'You want to deactivcate product?';
				var value = checkbox.prop('value');// we will get id
				
				bootbox.confirm({
					size : 'medium',
					title : 'The product activation and deactivation',
					message : dmsg,
					callback : function(confirmed){
						if(confirmed){
							console.log('value' , value);
							var activationURL= window.contextRoot+ '/manage/product/' + value + '/activation';
                            $.post(activationURL, function(data){
                            	bootbox.alert({
                            		size: 'medium',
                            		title :'Info',
                            		message: data
                            	});
                            });							
						}
						else{
							checkbox.prop('checked',!checked);
						}
					}
				});
			});
		}
	});
	
 }
// ---------DATATABLE FOR ADMIN ENDS-------------//

});