package GuestRoom;

//public class 실험 {
//public static void main(String[] args) {
//   
//   
//   Thread t = new Thread();
//    
//    slowPrint("손님방에 들어왔습니다.", t);
//    
//    System.out.println();
//}
//public static void slowPrint(String str, Thread t) {
//   for (int i = 0; i < str.length(); i++) {
//          System.out.print(str.charAt(i));
//          try {
//             t.sleep(50);
//          } catch (InterruptedException e) {
//             e.printStackTrace();
//          }
//       }
//}
//
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 실험 extends JPanel implements ActionListener {
    private int xPosition = 0;
    private ImageIcon legsImageIcon;
    private Timer timer;

    public 실험() {
        legsImageIcon = new ImageIcon("10575-a64b2316ed3d9e4c.js.다운로드"); // 이미지 파일 경로를 지정하세요.

        // Timer를 사용하여 애니메이션을 구현합니다.
        timer = new Timer(100, this); // 100ms마다 actionPerformed 메서드 호출
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        legsImageIcon.paintIcon(this, g, xPosition, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xPosition += 5; // 이미지를 오른쪽으로 이동
        if (xPosition > getWidth()) {
            xPosition = -legsImageIcon.getIconWidth(); // 이미지가 화면을 벗어나면 다시 왼쪽에서 시작
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Walking Legs Animation");
        실험 walkingLegsAnimation = new 실험();
        frame.add(walkingLegsAnimation);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}