/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.service;

import clinic.domain.Cita;
import clinic.domain.Doctor;
import clinic.domain.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

// Aquí vive la lógica: altas, crear cita y listados.
// Todo en memoria (listas). Reglas: nada en pasado y sin choques de horario.
public class Agenda {
    private final List<Doctor> doctores = new ArrayList<>();
    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<Cita> citas = new ArrayList<>();

    private int nextDoctorId = 1;
    private int nextPacienteId = 1;
    private int nextCitaId = 1;

    // ---- Altas ----
    public Doctor altaDoctor(String nombre, String especialidad) {
        Doctor d = new Doctor(nextDoctorId++, nombre, especialidad);
        doctores.add(d);
        return d;
    }

    public Paciente altaPaciente(String nombre, String telefono, String email) {
        Paciente p = new Paciente(nextPacienteId++, nombre, telefono, email);
        pacientes.add(p);
        return p;
    }

    // ---- Crear Cita ----
    public Cita crearCita(int doctorId, int pacienteId, String fechaAAAA_MM_DD, String horaHH_MM, String motivo) {
        Doctor d = buscaDoctor(doctorId);
        Paciente p = buscaPaciente(pacienteId);
        if (d == null || p == null) throw new IllegalArgumentException("Doctor/Paciente inexistente");

        LocalDate fecha = LocalDate.parse(fechaAAAA_MM_DD); // AAAA-MM-DD
        LocalTime hora = LocalTime.parse(horaHH_MM);         // HH:MM (24h)
        LocalDateTime fh = LocalDateTime.of(fecha, hora);

        if (fh.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("No se permiten fechas pasadas");
        }
        if (hayConflicto(doctorId, pacienteId, fh)) {
            throw new IllegalStateException("Conflicto: doctor/paciente ocupado en ese horario");
        }

        Cita c = new Cita(nextCitaId++, doctorId, pacienteId, fh, motivo);
        citas.add(c);
        return c;
    }

    // ---- Listar (para verificar que todo se guarda) ----
    public List<Doctor> listarDoctores() { return Collections.unmodifiableList(doctores); }
    public List<Paciente> listarPacientes() { return Collections.unmodifiableList(pacientes); }
    public List<Cita> listarCitas() { return Collections.unmodifiableList(citas); }

    // ---- Helpers ----
    private Doctor buscaDoctor(int id) {
        for (Doctor d : doctores) if (d.getId() == id) return d;
        return null;
    }
    private Paciente buscaPaciente(int id) {
        for (Paciente p : pacientes) if (p.getId() == id) return p;
        return null;
    }
    private boolean hayConflicto(int doctorId, int pacienteId, LocalDateTime fh) {
        for (Cita c : citas) {
            boolean mismaFechaHora = c.getFechaHora().equals(fh);
            if (mismaFechaHora && (c.getDoctorId() == doctorId || c.getPacienteId() == pacienteId)) {
                return true;
            }
        }
        return false;
    }
}
