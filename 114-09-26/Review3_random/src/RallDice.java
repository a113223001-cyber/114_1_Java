import java.security.SecureRandom;


public class RallDice {
    public static void main(String[] arges){
        SecureRandom randomNumbers = new SecureRandom();

        int[] frequency = new int[7]; // array of hold frequency of dice rolls(1-6)

        for(int roll = 0; roll <= 60000000; roll++){
            int face = 1 + randomNumbers.nextInt(6); // random number from 1 to 6
            frequency[face]++; // increment the appropriate frequency
        }
        System.out.printf("%s%10s%n", "點數", "出現次數");
        for(int face = 1; face < frequency.length; face++){
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }
    }
}
