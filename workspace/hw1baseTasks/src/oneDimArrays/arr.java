package oneDimArrays;

public class arr 
{
	// Найти минимальный элемент массива
	
	public static int min(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		for(int i = 1; i < a.length; i++)
			if(a[0] > a[i])
				a[0] = a[i];
		return a[0];
	}
	// Найти максимальный элемент массива
	
	public static int max(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		for(int i = 1; i < a.length; i++)
			if(a[0] < a[i])
				a[0] = a[i];
		return a[0];
	}
	// Найти индекс минимального элемента массива
	
	public static int minIndex(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		int min = 90000;
		for(int i = 0; i < a.length; i++)
			if(a[i] < min)
				min = a[i];

		for(int j = 0; j < a.length; j++)
		{
			if(a[j] == min)
			{
				min = j;
				break;
			}
		}
		return min;
	}
	// Найти индекс максимального элемента массива
	
	public static int maxIndex(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		int max = -90000;
		for(int i = 0; i < a.length; i++)
			if(a[i] > max)
				max = a[i];
		
		for(int j = 0; j < a.length; j++)
		{
			if(a[j] == max)
			{
				max = j;
				break;
			}
		}
		return max;
	}
	// Посчитать сумму элементов массива с нечетными индексами
	
	public static int sumNI(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		int sum = 0;
		for(int i = 1; i < a.length; i +=2)
				sum += a[i];
		return sum;
	}
	// Сделать реверс массива
	
	public static int[] revers(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		for(int i = 0; i < a.length/2; i++)
		{
			int temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
		return a;
	}
	// Посчитать количество нечетных элементов массива
	
	public static int numNechet(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		int b = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i]%2 != 0)
				b++;
		}
		return b;
	}
	// Поменять местами первую и вторую половину массива
	
	public static int[] exchange(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		for(int i = 0; i < a.length/2; i++)
		{
			if(a.length%2 != 0)
			{
				int temp = a[i];
				a[i] = a[a.length/2 + i + 1];
				a[a.length/2 + i + 1] = temp;
			}
			else
			{
			int temp = a[i];
			a[i] = a[a.length/2 + i];
			a[a.length/2 + i] = temp;
			}
		}
		return a;
	}
	// Отсортировать массив BUBBLE
	
	public static int[] bubble(int[] a)
	{
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		
		for(int i = a.length - 1; i > 0; i--)
		for(int j = 0; j < i; j++)
			if( a[j] > a[j + 1])
			{
				int temp = a[j];
				a[j] = a[j + 1];
				a[j+1] = temp;
			}
			
		return a;
	}
	// Отсортировать массив SELECT
	
	public static int[] select(int[] a)
	{
		 if (a == null || a.length == 0)
	            throw new IllegalArgumentException();
		 
		for (int i = 0; i < a.length - 1; i++) 
		{
			 	int least = i;
			 	for (int j = i + 1; j < a.length; j++) 
			 	{
			 	    if(a[j] < a[least]) 
			 			least = j;
			 		}
			 	int tmp = a[i];
					a[i] = a[least];
			 		a[least] = tmp;
			}
		return a;
	}
	// Отсортировать массив INSERT
	
	public static int[] insert(int[] a) 
	{
		 if (a == null || a.length == 0)
	            throw new IllegalArgumentException();
		 
	    int temp, j;
	    for(int i = 0; i < a.length - 1; i++)
	    {
	        if (a[i] > a[i + 1]) 
	        {
	           temp = a[i + 1];
	           a[i + 1] = a[i];      
	           j = i;
	           while (j > 0 && temp < a[j - 1]) 
	           {
	               a[j] = a[j - 1];               
	               j--;
	           }
	           a[j] = temp;             
	        }        
	    }
	    return a;
	}
	// Отсортировать массив QUICK
	
	public static int[] quickS(int[] array, int low, int high) 
	{
        if (array == null || array.length == 0)
            throw new IllegalArgumentException();
 
        if (low >= high)
            return array;
 
        int middle = (high + low) / 2;
        int opora = array[middle];
 
        int i = low, j = high;
        while (i < j) 
        {
            while (array[i] < opora) 
            {
                i++;
            }
 
            while (array[j] > opora) 
            {
                j--;
            }
 
            if (i <= j) 
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
 
        if (low < j)
            quickS(array, low, j);
 
        if (high > i)
            quickS(array, i, high);
        
        return array;
    }
	// Отсортировать массив MERGE
	
	
	/*public static void main(String[] args)
	{
		int[] a = {1,5,7,4,3,6,7,8,43,6,345,457,34,534};
		a = (a);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	} */
}
