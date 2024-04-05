package screenmatch;

public class ScreenMatch {
    public static void main(String[] args) {
        System.out.println("Bienvenida(o) a Screen Match");
        System.out.println("Pelicula: Matrix");
        
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.2;
        double media = (notaDeLaPelicula + 6.0 + 9.0) / 3;
        
        System.out.println("Media: " + media);
        
        String disponible = incluidoEnElPlan ? "Disponible en tu plan" : "No disponible tu plan";        
        String sinopsis = "Matrix es una paradoja\nLa mejor película del fin del milenio\nFué lanzada en: "
                + fechaDeLanzamiento + "\n" + disponible;
        
        System.out.println(sinopsis);
        
        int clasificacion = (int) (media / 2);
        
        System.out.println("Clasificación: " + clasificacion);
    }
}