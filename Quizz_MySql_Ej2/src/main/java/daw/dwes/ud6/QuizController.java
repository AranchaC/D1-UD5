package daw.dwes.ud6;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@Controller
public class QuizController {
	
    private final ResultadoRepository resultadoRepositorio;
    
    @Autowired
    public QuizController(ResultadoRepository resultadoRepositorio) {
    	this.resultadoRepositorio = resultadoRepositorio;
    }
	
	@GetMapping("/")
	public String inicio(HttpSession session, Model model) {
    	// Reiniciar los puntos en el inicio creando nuevo objeto/modelo Resultado:
        Resultado resultado = new Resultado();
        session.setAttribute("resultado", resultado);
		return "inicio"; //se muestra la pagina inicio.	
	}//inicio
	
    @GetMapping("/pregunta1")
    public String pregunta1() {
        return "pregunta1";
    }
    
    @PostMapping("/pregunta1")
    public String Pregunta1(
    		@RequestParam(name = "respuesta") String respuesta, 
    		HttpSession session,
    		Model model) {
    	
    	int puntos = 0;
    	
    	//manejar la respuesta de la pregunta 1 (radio button)
        if (respuesta.equals("gryffindor")) {
            puntos = 4;
        } else if (respuesta.equals("hufflepuff")) {
            puntos = 1;
        } else if (respuesta.equals("slytherin")) {
            puntos = 3;
        } else if (respuesta.equals("ravenclaw")) {
            puntos = 2;
        }

        // Obtener el objeto Resultado de la sesión
        Resultado resultado = obtenerResultado(session);

        // Actualizar los puntos acumulados en el objeto Resultado
        resultado.setPuntos(resultado.getPuntos() + puntos);

        // Agregar el objeto Resultado actualizado al modelo
        model.addAttribute("resultado", resultado);

        return "pregunta2";
    }//preg1
    
    @PostMapping("/pregunta2")
    public String pregunta2(
    		@RequestParam (value = "opciones", required = false) 
    		String[] opciones, 
    		HttpSession session,
    		Model model) {
        int puntos = 0;
        // Gestión respuesta de la pregunta 2 (checkbox)
        // asignar puntos según las opciones seleccionadas
        if (opciones != null) {
            puntos = opciones.length; 
        }

        // Actualizar la sesión con los puntos obtenidos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);

        return "pregunta3";
    }
    

    @PostMapping("/pregunta3")
    public String pregunta3(
    		@RequestParam(name = "respuesta") String respuesta, 
    		HttpSession session,
    		Model model) {
        int puntos = 0;
        // Gestión respuesta de la pregunta 3 (select)
        // asignar puntos según la opción seleccionada
        if (respuesta.equals("minerva")) {
            puntos = 4;
        } else if (respuesta.equals("snape")) {
            puntos = 3;
        } else if (respuesta.equals("flitwick")) {
            puntos = 2;
        } else if (respuesta.equals("sprout")) {
            puntos = 1;
        } 

        // Actualizar la sesión con los puntos obtenidos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);

        return "pregunta4";
    }//preg3
    

    @PostMapping("/pregunta4")
    public String pregunta4(
            @RequestParam(name = "respuesta") String respuesta,
            HttpSession session,
            Model model) {
        int puntos = 0;

        // Gestión de la respuesta de la pregunta 4 (botones)
        switch (respuesta) {
            case "gloria":
                puntos = 4;
                break;
            case "poder":
                puntos = 3;
                break;
            case "sabiduria":
                puntos = 2;
                break;
            case "amor":
                puntos = 1;
                break;

            default:
                // para valores no esperados
                break;
        }

        // Actualizar la sesión con los puntos obtenidos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);

        return "pregunta5";
    }//pregunta4
    
    @PostMapping("/pregunta5")
    public String pregunta5(
            @RequestParam(name = "respuesta") String respuesta,
            HttpSession session,
            Model model) {
        int puntos = 0;

        // pasar a minúsculas y eliminar espacios en blanco
        String respuestaReal = respuesta.toLowerCase().trim();

        // Comprobar la respuesta con las opciones válidas:
        if (respuestaReal.equals("espada")) {
            puntos = 4;
        } else if (respuestaReal.equals("varita")) {
            puntos = 3;
        } else if (respuestaReal.equals("libro")) {
            puntos = 2;
        } else if (respuestaReal.equals("escoba")) {
            puntos = 1;
        }

        // Actualizar la sesión con los puntos obtenidos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);

        return "pregunta6";
    }//preg5
    
    @PostMapping("/pregunta6")
    public String Pregunta6(
    		@RequestParam(name = "respuesta") String respuesta, 
    		HttpSession session,
    		Model model) {
    	
    	int puntos = 0;
    	
    	//manejar la respuesta de la pregunta 6 (radio button)
        if (respuesta.equals("gryffindor")) {
            puntos = 4;
        } else if (respuesta.equals("hufflepuff")) {
            puntos = 1;
        } else if (respuesta.equals("slytherin")) {
            puntos = 3;
        } else if (respuesta.equals("ravenclaw")) {
            puntos = 2;
        }

        // Obtener el objeto Resultado de la sesión
        // y actualizo los puntos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);

        return "pregunta7";
    }//preg6
    
    @PostMapping("/pregunta7")
    public String pregunta7(
            @RequestParam(name = "respuesta") String respuesta,
            HttpSession session,
            Model model) {
        int puntos = 0;

        // Gestión de la respuesta de la pregunta 7 (botones)
        switch (respuesta) {
            case "gryff":
                puntos = 4;
                break;
            case "slyth":
                puntos = 3;
                break;
            case "raven":
                puntos = 2;
                break;
            case "huff":
                puntos = 1;
                break;

            default:
                // para valores no esperados
                break;
        }

        // Actualizar la sesión con los puntos obtenidos
        Resultado resultado = obtenerResultado(session);
        resultado.setPuntos(resultado.getPuntos() + puntos);
        model.addAttribute("resultado", resultado);
        
        // y actualizamos la clasificación, accediendo a los puntos:
        resultado.setClasificacion(calcularClasificacion(resultado.getPuntos()));

        return "paginaNombre";
    }//pregunta7
    
    @PostMapping("/paginaNombre")
    public String paginaNombre(
            @RequestParam(name = "nombre") String nombre,
            HttpSession session,
            Model model) {
    	
        // Obtener el objeto Resultado de la sesión
        Resultado resultado = obtenerResultado(session);

        // Actualizar el nombre en el objeto Resultado
        resultado.setNombre(nombre);
        // Agregar el objeto Resultado actualizado al modelo
        model.addAttribute("resultado", resultado);
        
        // Guardar el resultado en el repositorio con .save:
        resultadoRepositorio.save(resultado);

        // Obtener todos los resultados del repositorio con .findAll():
        List<Resultado> todosLosResultados = resultadoRepositorio.findAll();

        // Seleccionar los últimos 5 resultados (o menos si hay menos de 5)
        List<Resultado> ultimosResultados = resultadoRepositorio.Ultimos5Resultados();

        // Agregar la lista de últimos resultados al modelo
        model.addAttribute("ultimosResultados", ultimosResultados);
        
        return "finalResultado";
    }

    
    private Resultado obtenerResultado(HttpSession session) {
    	Resultado resultado = (Resultado) session.getAttribute("resultado");
        // Si no existe en la sesión, crear uno nuevo y se guarda en la sesión:
    	if (resultado == null) {
            resultado = new Resultado();
            session.setAttribute("resultado", resultado);
        }
        return resultado;
    }//obtenerResultado
    
    private Clasificacion calcularClasificacion(int puntos) {
        // determinar la clasificación según los puntos
        if (puntos >= 20) {
            return Clasificacion.GRYFFINDOR;
        } else if (puntos >= 15) {
            return Clasificacion.RAVENCLAW;
        } else if (puntos >= 10) {
            return Clasificacion.SLYTHERIN;
        } else {
            return Clasificacion.HUFFLEPUFF;
        }
    }//calcularClasif
    
    // MÉTODOS CONSULTAS SQL //
    
    @GetMapping("/resultados")
    public List<Resultado> obtenerTodosLosResultados(){
    	return resultadoRepositorio.findAll();
    }//ObtenerTodos
    
    @GetMapping("/resultados/{id}")
    public Optional<Resultado> buscarResultadoId(@PathVariable ("id") Long id){
    	return resultadoRepositorio.findById(id);
    }//BuscarId
    
    
    @PostMapping("/resultados")
    public Resultado agregarResultado(@RequestBody Resultado nuevoResultado) {
        return resultadoRepositorio.save(nuevoResultado);
    }//agregar
    
    @DeleteMapping("/resultados/{id}")
    public ResponseEntity<Object> eliminarResultado(@PathVariable ("id") Long id) {
        Optional<Resultado> resultadoOptional = resultadoRepositorio.findById(id);

        if (!resultadoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        resultadoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }//eleminar
    
    @PutMapping("/resultados/{id}")
    public ResponseEntity<Object> actualizarResultado(
    		@PathVariable (name="id") Long id, 
    		@RequestBody Resultado resultadoActualizado) {
        Optional<Resultado> resultadoOptional = resultadoRepositorio.findById(id);

        if (!resultadoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        resultadoActualizado.setId(id); 
        resultadoRepositorio.save(resultadoActualizado);
        return ResponseEntity.noContent().build();
    }//actualizar
    
    @GetMapping("/resultados/count")
    public ResponseEntity<?> contarResultados() {
        long totalResultados = resultadoRepositorio.count();
        return ResponseEntity.ok("Número de resultados en la BBDD: " 
        		+ totalResultados);
    }//contar

}

