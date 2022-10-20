package org.apache.iotdb.admin.service.impl;

import org.apache.iotdb.admin.service.JVMIndicatorsConvert;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Service("CustomServiceImpl")
public class CustomServiceImpl implements JVMIndicatorsConvert {

  List<String> ThreadsLiveList = Arrays.asList(new String[] {"JVM_THREADS_LIVE_THREADS"});
  List<String> GCParseMAXMEANList =
      Arrays.asList(new String[] {"JVM_GC_PAUSE_MAX", "JVM_GC_PAUSE_MEAN"});
  List<String> GCParseTotalCountList =
      Arrays.asList(new String[] {"JVM_GC_PAUSE_TOTAL", "JVM_GC_PAUSE_COUNT"});

  List<String> ThreadStateList = Arrays.asList(new String[] {"JVM_THREADS_STATES_THREADS"});

  @Override
  public String getResultValue(List<String> queryResult, String JVMIndicatorsName) {
    if (CollectionUtils.isEmpty(queryResult)) {
      return "";
    }
    if (ThreadStateList.contains(JVMIndicatorsName)) {
      //    新建(0)、可运行(125)、运行(19)、阻塞(0)、休眠(18)、死亡(0)
      String defaultValue = "新建(0)、可运行(125)、运行(19)、阻塞(0)、休眠(18)、死亡(0)";
      String defaultTime = "";
      if (CollectionUtils.isEmpty(queryResult)) {
        return defaultTime;
      }
      if (queryResult.size() > 0) {
        String blocked = queryResult.get(1);
        String newState = queryResult.get(2);
        String runnable = queryResult.get(3);
        String terminated = queryResult.get(4);
        String timedWaiting = queryResult.get(5);
        String waiting = queryResult.get(6);
        defaultTime =
            "新建("
                + newState
                + ")、可运行("
                + runnable
                + ")、运行("
                + timedWaiting
                + ")、阻塞("
                + blocked
                + ")、休眠("
                + waiting
                + ")、死亡("
                + terminated
                + ")";
        return defaultTime;
      } else {
        return defaultValue;
      }
    } else if (ThreadsLiveList.contains(JVMIndicatorsName)) {
      String defaultTime = "140个";
      // 前台:142个，后台:20个，线程总数:162个
      if (queryResult.size() > 0) {
        String frontThreadCount = queryResult.get(1);
        return frontThreadCount + "个";
      }
      return defaultTime;
    } else if (GCParseTotalCountList.contains(JVMIndicatorsName)) {
      //	  0次 0.0s
      String defaultTime = "0次";
      // 前台:142个，后台:20个，线程总数:162个
      if (queryResult.size() > 0) {
        String frontThreadCount = queryResult.get(1);
        return frontThreadCount + "次";
      }
      return defaultTime;
    } else if (GCParseMAXMEANList.contains(JVMIndicatorsName)) {
      //	  0.0s(Metadata GC Threshold)
      String defaultTime = "0.0s(Metadata GC Threshold)";
      if (queryResult.size() > 0) {
        String frontThreadCount = queryResult.get(1);
        return Double.parseDouble(frontThreadCount) / 1000 + "s(Metadata GC Threshold)";
      }
      return defaultTime;
    }
    return "";
  }
}
