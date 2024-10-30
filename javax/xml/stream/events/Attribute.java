package javax.xml.stream.events;

import javax.xml.namespace.b;

public interface Attribute extends XMLEvent {
  b getName();
  
  String getValue();
  
  String getDTDType();
  
  boolean isSpecified();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\Attribute.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */