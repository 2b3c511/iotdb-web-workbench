package org.apache.iotdb.admin.common.enums;

public enum JVMConvertEnum {
  JVM_BUFFER_COUNT_BUFFERS(
      "当前缓冲区数量", "jvm.buffer.count.buffers", "内存", 0, "1,2,3", "TimeConvertServiceImpl", null),
  JVM_BUFFER_MEMORY_USED_BYTES(
      "已经使用的缓冲区大小",
      "jvm.buffer.memory.used.bytes",
      "内存",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_BUFFER_TOTAL_CAPACITY_BYTES(
      "最大缓冲区大小",
      "jvm.buffer.total.capacity.bytes",
      "内存",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_CLASSES_LOADED_CLASSES(
      "JVM累计加载的Class数量",
      "jvm.classes.loaded.classes",
      "Classes",
      0,
      "1,2,3",
      "TimeConvertServiceImpl",
      null),
  JVM_CLASSES_UNLOADED_CLASSES(
      "JVM累计卸载的Class数量",
      "jvm.classes.unloaded.classes",
      "Classes",
      0,
      "1,2,3",
      "TimeConvertServiceImpl",
      null),
  JVM_COMPILATION_TIME_MS(
      "JVM耗费在编译上的时间",
      "jvm.compilation.time.ms",
      "Classes",
      0,
      "1,2,3",
      "TimeConvertServiceImpl",
      null),
  JVM_GC_LIVE_DATA_SIZE_BYTES(
      "GC之后老年代内存的大小",
      "jvm.gc.live.data.size.bytes",
      "垃圾回收",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_GC_MAX_DATA_SIZE_BYTES(
      "老年代内存的历史最大值",
      "jvm.gc.max.data.size.bytes",
      "垃圾回收",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_GC_MEMORY_ALLOCATED_BYTES(
      "在一个GC之后到下一个GC之前年轻代增加的内存",
      "jvm.gc.memory.allocated.bytes",
      "垃圾回收",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_GC_MEMORY_PROMOTED_BYTES(
      "从GC之前到GC之后老年代内存池大小正增长的累计",
      "jvm.gc.memory.promoted.bytes",
      "垃圾回收",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_GC_PAUSE_COUNT(
      "YGC发生次数及总耗时",
      "jvm.gc.pause_count",
      "垃圾回收",
      2,
      "1,2,3",
      "CustomServiceImpl",
      "0.0s(Metadata GC Threshold)"),
  JVM_GC_PAUSE_MAX(
      "YGC最大耗时及原因", "jvm.gc.pause_max", "垃圾回收", 2, "1,2,3", "CustomServiceImpl", "0次 0.0s"),
  JVM_GC_PAUSE_MEAN(
      "FGC最大耗时及原因", "jvm.gc.pause_mean", "垃圾回收", 2, "1,2,3", "CustomServiceImpl", "0次 0.0s"),
  JVM_GC_PAUSE_TOTAL(
      "FGC发生次数及总耗时",
      "jvm.gc.pause_total",
      "垃圾回收",
      2,
      "1,2,3",
      "CustomServiceImpl",
      "0.0s(Metadata GC Threshold)"),
  JVM_MEMORY_COMMITTED_BYTES(
      "当前向JVM申请的内存大小",
      "jvm.memory.committed.bytes",
      "内存",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_MEMORY_MAX_BYTES(
      "JVM最大内存", "jvm.memory.max.bytes", "内存", 0, "1,2,3", "LogicalOperationsServiceImpl", null),
  JVM_MEMORY_USED_BYTES(
      "JVM已使用内存大小",
      "jvm.memory.used.bytes",
      "内存",
      0,
      "1,2,3",
      "LogicalOperationsServiceImpl",
      null),
  JVM_THREADS_DAEMON_THREADS(
      "当前daemon线程数",
      "jvm.threads.daemon.threads",
      "线程",
      0,
      "1,2,3",
      "TimeConvertServiceImpl",
      null),
  JVM_THREADS_LIVE_THREADS(
      "JVM当前线程数", "jvm.threads.live.threads", "线程", 1, "1,2,3", "CustomServiceImpl", null),
  JVM_THREADS_PEAK_THREADS(
      "峰值线程数", "jvm.threads.peak.threads", "线程", 0, "1,2,3", "TimeConvertServiceImpl", null),
  JVM_THREADS_STATES_THREADS(
      "处于各种状态的线程数",
      "jvm.threads.states.threads",
      "线程",
      0,
      "1,2,3,4",
      "CustomServiceImpl",
      "新建(0)、可运行(37)、运行(370)、阻塞(0)、休眠(60)、死亡(0)");

  private String name;
  private String mean;

  private String metricType;

  private int detailAvailable;

  private String querySQLLevel = "1,2,3";

  private String ImplClass;
  private String defaultValue;

  public String getMean() {
    return mean;
  }

  public String getName() {
    return name;
  }

  public String getMetricType() {
    return metricType;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public int getDetailAvailable() {
    return detailAvailable;
  }

  public String getQuerySQLLevel() {
    return querySQLLevel;
  }

  public String getImplClass() {
    return ImplClass;
  }

  JVMConvertEnum(
      String name,
      String mean,
      String metricType,
      int detailAvailable,
      String querySQLLevel,
      String implClass,
      String defaultValue) {
    this.name = name;
    this.mean = mean;
    this.metricType = metricType;
    this.detailAvailable = detailAvailable;
    this.querySQLLevel = querySQLLevel;
    ImplClass = implClass;
    this.defaultValue = defaultValue;
  }
}
