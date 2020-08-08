package pers.crystal.engine.utility;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class CEAudioClip {
	private float volume = 100.0f;

	public boolean loop = false;

	Clip clip;
	FloatControl floatControl;

	public CEAudioClip(File file) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						if (loop) {
							Replay();
						}
					}
				}
			});
			floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
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
		floatControl.setValue(6.0206f - (volume / 100f) * 86.0206f);
	}

	public void Play() {
		this.SetVolume(this.volume);
		clip.start();
	}

	public void Stop() {
		clip.stop();
	}

	public boolean IsPlaying() {
		return clip.isRunning();
	}

	public void Replay() {
		clip.setFramePosition(0);
		this.Play();
	}

	public synchronized void Close(){
		clip.close();
	}

}
