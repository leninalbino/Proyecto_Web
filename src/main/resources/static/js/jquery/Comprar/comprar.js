/*$(document).on("click", "#btnprocesar-compra", function() {
     $("#txtnombres").val("");
     $("#txtapellidos").val("");
     $("#txtemail").val("");
     $("#txtdireccion").val("");
     $("#ubigeo_dep").val("");
     $("#ubigeo_pro").val("");
     $("#ubigeo_dis").val("");
     $("#txttelefono").val("");
     $("#checktipotarjeta").val("");
     $("#txtnomtarjeta").val("");
     $("#txtnumetarjeta").val("");
     $("#txtexpiration").val("");
     $("#txtcvv").val("");
     $("#hddidpago").val("0");
     $("#modalpago").modal("show");
});

 

$(document).on("click", "#btnregistrarpago", function() {
    if ($("#txtnombres").val() === "") {
        $("#errornombres").text("Es obligatorio ingresar los nombre del cliente");
    } else {
        $("#errornombres").text("");
    }
    if ($("#txtapellidos").val() === "") {
        $("#errorapellidos").text("Es obligatorio ingresar los apellidos del cliente");
    } else {
        $("#errorapellidos").text("");
    }
    if ($("#txtemail").val() === "") {
        $("#erroremail").text("Es obligatorio ingresar el email del cliente");
    } else {
        $("#erroremail").text("");
    }
    if ($("#txtdireccion").val() === "") {
        $("#errordireccion").text("Es obligatorio ingresar la direccion del cliente");
    } else {
        $("#errordireccion").text("");
    }
    if ($("#ubigeo_dep").val() === "") {
        $("#errorubigeo_dep").text("Es obligatorio ingresar el departamento del cliente");
    } else {
        $("#errorubigeo_dep").text("");
    }
    if ($("#ubigeo_pro").val() === "") {
        $("#errorubigeo_pro").text("Es obligatorio ingresar la provincia del cliente");
    } else {
        $("#errorubigeo_pro").text("");
    }
    if ($("#ubigeo_dis").val() === "") {
        $("#errorubigeo_dis").text("Es obligatorio ingresar el distrito del cliente");
    } else {
        $("#errorubigeo_dis").text("");
    }
    if ($("#txttelefono").val() === "") {
        $("#errortelefono").text("Es obligatorio ingresar el telefono del cliente");
    } else {
        $("#errortelefono").text("");
    }
    if ($("#checktipotarjeta").val() === "") {
        $("#errorchecktipotarjeta").text("Es obligatorio ingresar el tipo de tarjeta del cliente");
    } else {
        $("#errorchecktipotarjeta").text("");
    }
    if ($("#txtnomtarjeta").val() === "") {
        $("#errornomtarjeta").text("Es obligatorio ingresar el nombre de la tarjeta del cliente");
    } else {
        $("#errornomtarjeta").text("");
    }
    if ($("#txtnumetarjeta").val() === "") {
        $("#errornumetarjeta").text("Es obligatorio ingresar el numero de la tarjeta del cliente");
    } else {
        $("#errornumetarjeta").text("");
    }
    if ($("#txtexpiration").val() === "") {
        $("#errorexpiration").text("Es obligatorio ingresar la fecha de la tarjeta del cliente");
    } else {
        $("#errorexpiration").text("");
    }
    if ($("#txtcvv").val() === "") {
        $("#errorcvv").text("Es obligatorio ingresar el cvv de la tarjeta del cliente");
    } else {
        $("#errorcvv").text("");
    }
    if ($("#txtnombres").val() !== "" && $("#txtapellidos").val() !== "" && $("#txtemail").val() !== ""
        && $("#txtdireccion").val() !== "" && $("#ubigeo_dep").val() !== "" && $("#ubigeo_pro").val() !== ""
        && $("#ubigeo_dis").val() !== "" && $("#txttelefono").val() !== "" && $("#checktipotarjeta").val() !== ""
        && $("#txtnomtarjeta").val() !== "" && $("#txtnumetarjeta").val() !== ""&& $("#txtexpiration").val() !== ""
        && $("#txtcvv").val() !== ""){
        if($("#hddidpago").val()=== "0"){
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/Pagar/registrarPago",
            data : JSON.stringify({
            nombres : $("#txtnombres").val(),
            apellidos : $("#txtapellidos").val(),
            email : $("#txtemail").val(),
            direccion : $("#txtdireccion").val(),
            departamento : $("#ubigeo_dep").val(),
            provincia : $("#ubigeo_pro").val(),
            distrito : $("#ubigeo_dis").val(),
            telefono : $("#txttelefono").val(),
            tipotarjeta : $("#checktipotarjeta").val(),
            nomtarjeta : $("#txtnomtarjeta").val(),
            numetarjeta : $("#txtnumetarjeta").val(),
            expiration : $("#txtexpiration").val(),
            cvv : $("#txtcvv").val()
            
        }),
        success : function(resultado) {
            var estilo = "danger";

 

            if (resultado.respuesta){
                var estilo = "danger";
              // alert(resultado.mensaje);
            }
            mostrarMensaje(resultado.mensaje, estilo);
            $("#modalpago").modal("hide");
        }
    });
        }
});*/