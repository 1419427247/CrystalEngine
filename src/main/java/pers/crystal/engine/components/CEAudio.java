package pers.crystal.engine.components;

import java.io.File;
import java.util.ArrayList;

import pers.crystal.engine.application.CEComponent;
import pers.crystal.engine.utility.CEAudioClip;
import pers.crystal.engine.utility.CEVector;

public class CEAudio extends CEComponent {
    private static ArrayList<CEAudio> audios = new ArrayList<CEAudio>();
    private static float OverallVolume = 100.0f;
    private float volume = 100.0f;

    public boolean playOnStart = true;
    public boolean loop = true;

    public boolean attenuation = true;

    public float attenuationRate = 0f;
    public float slope = 5;
    public float minDistance = 30f;
    public float maxDistance = 800f;

    File file;
    CEAudioClip clip;

    @Override
    public void Start() {
        if (file != null && clip == null) {
            clip = new CEAudioClip(file);
        }
        if (clip != null) {
            clip.loop = loop;
            if (playOnStart) {
                clip.Play();
            }
        }
        audios.add(this);
    }

    @Override
    public void Update() {
        if (clip != null && clip.IsPlaying() && attenuation && CECamera.mainCamera != null) {
            double distance = CEVector
                    .Add(gameObject.transform.position, CECamera.mainCamera.gameObject.transform.position).GetLength();
            if (distance > maxDistance) {
                attenuationRate = 1.0f;
            } else if (distance > minDistance && distance < maxDistance) {
                attenuationRate = (float) ((distance - minDistance) / (maxDistance - minDistance + slope));
            } else {
                attenuationRate = 0f;
            }
            clip.SetVolume(volume * attenuationRate);
        }
    }

    @Override
    public void Destroy() {
        if (clip != null) {
            clip.Close();
        }
        audios.remove(this);
    }

    public void LoadAudioFile(File file) {
        if (clip != null) {
            clip.Close();
        }
        this.file = file;
        clip = new CEAudioClip(file);
    }

    public void Play() {
        clip.Play();
    }

    public void Restart() {
        clip.Replay();
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
            ceAudio.SetVolume();
        }
    }

    public float GetVolume() {
        return this.volume;
    }

    public void SetVolume() {
        if (clip != null) {
            clip.SetVolume(volume * OverallVolume / 100f);
        }
    }

    public void SetVolume(float volume) {
        this.volume = volume;
        clip.SetVolume(volume * OverallVolume / 100f);
    }
}