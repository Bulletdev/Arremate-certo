package org.openxmlformats.schemas.presentationml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPlaceholder extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPlaceholder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctplaceholder9efctype");
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  STPlaceholderType.Enum getType();
  
  STPlaceholderType xgetType();
  
  boolean isSetType();
  
  void setType(STPlaceholderType.Enum paramEnum);
  
  void xsetType(STPlaceholderType paramSTPlaceholderType);
  
  void unsetType();
  
  STDirection$Enum getOrient();
  
  STDirection xgetOrient();
  
  boolean isSetOrient();
  
  void setOrient(STDirection$Enum paramSTDirection$Enum);
  
  void xsetOrient(STDirection paramSTDirection);
  
  void unsetOrient();
  
  STPlaceholderSize$Enum getSz();
  
  STPlaceholderSize xgetSz();
  
  boolean isSetSz();
  
  void setSz(STPlaceholderSize$Enum paramSTPlaceholderSize$Enum);
  
  void xsetSz(STPlaceholderSize paramSTPlaceholderSize);
  
  void unsetSz();
  
  long getIdx();
  
  XmlUnsignedInt xgetIdx();
  
  boolean isSetIdx();
  
  void setIdx(long paramLong);
  
  void xsetIdx(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetIdx();
  
  boolean getHasCustomPrompt();
  
  XmlBoolean xgetHasCustomPrompt();
  
  boolean isSetHasCustomPrompt();
  
  void setHasCustomPrompt(boolean paramBoolean);
  
  void xsetHasCustomPrompt(XmlBoolean paramXmlBoolean);
  
  void unsetHasCustomPrompt();
  
  public static final class Factory {
    public static CTPlaceholder newInstance() {
      return (CTPlaceholder)POIXMLTypeLoader.newInstance(CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder newInstance(XmlOptions param1XmlOptions) {
      return (CTPlaceholder)POIXMLTypeLoader.newInstance(CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(String param1String) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1String, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1String, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(File param1File) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1File, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1File, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(URL param1URL) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1URL, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1URL, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1InputStream, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1InputStream, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1Reader, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1Reader, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(Node param1Node) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1Node, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1Node, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static CTPlaceholder parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1XMLInputStream, CTPlaceholder.type, null);
    }
    
    public static CTPlaceholder parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPlaceholder)POIXMLTypeLoader.parse(param1XMLInputStream, CTPlaceholder.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPlaceholder.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPlaceholder.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTPlaceholder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */