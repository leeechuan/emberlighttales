package main.emberlight;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

		Clip clip;
		URL soundURL[] = new URL[50];
		FloatControl fc;
		int volumeScale = 3;
		float volume;
		
		public Sound( ) {
		
			soundURL[0] = getClass().getResource("/sound/emberlight-theme.wav");
			soundURL[1] = getClass().getResource("/sound/chest-open.wav");
			soundURL[2] = getClass().getResource("/sound/hit-slime.wav");
			soundURL[3] = getClass().getResource("/sound/received-damage.wav");
			soundURL[4] = getClass().getResource("/sound/sword-swing.wav");
			soundURL[5] = getClass().getResource("/sound/level-up.wav");
			soundURL[6] = getClass().getResource("/sound/cursor-move.wav");
			soundURL[7] = getClass().getResource("/sound/arrow-woosh.wav");
			soundURL[8] = getClass().getResource("/sound/chop-wood.wav");
			soundURL[9] = getClass().getResource("/sound/game-over.wav");
			soundURL[10]= getClass().getResource("/sound/block.wav");
			soundURL[11]= getClass().getResource("/sound/parry.wav");
			soundURL[12]= getClass().getResource("/sound/speak.wav");
			soundURL[13]= getClass().getResource("/sound/open-chest.wav");
			soundURL[14]= getClass().getResource("/sound/door-open.wav");
			soundURL[15]= getClass().getResource("/sound/steps.wav");
			soundURL[16]= getClass().getResource("/sound/pressure-plate.wav");
			soundURL[17]= getClass().getResource("/sound/stone-move.wav");
			soundURL[18]= getClass().getResource("/sound/iron-gate.wav");
			soundURL[19]= getClass().getResource("/sound/emberlight-bossbattle.wav");
			soundURL[20]= getClass().getResource("/sound/emberlight-indoor.wav");
			soundURL[21]= getClass().getResource("/sound/emberlight-mines.wav");
			soundURL[22]= getClass().getResource("/sound/walk-grass.wav");
			soundURL[23]= getClass().getResource("/sound/walk-grass-2.wav");
			soundURL[24]= getClass().getResource("/sound/enter-cave.wav");
			soundURL[25]= getClass().getResource("/sound/emberlight-credits.wav");
			soundURL[26]= getClass().getResource("/sound/player-transformation.wav");
			soundURL[27]= getClass().getResource("/sound/popup.wav");
			soundURL[28]= getClass().getResource("/sound/popdown.wav");
			soundURL[29]= getClass().getResource("/sound/journalupdate.wav");
			soundURL[30]= getClass().getResource("/sound/harvest-crop.wav");
			soundURL[31]= getClass().getResource("/sound/plant-seed.wav");
			soundURL[32]= getClass().getResource("/sound/sword-break.wav");
			soundURL[33]= getClass().getResource("/sound/shield-break.wav");
			soundURL[34]= getClass().getResource("/sound/flame-burnout.wav");
			soundURL[35]= getClass().getResource("/sound/sword-swing-2.wav");
			soundURL[36]= getClass().getResource("/sound/sword-swing-3.wav");
			soundURL[37]= getClass().getResource("/sound/player-roll.wav");
			soundURL[38]= getClass().getResource("/sound/coin-jingle.wav");
		}
		
		public void setFile(int i) {
		    try {
		        if (soundURL[i] == null) {
		            throw new IllegalArgumentException("Sound file not found: Index " + i);
		        }

		        AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
		        clip = AudioSystem.getClip();
		        clip.open(ais);
		        fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		        checkVolume();
		    } catch (IllegalArgumentException e) {
		        System.err.println("Error: " + e.getMessage());
		    } catch (Exception e) {
		        System.err.println("Audio system error: No valid sound output device found!");
		        clip = null;  // Prevent crashes by setting clip to null
		    }
		}
		
		public void play() {
		    if (clip != null) {
		        clip.start();
		    } else {
		        System.err.println("Cannot play sound: No valid audio output device.");
		    }
		}

		public void loop() {
		    if (clip != null) {
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		    } else {
		        System.err.println("Cannot loop sound: No valid audio output device.");
		    }
		}

		public void stop() {
		    if (clip != null) {
		        clip.stop();
		    }
		}
		public void checkVolume() {
		    if (fc == null) {
		        System.err.println("Cannot adjust volume: No valid audio output device.");
		        return;
		    }

		    switch (volumeScale) {
		        case 0: volume = -80f; break;
		        case 1: volume = -20f; break;
		        case 2: volume = -12f; break;
		        case 3: volume = -5f; break;
		        case 4: volume = 1f; break;
		        case 5: volume = 6f; break;
		    }
		    fc.setValue(volume);
		}
}
