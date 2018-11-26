import java.util.Iterator;

public class MyIter<T> implements Iterator<T>
{
	T[]ar;
	int i = 0;
	int size;
	
	public MyIter(T[]ar)
	{
		this.ar = ar;
		size = ar.length;
	}
	@Override
	public boolean hasNext()
	{
		return (i < size);
	}

	@Override
	public T next()
	{
		return ar[i++];
	}

}
