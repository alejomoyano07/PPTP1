//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);

    Estudiante estudiante1= new Estudiante("53430","Alejo");
    Estudiante estudiante2= new Estudiante("47876","Martin");
    Estudiante estudiante3= new Estudiante("23456","Santiago");

    Eventouniversitario evento1= new Eventouniversitario("0001","evento1",0.0,false);

    Sala sala1=new Sala(1,"Sala 7");

    evento1.asignarsala(sala1);

    evento1.crearActividad(1,"Programacion en Java",20,"taller");
    evento1.crearActividad(2,"Historia de compuadoras",50,"charla");

    evento1.getActividades().get(0).inscribir(estudiante1);
    evento1.getActividades().get(0).inscribir(estudiante2);
    evento1.getActividades().get(1).inscribir(estudiante2);
    evento1.getActividades().get(1).inscribir(estudiante3);

    evento1.mostrardatos();




}


