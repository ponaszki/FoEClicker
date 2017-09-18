package org.ponaszki;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    final URL resource;
    public static int DELAY_MILLIS = 1000;
    public static void main( String[] args ) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.setAutoDelay(100);
        App a = new App("telephone-ring.wav");

//        test(robot);
        collect(robot, a);

        System.out.println( "Ended!!!!" );
    }



    private static void collect(Robot robot, App a) throws InterruptedException {
        Thread.sleep(5000);
        for(int i = 0 ; i<200 ; i++) {
            System.out.println( "Loop:" + i);
            moveAndCllick(robot, 1670, 750, DELAY_MILLIS);
            select5MinPortion(robot);
            moveAndCllick(robot, 1550, 800, DELAY_MILLIS);
            select5MinPortion(robot);
            moveAndCllick(robot, 1420, 870, DELAY_MILLIS);
            select5MinPortion(robot);
            moveAndCllick(robot, 1280, 930, DELAY_MILLIS);
            select5MinPortion(robot);

            select5MinPortion(robot);
            Thread.sleep(310000);
            a.playSound();
            Thread.sleep(10000);

            moveAndCllick(robot, 220, 15, DELAY_MILLIS);
            moveAndCllick(robot, 1670, 750, DELAY_MILLIS);
            moveAndCllick(robot, 1550, 800, DELAY_MILLIS);
            moveAndCllick(robot, 1420, 870, DELAY_MILLIS);
            moveAndCllick(robot, 1280, 930, DELAY_MILLIS);
        }
    }

    private static void test(Robot robot) {
        moveAndCllick(robot, 220, 15, DELAY_MILLIS);
    }

    public static void moveAndCllick(Robot robot, int x, int y, int delayBefaore){
        robot.delay(delayBefaore);
        robot.mouseMove(x, y);
        robot.delay(200);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void select5MinPortion(Robot robot){
        moveAndCllick(robot, 770, 500, DELAY_MILLIS);
    }

    App(String url){
        ClassLoader classLoader = getClass().getClassLoader();
        resource = classLoader.getResource(url);
    }

    public synchronized void playSound() {

        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            resource);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
