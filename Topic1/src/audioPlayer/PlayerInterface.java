package audioPlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class PlayerInterface extends JFrame implements ActionListener {
	private AudioPlayer audioPlayer;
	private JButton playButton;
	private JButton nextButton;
	private JButton previousButton;
	private JLabel currentTrack;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem goToInterface;
	private JMenuItem goToTracks;

	public PlayerInterface(AudioPlayer audioPlayer) {
		this.setAudioPlayer(audioPlayer);

		setTitle("Player");
		pack();

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		playButton = new JButton("Play");
		playButton.setName("play");
		playButton.addActionListener(this);

		nextButton = new JButton(">");
		nextButton.setName("next");
		nextButton.addActionListener(this);

		previousButton = new JButton("<");
		previousButton.setName("previous");
		previousButton.addActionListener(this);

		currentTrack = new JLabel("No track");

		menuBar = new JMenuBar();
		menu = new JMenu("GO TO");
		goToInterface = new JMenuItem("Player");
		goToTracks = new JMenuItem("Tracks");
		menu.add(goToInterface);
		menu.add(goToTracks);
		menuBar.add(menu);
		setJMenuBar(menuBar);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(playButton, BorderLayout.CENTER);
		getContentPane().add(nextButton, BorderLayout.LINE_END);
		getContentPane().add(previousButton, BorderLayout.LINE_START);
		getContentPane().add(currentTrack, BorderLayout.PAGE_START);

		setVisible(true);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 200);
	}

	public AudioPlayer getAudioPlayer() {
		return audioPlayer;
	}

	public void setAudioPlayer(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button.getName().equalsIgnoreCase("play")) {
			audioPlayer.playTrack();
			playButton.setName("stop");
			playButton.setText("stop");

		}

		else if (button.getName().equalsIgnoreCase("next")) {
			audioPlayer.nextTrack();

		}

		else if (button.getName().equalsIgnoreCase("previous")) {
			audioPlayer.previousTrack();
		}

		else if (button.getName().equalsIgnoreCase("stop")) {
			audioPlayer.stopTrack();
			playButton.setName("play");
			playButton.setText("play");
		}

		if (audioPlayer.getCurrentTrack() == null)
			currentTrack.setText("No track");
		else
			currentTrack.setText(audioPlayer.getCurrentTrack().getName());

	}
}
