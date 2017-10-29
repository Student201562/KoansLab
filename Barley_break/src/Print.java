public class Print {
    // Вывод игрового поля
    public static void PrintGameField(Game game) {
        for (int i = 0; i < game.sizeField; i++) {
            System.out.print("\t\t\t");
            for (int j = 0; j < game.sizeField; j++) {
                System.out.print("|");
                System.out.print(game.gameField[i][j]);
                System.out.print("| ");
            }
            System.out.println();
        }
    }
}

    /*Console.Write("|");
    Console.ForegroundColor = ConsoleColor.Black;
                    Console.Write(game[i, j]);
    Console.ForegroundColor = ConsoleColor.White;
                    Console.Write("|" +  "\t");
                    */