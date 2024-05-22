import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdministradorDeArchivos {

    private ArrayList<String> metas;

    public AdministradorDeArchivos() {
        metas = new ArrayList<String>();
    }

    public ArrayList<String> obtenerMetasGuardadas() {
        return this.metas;
    }

    public void crearArchivo() {
        File archivo = new File("./data/metas.txt");
        try {
            if (!archivo.createNewFile()) {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    public void añadirTextoMetas(String texto) {
        try {
            File file = new File("./data/metas.txt");
            FileWriter escribir = new FileWriter(file, true);
            if (file.length() != 0) {
                escribir.write("\n");
            }
            escribir.write(texto); 
            escribir.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public void leerArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("./data/metas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                metas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existeArchivoMeta() {
        File archivo = new File("./data/metas.txt");
        return archivo.exists();
    }

    public boolean eliminarArchivoMeta() {
        File archivo = new File("./data/metas.txt");
        return archivo.delete();
    }
}
