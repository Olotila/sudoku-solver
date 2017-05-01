import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class BoardTest {

	@Test
	public void testValidBoard(){
		int[][] grid = 
			{
					{4,6,3,7,2,8,9,5,1},
					{2,5,9,4,6,1,7,3,8},
					{7,8,1,3,0,9,6,4,2},
					{5,3,0,1,9,7,4,8,6},
					{9,0,4,6,8,2,5,7,3},
					{6,7,8,5,4,3,1,2,9},
					{8,2,6,9,0,5,3,1,4},
					{1,4,7,2,3,6,8,9,5},
					{3,9,5,8,1,4,2,6,7}
			};
		
		assertTrue(new Board(grid).isValid());
	}
	
	@Test
	public void testInvalidBoard(){
		int[][] grid = 
			{
					{1,1,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0}
			};
		
		assertFalse(new Board(grid).isValid());
	}
	
	@Test
	public void testCompleteBoard(){
		int[][] grid = 
			{
					{4,6,3,7,2,8,9,5,1},
					{2,5,9,4,6,1,7,3,8},
					{7,8,1,3,5,9,6,4,2},
					{5,3,2,1,9,7,4,8,6},
					{9,1,4,6,8,2,5,7,3},
					{6,7,8,5,4,3,1,2,9},
					{8,2,6,9,7,5,3,1,4},
					{1,4,7,2,3,6,8,9,5},
					{3,9,5,8,1,4,2,6,7}
			};
		
		assertTrue(new Board(grid).isComplete());
	}
	
	@Test
	public void testConstructorAccepts9by9(){
		new Board(new int[9][9]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorRejects10by10(){
		new Board(new int[10][10]);
	}
	
	@Test
	public void testToString(){
		int[][] grid = 
			{
					{1,1,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0}
			};
		
		String gridStr =
			"1 1 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n" + 
			"0 0 0 0 0 0 0 0 0\n";
		
		assertEquals(gridStr, new Board(grid).toString());
	}
}
