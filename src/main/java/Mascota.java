import com.fasterxml.jackson.annotation.JsonProperty;

public class Mascota {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("especie")
    private String especie;

    @JsonProperty("edad")
    private int edad;

    public Mascota( String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    public Mascota(){}

    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Especie: " + especie + ", Edad: " + edad;
    }
}