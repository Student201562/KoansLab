import java.util.Scanner;


public class Program {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        int[] gameField = new int[9];

        Game game = new Game(gameField);
        System.out.println("\n\n\n\n\n\n");
        Print.PrintGameField(game);

        StartGame(game);

        System.out.println("Вы выиграли!");
        System.out.print("Если вы хотите сыграть еще раз, намите Y = ");
    }

    static void StartGame(Game game)
    {
        while (!game.CheckWin())
        {
            System.out.print("\t\tВведите значение, которое хотите поменять = ");
            int moveValue = in.nextInt();

            System.out.println("\n\n\n");
            if (!game.Shift(moveValue))
            {
                System.out.println("\t\tНекорректные данные!!!");
            }
            Print.PrintGameField(game);
        }
    }
}
