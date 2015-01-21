package com.matiasjuarez;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AudioPlayerInterfacesHolder extends JFrame implements
		ActionListener {
	private AudioPlayer audioPlayer;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem goToAudioPlayerInterface;
	private JMenuItem goToTracksInterface;
	private AudioPlayerInterface mainInterface;
	private TrackListInterface trackListInterface;

	public AudioPlayerInterfacesHolder(AudioPlayer audioPlayer) {
		this.setAudioPlayer(audioPlayer);
		
		setTitle("Player");
		pack();

		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// This Builds up the menu
		buildMenu();

		// It Builds the interface to play and stop the tracks
		mainInterface = new AudioPlayerInterface(audioPlayer);
		

		// This one Builds the interface to manage the tracks
		
		trackListInterface = new TrackListInterface(audioPlayer);

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
		AbstractButton button = (AbstractButton) e.getSource();

		// If we select the menu item named "player", we'll show the player
		// interface
		if (button == goToAudioPlayerInterface) {
			this.setContentPane(mainInterface);
			this.revalidate();
			this.repaint();
		}

		// If we select the menu item named "Tracks", we'll show the tracks
		// interface
		else if (button == goToTracksInterface) {
			this.setContentPane(trackListInterface);
			this.revalidate();
			this.repaint();
		}
	}

	// This build up the menu bar and all the items of that menu
	public void buildMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("GO TO");

		goToAudioPlayerInterface = new JMenuItem("Player");

		goToAudioPlayerInterface.addActionListener(this);

		goToTracksInterface = new JMenuItem("Tracks");

		goToTracksInterface.addActionListener(this);

		menu.add(goToAudioPlayerInterface);

		menu.add(goToTracksInterface);

		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
}
