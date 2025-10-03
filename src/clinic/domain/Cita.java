/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic.domain;

import java.time.LocalDateTime;

// La cita amarra doctor + paciente + fecha/hora + motivo.
// Guardamos IDs para mantenerlo simple (sin BD en esta evidencia).
public class Cita {
    private final int id;
    private final int doctorId;
    private final int pacienteId;
    private final LocalDateTime fechaHora;
    private final String motivo;

    public Cita(int id, int doctorId, int pacienteId, LocalDateTime fechaHora, String motivo) {
        this.id = id;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public int getId() { return id; }
    public int getDoctorId() { return doctorId; }
    public int getPacienteId() { return pacienteId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getMotivo() { return motivo; }

    @Override
    public String toString() {
        return "Cita{id=" + id + ", doctorId=" + doctorId + ", pacienteId=" + pacienteId +
                ", fechaHora=" + fechaHora + ", motivo='" + motivo + "'}";
    }
}
