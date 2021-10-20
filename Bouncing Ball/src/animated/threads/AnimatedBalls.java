package animated.threads;

import static animated.threads.Constants.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimatedBalls {

	public static void main(String[] args) {
		
		Ball roedBall = new Ball(Color.RED, randomXY(), randomXY());
		Ball blaaBall = new Ball(Color.BLUE, randomXY(), randomXY());
		Ball gronBall = new Ball(Color.GREEN, randomXY(), randomXY());
		
		JPanel ballArea = new JPanel();
		ballArea.setLayout(null);
		ballArea.add(roedBall);
		ballArea.add(blaaBall);
		ballArea.add(gronBall);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(PANE_SIZE, PANE_SIZE);
		frame.add(ballArea);
		
		frame.setVisible(true);
		new Thread(() -> roedBall.animate()).start();
		new Thread(() -> blaaBall.animate()).start();
		new Thread(() -> gronBall.animate()).start();
	}

	private static int randomXY() {
		return (int) Math.round((Math.random() * MAX_VX_VY));
	}

}