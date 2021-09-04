import static org.junit.jupiter.api.Assertions.*;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

class BoardTest {

	JLabel s = new JLabel("");
	JLabel t = new JLabel("");
	int h=5;
	int w=5;
	int m=2;
	
	
	@Test
	void BeginnerFileExist() {
		
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("Beginner.txt"));
			assertNotNull(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testBoard() {
		
		
		Board a = new Board(s, t, w, h, m);
		Board b = new Board(s, t, w, h, m);
		
		assertEquals(a.getSize(),b.getSize());
	}
	
	@Test
	void componentCountTest() {
		
		
		
		Board a = new Board(s, t, w, h, m);
		Board b = new Board(s, t, w, h, m);
		
		assertEquals(a.getComponentCount(),b.getComponentCount());
	}
	
	@Test
	void IntermediateFileExist() {
		
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("Intermediate.txt"));
			assertNotNull(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void layoutTest() {	
		
		Board a = new Board(s, t, w, h, m);
		assertNotNull(a.getLayout());
	}
	
	@Test
	void checkClassID() {	
		Board a = new Board(s, t, w, h, m);
		Board b = new Board(s, t, w, h, m);
		assertEquals(a.getUIClassID(),b.getUIClassID());
	}
	
	@Test
	void masterFileExist() {
		
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("Master.txt"));
			assertNotNull(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void widthTest() {
            var ex = new Minesweeper();
            ex.setVisible(true);
            assertEquals(400,ex.getWidth());      
	}
	
	@Test
	void heightTest(){
            var ex = new Minesweeper();
            ex.setVisible(true);
            assertEquals(400,ex.getHeight());      
	}
	
	@Test
	void isObjectCrested(){
            var ex = new Minesweeper();
           
            assertNotNull(ex);      
	}
}
