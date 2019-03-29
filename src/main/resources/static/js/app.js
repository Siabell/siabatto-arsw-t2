app = (function () {
    var nameCity;

    return {
        setCityName: function () {
            nameCity = document.getElementById("txt_city").value;
        },

        obtenerDescripcion: function (city) {
            $("#nombre").empty();
            $("#coord").empty();
            $("#temp").empty();
            $("#press").empty();
            $("#humi").empty();
            var datos = JSON.parse(city);
            var nombre = "City: " +datos.name;
            var coord = "longitud:"+datos.coord.lon+" latitud: "+datos.coord.lat;
            var temp = "Temperature: "+datos.main.temp;
            var press = "Pressure: "+datos.main.pressure;
            var humi = "Humidir: "+datos.main.humidity;


            $("#nombre").append(nombre);
            $("#coord").append(coord);
            $("#temp").append(temp);
            $("#press").append(press);
            $("#humi").append(humi);
            
            
            

            
        },

        obtenerClimaCiudad: function () {           
            app.setCityName();
            //document.getElementById("funcionesTxt").innerHTML = "function app";
            api.getCityWeather(nameCity, app.obtenerDescripcion);
            
        }
    };
})();

api = (function () {
       
    
    return {      
        getCityWeather: function (name, callback) {
        	//alert( "Load was performed." );
        	
        	$.get( 'weather/'+name, function( data ) {
        		//alert( "Load was performed sfsgsgd." );
        		console.log(data);
        		
        		callback(data);
        		  
        		});
        }
    };

})();