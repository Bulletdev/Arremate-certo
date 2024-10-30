package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public interface DatePrinter {
  String format(long paramLong);
  
  String format(Date paramDate);
  
  String format(Calendar paramCalendar);
  
  @Deprecated
  StringBuffer format(long paramLong, StringBuffer paramStringBuffer);
  
  @Deprecated
  StringBuffer format(Date paramDate, StringBuffer paramStringBuffer);
  
  @Deprecated
  StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer);
  
  <B extends Appendable> B format(long paramLong, B paramB);
  
  <B extends Appendable> B format(Date paramDate, B paramB);
  
  <B extends Appendable> B format(Calendar paramCalendar, B paramB);
  
  String getPattern();
  
  TimeZone getTimeZone();
  
  Locale getLocale();
  
  StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\DatePrinter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */