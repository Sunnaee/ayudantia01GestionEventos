public class gestionEventos {
    public static void main(String[] args) {
        //sala general = 10 asistentes (todos entrada general)
        //sala VIP = 9 asistentes (3 entradas VIP con 2 invitados c/u)
        }

    //Devolver true si la persona en la fila especificada tiene 18 años o más, y false en caso contrario.
    public static boolean verificarEdad(String[][] listaAsistentes, int fila){
        boolean mayorDeEdad = false;
        if(Integer.parseInt(listaAsistentes[fila][1]) >= 18){
            mayorDeEdad = true;
        }
        return mayorDeEdad;
    }

    //Devolver "General", "VIP", o "False" según el tipo de entrada de la persona en la fila especificada.
    public static String verificarBoleto(String[][] listaAsistentes, int fila){
        String tipoEntrada = listaAsistentes[fila][2];
        return tipoEntrada;
    }

}
