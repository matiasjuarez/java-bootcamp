package audioPlayer;

import java.io.File;

import javax.swing.SwingUtilities;

public class TestAudio {
	public static void main(String args[]) {
		AudioPlayer player = new AudioPlayer();
		
		Track track1 = new Track(new File("audioPlayer/songs/a1.mp3"));
		Track track2 = new Track(new File("audioPlayer/songs/a2.mp3"));
		
		player.addTrack(track1);
		player.addTrack(track2);
		

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PlayerInterface(player);
			}
		});
	}
}

