package audioPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;

//This class holds all the logic of an audio player. The interface for this audio player is build up in the PlayerInterface class
public class AudioPlayer {
	private ArrayList<Track> trackList;

	//represents the possible states in which an audio player could be
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

	// This method reads all the files in a directory and loads all the songs in
	// the trackList
	// In fact it loads all files that are not a directory... we need to improve
	// it
	public void readDirectory(File file) {
		Track track;
		for (File song : file.listFiles()) {
			if (song.isDirectory() == false) {
				track = new Track(song);
				trackList.add(track);
			}
		}
	}

	public void selectTrack(Track track) {
		this.currentTrack = track;
	}

	// puts on the previous track
	public void previousTrack() {
		if (currentTrack != null) {
			for (int i = 0; i < trackList.size(); i++) {
				if (currentTrack == trackList.get(i)) {
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
				if (currentTrack == trackList.get(i)) {
					if (i < trackList.size() - 1)
						currentTrack = trackList.get(i + 1);
					break;
				}

			}
		}
	}

	// It plays the current track or shows an error message
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

	public Track getCurrentTrack() {
		return this.currentTrack;
	}

	public ArrayList<Track> getTrackList() {
		return trackList;
	}

	public void removeTrack(Track track) {
		this.trackList.remove(track);
	}

}
