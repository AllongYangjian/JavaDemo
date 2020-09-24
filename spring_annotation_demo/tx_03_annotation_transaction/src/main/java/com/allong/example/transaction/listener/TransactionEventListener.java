package com.allong.example.transaction.listener;

import com.allong.example.transaction.event.MyApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Map;

@Component
public class TransactionEventListener {

    /**
     * 事务提交后执行
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(MyApplicationEvent event) {
        Map map = (Map) event.getSource();
        System.err.println(map.get("事务提交了" + "sourceName") + "向" + map.get("targetName") + "转账" + map.get("money") + "成功");
    }

    /**
     * 事务回滚后执行
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterRollback(MyApplicationEvent event) {
        Map map = (Map) event.getSource();
        System.err.println("事务回滚了" + map.get("sourceName") + "向" + map.get("targetName") + "转账" + map.get("money") + "失败");
    }
}
