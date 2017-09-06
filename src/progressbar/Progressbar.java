package progressbar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author jay
 */
class ProgressbarExample extends JFrame implements ActionListener{
    
    private JProgressBar progress;
    private JButton button;
    private JLabel label1;
    private JPanel topPanel;
   
     public ProgressbarExample() {
        setTitle("Progress Bar Application");
        setSize(310, 130);
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(310, 130));
        getContentPane().add(topPanel);
        
   // Create a label and progress bar
        label1 = new JLabel("Waiting to start tasks...");
        label1.setPreferredSize(new Dimension(280, 24));
        topPanel.add(label1);
        progress = new JProgressBar();
        progress.setPreferredSize(new Dimension(300, 20));
        progress.setMinimum(10);
        progress.setMaximum(20);
        progress.setValue(0);
        progress.setBounds(20, 35, 260, 10);
        topPanel.add(progress);
        button = new JButton("Start");
        topPanel.add(button);
        button.addActionListener(this);
    }
         public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button) {
// Prevent more button presses
            button.setEnabled(false);
// Perform all of our bogus tasks
            for (int iCtr = 1; iCtr < 21; iCtr++) {
// Do some sort of simulated task
                DoBogusTask(iCtr);
// Update the progress indicator and label
                label1.setText("Performing task " + iCtr + " of 20");
                Rectangle labelRect = label1.getBounds();
                labelRect.x = 0;
                labelRect.y = 0;
                label1.paintImmediately(labelRect);
                progress.setValue(iCtr);
                Rectangle progressRect = progress.getBounds();
                progressRect.x = 0;
                progressRect.y = 0;
                progress.paintImmediately(progressRect);
            }
        }
    }

    public void DoBogusTask(int iCtr) {
        Random random = new Random(iCtr);
// Waste some time
        int iValue;
          for (int ver = 0; ver < random.nextFloat() * 10; ver++) {
                for (iValue = 0; iValue < random.nextFloat() * 10000; iValue++) {
                    System.out.println("iValue=" + iValue);
                }
                if(iValue == 278){
                topPanel.disable();
                }
            }
    }       
        
    public static void main(String[] args) {
        // Create an instance of the test application
        ProgressbarExample mainFrame = new ProgressbarExample();
        mainFrame.setVisible(true);
        mainFrame.pack();
    }
    
}
