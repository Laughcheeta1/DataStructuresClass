package Main;

import java.awt.EventQueue;

import Interfaces.*;

public class Main {
	public static void main(String[] argc)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPrincipal window = new PaginaPrincipal();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
