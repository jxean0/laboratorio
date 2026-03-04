package clases;

import java.util.HashMap;
import entidades.Estudiante;

public class ModeloDatos {

    HashMap<String, Estudiante> estudiantesMap;

    public ModeloDatos() {
        estudiantesMap = new HashMap<String, Estudiante>();
    }

    public String registrarEstudiante(Estudiante est) {
        if (!estudiantesMap.containsKey(est.getDocumento())) {
            estudiantesMap.put(est.getDocumento(), est);
            return "ok";
        } else {
            return "Estudiante existente";
        }
    }

    public Estudiante consultaEstudiante(String documento) {
        Estudiante estTemporal = null;
        if (estudiantesMap.containsKey(documento)) {
            estTemporal = estudiantesMap.get(documento);
        }
        return estTemporal;
    }

    public String eliminarEstudiante(String documento) {
        if (estudiantesMap.containsKey(documento)) {
            estudiantesMap.remove(documento);
            return "ok";
        }
        return "No encontrado";
    }

    public String actualizarEstudiante(Estudiante est) {
        if (estudiantesMap.containsKey(est.getDocumento())) {
            estudiantesMap.put(est.getDocumento(), est);
            return "ok";
        }
        return "No encontrado";
    }

    public String imprimirListaEstudiantes() {
        String msj = "DATOS ESTUDIANTES\n";
        for (Estudiante estudiante : estudiantesMap.values()) {
            msj += "Nombre: " + estudiante.getNombre() + ", Materia: " + estudiante.getMateria() + "\n";
            msj += "Nota1: " + estudiante.getNota1() + ", Nota2: " + estudiante.getNota2() + ", ";
            msj += "Nota3: " + estudiante.getNota3() + ", Promedio:" + estudiante.getPromedio() + "\n\n";
        }
        System.out.println(msj);
        return msj;
    }
}
