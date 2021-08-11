/*$(document).on("click",".btneliminaritem", function() {
			alert ($("#hddidproducto").val());
			$("#hddcodproducto").val("0");
			$("#mensajeeliminar").text("¿Estas seguro de eliminar este producto del Carrito : "+ 
					$(this).attr("data-catproducto") + "?");
			$("#hddcodproducto").val($(this).attr("data-codproducto"))
			$("#modaleliminarVp").modal("show");
		});
*/


/*$(document).on("click", "#btneliminarproducto", function(){
	
	$("#hddidproducto").val($(this).attr("data-codproducto"));
	var id =$("#hddidproducto").val();
	console.log(id);
	$.ajax({
			type: "POST",
			url: "/Pedido/EliminarProCarrito",
			data:{
				idproducto: id
			},
			success: function(resultado){
				var estilo = "danger";
				if(resultado.respuesta){
					estilo="success";
					
				}
				ListarCarrito();
				mostrarMensaje(resultado.mensaje, estilo);
				$("#hddidproducto").val("");
				
			}
	});
	
});

function ListarCarrito(){
	$.ajax({
		type: "GET",
		url: "/Pedido/listarCarrito",
		dataType: "json",
		success: function(resultado){
			$("#listacompra > tbody").html("");
			$.each(resultado, function(index, value){
				$("#listacompra > tbody").append(
						"<tr>"+
						"<td>" + value.idproducto + "</td>"+
						"<td>" + value.categoria + "</td>"+
						"<td>" + value.cantidadtotal + "</td>"+
						"<td>" + value.preciounitario + "</td>"+
						"<td>" + value.preciototal + "</td>"+
						"<td><button type='button' class='btn btn-outline-danger btneliminaritem' "+
						" data-idproducto='" + value.idproducto +"'"+
						"data-catproducto='" + value.categoria +"'"+
						">Eliminar</button></td>"+
						
						"<td><button type='submit' class='btn btn-success btneditarVP' " +
							"th:data-codproducto='" + producto.idproducto +"'"+
							"th:data-catproducto='" + producto.categoria +" ' "+
							"th:data-cantproducto='" + producto.cantidadtotal + " ' "+
							"th:data-preuproducto='" + producto.preciounitario + " ' "+
							"th:data-pretproducto='" + producto.preciototal + "'" +
									">Editar</button></td>" +
						"</tr>");
			});
		}
	});
}*/