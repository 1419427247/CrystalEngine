package CEComponents;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import CEApplication.CEComponent;


public class CEAudio extends CEComponent {
	public Clip clip;
	@Override
	public void Start() {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("y.wav")));
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update() {
		
	}

	@Override
	public void Destroy() {
		
	}
	
	public void Play() {
		System.out.println(clip.isRunning());
//		if (clip.isRunning()) {
//			clip.close();
//		}
		clip.loop(1);
	}
	
	public void Stop() {
		clip.stop();
	}
	
}
