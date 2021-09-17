package ldp.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadUtils {

    public static void openNewWorkThread(IWork iWork) {
        if (iWork == null) return;

        new Thread(iWork::doBackgroundWork).start();
    }

    public static void openNewWorkThreadForQuickSort(IWork iWork) {
        if (iWork == null) return;

        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                iWork.doBackgroundWork();
            }
        },"quick"+System.currentTimeMillis(),1024*1024*100).start();
    }
}
