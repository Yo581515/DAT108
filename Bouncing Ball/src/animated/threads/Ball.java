package animated.threads;

import static animated.nothreads.Constants.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Ball extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Color color;
	int diameter;
	long delay;
	private int vx;
	private int vy;

	public Ball(Color color, int xvelocity, int yvelocity) {
		this.color = color;
		diameter = BALL_DIAMETER;
		delay = SLEEP_TIME;

		vx = xvelocity;
		vy = yvelocity;

		setSize(getPreferredSize());
		setLocation((int) Math.round((Math.random() * PANE_SIZE) - BALL_DIAMETER),
				(int) Math.round((Math.random() * PANE_SIZE) - BALL_DIAMETER));
		
	}
	
	public void animate() {
		while (isVisible()) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			}
			move();
			repaint();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(color);
		g.fillOval(0, 0, BALL_DIAMETER-1, BALL_DIAMETER-1);
		g.setColor(Color.black);
		g2.drawOval(0, 0, BALL_DIAMETER-1, BALL_DIAMETER-1);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(BALL_DIAMETER, BALL_DIAMETER);
	}

	public void move() {

		int x = getX();
		int y = getY();

		if (x + vx < 0 || x + diameter + vx > getParent().getWidth()) {
			vx *= -1;
		}
		if (y + vy < 0 || y + diameter + vy > getParent().getHeight()) {
			vy *= -1;
		}
		x += vx;
		y += vy;

		setLocation(x, y);

	}
}

