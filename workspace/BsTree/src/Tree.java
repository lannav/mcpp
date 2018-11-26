
public interface Tree 
{
	void clear();
	void init(int[] ini);
	void add(int val);
	int size();
	int nodes();
	int leaves();
	int height();
	int[] toArray();
	void del(int val);
	int width();
	String toString();
	void reverse();
	boolean equals(BS_Tree_Linked tr);
	boolean check();
}
