package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTTablePartStyle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTablePartStyle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablepartstylef22btype");
  
  CTTableStyleTextStyle getTcTxStyle();
  
  boolean isSetTcTxStyle();
  
  void setTcTxStyle(CTTableStyleTextStyle paramCTTableStyleTextStyle);
  
  CTTableStyleTextStyle addNewTcTxStyle();
  
  void unsetTcTxStyle();
  
  CTTableStyleCellStyle getTcStyle();
  
  boolean isSetTcStyle();
  
  void setTcStyle(CTTableStyleCellStyle paramCTTableStyleCellStyle);
  
  CTTableStyleCellStyle addNewTcStyle();
  
  void unsetTcStyle();
  
  public static final class Factory {
    public static CTTablePartStyle newInstance() {
      return (CTTablePartStyle)POIXMLTypeLoader.newInstance(CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle newInstance(XmlOptions param1XmlOptions) {
      return (CTTablePartStyle)POIXMLTypeLoader.newInstance(CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(String param1String) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1String, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1String, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(File param1File) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1File, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1File, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(URL param1URL) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1URL, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1URL, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1InputStream, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1InputStream, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1Reader, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1Reader, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(Node param1Node) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1Node, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1Node, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static CTTablePartStyle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTablePartStyle.type, null);
    }
    
    public static CTTablePartStyle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTablePartStyle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTablePartStyle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTablePartStyle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTablePartStyle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTablePartStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */