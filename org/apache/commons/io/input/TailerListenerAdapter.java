package org.apache.commons.io.input;

public class TailerListenerAdapter implements TailerListener {
  public void init(Tailer paramTailer) {}
  
  public void fileNotFound() {}
  
  public void fileRotated() {}
  
  public void handle(String paramString) {}
  
  public void handle(Exception paramException) {}
  
  public void endOfFileReached() {}
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\TailerListenerAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */