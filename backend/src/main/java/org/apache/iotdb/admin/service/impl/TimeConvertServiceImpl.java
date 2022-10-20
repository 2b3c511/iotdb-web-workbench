package org.apache.iotdb.admin.service.impl;

import org.apache.iotdb.admin.service.JVMIndicatorsConvert;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Service("TimeConvertServiceImpl")
public class TimeConvertServiceImpl implements JVMIndicatorsConvert {

  List<String> TimeCountList = Arrays.asList(new String[] {"JVM_COMPILATION_TIME_MS"});
  List<String> NUMCountList =
      Arrays.asList(
          new String[] {
            "JVM_CLASSES_LOADED_CLASSES",
            "JVM_CLASSES_UNLOADED_CLASSES",
            "JVM_BUFFER_COUNT_BUFFERS",
            "JVM_THREADS_PEAK_THREADS",
            "JVM_THREADS_DAEMON_THREADS"
          });

  //    List<String> PreCountList = Arrays.asList(new
  // String[]{"JVM_GC_PAUSE_COUNT","JVM_GC_PAUSE_TOTAL"});

  @Override
  public String getResultValue(List<String> queryResult, String JVMIndicatorsName) {

    if (TimeCountList.contains(JVMIndicatorsName)) {
      String defaultTime = "0s";
      if (CollectionUtils.isEmpty(queryResult)) {
        return defaultTime;
      }
      if (queryResult.size() > 0) {
        return queryResult.get(1) + "s";
      } else {
        return defaultTime;
      }
    } else if (NUMCountList.contains(JVMIndicatorsName)) {
      String defaultTime = "0个";
      if (CollectionUtils.isEmpty(queryResult)) {
        return defaultTime;
      }
      if (queryResult.size() > 0) {
        return queryResult.get(1) + "个";
      } else {
        return defaultTime;
      }
      //        }else if(PreCountList.contains(JVMIndicatorsName)){
      //            String defaultTime = "0次";
      //            if(CollectionUtils.isEmpty(queryResult)){
      //                return defaultTime;
      //            }
      //            if(queryResult.size()>0){
      //                return queryResult.get(1)+"次";
      //            }else {
      //                return defaultTime;
      //            }
    }
    return "0个";
  }
}
