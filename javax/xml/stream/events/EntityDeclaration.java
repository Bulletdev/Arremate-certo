package javax.xml.stream.events;

public interface EntityDeclaration extends XMLEvent {
  String getPublicId();
  
  String getSystemId();
  
  String getName();
  
  String getNotationName();
  
  String getReplacementText();
  
  String getBaseURI();
}


/* Location:              C:\Arremate\Arremate.jar!\javax\xml\stream\events\EntityDeclaration.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */