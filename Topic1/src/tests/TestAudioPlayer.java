package tests;

import java.io.File;

import javax.swing.SwingUtilities;

import audioPlayer.AudioPlayer;
import audioPlayer.AudioPlayerInterfacesHolder;

public class TestAudioPlayer {
	public static void main(String args[]) {

		AudioPlayer player = new AudioPlayer();

		// This is the directory from which we well take all our songs
		// The mp3 archives have not a valid format. They were created for
		// demonstration purposes
		File baseDirectory = new File("src/audioPlayer/songs");

		player.readDirectory(baseDirectory);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AudioPlayerInterfacesHolder(player);
			}
		});
	}
}
