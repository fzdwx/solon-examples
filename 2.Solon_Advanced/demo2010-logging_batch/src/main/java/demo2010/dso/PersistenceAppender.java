package demo2010.dso;

import demo2010.dso.queue.PackagingQueueTask;
import demo2010.dso.queue.PackagingQueueTaskImpl;
import demo2010.dso.queue.PackagingWorkHandler;
import org.noear.snack.ONode;
import org.noear.solon.logging.event.AppenderBase;
import org.noear.solon.logging.event.LogEvent;

import java.util.List;

/**
 * 持久化添加器（实现了异步、批量的特性）
 *
 * @author noear 2023/1/7 created
 */
public class PersistenceAppender extends AppenderBase implements PackagingWorkHandler<LogEvent> {
    //打包队列
    PackagingQueueTask<LogEvent> packagingQueueTask = new PackagingQueueTaskImpl<LogEvent>();

    public PersistenceAppender() {
        packagingQueueTask.setWorkHandler(this);
    }

    @Override
    public void append(LogEvent logEvent) {
        packagingQueueTask.add(logEvent);
    }

    @Override
    public void onEvents(List<LogEvent> list) {
        //批量插到数据库去（或者批量提义到远程接口）
        System.out.println(ONode.stringify(list));
    }
}
