package com.firtsappspring.tutospring;

import org.springframework.web.bind.annotation.RestController;

import com.firtsappspring.tutospring.models.Libro;
import com.firtsappspring.tutospring.models.Producto;
import com.firtsappspring.tutospring.models.UserData;
import com.firtsappspring.tutospring.services.OrderService;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Rutas {

    private OrderService orderService = new OrderService();

    private final Logger logger = LoggerFactory.getLogger(Rutas.class); 

    // Metodo GET:

    // Path parameters
    @GetMapping("/hola")
    public String  miPrimeraRuta() {
        return "Hola mundo desde Spring Controller";
        // probar en postman: localhost:8080/hola
    }
    @GetMapping("/libro/{id}/editorial/{editorial}")
    public String  LeerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id: " + id + " de la editorial: " + editorial;
        // probar en postman: localhost:8080/libro/30/editorial/any
    } 
    @GetMapping("/hola/{id}")
    public String  LeerLibro(@PathVariable String id) {
        return "Hola " + id + ", ¿Como estas?";
        // probar en postman: localhost:8080/hola/kevin
    }

    // Query parameters

    @GetMapping("/libro2/{id}")
    public String  LeerLibroQuery(@PathVariable int id, @RequestParam String editorial, @RequestParam String autor) {
        return "Leyendo el libro id: " + id + " de la editorial: " + editorial + " del autor: " + autor;
        // probar en postman: localhost:8080/libro2/30?editorial=any&autor=any
    } 


    // Metodo POST:

    @PostMapping("/libro")
    // Para enviar informacion, no usamos query parameters ni path variables
    // Usamos el @RequestBody para enviar la informacion en formato JSON o XML o texto plano etc.
    // Creamos un modelo de Libro con la Clase Libro para esperar la informacion que nos mande el cliente
    public String guardarLibro(@RequestBody Libro libro) {
        logger.debug("Libro {} editorial {} ", libro.getNombre(), libro.getEditorial()); 
        return "libro guardado";
    }

    // ---------------------------------------------------------------------------
    // HTTP STATUS CODES

    @GetMapping("/saludar")
    // con esto devolvemos un estatus code personalizado y un mensaje de statuscode
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la version 2.0 API") 
    public String saludar() {
        //ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY returnta un 301 Moved Permanently
        return "Hola mundo";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
        if(lugar.equals("granja")){
            // con esto devolvemos un estatus code personalizado y la respuesta
            return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, oveja, gallina");
            
        }else if (lugar.equals("selva")){
            return ResponseEntity.status(HttpStatus.OK).body("Mono, Gorila, Puma");
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido");
        }
    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("la clave del usuario es pasw1234 y no deberia leerse en postman");
    }
    
    
    // como devolver un JSON

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .header("Content-Type", "application/json")
            .body("{\"id\": 1, \"name\": \"kevin\"}");
            // asi devolvemos de forma cruda un JSON
    }

    // Spring boot ofrece una manera mas elegante de devolver un JSON

    /*  Spring boot detecta que le vas a devolver una estructura de datos tipo Diccionario 
     *  y lo convierte en un JSON
    */
    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2(){
        return Map.of("user", Map.of("name", "kevin", "age", 25));
    }
 
    // otra manera mas elegante de hacerla es crear una clase UserData y especificar el 
    // tipo de tipo de dato que va a devolver
    @GetMapping("/userData/v3")
    public UserData getUserDataV3() {
        return new UserData("kevin", 25, "calle 123");
    }


    // Servicios
    @PostMapping("/order")
    public String crearOrden(@RequestBody List<Producto> products) {
        orderService.saveOrder(products);
        return "Productos Guardados";
    }
    
    
}
