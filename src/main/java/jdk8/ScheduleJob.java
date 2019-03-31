package jdk8;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleJob {
	public static void main(String[] string) {
		Timer timer = new Timer();
		Thread myThread = new UploadDefaultCardThread();
		Calendar date = Calendar.getInstance();
		/*date.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		date.set(Calendar.HOUR, 10);
		date.set(Calendar.MINUTE, 52);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);*/
		
		date.set(Calendar.HOUR_OF_DAY, 10);
		date.set(Calendar.MINUTE, 55);
		date.set(Calendar.SECOND, 0);
		
		// Schedule to run every Sunday in midnight
		timer.schedule(new JobDrawImageTask(myThread), date.getTime(), 1000 * 60 * 60 * 24);
	}
}
class UploadDefaultCardThread extends Thread {

	public void run() {
		System.out.println("output================");
	}
}

class JobDrawImageTask extends TimerTask {
	Thread myThreadObj;

	JobDrawImageTask(Thread t) {
		this.myThreadObj = t;
	}

	public void run() {
		myThreadObj.start();
	}
}
