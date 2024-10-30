package org.apache.xmlbeans;

import java.math.BigDecimal;

public interface GDurationSpecification {
  boolean isImmutable();
  
  int getSign();
  
  int getYear();
  
  int getMonth();
  
  int getDay();
  
  int getHour();
  
  int getMinute();
  
  int getSecond();
  
  BigDecimal getFraction();
  
  boolean isValid();
  
  int compareToGDuration(GDurationSpecification paramGDurationSpecification);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\GDurationSpecification.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */