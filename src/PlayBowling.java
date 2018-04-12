import java.util.ArrayList;
import java.util.Arrays;

public class PlayBowling {
	public ArrayList<ArrayList<Integer>> table;
	public ArrayList<ArrayList<Integer>> bonus;
	public int size;

	public PlayBowling(int n){
		table = new ArrayList<ArrayList<Integer>>();
		bonus = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<10; i++){
			int nrand1= (int) (Math.random()* 10);
			int nrand2= (int) (Math.random()* 10);
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(nrand1);
			l.add(nrand2);
			table.add(l);
			System.out.println("table["+i+"][0] =" +(table.get(i)).get(0));
			System.out.println("table["+i+"][1] =" +(table.get(i)).get(1));

			//table.add((ArrayList<Integer>) Arrays.asList(i,i));
			//System.out.println("table["+i+"]["+j+"] =" +(table.get(i)).get(j));

		}
		size = n;
	}
	
	public PlayBowling(){
		table = new ArrayList<ArrayList<Integer>>();
		size =0;
		
	}
	
	public boolean addTuple(int s1,int s2){
		if(s1 >=0 && s2>=0 && s1+s2 <= 10 && table.size()<=9){
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(s1);
			l.add(s2);
			table.add(l);
			size = table.size();
			return true;
		}
		return false;
	}
	
	public String stringReturn(String s){
		return s;
	}
	
	public void addBonusStrike()
	{
		int nrand1= (int) (Math.random()* 10);
		int nrand2= (int) (Math.random()* 10);
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(nrand1);
		l.add(nrand2);
		bonus.add(l);
	}
	
	
	public int scoreBasic(){
		int sum=0;
		
		for (int i=0; i<size; i++){
			for (int j=0; j<2; j++){			
				sum+=(table.get(i)).get(j);
				System.out.println("Somme"+i + "= "+sum); 
			}
		}
		
		return sum;
	}
	
	
	
	public int calculScore(int ind){
		int add = table.get(ind).get(0)+table.get(ind).get(1);
		if(add !=10){
			return add;
		}else{
			//on regarde si c'est un strike
			if(table.get(ind).get(0) ==10){
				add+=calculScore(ind+1);
				return add;
			}else{ // donc c'est spaire
				add+= table.get(ind+1).get(0);
				return add;
			}
		}
				
	}
	
	
	public int scoreReal(){
		int sum=0;
		//Pour les 8 premiers Tuples
		for (int i=0; i<size-2; i++){
			sum+=calculScore(i);
			System.out.println("Score"+i+ "= "+sum); 
		}
		
		if ( table.get(8).get(0)+table.get(8).get(1)==10){
			if(table.get(8).get(0)==10){
				addBonusStrike();
				addBonusStrike();
			}else {
				addBonusStrike();
			}
		}else{
			sum+=calculScore(8);
		}
		
		if ( table.get(9).get(0)+table.get(9).get(1)==10){
			if(table.get(9).get(0)==10){
				addBonusStrike();
				addBonusStrike();
			}else {
				addBonusStrike();
			}
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
