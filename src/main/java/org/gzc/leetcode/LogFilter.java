package org.gzc.leetcode;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author GZC
 * @create 2022-10-17 22:58
 * @desc 访日志注入过滤器
 */

@Slf4j
public class LogFilter extends Filter<ILoggingEvent> {
    String str = "ch.qos.logback";

    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        log.info(Arrays.toString(iLoggingEvent.getArgumentArray()));

        String[] split = str.split(";");
        String message = iLoggingEvent.getMessage();
        String loggerName = iLoggingEvent.getLoggerName();
        for (String s : split) {
            if (message.contains(s)||loggerName.contains(s)) {
                return FilterReply.DENY;
            }
        }
        return FilterReply.ACCEPT;
    }

}
