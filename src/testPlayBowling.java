import static org.junit.Assert.*;

import org.junit.Test;

public class testPlayBowling{

	@Test
	public void testStringReturn() {
		PlayBowling b = new PlayBowling();
		String s = "Bonjour";
		String s2 = b.stringReturn(s);
		assert(s.equals(s2));
	}
	
	
	
	@Test
	public void testScoreBasic() {
		PlayBowling b = new PlayBowling(3);
		int score = b.scoreBasic();
		System.out.println(score);
		assert(score==0);
		
	}
	
	
	@Test
	public void testTailleTableau() {
		PlayBowling b = new PlayBowling(12);
		assert(b.table.size()<=10);
		
	}
	
	@Test
	public void testScoreSupZero() {
		PlayBowling b = new PlayBowling();
		
		for (int i=0; i<b.size; i++){
			assert(b.table.get(i).get(0)>=0);
			assert(b.table.get(i).get(1)>=0);
		}
		
	}
	
	
	@Test
	public void testSumTuple() {
		PlayBowling b = new PlayBowling();
		
		for (int i=0; i<b.size; i++){
			assert(b.table.get(i).get(0)+b.table.get(i).get(1)>=10);
		}
		
	}
	
	@Test
	public void testAddTuple() {
		PlayBowling b = new PlayBowling();
		boolean add1 = b.addTuple(3, -2);
		System.out.println("Taille = "+ b.table.size());
		boolean add2 = b.addTuple(3, 7);
		boolean add3 = b.addTuple(9, 2);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		b.addTuple(3, 7);
		boolean add4 = b.addTuple(3, 7);
		
		assert(!add1);
		assert(add2);
		assert(!add3);
		assert(!add4);
		
	}
	
	@Test
	public void testScoreBowling() {
		PlayBowling b = new PlayBowling();
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		b.addTuple(10, 0);
		int score = b.scoreReal();
		assert(score==300);
		
		
	}
	
	

}
