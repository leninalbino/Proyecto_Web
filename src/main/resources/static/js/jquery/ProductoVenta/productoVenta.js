/*$(document).on("click", "#btnregistrarproducto", function() {
	$("#txtcantproducto").val("");
	$("#hddidproducto").val("0");
	$("#modaleditarVP").modal("show");
	$("#modaleditarVP").modal("hide");
});
 */
$(document).on("click", ".btneditarVP", function() {
	$("#txtcantproducto").val($(this).attr("data-cantproducto"));
	$("#hddidproducto").val($(this).attr("data-codproducto"));
	$("#modaleditarVP").modal("show");
});

/*
 * $(document).on( "click", ".btneliminarVP", function() {
 * $("#hddidproductoeliminar").val("0"); $("#mensajeeliminar").text( "¿Estas
 * seguro de eliminar este producto del Carrito : " +
 * $(this).attr("data-catproducto") + "?");
 * $("#hddidproductoeliminar").val($(this).attr("data-codproducto"))
 * $("#modaleliminarVp").modal("show"); });
 */

/*
 * $(document).on("click", "#btnregistrarnuevacantidad", function() { if
 * ($("#hddidproducto").vall() == "0") { $.ajax({ type : "POST", contentType :
 * "json", url : "/registrarProducto", data : JSON.stringify({ codproducto :
 * $("#hddidproducto").val(), cantproducto : $("#txtcantproducto").val() }),
 * success : function(resultado) { var estilo = "danger"; if
 * (resultado.respuesta) { // alerta(resultado.mensaje); estilo = "success"; }
 * mostrarMensaje(resultado.mensaje, estilo); $("#modaleditarVP").modal("hide"); } }) }
 * });
 */

/*
 * $(document).on("click", "#btneliminarproducto", function() { $.ajax({ type :
 * "DELETE", contentType : "application/json", url : "/eliminarProductoVenta",
 * data : JSON.stringify({ codproducto : $("#hddidproductoeliminar").val()
 * 
 * }), success : function(resultado) { var estilo = "danger"; if
 * (resultado.respuesta) { // alerta(resultado.mensaje); estilo = "success"; }
 * mostrarMensaje(resultado.mensaje, estilo);
 * $("#modaleliminarVp").modal("hide"); } });
 * 
 * });
 */

function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje")
			.append(

					"<div class='alert alert-"
							+ estilo
							+ " alert-dismissible fade show' role='alert' >"
							+ "<strong>"
							+ mensaje
							+ "</strong>"
							+ "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>"
							+ "<span aria-hidden='true'>&times;</span></button></div>");
}

$(document).on("input", "#txtcantproducto", function() {
	this.value = this.value.replace(/[^0-9]/g, "");
})

// ============================================================================================000

$(document).on("click", ".btncomprarproducto", function() {
	$("#txtdescripcion").val($(this).attr("data-descripcionproducto"));
	$("#txtprecioventa").val($(this).attr("data-precioventaproducto"));
	$("#txtcantidadproducto").val("1");
	$("#hddcodproducto").val($(this).attr("data-codproducto"));
	$("#modalproducto").modal("show");
});

$(document).on("click", "#btnregistrarproducto", function() {
	var cantidad = $("#txtcantidadproducto").val();
	var precio = $("#txtprecioventa").val();
	var subtotal = cantidad * precio;
	 //alert ($("#txtdescripcion").val());
	$.ajax({
		type: "POST",
		dataType: "json",
		contentType: "application/json",
		url: "/Producto/registrarProducto",
		data : JSON.stringify({
			idproducto : $("#hddcodproducto").val(),
			categoria : $("#txtdescripcion").val(),
			preciounitario : precio,
			cantidadtotal : cantidad,
			preciototal : subtotal
		}),
		success: function(resultado) {
			if (resultado.respuesta){
				
				alert(resultado.mensaje);
			}else{
				alert(resultado.mensaje);
			}
			$("#modalproducto").modal("hide");
		}
	});
	

	});





$(document).on("input", "#txtcantidadproducto", function() {
	this.value = this.value.replace(/[^0-9]/g, "");
})

// ======================================================================
/*
 * function ListarCarrito(){ $.ajax({ type: "Get", url:"/listarVentaProductos",
 * datatype:"json", success: function(datos){ $("#tablacarrito > tbody").append( "<tr>"+ "<td>"+value.codproducto+"</td>"+ "<td>"+value.descripproducto+"</td>"+ "<td>"+value.cantproducto+"</td>"+ "<td>"+value.subtotal+"</td>"+ "</tr>") } })
 *  }	
 */


