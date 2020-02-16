import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame{
	
	//加载图片
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; //小球横坐标
	double y = 100; //小球纵坐标
	double degree = 3.14/3; //弧度 60度角
	
	//绘制 paint
	public void paint(Graphics g) {
		
		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		
		//碰到上下边界  关于x轴对称
		if(y>500-40-30||y<40+40) { //500是窗口高度 40是桌子边框 30是球直径 最后一个40是标题栏的高度
			degree = -degree;
		}
		
		//碰到左右边界 关于y轴对称
		if(x<0+40||x>856-40-30) {
			degree = 3.14 - degree;
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
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
