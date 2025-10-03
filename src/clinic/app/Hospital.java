/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.app;

import clinic.domain.Cita;
import clinic.domain.Doctor;
import clinic.domain.Paciente;
import clinic.security.Usuario;
import clinic.service.Agenda;

import java.util.List;
import java.util.Scanner;

// Clase principal: login + menú. Consola para ir a lo seguro.
public class Hospital {
    private static final Usuario ADMIN = new Usuario("admin", "1234"); // demo para pasar el requisito
    private static final Agenda agenda = new Agenda();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1) Login
        if (!login()) {
            System.out.println("Acceso denegado. Fin del programa.");
            return;
        }
        System.out.println("Bienvenido, acceso concedido.\n");

        // 2) Menú
        int opcion;
        do {
            opcion = menu();
            try {
                switch (opcion) {
                    case 1 -> altaDoctor();
                    case 2 -> altaPaciente();
                    case 3 -> crearCita();
                    case 4 -> listarTodo(); // no lo piden, pero ayuda a validar
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        } while (opcion != 5);
    }

    private static boolean login() {
        System.out.print("Ingrese su usuario: ");
        String u = sc.nextLine().trim();
        System.out.print("Ingrese su contraseña: ");
        String p = sc.nextLine().trim();
        return ADMIN.valida(u, p);
    }

    private static int menu() {
        System.out.println("Seleccione opción:");
        System.out.println("1) Alta Doctor");
        System.out.println("2) Alta Paciente");
        System.out.println("3) Crear Cita");
        System.out.println("4) Listar Doctores/Pacientes/Citas");
        System.out.println("5) Salir");
        System.out.print("Opción: ");
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private static void altaDoctor() {
        System.out.print("Nombre del doctor: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Especialidad: ");
        String esp = sc.nextLine().trim();
        Doctor d = agenda.altaDoctor(nombre, esp);
        System.out.println("Doctor registrado: " + d);
    }

    private static void altaPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        Paciente p = agenda.altaPaciente(nombre, tel, email);
        System.out.println("Paciente registrado: " + p);
    }

    private static void crearCita() {
        System.out.print("ID Doctor: ");
        int dId = Integer.parseInt(sc.nextLine().trim());
        System.out.print("ID Paciente: ");
        int pId = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Fecha (AAAA-MM-DD): ");
        String fecha = sc.nextLine().trim();
        System.out.print("Hora (HH:MM): ");
        String hora = sc.nextLine().trim();
        System.out.print("Motivo: ");
        String motivo = sc.nextLine().trim();

        Cita c = agenda.crearCita(dId, pId, fecha, hora, motivo);
        System.out.println("Cita creada: " + c);
    }

    private static void listarTodo() {
        List<Doctor> ds = agenda.listarDoctores();
        List<Paciente> ps = agenda.listarPacientes();
        List<Cita> cs = agenda.listarCitas();

        System.out.println("Doctores (" + ds.size() + "):");
        for (Doctor d : ds) System.out.println("  " + d);

        System.out.println("Pacientes (" + ps.size() + "):");
        for (Paciente p : ps) System.out.println("  " + p);

        System.out.println("Citas (" + cs.size() + "):");
        for (Cita c : cs) System.out.println("  " + c);
    }
}
