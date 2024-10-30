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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPatternFill extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPatternFill.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpatternfill7452type");
  
  CTColor getFgColor();
  
  boolean isSetFgColor();
  
  void setFgColor(CTColor paramCTColor);
  
  CTColor addNewFgColor();
  
  void unsetFgColor();
  
  CTColor getBgColor();
  
  boolean isSetBgColor();
  
  void setBgColor(CTColor paramCTColor);
  
  CTColor addNewBgColor();
  
  void unsetBgColor();
  
  STPatternType.Enum getPatternType();
  
  STPatternType xgetPatternType();
  
  boolean isSetPatternType();
  
  void setPatternType(STPatternType.Enum paramEnum);
  
  void xsetPatternType(STPatternType paramSTPatternType);
  
  void unsetPatternType();
  
  public static final class Factory {
    public static CTPatternFill newInstance() {
      return (CTPatternFill)POIXMLTypeLoader.newInstance(CTPatternFill.type, null);
    }
    
    public static CTPatternFill newInstance(XmlOptions param1XmlOptions) {
      return (CTPatternFill)POIXMLTypeLoader.newInstance(CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(String param1String) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1String, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1String, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(File param1File) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1File, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1File, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(URL param1URL) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1URL, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1URL, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1InputStream, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1InputStream, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1Reader, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1Reader, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(Node param1Node) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1Node, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1Node, CTPatternFill.type, param1XmlOptions);
    }
    
    public static CTPatternFill parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTPatternFill.type, null);
    }
    
    public static CTPatternFill parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPatternFill)POIXMLTypeLoader.parse(param1XMLInputStream, CTPatternFill.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPatternFill.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPatternFill.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPatternFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */