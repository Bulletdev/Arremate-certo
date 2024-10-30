package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

public interface CTSheet extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheet.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheet4dbetype");
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  long getSheetId();
  
  XmlUnsignedInt xgetSheetId();
  
  void setSheetId(long paramLong);
  
  void xsetSheetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  STSheetState.Enum getState();
  
  STSheetState xgetState();
  
  boolean isSetState();
  
  void setState(STSheetState.Enum paramEnum);
  
  void xsetState(STSheetState paramSTSheetState);
  
  void unsetState();
  
  String getId();
  
  STRelationshipId xgetId();
  
  void setId(String paramString);
  
  void xsetId(STRelationshipId paramSTRelationshipId);
  
  public static final class Factory {
    public static CTSheet newInstance() {
      return (CTSheet)POIXMLTypeLoader.newInstance(CTSheet.type, null);
    }
    
    public static CTSheet newInstance(XmlOptions param1XmlOptions) {
      return (CTSheet)POIXMLTypeLoader.newInstance(CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(String param1String) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1String, CTSheet.type, null);
    }
    
    public static CTSheet parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1String, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(File param1File) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1File, CTSheet.type, null);
    }
    
    public static CTSheet parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1File, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(URL param1URL) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1URL, CTSheet.type, null);
    }
    
    public static CTSheet parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1URL, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1InputStream, CTSheet.type, null);
    }
    
    public static CTSheet parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1InputStream, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1Reader, CTSheet.type, null);
    }
    
    public static CTSheet parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheet)POIXMLTypeLoader.parse(param1Reader, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheet.type, null);
    }
    
    public static CTSheet parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(Node param1Node) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1Node, CTSheet.type, null);
    }
    
    public static CTSheet parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheet)POIXMLTypeLoader.parse(param1Node, CTSheet.type, param1XmlOptions);
    }
    
    public static CTSheet parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheet.type, null);
    }
    
    public static CTSheet parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheet)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheet.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheet.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheet.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */