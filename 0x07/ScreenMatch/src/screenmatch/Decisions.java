package screenmatch;

public class Decisions {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.2;
        String tipoPlan = "plus";
        
        if (fechaDeLanzamiento > 2022) {
            System.out.println("Péliculas más populares");
        } else {
            System.out.println("Pélicula retro que aún vale la pena ver");
        }
        
        if (incluidoEnElPlan && tipoPlan.equals("plus") ) {
            System.out.println("Disfrute de su película");
        }else{
            System.out.println("Película no disponible para su plan actual");
        }
    }
}
