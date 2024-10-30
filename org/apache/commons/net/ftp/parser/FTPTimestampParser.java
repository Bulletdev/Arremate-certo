package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import java.util.Calendar;

public interface FTPTimestampParser {
  public static final String DEFAULT_SDF = "MMM d yyyy";
  
  public static final String DEFAULT_RECENT_SDF = "MMM d HH:mm";
  
  Calendar parseTimestamp(String paramString) throws ParseException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\FTPTimestampParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */