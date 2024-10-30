package javax.xml.stream.events;

import java.util.Iterator;
import javax.xml.namespace.a;
import javax.xml.namespace.b;

public interface StartElement extends XMLEvent {
  b getName();
  
  Iterator getAttributes();
  
  Iterator getNamespaces();
  
  Attribute getAttributeByName(b paramb);
  
  a getNamespaceContext();
  
  String getNamespaceURI(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\StartElement.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */