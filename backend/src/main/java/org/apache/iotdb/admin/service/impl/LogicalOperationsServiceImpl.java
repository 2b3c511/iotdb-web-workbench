package org.apache.iotdb.admin.service.impl;

import org.apache.iotdb.admin.service.JVMIndicatorsConvert;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@Service("LogicalOperationsServiceImpl")
public class LogicalOperationsServiceImpl implements JVMIndicatorsConvert {

  List<String> JVMGCList =
      Arrays.asList(
          new String[] {
            "JVM_GC_MEMORY_PROMOTED_BYTES",
            "JVM_GC_MAX_DATA_SIZE_BYTES",
            "JVM_GC_LIVE_DATA_SIZE_BYTES",
            "JVM_GC_MEMORY_ALLOCATED_BYTES",
            "JVM_BUFFER_MEMORY_USED_BYTES",
            "JVM_BUFFER_TOTAL_CAPACITY_BYTES",
            "JVM_MEMORY_COMMITTED_BYTES",
            "JVM_MEMORY_MAX_BYTES",
            "JVM_MEMORY_USED_BYTES"
          });

  @Override
  public String getResultValue(List<String> queryResult, String JVMIndicatorsName) {
    //        大小：单位（GB、MB）、6.1GB、104.4MB
    //        计算
    if (CollectionUtils.isEmpty(queryResult) || queryResult.size() <= 1) {
      return "0";
    }
    String latestResult =
        getNetFileSizeDescription((long) (Double.parseDouble(queryResult.get(1))));
    return latestResult;
  }

  private static String getNetFileSizeDescription(long size) {
    StringBuffer bytes = new StringBuffer();
    DecimalFormat format = new DecimalFormat("###.0");
    if (size >= 1024 * 1024 * 1024) {
      double i = (size / (1024.0 * 1024.0 * 1024.0));
      bytes.append(format.format(i)).append("GB");
    } else if (size >= 1024 * 1024) {
      double i = (size / (1024.0 * 1024.0));
      bytes.append(format.format(i)).append("MB");
    } else if (size >= 1024) {
      double i = (size / (1024.0));
      bytes.append(format.format(i)).append("KB");
    } else if (size < 1024) {
      if (size <= 0) {
        bytes.append("0B");
      } else {
        bytes.append((int) size).append("B");
      }
    }
    return bytes.toString();
  }
}
