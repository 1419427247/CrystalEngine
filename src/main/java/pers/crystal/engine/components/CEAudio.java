package pers.crystal.engine.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.*;


import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.CEAsset;
import pers.crystal.engine.utility.CEVector;

public class CEAudio extends CEComponent implements LineListener {
	private static ArrayList<CEAudio> audios = new ArrayList<CEAudio>();
	private static float OverallVolume = 100.0f;

	private float volume = 100.0f;
	private float attenuationRate = 0f;

	public boolean loop = true;
	public boolean playOnStart = true;

	public boolean attenuation = true;

	public float slope = 0;

	public float minDistance = 30f;
	public float maxDistance = 800f;

	File audioFile;
	Clip clip;
	FloatControl floatControl;

	@Override
	public void Start() {
		if (audioFile != null) {
			this.SetAudioFile(audioFile);
			if (playOnStart) {
				this.Play();
			}
		}
	}

	@Override
	public void Update() {
		if (clip != null && clip.isActive() && attenuation) {
			double distance = CEVector
					.Add(gameObject.transform.position, CECamera.mainCamera.gameObject.transform.position).GetLength();
			if (distance > maxDistance) {
				attenuationRate = 100.0f;
			} else if (distance > minDistance && distance < maxDistance) {
				attenuationRate = (float) ((distance - minDistance) / (maxDistance - minDistance + slope));
			} else {
				attenuationRate = 0f;
			}
			this.SetVolume(this.volume);
		}
	}

	@Override
	public void Destroy() {
		clip.close();
		audios.remove(this);
	}

	public void SetAudioFile(File audioFile){
		if (clip != null && clip.isOpen()) {
			clip.close();
		}
		try {
			this.audioFile = audioFile;
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(this.audioFile));
			clip.addLineListener(this);
			floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static float GetOverallVolume() {
		return OverallVolume;
	}

	public static void SetOverallVolume(float overallVolume) {
		if (OverallVolume > 100f) {
			OverallVolume = 100;
		} else if (OverallVolume < 0) {
			OverallVolume = 0;
		}
		CEAudio.OverallVolume = overallVolume;

		for (CEAudio ceAudio : audios) {
			ceAudio.SetVolume(ceAudio.volume);
		}
	}

	public float GetVolume() {
		return volume;
	}

	public void SetVolume(float volume) {
		if (volume > 100f) {
			volume = 100;
		} else if (volume < 0) {
			volume = 0;
		}
		this.volume = volume;
		floatControl.setValue(6.0206f - (volume * attenuationRate * OverallVolume) / 10000f * 86.0206f);
	}

	public void Play() {
		this.SetVolume(this.volume);
		clip.start();
	}

	public void Stop() {
		clip.stop();
	}

	public void Restart() {
		clip.setFramePosition(0);
		this.Play();
	}

	@Override
	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.STOP){
			if (loop) {
				this.Restart();
			}
		}
	}
}
