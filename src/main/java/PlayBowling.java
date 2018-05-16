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
			int nrand2;
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(nrand1);
			do{
				nrand2= (int) (Math.random()* 10);
			} while(nrand1+nrand2 >10);
			l.add(nrand2);
			table.add(l);
			//System.out.println("table["+i+"][0] =" +(table.get(i)).get(0));
			//System.out.println("table["+i+"][1] =" +(table.get(i)).get(1));

		}
		size = 10;
	}
	
	public PlayBowling(){
		table = new ArrayList<ArrayList<Integer>>();
		bonus = new ArrayList<ArrayList<Integer>>();
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
		int nrand2;
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(nrand1);
		do{
			nrand2= (int) (Math.random()* 10);
		} while(nrand1+nrand2 >10);
		l.add(nrand2);
		bonus.add(l);
	}
	
	
	public int scoreBasic(){
		int sum=0;
		
		for (int i=0; i<size; i++){
			for (int j=0; j<2; j++){			
				sum+=(table.get(i)).get(j);
				//System.out.println("Somme"+i + "= "+sum); 
			}
		}
		
		return sum;
	}
	
	
	/*
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
				
	}*/
	
	
	public int scoreReal(){
		int sum=0;
		//Pour les 8 premiers Tuples
		for (int i=0; i<size-2; i++){
			int add = table.get(i).get(0)+table.get(i).get(1);
			if(add ==10){
				//on regarde si c'est un strike
				if(table.get(i).get(0) ==10){
					if(table.get(i+1).get(0) ==10){
						add+=10+table.get(i+2).get(0);
						
					}else
						add+=table.get(i+1).get(0)+table.get(i+1).get(1);
					
				}
				else{ // donc c'est spaire
					add+= table.get(i+1).get(0);
				}
			}
			sum+=add;
			System.out.println("Score"+i+ "= "+sum); 
		}
		//Pour l'avant dernier 
		if ( table.get(8).get(0)+table.get(8).get(1)==10){
			if(table.get(8).get(0)==10){
				if(table.get(9).get(0)==10){
					addBonusStrike();
					sum+=20+bonus.get(0).get(0);
				}else
					sum+=10+table.get(9).get(0)+table.get(9).get(1);
				
			}else {
				sum+=table.get(8).get(0)+table.get(8).get(1)+table.get(9).get(0);
			}
		}else{
			sum+=table.get(8).get(0)+table.get(8).get(1);
		}
		System.out.println("Score 8 = "+sum); 
		//Pour le dernier
		if ( table.get(9).get(0)+table.get(9).get(1)==10){
			if(table.get(9).get(0)==10){
				addBonusStrike();
				if(bonus.get(0).get(0)==10){
					addBonusStrike();
					sum+=20+bonus.get(1).get(0);
				}
				sum+= bonus.get(0).get(0)+bonus.get(0).get(1)+10;
			}else {
				addBonusStrike();
				sum+=table.get(9).get(0)+table.get(9).get(1)+bonus.get(0).get(0);
			}
		}else{
			sum+=table.get(9).get(0)+table.get(9).get(1);
		}
		
		System.out.println("Score 9 = "+sum); 
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
