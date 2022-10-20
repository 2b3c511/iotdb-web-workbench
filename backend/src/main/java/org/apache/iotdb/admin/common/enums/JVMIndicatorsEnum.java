package org.apache.iotdb.admin.common.enums;

public enum JVMIndicatorsEnum {
  JVM_BUFFER_COUNT_BUFFERS("当前缓冲区数量", "jvm.buffer.count.buffers", "内存", 0, "1,2,3", "%s个", "1"),
  JVM_BUFFER_MEMORY_USED_BYTES(
      "已经使用的缓冲区大小", "jvm.buffer.memory.used.bytes", "内存", 0, "1,2,3", "%s", "1"),
  JVM_BUFFER_TOTAL_CAPACITY_BYTES(
      "最大缓冲区大小", "jvm.buffer.total.capacity.bytes", "内存", 0, "1,2,3", "%s个", "1"),
  JVM_CLASSES_LOADED_CLASSES(
      "JVM累计加载的Class数量", "jvm.classes.loaded.classes", "Classes", 0, "1,2,3", "%s个", "1"),
  JVM_CLASSES_UNLOADED_CLASSES(
      "JVM累计卸载的Class数量", "jvm.classes.unloaded.classes", "Classes", 0, "1,2,3", "%s个", "1"),
  JVM_COMPILATION_TIME_MS(
      "JVM耗费在编译上的时间", "jvm.compilation.time.ms", "Classes", 0, "1,2,3", "%s", "1"),
  JVM_GC_LIVE_DATA_SIZE_BYTES(
      "GC之后老年代内存的大小", "jvm.gc.live.data.size.bytes", "垃圾回收", 0, "1,2,3", "%s", "1"),
  JVM_GC_MAX_DATA_SIZE_BYTES(
      "老年代内存的历史最大值", "jvm.gc.max.data.size.bytes", "垃圾回收", 0, "1,2,3", "%s", "1"),
  JVM_GC_MEMORY_ALLOCATED_BYTES(
      "在一个GC之后到下一个GC之前年轻代增加的内存", "jvm.gc.memory.allocated.bytes", "垃圾回收", 0, "1,2,3", "%s", "1"),
  JVM_GC_MEMORY_PROMOTED_BYTES(
      "从GC之前到GC之后老年代内存池大小正增长的累计", "jvm.gc.memory.promoted.bytes", "垃圾回收", 0, "1,2,3", "%s", "1"),
  JVM_GC_PAUSE_COUNT(
      "YGC发生次数及总耗时",
      "jvm.gc.pause_count",
      "垃圾回收",
      2,
      "1,2,3",
      null,
      null,
      "0.0s(Metadata GC Threshold)"),
  JVM_GC_PAUSE_MAX("YGC最大耗时及原因", "jvm.gc.pause_max", "垃圾回收", 2, "1,2,3,4", null, null, "0次 0.0s"),
  JVM_GC_PAUSE_MEAN("FGC最大耗时及原因", "jvm.gc.pause_mean", "垃圾回收", 2, "1,2,3", null, null, "0次 0.0s"),
  JVM_GC_PAUSE_TOTAL(
      "FGC发生次数及总耗时",
      "jvm.gc.pause_total",
      "垃圾回收",
      2,
      "1,2,3",
      null,
      null,
      "0.0s(Metadata GC Threshold)"),
  JVM_MEMORY_COMMITTED_BYTES(
      "当前向JVM申请的内存大小", "jvm.memory.committed.bytes", "内存", 0, "1,2,3", "%s个", "1"),
  JVM_MEMORY_MAX_BYTES("JVM最大内存", "jvm.memory.max.bytes", "内存", 0, "1,2,3", "%s个", "1"),
  JVM_MEMORY_USED_BYTES("JVM已使用内存大小", "jvm.memory.used.bytes", "内存", 0, "1,2,3", "%s个", "1"),
  JVM_THREADS_DAEMON_THREADS(
      "当前daemon线程数", "jvm.threads.daemon.threads", "线程", 0, "1,2,3", "%s个", "1"),
  JVM_THREADS_LIVE_THREADS(
      "JVM当前线程数", "jvm.threads.live.threads", "线程", 1, "1,2,3", "前台:%s个，后台:%s个", "1,2"),
  JVM_THREADS_PEAK_THREADS("峰值线程数", "jvm.threads.peak.threads", "线程", 0, "1,2,3", "%s个", "1"),
  JVM_THREADS_STATES_THREADS(
      "处于各种状态的线程数",
      "jvm.threads.states.threads",
      "线程",
      0,
      "1,2,3,4",
      null,
      null,
      "新建(0)、可运行(37)、运行(370)、阻塞(0)、休眠(60)、死亡(0)");

  private String name;
  private String mean;

  private String metricType;

  private int detailAvailable;

  private String querySQLLevel = "1,2,3";

  private String template;

  private String valueOrder;

  private String defaultValue;

  JVMIndicatorsEnum(
      String name, String mean, String metricType, int detailAvailable, String querySQLLevel) {
    this.name = name;
    this.mean = mean;
    this.metricType = metricType;
    this.detailAvailable = detailAvailable;
    this.querySQLLevel = querySQLLevel;
  }

  JVMIndicatorsEnum(
      String name,
      String mean,
      String metricType,
      int detailAvailable,
      String querySQLLevel,
      String template) {
    this.name = name;
    this.mean = mean;
    this.metricType = metricType;
    this.detailAvailable = detailAvailable;
    this.template = template;
    this.querySQLLevel = querySQLLevel;
  }

  JVMIndicatorsEnum(
      String name,
      String mean,
      String metricType,
      int detailAvailable,
      String querySQLLevel,
      String template,
      String valueOrder) {
    this.name = name;
    this.mean = mean;
    this.metricType = metricType;
    this.detailAvailable = detailAvailable;
    this.template = template;
    this.valueOrder = valueOrder;
    this.querySQLLevel = querySQLLevel;
  }

  JVMIndicatorsEnum(
      String name,
      String mean,
      String metricType,
      int detailAvailable,
      String querySQLLevel,
      String template,
      String valueOrder,
      String defaultValue) {
    this.name = name;
    this.mean = mean;
    this.metricType = metricType;
    this.detailAvailable = detailAvailable;
    this.template = template;
    this.valueOrder = valueOrder;
    this.defaultValue = defaultValue;
    this.querySQLLevel = querySQLLevel;
  }
  //    public static void main(String[] args) {
  //        for (JVMIndicatorsEnum value : values()) {
  //            if(StringUtils.isNotBlank(value.getDefaultValue()){
  //
  //            }
  //            if (StringUtils.isNotBlank(value.getTemplate())) {
  //                String valueTemplate = value.getTemplate();
  //                List<String> result = new ArrayList<>();
  //                String order = value.getValueOrder();
  //                String[] split = order.split(",");
  //                String[] values = new String[split.length];
  //                for (int i = 0; i < split.length; i++) {
  //                    int j = Integer.parseInt(split[i]);
  //                    values[i] = result.get(j);
  //                }
  //                String formated = String.format(valueTemplate, values);
  //
  //            } else {
  //
  //            }
  //        }
  //    }

  public String getMean() {
    return mean;
  }

  public String getName() {
    return name;
  }

  public String getMetricType() {
    return metricType;
  }

  public String getTemplate() {
    return template;
  }

  public String getValueOrder() {
    return valueOrder;
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
}
