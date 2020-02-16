import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	//加载图片
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; //小球横坐标
	double y = 100; //小球纵坐标
	boolean right = true; //true代表小球向右移动  false代表小球向左移动
	
	//绘制 paint
	public void paint(Graphics g) {
		
		if(x > 856-40-30) { //856 窗口宽度   40桌子边框的宽度   30小球直径 
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
		
		System.out.println("窗口被画了一次!");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball, (int)x, (int)y,null);
	
	}
	
	//出现窗口 窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(400,400);
		setVisible(true);
		
		//重画窗口 每秒画25次
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
		System.out.println("我在学尚学堂的java教程");
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
