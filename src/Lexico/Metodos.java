package Lexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    public static String CadenaExaminar = "";
    DefaultTableModel modelo = (DefaultTableModel) Principal.tabla.getModel();
    Object[] fila = new Object[2];
    int contadorsintactico = 0;
    int contadorid = 0;
    String[] sintactico;
    String[] identificadores;
    String[] datosentrada;

    void proceso() throws IOException {

        //Limpiamos La Tabla Para Poder Almacenar Nuevos Datos Y Que No Se Concatenen
        for (int i = 0; i < Principal.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        //////////////////////////////////////////////////////////////////////////////

        //Carga los tokens desde un archivo de texto externo y lo almacena en un vector llamado Datos
        //El documento de los tokens esta contituido por el token y funcion, 
        // ";Fin_linea" si la funcion es de mas de una palbra usar _ 
        //para hacer una separacion. Ya que cuando almacena los tokens los almacena por posicion separandolos por un espacio
        String strDatos;
        FileReader fr;
        fr = new FileReader("C:\\Users\\DAVID\\Documents\\NetBeansProjects\\Analzador_Lexico_dart\\src\\tokens1.txt");
        BufferedReader br = new BufferedReader(fr);
        strDatos = br.readLine();

        int numTokens = 0;

        StringTokenizer tokens = new StringTokenizer(strDatos, " |\n");
        int i = 0;
        int nDatos = tokens.countTokens();
        String[] datos = new String[nDatos];
        while (tokens.hasMoreTokens()) {
            String str = tokens.nextToken();
            datos[i] = str;

            i++;
        }
        ///////////////////////////////////////////////////////////////////////////////////

        ///Los datos que son ingresados como codigo lo almacena en otro vector, cada simbolo almacenado en un espacio o un salto de linea
        StringTokenizer tokencadenaentrada = new StringTokenizer(CadenaExaminar, " \n");
        int nDatosentrada = tokencadenaentrada.countTokens();
        datosentrada = new String[nDatosentrada];
        int j = 0;
        while (tokencadenaentrada.hasMoreTokens()) {
            String str = tokencadenaentrada.nextToken();
            datosentrada[j] = str;
            j++;
        }
        ////////////////////////////////////////////////////////////////////////

        //sintactico=new String[nDatosentrada];
        //Comprobacion de los token y sus respectivas funciones, ademas hay llamado a funciones que se encargan
        // de identificar si son numeros, letras o decimales
        for (int k = 0; k < nDatosentrada; k++) {
            int aux = 0;

            for (int l = 0; l < nDatos; l++) {
                if (datosentrada[k].equals(datos[l])) {
                    fila[0] = datos[l + 1]; //identificador
                    fila[1] = datos[l]; //token
                    modelo.addRow(fila);
                    Principal.tabla.setModel(modelo);
                    aux = 1;
                    break;
                } else if (numero(datosentrada[k]) == true) {
                    fila[0] = "Valor Numerico: ";
                    fila[1] = datosentrada[k];
                    modelo.addRow(fila);
                    Principal.tabla.setModel(modelo);
                    aux = 1;

                    break;
                } else if (decimal(datosentrada[k]) == true) {
                    fila[0] = "Valor Foltante: ";
                    fila[1] = datosentrada[k];
                    modelo.addRow(fila);
                    Principal.tabla.setModel(modelo);
                    aux = 1;

                    break;
                }

            }

            if (aux == 0) {
                if (identificador(datosentrada[k]) == true) {
                    fila[0] = "Identificador: ";
                    fila[1] = datosentrada[k];
                    modelo.addRow(fila);
                    Principal.tabla.setModel(modelo);
                    
                } else {
                    System.out.println("Simbolo " + datosentrada[k] + " en la posicion " + k + " desconocido ");
                    fila[0] = "Simbolo Desconocido: ";
                    fila[1] = datosentrada[k] + " en posicion: " + (k + 1);
                    modelo.addRow(fila);
                    Principal.tabla.setModel(modelo);

                    Errores = Errores + "Simbolo Desconocido: " + datosentrada[k] + " en posicion: " + (k + 1) + "\n";
                }
            }
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //FUnciones que identifican si son Letras, Numeros o Flotantes
    public String Errores = "";
    int numeros[] = new int[3];
    String ids[] = new String[3];
    int cnumeros = 0, cids = 0;

    public boolean numero(String cad) {
        try {
            if (cad.matches("[0-9]*")) {
                numeros[cnumeros] = Integer.valueOf(cad);
                cnumeros++;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }

    }

    public boolean decimal(String cad) {
        if (cad.matches("[0-9]+(\\.[0-9][0-9]?)?")) {
            return true;
        } else {
            return false;
        }

    }
    int validar = 0;

    public boolean identificador(String cadena) {
        validar++;
        if (cadena.matches("^[a-zA-Z0-9_]*$")) {
            if (validar <= 3) {
                ids[cids] = cadena;
                cids++;
            }
            return true;
        } else {
            return false;
        }
    }

    //////////////////////////////////////////////////////////////////////////////
    int po = 0, po2 = 0, po3 = 0, po4 = 0;

    void resultadoFinal() {
        if (po4 == 0) {
            Errores = Errores + "Compilado Exitosamente\n============================= \n" + numeros[0] + "\n";
        }
        if (po4 == 1) {
            Errores = Errores + "Compilado Exitosamente\n============================= \n" + numeros[1] + "\n";
        }
        if (po4 == 2) {
            Errores = Errores + "Compilado Exitosamente\n============================= \n" + numeros[2] + "\n";
        }
    }

    //Realiza las operaciones segun los simbolos +-*/ del codigo las variables y sus cvalores son almacenado en vectore diferentes
    int r = 0;

    int no = 0;
    String variablesnodeclaradas = "";

    //////////////////////////////////////////////////////////////////////////////    
    String strDatos;

    void cargardatos() throws IOException {
        FileReader fr;
        fr = new FileReader("C:\\Users\\DAVID\\Documents\\NetBeansProjects\\Analzador_Lexico_dart\\src\\tokens1.txt");
        BufferedReader br = new BufferedReader(fr);
        strDatos = br.readLine();
    }

}
