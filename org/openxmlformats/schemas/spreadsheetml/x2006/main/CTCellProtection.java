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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCellProtection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCellProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellprotectionf524type");
  
  boolean getLocked();
  
  XmlBoolean xgetLocked();
  
  boolean isSetLocked();
  
  void setLocked(boolean paramBoolean);
  
  void xsetLocked(XmlBoolean paramXmlBoolean);
  
  void unsetLocked();
  
  boolean getHidden();
  
  XmlBoolean xgetHidden();
  
  boolean isSetHidden();
  
  void setHidden(boolean paramBoolean);
  
  void xsetHidden(XmlBoolean paramXmlBoolean);
  
  void unsetHidden();
  
  public static final class Factory {
    public static CTCellProtection newInstance() {
      return (CTCellProtection)POIXMLTypeLoader.newInstance(CTCellProtection.type, null);
    }
    
    public static CTCellProtection newInstance(XmlOptions param1XmlOptions) {
      return (CTCellProtection)POIXMLTypeLoader.newInstance(CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(String param1String) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1String, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1String, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(File param1File) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1File, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1File, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(URL param1URL) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1URL, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1URL, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1InputStream, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1InputStream, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1Reader, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1Reader, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(Node param1Node) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1Node, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1Node, CTCellProtection.type, param1XmlOptions);
    }
    
    public static CTCellProtection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellProtection.type, null);
    }
    
    public static CTCellProtection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCellProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellProtection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellProtection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellProtection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCellProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */