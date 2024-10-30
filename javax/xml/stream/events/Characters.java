package javax.xml.stream.events;

public interface Characters extends XMLEvent {
  String getData();
  
  boolean isWhiteSpace();
  
  boolean isCData();
  
  boolean isIgnorableWhiteSpace();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\Characters.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */