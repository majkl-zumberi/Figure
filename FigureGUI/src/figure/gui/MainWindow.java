package figure.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import figure.model.Rettangolo;

public class MainWindow extends JFrame {

//	public static int somma(int a,int b) {return a+b;}
	Rettangolo rett;
	boolean start=true;
	boolean thread=true;
	Color colore =Color.pink;
	JPanel pnl1;
	public MainWindow() {
		super("Figure geometriche");
		rett = new Rettangolo(10, 10, 200, 100);
		// System.out.println(somma(10,5));
		setSize(500, 500);
		pnl1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
//				g.setColor(Color.PINK);
				g.setColor(colore);
				g.fillRect(rett.getX(), rett.getY(), rett.getBase(), rett.getAltezza());
			}
			
			
		};
		this.add(pnl1);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		Thread t = new Thread() {
			
			boolean dirDx = true;
			
			@Override
			public void run() {
				thread=true;
				while (true) {
					if (rett.getX() >= getWidth() - rett.getBase()) {
//						rett.setX(0);
						dirDx = false;
					}
					if (rett.getX() < 0) {
						dirDx = true;
					}
					if(thread) {
						rett.setX(rett.getX() + (dirDx ? 5 : -5));
					}
					
					pnl1.repaint();
					pnl1.invalidate();
					repaint();
					invalidate();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		setLayout(null);
		JButton b = new JButton("colora rettangolo");
		JButton b1 = new JButton("start");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(MainWindow.this, "ciao");
				if(colore==Color.pink) {
					colore=Color.blue;
				}
				else {
					colore=Color.pink;
				}
			}
		});
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thread=!thread;
				if(thread) {
					b1.setText("Play");
//					t.start();
				}
				else {
					b1.setText("Stop");
//					t.stop();
				}
				
				
			}
		});
		b.setSize(120,50);
		b1.setSize(120,50);
		b.setLocation(10, 400);
		b1.setLocation(130, 400);
		pnl1.setSize(400, 400);
		pnl1.setBackground(Color.black);
		add(b);
		add(b1);
		MyKeyListener l1=new MyKeyListener(this);
		b.addKeyListener(l1);
		b1.addKeyListener(l1);
		this.setVisible(true);
//		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
class MyKeyListener implements KeyListener{
	private MainWindow mainWindow;
	public MyKeyListener(MainWindow mainWindow){
		this.mainWindow=mainWindow;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("tasto cliccato: su");
			mainWindow.rett.setY(mainWindow.rett.getY() - 5);
			mainWindow.pnl1.repaint();
			mainWindow.pnl1.invalidate();
			mainWindow.repaint();
			mainWindow.invalidate();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("tasto cliccato: giu");
			mainWindow.rett.setY(mainWindow.rett.getY() + 5);
			mainWindow.pnl1.repaint();
			mainWindow.pnl1.invalidate();
			mainWindow.repaint();
			mainWindow.invalidate();
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("tasto cliccato: Sinistra");
			mainWindow.rett.setX(mainWindow.rett.getX() - 5);
			mainWindow.pnl1.repaint();
			mainWindow.pnl1.invalidate();
			mainWindow.repaint();
			mainWindow.invalidate();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("tasto cliccato: Destra");
			mainWindow.rett.setX(mainWindow.rett.getX() + 5);
			mainWindow.pnl1.repaint();
			mainWindow.pnl1.invalidate();
			mainWindow.repaint();
			mainWindow.invalidate();
			break;
		}
	}
	
}