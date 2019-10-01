package org.floworc.runner.kafka;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Factory;
import org.floworc.core.models.executions.Execution;
import org.floworc.core.queues.QueueFactoryInterface;
import org.floworc.core.queues.QueueInterface;
import org.floworc.core.runners.WorkerTask;
import org.floworc.core.runners.WorkerTaskResult;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Factory
@KafkaQueueEnabled
public class KafkaQueueFactory implements QueueFactoryInterface {
    @Inject
    ApplicationContext applicationContext;

    @Singleton
    @Named(QueueFactoryInterface.EXECUTION_NAMED)
    public QueueInterface<Execution> execution() {
        return new KafkaQueue<>(Execution.class, applicationContext);
    }

    @Singleton
    @Named(QueueFactoryInterface.WORKERTASK_NAMED)
    public QueueInterface<WorkerTask> workerTask() {
        return new KafkaQueue<>(WorkerTask.class, applicationContext);
    }

    @Singleton
    @Named(QueueFactoryInterface.WORKERTASKRESULT_NAMED)
    public QueueInterface<WorkerTaskResult> workerTaskResult() {
        return new KafkaQueue<>(WorkerTaskResult.class, applicationContext);
    }
}
