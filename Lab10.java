import java.util.Random;
import java.util.Scanner;

public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }
            
            double a, b ,r;

            if (input.equals("square")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the square is: " + a * 4);
                System.out.println("The area of the square is: " + a * a);

            } else if (input.equals("rectangle")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the length of side b: ");
                b = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the rectangle is: " + (2 * a + 2 * b));
                System.out.println("The area of the rectangle is: " + (a * b));
            } else if (input.equals("circle")) {
                System.out.println("Enter the radius: ");
                r = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the circle is: " + (Math.PI * r * 2));
                System.out.println("The area of the circle is: " + (Math.PI * r * r));
            }
        }
    }

    public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        int num = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());
        

    
            if(num <= 28)
            {
                if(num2 == 2)
                {
                    System.out.print("You selected " + num2 + " of February");
                }
            }
            if(num <= 29)
            {
                if(num2 == 2)
                {
                    System.out.println("Enter the current year");
                    int num3 = Integer.parseInt(scan.nextLine());
                    {
                      if(num3 % 4 == 0)
                        {
                        System.out.print("You selected " + num2 + " of February");
                        }  
                    }
                }
            }
            if(num <= 30)
            {

                if(num2 == 4)
                {
                    System.out.print("You selected " + num2 + " of April");
                }
                if(num2 == 6)
                {
                    System.out.print("You selected " + num2 + " of June");
                }
                if(num2 == 9)
                {
                    System.out.print("You selected " + num2 + " of September");
                }
                if(num2 == 11)
                {
                    System.out.print("You selected " + num2 + " of November");
                }
            }
            if(num <= 31)
            {
                if(num2 == 1)
                {
                    System.out.print("You selected " + num2 + " of January");
                }
                if(num2 == 3)
                {
                    System.out.print("You selected " + num2 + " of March");
                }
                if(num2 == 5)
                {
                    System.out.print("You selected " + num2 + " of May");
                }
                if(num2 == 7)
                {
                    System.out.print("You selected " + num2 + " of July");
                }
                if(num2 == 8)
                {
                    System.out.print("You selected " + num2 + " of August");
                }
                if(num2 == 10)
                {
                    System.out.print("You selected " + num2 + " of October");
                }
                if(num2 == 12)
                {
                    System.out.print("You selected " + num2 + " of December");
                }
                
            }
            if(num > 31 || num2 > 12)
            {  
                System.out.print("Invalid");
            }
                
            }
            
            
                
            
                

        
       

public static void Q3() {
    System.out.println("Q3: Enter how many numbers you want to check for primality: ");
    int n = Integer.parseInt(scan.nextLine());
    int counter = 0;
    
    for (int i = 1; i <= n; i++) 
    {
        if( n % i == 0)
        {
            counter++;
        }
    }
     System.out.println("There are: " + counter + " primes between 0 and " + n);
}

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int attempt = 0;

        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }

            if (doAttack) {
                attempt++;
                int attackRoll = rng.nextInt(0,21);
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if(check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if(check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if(check) {
                        System.out.print(" (buffed attack)");
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + attempt + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}


