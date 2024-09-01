public class gestionEventos {
    public static void main(String[] args) {
        //sala general = 10 asistentes (todos entrada general)
        //sala VIP = 9 asistentes (3 entrada VIP con 2 invitados c/u)
        String[][] lista = inicializarAsistentes();
        for(int i=0;i<lista.length;i++){
            System.out.print(lista[i][0] + " ");
            System.out.print(lista[i][1] + " ");
            System.out.print(lista[i][2] + " ");
            System.out.print(lista[i][3] + " ");
            System.out.println(lista[i][4]);
        }
    }

    public static String[][] crearMatrizAsistentes(){
        String[][] asistentes = new String[10][5];
        return asistentes;
    }

    public static String[][] agregarAsistentes(String[][] asistentes, String nombre, String edad, String entrada, String invitados, String ingresadoBool){
        for(int i=0;i<10;i++){
            if(asistentes[i][0] == null){
                asistentes[i][0] = nombre;
                asistentes[i][1] = edad;
                asistentes[i][2] = entrada;
                asistentes[i][3] = invitados;
                asistentes[i][4] = ingresadoBool;
                break;
                //Boolean.parseBoolean(String)
                //String.valueOf(boolean)
            }
        }
        return asistentes;
    }

    public static String[][] inicializarAsistentes(){
        String[][] asistentes = crearMatrizAsistentes();
        asistentes = agregarAsistentes(asistentes, "1", "21", "general", "0", "false");
        asistentes = agregarAsistentes(asistentes,"2", "21", "general", "0", "false");
        return asistentes;
    }

}
