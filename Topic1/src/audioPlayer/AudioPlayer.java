package audioPlayer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;

public class AudioPlayer {
	private ArrayList<Track> trackList;

	private enum state {
		playing, stoped, paused, error
	};

	private state currentState;
	private Track currentTrack;

	private AudioInputStream audioStream;

	public AudioPlayer() {
		trackList = new ArrayList<Track>();
		this.setCurrentState(state.stoped);
	}

	public void selectTrack(Track track) {
		this.currentTrack = track;
	}

	// puts on the previous track
	public void previousTrack() {
		if (currentTrack != null) {
			for (int i = 0; i < trackList.size(); i++) {
				if (currentTrack == trackList.get(i)){
					if (i > 0)
						currentTrack = trackList.get(i - 1);
					break;
				}

			}
		}
	}

	// puts on the next track
	public void nextTrack() {
		if (currentTrack != null) {
			for (int i = 0; i < trackList.size(); i++) {
				if (currentTrack == trackList.get(i)){
					if (i < trackList.size() - 1)
						currentTrack = trackList.get(i + 1);
					break;
				}

			}
		}
	}

	// Starts playing the current track or shows an error message
	public void playTrack() {
		setCurrentState(state.playing);
		if (currentTrack == null)
			if (trackList.size() > 0)
				currentTrack = trackList.get(0);

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(currentTrack.getFile());
		} catch (Exception e) {
			currentState = state.error;
		}

	}

	public void stopTrack() {
		setCurrentState(state.stoped);
		currentTrack = null;
	}

	public void pauseTrack() {
		setCurrentState(state.paused);
	}

	public state getCurrentState() {
		return currentState;
	}

	public void setCurrentState(state currentState) {
		this.currentState = currentState;
	}

	public void addTrack(Track track) {
		trackList.add(track);
	}

	public void setCurrentTrack(Track track) {
		this.currentTrack = track;
	}
	
	public Track getCurrentTrack()
	{
		return this.currentTrack;
	}

}
