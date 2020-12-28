package aerorpess.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class DiceFrame extends JFrame{
	private JPanel titlePanel, dicePanel,dicePanel2, buttonPanel;
	private JButton rollButton, clearButton;
	private JTextArea ratioArea, gTArea, tempArea, methodArea, stirArea;
	private Dice d;
	
	public DiceFrame(){
		d = new Dice();
		makeTitlePanel();
		makeDicePanel();
		makeButtonPanel();
		makeMainPanel();
		setSize(1920, 1080);
		//setResizable(false);
	}
	private void makeMainPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(titlePanel, BorderLayout.NORTH);
		JPanel die = new JPanel();
		die.setLayout(new GridLayout(2,1));
		die.add(dicePanel);
		die.add(dicePanel2);
		panel.add(die, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		add(panel);
	}
	private void makeTitlePanel() {
		titlePanel = new JPanel();
		JLabel title = new JLabel("My brew today will be...");
		title.setFont(new Font("SansSerif", Font.BOLD, 36));
		titlePanel.add(title);
	}
	private void makeDicePanel() {
		dicePanel = new JPanel();
		dicePanel.setLayout(new GridLayout(1,3));
		dicePanel2 = new JPanel();
		dicePanel2.setLayout(new GridLayout(1,2));
		ratioArea = new JTextArea(10,10);
		gTArea  = new JTextArea(10,10);
		tempArea = new JTextArea(10,10);
		methodArea = new JTextArea(10,10);
		stirArea = new JTextArea(10,10);
		ArrayList<JTextArea> areaList = new ArrayList<>();
		areaList.add(ratioArea);
		areaList.add(tempArea);
		areaList.add(methodArea);
		areaList.add(gTArea);
		areaList.add(stirArea);
		int sum = 0;
		for (JTextArea area : areaList) {
			area.setEditable(true);
			area.setFont(ratioArea.getFont().deriveFont(35f));
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			Border b = new LineBorder(Color.BLACK, 2, true);
			Border margin = new EmptyBorder(10,10,10,10);
			area.setBorder(new CompoundBorder(b, margin));
			if (sum < 3) {
				dicePanel.add(area);
			}
			else {
				dicePanel2.add(area);
			}
			sum++;
		}
		
		
	}
	class RollButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			ratioArea.setText(d.rollRatio());
			tempArea.setText(d.rollTemp());
			gTArea.setText(d.rollGrindAndTime());
			methodArea.setText(d.rollMethod());
			stirArea.setText(d.rollStir());
		}
	}
	private void makeRollButton() {
		rollButton = new JButton("Generate Brew");
		ActionListener listener = new RollButtonListener();
		rollButton.addActionListener(listener);
		
	}
	class ClearButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			ratioArea.setText("");
			tempArea.setText("");
			gTArea.setText("");
			methodArea.setText("");
			stirArea.setText("");
		}
	}
	private void makeClearButton() {
		clearButton = new JButton("Clear Selections");
		ActionListener listener = new ClearButtonListener();
		clearButton.addActionListener(listener);
	}
	private void makeButtonPanel() {
		buttonPanel = new JPanel();
		makeRollButton();
		buttonPanel.add(rollButton);
		makeClearButton();
		buttonPanel.add(clearButton);
	}

}
