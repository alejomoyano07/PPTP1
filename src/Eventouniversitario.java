import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Eventouniversitario {
    private final String id;
    private String titulo;
    private double costobase;
    private boolean gratuitos;
    private static int cantidadeventos=0;
    private Sala sala;
    private List<Actividad> actividades;



    public Eventouniversitario (String id,String titulo, double costobase, boolean gratuitos){
        this.id=id;
        this.titulo=titulo;
        this.costobase=costobase;
        this.gratuitos=gratuitos;
        cantidadeventos++;
        this.actividades=new ArrayList<>();
    }

    public String getId (){return id;}

    public String getTitulo(){return titulo;}

    public void setTitulo(String titulo){
        if (titulo==null||titulo.isEmpty()||titulo.isBlank()){
            ;System.out.println ("Nombre titulo invalido");
            return;
        }
        this.titulo=titulo;
    }

    public double getCostobase(){return costobase;}

    public void setCostobase(double costobase){
        if (gratuitos==true){
            System.out.println("El evento es gratuito");
            return;
        } else if (costobase<0.0) {
            System.out.println("Numero invalido");
            return;
        }
        this.costobase=costobase;
    }

    public boolean getGratuitos (){return gratuitos;}

    public void setGratuitos(boolean gratuitos){this.gratuitos=gratuitos;}

    public int getCantidadeventos(){return cantidadeventos;}

    public Eventouniversitario(Eventouniversitario otro){
        this.id=otro.id;
        this.titulo=otro.titulo;
        this.costobase=otro.costobase;
        this.gratuitos=otro.gratuitos;
        cantidadeventos++;
    }
    public double calcularestimado(){
        double costototal=costobase;
        if (gratuitos==false){
            for(Actividad actividad:actividades){
                costototal+=actividad.calcularcostomateriales();
            }
            return costototal*1.21;
        }
        return 0.0;
    }
    public void asignarsala(Sala sala){
        this.sala=sala;
    }

    public Sala getSala(){return sala;}
    public void crearActividad(int id, String titulo, int cupo, String tipoactividad) {
        Scanner scanner = new Scanner(System.in);
        switch (tipoactividad) {
            case "charla":
                System.out.println("Ingrrese el nombre del disertante para la charla " + titulo + " : ");
                String disertante = scanner.nextLine();
                Actividad charla = new Charla(id, titulo, cupo, disertante);
                this.actividades.add(charla);
                break;
            case "taller":
                System.out.println("El taller " + titulo + " requier el uso de notebook? :");
                String respuesta = scanner.nextLine().trim().toLowerCase();
                boolean requierenotebook = false;
                if (respuesta.equals("s") || respuesta.equals("Si")||respuesta.equals("si")) {
                    requierenotebook = true;
                }
                Actividad taller = new Taller(id, titulo, cupo, requierenotebook);
                this.actividades.add(taller);
                break;
            default:
                System.out.println("Tipo de actividad no reconocido");
        }
    }
    public List<Actividad> getActividades(){
        return Collections.unmodifiableList(actividades);
    }
    public void mostrardatos(){
        System.out.println("Id: "+getId());
        System.out.println("Titulo: "+getTitulo());
        System.out.println("Costo: "+calcularestimado());
        System.out.println("Gratuito: "+getGratuitos());
        System.out.println("Sala : "+sala.getNombre()+"  id : "+sala.getId());
        System.out.println("Actividades: ");
        for (Actividad actividad: actividades){
            System.out.println("id: "+actividad.getId()+" Titutlo: "+actividad.getTitulo()+" Cupos: "+actividad.getCupomaximo());
            actividad.mostarInscripciones();
        }
        System.out.println("Cantidad de eventos: "+getCantidadeventos());
    }
}
