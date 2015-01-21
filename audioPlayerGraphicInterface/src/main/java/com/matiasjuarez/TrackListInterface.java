package com.matiasjuarez;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TrackListInterface extends JPanel implements ActionListener {
	private JButton addButton;
	private JButton removeButton;
	private JScrollPane trackListHolder; // A JScrollPane
	private JPanel view; // This will contain all the songs and will be inside
							// the trackListHolder
	private ArrayList<JCheckBox> trackList = new ArrayList<JCheckBox>();
	private AudioPlayer audioPlayer;

	private final JFileChooser fileChosser = new JFileChooser();

	public TrackListInterface(AudioPlayer audioPlayer) {
		this.audioPlayer = audioPlayer;
		buildTrackListInterface();

		reloadTrackList();

	}

	// This method reload the checkBoxes stored in the corresponding arrayList
	// and will be called when the amount of tracks in the AudioPlayer.trackList
	// change
	public void reloadTrackList() {
		trackList.clear();

		// We create a JCheckBox for each Track in the trackList of the
		// AudioPlayer class
		for (Track track : audioPlayer.getTrackList()) {
			JCheckBox checkBox = new JCheckBox();
			checkBox.setText(track.getName());
			trackList.add(checkBox);
		}

		displayTrackList();
	}

	// This one shows the track list in the JPanel view
	public void displayTrackList() {
		view.removeAll(); // First we remove all the elements of the JPanel view

		// We configure our layout for each checkBox
		GridBagConstraints gbc = null;
		int gridy = 0;
		for (JCheckBox checkBox : trackList) {
			gbc = new GridBagConstraints();
			gbc.gridy = gridy;
			gbc.gridx = 0;
			gbc.anchor = gbc.LINE_START;
			gridy++;

			// We add the corresponding checkBox
			view.add(checkBox, gbc);
		}

		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton button = (AbstractButton) e.getSource();

		if (button.getName().equalsIgnoreCase("addButton")) {
			addNewSong();
		}

		else if (button.getName().equalsIgnoreCase("removeButton")) {
			removeSongs();
		}
		
		reloadTrackList();
		
	}

	public void removeSongs() {
		JCheckBox ancillaryCheckBox;
		// Here we store all the selected songs
		ArrayList<JCheckBox> selectedSongs = new ArrayList<JCheckBox>();

		// We look for the songs that are selected and we load them in the
		// selectedSongs ArrayList
		for (int i = 0; i < view.getComponentCount(); i++) {
			ancillaryCheckBox = (JCheckBox) view.getComponent(i);
			if (ancillaryCheckBox.isSelected()) {
				selectedSongs.add(ancillaryCheckBox);
			}

		}

		// We go through the selectSongs Array and we tell the audioPlayer to
		// remove the tracks selected
		for (JCheckBox checkBox : selectedSongs)
			for (Track track : audioPlayer.getTrackList())
				if (track.getName().equalsIgnoreCase(checkBox.getText())) {
					audioPlayer.removeTrack(track);
					break;
				}
		
	}

	public void addNewSong() {
		int returnValue = fileChosser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selected = fileChosser.getSelectedFile();
			
			Track newTrack = new Track(selected);
			audioPlayer.addTrack(newTrack);
		}

	}

	// Build up the interface needed to see the track list, to add and to
	// eliminate songs
	public void buildTrackListInterface() {

		this.setLayout(new BorderLayout());

		addButton = new JButton("+");
		addButton.setName("addButton");
		addButton.addActionListener(this);

		removeButton = new JButton("-");
		removeButton.setName("removeButton");
		removeButton.addActionListener(this);

		view = new JPanel();
		view.setLayout(new GridBagLayout());

		trackListHolder = new JScrollPane(view);

		this.add(removeButton, BorderLayout.LINE_START);
		this.add(addButton, BorderLayout.LINE_END);
		this.add(trackListHolder, BorderLayout.CENTER);
		
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("MP3 file","mp3");
		fileChosser.setFileFilter(fileFilter);
		fileChosser.setAcceptAllFileFilterUsed(false);
		fileChosser.setCurrentDirectory(new File("src/audioPlayer/songs"));
	}

}
