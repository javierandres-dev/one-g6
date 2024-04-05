package challenges;

public class Challenges {
    public static void main(String[] args) {
        double celsius = 10.0;
        celsius = 3.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        
        System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
    }
    
    private static double celsiusToFahrenheit(double celsius){
        return (celsius * 1.8) + 32;
    }
}