package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbr7dd8type");
  
  STBrType.Enum getType();
  
  STBrType xgetType();
  
  boolean isSetType();
  
  void setType(STBrType.Enum paramEnum);
  
  void xsetType(STBrType paramSTBrType);
  
  void unsetType();
  
  STBrClear.Enum getClear();
  
  STBrClear xgetClear();
  
  boolean isSetClear();
  
  void setClear(STBrClear.Enum paramEnum);
  
  void xsetClear(STBrClear paramSTBrClear);
  
  void unsetClear();
  
  public static final class Factory {
    public static CTBr newInstance() {
      return (CTBr)POIXMLTypeLoader.newInstance(CTBr.type, null);
    }
    
    public static CTBr newInstance(XmlOptions param1XmlOptions) {
      return (CTBr)POIXMLTypeLoader.newInstance(CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(String param1String) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1String, CTBr.type, null);
    }
    
    public static CTBr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1String, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(File param1File) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1File, CTBr.type, null);
    }
    
    public static CTBr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1File, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(URL param1URL) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1URL, CTBr.type, null);
    }
    
    public static CTBr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1URL, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1InputStream, CTBr.type, null);
    }
    
    public static CTBr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1InputStream, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1Reader, CTBr.type, null);
    }
    
    public static CTBr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBr)POIXMLTypeLoader.parse(param1Reader, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBr.type, null);
    }
    
    public static CTBr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(Node param1Node) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1Node, CTBr.type, null);
    }
    
    public static CTBr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBr)POIXMLTypeLoader.parse(param1Node, CTBr.type, param1XmlOptions);
    }
    
    public static CTBr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBr)POIXMLTypeLoader.parse(param1XMLInputStream, CTBr.type, null);
    }
    
    public static CTBr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBr)POIXMLTypeLoader.parse(param1XMLInputStream, CTBr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTBr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */