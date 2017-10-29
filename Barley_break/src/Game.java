import java.lang.Math;
import java.util.Random;
public class Game {
    public int[][] gameField;
    public int sizeField;
    // Конструктор, который работает с цифрами
    public Game(int[] valueForPlay)
    {
        valueForPlay = FullMassive(valueForPlay);
        if (IsExsistGameField(valueForPlay))
        {
            sizeField = (int) Math.sqrt(valueForPlay.length);
            int temp = 0;

            gameField = new int[sizeField][sizeField];
            for (int i = 0; i < gameField[0].length; i++)
            {
                for (int j = 0; j < gameField[1].length; j++)
                {
                    gameField[i][j] = valueForPlay[temp];
                    temp++;
                }
            }
            GenerationNumbersOnField();
        }
        else
        {
            System.out.println("Not exists game field");
        }
    }

    private static int[] FullMassive(int[] valueForPlay){

        for(int i = 0; i < valueForPlay.length; i++){
            valueForPlay[i] = i;
    }

        return valueForPlay;
    }

    public static boolean IsExsistGameField(int[] valueForPlay)
    {
        int count = 0;

        if (Math.sqrt(valueForPlay.length) % 1 == 0)
        {
            count = 1;
        }
        //=====================
        int zeroCount = 0;
        for (int i = 0; i < valueForPlay.length; i++)
        {
            if (valueForPlay[i] == 0)
            {
                zeroCount ++;
            }
        }

        for (int i = 0; i < valueForPlay.length; i++)
        {
            for (int j = 0; j < valueForPlay.length; j++)
            {
                if (i < j)
                {
                    if (valueForPlay[i] == valueForPlay[j])
                    {
                        return false;
                    }
                }
            }
        }

        if ((count == 1) && (zeroCount == 1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void GenerationNumbersOnField()
    {
        Random gen = new Random();
        int temp = 0;

        for (int i = 0; i < gameField[0].length; i++)
        {
            for (int j = 0; j < gameField[1].length; j++)
            {
                int x = gen.nextInt(sizeField); // 1234
                int y = gen.nextInt(sizeField); // 56780
                temp = gameField[x][y];
                gameField[x][y] = gameField[i][j];
                gameField[i][j] = temp;
            }
        }
    }
    private int[] GetLocation(int moveValue)
    {
        for (int i = 0; i < gameField[0].length; i++)
        {
            for (int j = 0; j < gameField[1].length; j++)
            {
                if (gameField[i][j] == moveValue)
                {
                    int[] location = {i,j};
                    return location;
                }
            }
        }

        return null;
    }
    public boolean Shift(int moveValue)
    {
        int count = 0;
        int temp = 0;
        int[] massiveZero;
        int[] massiveMoveValue;

        massiveZero = GetLocation(0);
        massiveMoveValue = GetLocation(moveValue);

        if ((massiveMoveValue != null) && (Math.sqrt(Math.pow(massiveMoveValue[0] - massiveZero[0], 2) + Math.pow(massiveMoveValue[1] - massiveZero[1], 2)) == 1))
        {
            // Перемещение
            temp = gameField[massiveMoveValue[0]][massiveMoveValue[1]];
            gameField[massiveMoveValue[0]][massiveMoveValue[1]] = gameField[massiveZero[0]][massiveZero[1]];
            gameField[massiveZero[0]][massiveZero[1]] = temp;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean CheckWin()
    {
        int[] numbers = new int[gameField.length * gameField.length];
        int count = 0;
        //=======================================
        for (int i = 0; i < gameField[0].length; i++)
        {
            for(int j = 0; j < gameField[1].length; j++)
            {
                numbers[count] = gameField[i][j];
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = 0; j < numbers.length; j++)
            {
                if (numbers[numbers.length - 1] == 0)
            {
                if ((i == numbers.length - 1) || (j == numbers.length - 1))
                {
                }
                else
                {
                    if (j > i)
                    {
                        if (numbers[i] > numbers[j])
                        {
                            return false;
                        }
                    }
                }
            }
            else
            {
                return false;
            }
            }
        }
        return true;
        //==================================
    }
}
