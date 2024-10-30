package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

public interface LoggerFactoryBinder {
  ILoggerFactory getLoggerFactory();
  
  String getLoggerFactoryClassStr();
}


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\spi\LoggerFactoryBinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */