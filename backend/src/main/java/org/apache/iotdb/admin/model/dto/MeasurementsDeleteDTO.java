package org.apache.iotdb.admin.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

@Data
public class MeasurementsDeleteDTO implements Serializable {

  @NotEmpty(message = "The measurement list cannot be empty")
  private List<String> measurementList;

  public boolean isMeasurementEmpty() {
    if (null != this && this.getMeasurementList() != null && this.getMeasurementList().size() > 0) {
      return false;
    }
    return true;
  }
}
