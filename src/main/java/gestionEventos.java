public class gestionEventos {
    public static void main(String[] args) {
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

    //Verificar que el número de invitados asignados a una persona con entrada "VIP" no exceda el número máximo permitido (2 invitados por persona).
    public static boolean validarInvitadosVIP(String[][] listaAsistentes, int fila){
        String tipoEntrada = verificarBoleto(listaAsistentes, fila);
        boolean invitadosValidos = false;
        if(tipoEntrada.equals("VIP")){
            if(Integer.parseInt(listaAsistentes[fila][3]) <= 2){
                invitadosValidos = true;
            }
        }
        return invitadosValidos;
    }

    //Validar que los asistentes con entrada general no contemplen invitados.
    public static boolean validarInvitadosGeneral(String[][] listaAsistentes, int fila){
        String tipoEntrada = verificarBoleto(listaAsistentes, fila);
        boolean invitadosValidos = false;
        if((tipoEntrada.equals("general")) || (tipoEntrada.equals("false"))) {
            if(Integer.parseInt(listaAsistentes[fila][3]) == 0){
                invitadosValidos = true;
            }
        }
        return invitadosValidos;
    }

    //Cambiar el estado de la persona de "Ingresado" de False a True.
    public static String[][] ingresarPersona(String[][] listaAsistentes, int fila){
        listaAsistentes[fila][4] = "true";
        return listaAsistentes;
    }

    //Permitir eliminar a una persona específica de alguna sala. Si se trata de un VIP, se debe remover en conjunto con el número de invitados que trajo.
    //Se cambia su estado de “Ingresado” de True a False
    public static String[][] removerPersona(String[][] listaAsistentes, int fila){
        listaAsistentes[fila][4] = "false";
        return listaAsistentes;
    }

    //Devolver el aforo restante para una sala específica (VIP o General) después de contabilizar a los invitados ya admitidos.
    //Sala general = 10 asistentes (todos entrada general).
    //También removerá a la persona si no cumple los requisitos.
    public static int aforoDisponibleGeneral(String[][] listaAsistentes){
        int aforoGeneral = 10;
        for(int i=0;i<listaAsistentes.length;i++){
            if(verificarEdad(listaAsistentes,i) && Boolean.parseBoolean(listaAsistentes[i][4]) && verificarBoleto(listaAsistentes, i).equals("general")){
                if(validarInvitadosGeneral(listaAsistentes,i)){
                    aforoGeneral = aforoGeneral - 1;
                } else {
                    removerPersona(listaAsistentes,i);
                }
            }
        }
        return aforoGeneral;
    }

    //Sala VIP = 9 asistentes (3 entradas VIP con 2 invitados c/u).
    //También removerá a la persona si no cumple los requisitos.
    public static int aforoDisponibleVIP(String[][] listaAsistentes){
        int aforoVIP = 9;
        for(int i=0;i<listaAsistentes.length;i++){
            if(verificarEdad(listaAsistentes,i) && Boolean.parseBoolean(listaAsistentes[i][4]) && verificarBoleto(listaAsistentes, i).equals("VIP") && validarInvitadosVIP(listaAsistentes,i)){
                if(validarInvitadosVIP(listaAsistentes,i)) {
                    aforoVIP = aforoVIP - Integer.parseInt(listaAsistentes[i][3]) - 1;
                } else {
                    removerPersona(listaAsistentes,i);
                }
            }
        }
        return aforoVIP;
    }

    //Validar si la persona en la fila especificada puede entrar al evento, verificando que cumpla con las siguientes condiciones:
    //Ser mayor de edad.
    //Tener una entrada válida ("General" o "VIP").
    //Verificar que no se exceda el aforo máximo de la sala correspondiente (VIP o General).
    //Si el aforo de la sala correspondiente está completo, debe devolver false, incluso si la persona cumple con los requisitos.
    //También ingresará, o removerá, a la persona si cumple, o no, los requisitos.
    public static boolean permitirEntrada(String[][] listaAsistentes, int fila){
        boolean entradaPermitida = false;
        if(verificarEdad(listaAsistentes,fila) && verificarBoleto(listaAsistentes,fila).equals("general") && (validarInvitadosGeneral(listaAsistentes,fila)) && aforoDisponibleGeneral(listaAsistentes) > 0){
            entradaPermitida = true;
            ingresarPersona(listaAsistentes,fila);
        } else if(verificarEdad(listaAsistentes,fila) && verificarBoleto(listaAsistentes,fila).equals("VIP") && (validarInvitadosVIP(listaAsistentes,fila)) && aforoDisponibleVIP(listaAsistentes) > 0) {
            entradaPermitida = true;
            ingresarPersona(listaAsistentes,fila);
        } else {
            removerPersona(listaAsistentes,fila);
        }
        return entradaPermitida;
    }

}
