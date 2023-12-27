
public class TwoDarrayThreads {
    public static void main(String[] args)
    {
        int n = 5; // Number of threads
        int from = 10;
        int to = 10;
        int[][] array = new int [10][10];
        for (int i = 1; i <= n; i++) {
            Thread object
                = new Thread(new TwoDArray (array, i, 10));
            object.start();
            try
            {
                object.join(100);
            }
            catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
            }
        }

        for(int i = 0 ; i < from ; i++)
        {
            for(int j = 0; j < to ; j++)
            {
                System.out.print(array[i][j]);
            }System.out.println();
        }
    }
}

class TwoDArray implements Runnable {
    private int[][] array;
	private int from;
	private int to;

	public TwoDArray(int[][] array, int from, int to)
	{
        this.array = array;
		this.from = from;
		this.to = to;
	}
    public void run()
    {
        try {
            for(int i = from - 1; i <= from + 2 ; i++)
            {
                for(int j = 0; j < to ; j++)
                {
                    array[i][j] = 1;
                }
            }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}