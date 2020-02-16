import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	//����ͼƬ
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; //С�������
	double y = 100; //С��������
	boolean right = true; //true����С�������ƶ�  false����С�������ƶ�
	
	//���� paint
	public void paint(Graphics g) {
		
		if(x > 856-40-30) { //856 ���ڿ��   40���ӱ߿�Ŀ��   30С��ֱ�� 
			right = false;
		}
		if(x < 40) {
			right = true;
		}
		
		if(right) {
			x = x + 10;
		}else {
			x = x - 10;
		}
		
		System.out.println("���ڱ�����һ��!");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball, (int)x, (int)y,null);
	
	}
	
	//���ִ��� ���ڼ���
	void launchFrame() {
		setSize(856,500);
		setLocation(400,400);
		setVisible(true);
		
		//�ػ����� ÿ�뻭25��
		while(true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("����ѧ��ѧ�õ�java�̳�");
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
