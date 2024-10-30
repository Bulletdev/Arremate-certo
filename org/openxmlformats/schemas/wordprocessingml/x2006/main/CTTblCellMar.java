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

public interface CTTblCellMar extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblCellMar.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblcellmar66eatype");
  
  CTTblWidth getTop();
  
  boolean isSetTop();
  
  void setTop(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewTop();
  
  void unsetTop();
  
  CTTblWidth getLeft();
  
  boolean isSetLeft();
  
  void setLeft(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewLeft();
  
  void unsetLeft();
  
  CTTblWidth getBottom();
  
  boolean isSetBottom();
  
  void setBottom(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewBottom();
  
  void unsetBottom();
  
  CTTblWidth getRight();
  
  boolean isSetRight();
  
  void setRight(CTTblWidth paramCTTblWidth);
  
  CTTblWidth addNewRight();
  
  void unsetRight();
  
  public static final class Factory {
    public static CTTblCellMar newInstance() {
      return (CTTblCellMar)POIXMLTypeLoader.newInstance(CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar newInstance(XmlOptions param1XmlOptions) {
      return (CTTblCellMar)POIXMLTypeLoader.newInstance(CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(String param1String) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1String, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1String, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(File param1File) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1File, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1File, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(URL param1URL) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1URL, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1URL, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1InputStream, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1InputStream, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1Reader, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1Reader, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(Node param1Node) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1Node, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1Node, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static CTTblCellMar parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblCellMar.type, null);
    }
    
    public static CTTblCellMar parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblCellMar)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblCellMar.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblCellMar.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblCellMar.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblCellMar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */