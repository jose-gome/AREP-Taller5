var app = (function () {

	
	var numeros = function (error, info){
		if (error != null){
			alert("Verificar datos");
			return;	
		}
		$("#Lista").text(info.Lista);
	}
	
	var enviar = function (){
		var strings = $("#captura").val();
		var listaNums= strings.split(",");
		apiclient.capturarDatos(listaNums, numeros);
	}
	

    return {
		capturarDatos : function(){
			enviar();
		}
    }
})();