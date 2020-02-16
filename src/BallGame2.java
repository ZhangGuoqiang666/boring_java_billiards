import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	//����ͼƬ
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; //С�������
	double y = 100; //С��������
	double degree = 3.14/3; //���� 60�Ƚ�
	
	//���� paint
	public void paint(Graphics g) {
		
		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		
		//�������±߽�  ����x��Գ�
		if(y>500-40-30||y<40+40) { //500�Ǵ��ڸ߶� 40�����ӱ߿� 30����ֱ�� ���һ��40�Ǳ������ĸ߶�
			degree = -degree;
		}
		
		//�������ұ߽� ����y��Գ�
		if(x<0+40||x>856-40-30) {
			degree = 3.14 - degree;
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
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
