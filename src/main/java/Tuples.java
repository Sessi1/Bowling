
public class Tuples {
	

	public int [][]table;
	public int size;
	
	public Tuples(int n){
		for (int i=0; i<n; i++){
			for (int j=0; j<2; j++){
				//int nrand= (int) Math.random();
				int nrand = i;
				table[i][j] =nrand;
			}
		}
		size =n;
	}
	
	
	
	
}
