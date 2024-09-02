import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gestionEventosTest {

    String[][] listaAsistentes;

    @BeforeEach
    void setUp() {
        System.out.println("Iniciando lista para una prueba...");
        listaAsistentes = new String[][]{
                //comentarios de los datos que se deberían marcar como erróneos o si están todos correctos.
                {"Asistente 1", "16", "general", "0", "true"}, //menor de edad y está ingresado
                {"Asistente 2", "17", "VIP", "2", "false"}, //menor de edad
                {"Asistente 3", "18", "general", "0", "true"}, //datos correctos
                {"Asistente 4", "19", "general", "1", "false"}, //tiene invitado siendo general
                {"Asistente 5", "20", "VIP", "1", "true"}, //datos correctos
                {"Asistente 6", "21", "general", "0", "false"}, //datos correctos
                {"Asistente 7", "22", "general", "1", "true"}, //tiene invitado siendo general y está ingresado
                {"Asistente 8", "23", "VIP", "3", "false"}, //excede número de invitados
                {"Asistente 9", "24", "general", "0", "true"}, //datos correctos
                {"Asistente 10", "25", "VIP", "2", "false"}, //datos correctos
        };
    }

    @AfterEach
    void tearDown() {
        System.out.println("Limpiando lista después de una prueba...");
        listaAsistentes = null;
    }

    @Test
    void verificarEdad() {
        assertFalse(gestionEventos.verificarEdad(listaAsistentes, 0));
        assertFalse(gestionEventos.verificarEdad(listaAsistentes, 1));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 2));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 3));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 4));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 5));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 6));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 7));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 8));
        assertTrue(gestionEventos.verificarEdad(listaAsistentes, 9));
    }

    @Test
    void verificarBoleto() {
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,0));
        assertEquals("VIP",gestionEventos.verificarBoleto(listaAsistentes,1));
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,2));
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,3));
        assertEquals("VIP",gestionEventos.verificarBoleto(listaAsistentes,4));
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,5));
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,6));
        assertEquals("VIP",gestionEventos.verificarBoleto(listaAsistentes,7));
        assertEquals("general",gestionEventos.verificarBoleto(listaAsistentes,8));
        assertEquals("VIP",gestionEventos.verificarBoleto(listaAsistentes,9));
    }

    @Test
    void validarInvitadosVIP() {
        assertTrue(gestionEventos.validarInvitadosVIP(listaAsistentes, 1));
        assertTrue(gestionEventos.validarInvitadosVIP(listaAsistentes, 4));
        assertFalse(gestionEventos.validarInvitadosVIP(listaAsistentes, 7));
        assertTrue(gestionEventos.validarInvitadosVIP(listaAsistentes, 9));
    }

    @Test
    void validarInvitadosGeneral() {
        assertTrue(gestionEventos.validarInvitadosGeneral(listaAsistentes, 0));
        assertTrue(gestionEventos.validarInvitadosGeneral(listaAsistentes, 2));
        assertFalse(gestionEventos.validarInvitadosGeneral(listaAsistentes, 3));
        assertTrue(gestionEventos.validarInvitadosGeneral(listaAsistentes, 5));
        assertFalse(gestionEventos.validarInvitadosGeneral(listaAsistentes, 6));
        assertTrue(gestionEventos.validarInvitadosGeneral(listaAsistentes, 8));
    }

    @Test
    void ingresarPersona() {
        assertTrue(Boolean.parseBoolean((gestionEventos.ingresarPersona(listaAsistentes,1))[1][4]));
        assertTrue(Boolean.parseBoolean((gestionEventos.ingresarPersona(listaAsistentes,3))[3][4]));
        assertTrue(Boolean.parseBoolean((gestionEventos.ingresarPersona(listaAsistentes,5))[5][4]));
        assertTrue(Boolean.parseBoolean((gestionEventos.ingresarPersona(listaAsistentes,7))[7][4]));
        assertTrue(Boolean.parseBoolean((gestionEventos.ingresarPersona(listaAsistentes,9))[9][4]));
    }

    @Test
    void removerPersona() {
        assertFalse(Boolean.parseBoolean((gestionEventos.removerPersona(listaAsistentes,0))[0][4]));
        assertFalse(Boolean.parseBoolean((gestionEventos.removerPersona(listaAsistentes,2))[2][4]));
        assertFalse(Boolean.parseBoolean((gestionEventos.removerPersona(listaAsistentes,4))[4][4]));
        assertFalse(Boolean.parseBoolean((gestionEventos.removerPersona(listaAsistentes,6))[6][4]));
        assertFalse(Boolean.parseBoolean((gestionEventos.removerPersona(listaAsistentes,8))[8][4]));

    }

    @Test
    void aforoDisponibleGeneral() {
        assertEquals(8,gestionEventos.aforoDisponibleGeneral(listaAsistentes));
    }

    @Test
    void aforoDisponibleVIP() {
        assertEquals(7,gestionEventos.aforoDisponibleVIP(listaAsistentes));
    }

    @Test
    void permitirEntrada() {
        assertFalse(gestionEventos.permitirEntrada(listaAsistentes, 0));
        assertFalse(gestionEventos.permitirEntrada(listaAsistentes, 1));
        assertTrue(gestionEventos.permitirEntrada(listaAsistentes, 2));
        assertFalse(gestionEventos.permitirEntrada(listaAsistentes, 3));
        assertTrue(gestionEventos.permitirEntrada(listaAsistentes, 4));
        assertTrue(gestionEventos.permitirEntrada(listaAsistentes, 5));
        assertFalse(gestionEventos.permitirEntrada(listaAsistentes, 6));
        assertFalse(gestionEventos.permitirEntrada(listaAsistentes, 7));
        assertTrue(gestionEventos.permitirEntrada(listaAsistentes, 8));
        assertTrue(gestionEventos.permitirEntrada(listaAsistentes, 9));
    }
}