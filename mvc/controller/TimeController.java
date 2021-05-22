package mvc.controller;

import mvc.controller.thread.TimeThread;

public class TimeController
{
    private final TimeThread       timeThread;
    private final ThreadController threadController;

    public TimeController()
    {
        this.threadController = new ThreadController();
        this.timeThread       = new TimeThread(threadController);
    }

    public void start()
    {
        this.timeThread.start();
    }

    public void pause()
    {
        timeThread.setForceStop(true);
    }

    public void resume()
    {
        timeThread.setForceStop(false);
        timeThread.wake();
    }

    public void startOver()
    {
        timeThread.setTime(0);
        timeThread.setForceStop(false);
        timeThread.wake();
    }

    public TimeThread getTimeThread()
    {
        return timeThread;
    }

    public String getTime()
    {
        return timeThread.getTime();
    }
}