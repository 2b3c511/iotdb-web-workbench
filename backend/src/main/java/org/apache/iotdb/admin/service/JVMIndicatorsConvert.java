package org.apache.iotdb.admin.service;

import java.util.List;

public interface JVMIndicatorsConvert {

  public String getResultValue(List<String> queryResult, String JVMIndicatorsName);
}
