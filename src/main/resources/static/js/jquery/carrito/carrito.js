$(document).on("click",".btneliminaritem", function() {
			
			$("#hddcodproducto").val("0");
			$("#mensajeeliminar").text("¿Estas seguro de eliminar este producto del Carrito : "+ 
					$(this).attr("data-catproducto") + "?");
			$("#hddcodproducto").val($(this).attr("data-codproducto"))
			$("#modaleliminarVp").modal("show");
			//alert ($("#hddcodproducto").val());
		});



$(document).on("click", "#btneliminarproducto", function(){
	
	$("#hddcodproducto").val($(this).attr("data-codproducto"));
	var id =$("#hddcodproducto").val();
	console.log(id);
	//alert(id);
	//alert ($("#hddcodproducto").val());
	$.ajax({
			type: "Delete",
			contentType:"application/json",
			url: "/Producto/eliminarProductoVenta",
			data: JSON.stringify({
				idproducto: id
				//idproducto: $("#hddcodproducto").val()
			}),
			success: function(resultado){
				if (resultado.respuesta){
					alert(resultado.mensaje);
					ListarCarrito();
				}else{
					alert(resultado.mensaje);
				}
				$("#modalcodproducto").modal("hide");
				
			}
	});
	
});

function ListarCarrito(){
	var total=0.00;
	$.ajax({
		type: "GET",
		url: "/Producto/listarVentaProductos",
		dataType: "json",
		success: function(resultado){
			$(".listacompra > tbody").html("");
		
			$.each(resultado, function(index, value){
				$(".listacompra > tbody").append(
						total=total+value.subtotal,
						"<tr>"+
						"<td>" + value.idproducto + "</td>"+
						"<td>" + value.categoria + "</td>"+
						"<td>" + value.preciounitario + "</td>"+
						"<td>" + value.cantidadtotal + "</td>"+
						"<td>" + value.preciototal + "</td>"+
						
						"<td><button type='button' class='btn btn-outline-danger btneliminaritem' "+
						" data-idproducto='" + value.idproducto +"'"+
						"data-catproducto='" + value.categoria +"'"+
						">Eliminar</button></td>"+
						
						"<td><button type='submit' class='btn btn-success btneditarVP' " +
							"th:data-codproducto='" + value.idproducto +"'"+
							"th:data-cantproducto='" + value.cantidadtotal + "'"+
									">Editar</button></td>" +
						"</tr>");
			});
			
		}
	});
}