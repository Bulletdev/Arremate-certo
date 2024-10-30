package org.apache.xmlbeans.xml.stream;

public interface XMLEvent {
  public static final int XML_EVENT = 1;
  
  public static final int START_ELEMENT = 2;
  
  public static final int END_ELEMENT = 4;
  
  public static final int PROCESSING_INSTRUCTION = 8;
  
  public static final int CHARACTER_DATA = 16;
  
  public static final int COMMENT = 32;
  
  public static final int SPACE = 64;
  
  public static final int NULL_ELEMENT = 128;
  
  public static final int START_DOCUMENT = 256;
  
  public static final int END_DOCUMENT = 512;
  
  public static final int START_PREFIX_MAPPING = 1024;
  
  public static final int END_PREFIX_MAPPING = 2048;
  
  public static final int CHANGE_PREFIX_MAPPING = 4096;
  
  public static final int ENTITY_REFERENCE = 8192;
  
  int getType();
  
  XMLName getSchemaType();
  
  String getTypeAsString();
  
  XMLName getName();
  
  boolean hasName();
  
  Location getLocation();
  
  boolean isStartElement();
  
  boolean isEndElement();
  
  boolean isEntityReference();
  
  boolean isStartPrefixMapping();
  
  boolean isEndPrefixMapping();
  
  boolean isChangePrefixMapping();
  
  boolean isProcessingInstruction();
  
  boolean isCharacterData();
  
  boolean isSpace();
  
  boolean isNull();
  
  boolean isStartDocument();
  
  boolean isEndDocument();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\XMLEvent.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */