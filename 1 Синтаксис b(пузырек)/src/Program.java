import java.lang.reflect.Array;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int[] arr = new int[100];

        arr = FullMassive(arr);
        arr = StartGame(arr);

        for (int i  = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    static int[] FullMassive(int[] arr){
        Random gen = new Random();
        for (int i  = 0; i < arr.length; i++){
            arr[i] = gen.nextInt(100);
        }

        return arr;
    }

    static int[] StartGame(int[] arr)
    {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}
