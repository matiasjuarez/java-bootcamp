package audioPlayer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This class is a graphic interface for the audioPlayer class.
public class AudioPlayerInterface extends JPanel implements ActionListener {
	private JButton playButton;
	private JButton nextButton;
	private JButton previousButton;
	private JLabel currentTrack;
	private AudioPlayer audioPlayer;

	public AudioPlayerInterface(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
		buildAudioPlayerInterface();
	}

	public void actionPerformed(ActionEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();

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

	// This method build all the components that are inside the
	// AudioPlayerInterface
	public void buildAudioPlayerInterface() {
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

		setLayout(new BorderLayout());
		add(playButton, BorderLayout.CENTER);
		add(nextButton, BorderLayout.LINE_END);
		add(previousButton, BorderLayout.LINE_START);
		add(currentTrack, BorderLayout.PAGE_START);
	}

}
