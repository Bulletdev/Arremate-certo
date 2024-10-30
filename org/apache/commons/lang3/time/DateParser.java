package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public interface DateParser {
  Date parse(String paramString) throws ParseException;
  
  Date parse(String paramString, ParsePosition paramParsePosition);
  
  boolean parse(String paramString, ParsePosition paramParsePosition, Calendar paramCalendar);
  
  String getPattern();
  
  TimeZone getTimeZone();
  
  Locale getLocale();
  
  Object parseObject(String paramString) throws ParseException;
  
  Object parseObject(String paramString, ParsePosition paramParsePosition);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\DateParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */