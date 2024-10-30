package javax.xml.stream.events;

import java.util.List;

public interface DTD extends XMLEvent {
  String getDocumentTypeDeclaration();
  
  Object getProcessedDTD();
  
  List getNotations();
  
  List getEntities();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\DTD.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */