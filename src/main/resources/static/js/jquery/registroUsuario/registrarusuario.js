/*$(document).on("input", "#txtnombre", function() {
	this.value = this.value.replace(/[^0-9]/g, "");
})*/
$(document).on("click", "#btnregistrarusuario", function(){
	var nombre=$("#txtnombre").val();
	var apellido=$("#txtapellido").val();
	var email=$("#txtemail").val();
	var username=$("#txtusername").val();
	var password=$("#txtpassword").val();
});

const nombre=/[^A-Za-z\s]/g;
$(document).on("input", "#txtnombre", function(){
	this.value=this.value.replace(nombre,"");
});

const apellido=/[^A-Za-z\s]/g;
$(document).on("input", "#txtapellido", function(){
	this.value=this.value.replace(apellido,"");
});
