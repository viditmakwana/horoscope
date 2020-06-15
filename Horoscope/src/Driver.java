import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This class creates the GUI with radio buttons for the different zodiac signs
 * and shows the respective message.
 * 
 * @author Vidit Makwana
 *
 */
public class Driver extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	JTextArea message;
	DailyHoroscope today;

	/**
	 * This constructor creates the radio buttons, panel, and text for the GUI.
	 */
	public Driver() {
		super(new BorderLayout());
		today = new DailyHoroscope();
		ButtonGroup group = new ButtonGroup();
		JRadioButton aries = new JRadioButton("Aries");
		aries.addActionListener(this);
		group.add(aries);
		JRadioButton taurus = new JRadioButton("Taurus");
		taurus.addActionListener(this);
		group.add(taurus);
		JRadioButton gemini = new JRadioButton("Gemini");
		gemini.addActionListener(this);
		group.add(gemini);
		JRadioButton cancer = new JRadioButton("Cancer");
		cancer.addActionListener(this);
		group.add(cancer);
		JRadioButton leo = new JRadioButton("Leo");
		leo.addActionListener(this);
		group.add(leo);
		JRadioButton virgo = new JRadioButton("Virgo");
		virgo.addActionListener(this);
		group.add(virgo);
		JRadioButton libra = new JRadioButton("Libra");
		libra.addActionListener(this);
		group.add(libra);
		JRadioButton scorpio = new JRadioButton("Scorpio");
		scorpio.addActionListener(this);
		group.add(scorpio);
		JRadioButton sagittarius = new JRadioButton("Sagittarius");
		sagittarius.addActionListener(this);
		group.add(sagittarius);
		JRadioButton capricorn = new JRadioButton("Capricorn");
		capricorn.addActionListener(this);
		group.add(capricorn);
		JRadioButton aquarius = new JRadioButton("Aquarius");
		aquarius.addActionListener(this);
		group.add(aquarius);
		JRadioButton pisces = new JRadioButton("Pisces");
		pisces.addActionListener(this);
		group.add(pisces);
		JPanel radioPanel = new JPanel(new GridLayout(1, 0));
		radioPanel.add(aries);
		radioPanel.add(taurus);
		radioPanel.add(gemini);
		radioPanel.add(cancer);
		radioPanel.add(leo);
		radioPanel.add(virgo);
		radioPanel.add(libra);
		radioPanel.add(scorpio);
		radioPanel.add(sagittarius);
		radioPanel.add(capricorn);
		radioPanel.add(aquarius);
		radioPanel.add(pisces);
		message = new JTextArea();
		message.setFont(new Font(Font.MONOSPACED, 15, 15));
		message.setText("");
		message.setLineWrap(true);
		add(radioPanel, BorderLayout.LINE_START);
		add(message, BorderLayout.SOUTH);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/**
	 * This method satisfies the requirements for the ActionListener interface and
	 * sets the textArea to the message generated from the DailyHoroscope class.
	 * 
	 * @param ActionEvent e
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			message.setText(today.getMessage(e.getActionCommand()));
		} catch (IOException i) {
		}
	}

	/**
	 * This method creates the frame for the GUI and sets the content with what is
	 * in the constructor.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Daily Horoscope");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new Driver();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.setPreferredSize(new Dimension(1500, 400));
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * This is the main method for the project and spawns the Event Dispatching
	 * Thread for the GUI.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
