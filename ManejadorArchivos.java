import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivos {
    public void crearArchivo(String nombreMeta) {
        File archivo = new File("./Metas/" + nombreMeta + ".txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    public void añadirTexto(String nombreMeta, String texto) {
        try {
            File file = new File("./Metas/" + nombreMeta + ".txt");
            FileWriter yoEscribo = new FileWriter(file, true);
            if (file.length() != 0) {
                yoEscribo.write("\n");
            }
            yoEscribo.write(texto); 
            yoEscribo.close();
            System.out.println("Texto añadido al archivo: " + "./Metas/" + nombreMeta + ".txt");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
