public class gestionEventos {
    public static void main(String[] args) {
        //sala general = 10 asistentes (todos entrada general)
        //sala VIP = 9 asistentes (3 entradas VIP con 2 invitados c/u)
        }

    //Devolver true si la persona en la fila especificada tiene 18 años o más, y false en caso contrario.
    public static boolean verificarEdad(String[][] listaAsistentes, int fila, String edad){
        boolean mayorDeEdad = false;
        if(Integer.parseInt(listaAsistentes[fila][1]) >= 18){
            mayorDeEdad = true;
        }
        return mayorDeEdad;
    }

}
