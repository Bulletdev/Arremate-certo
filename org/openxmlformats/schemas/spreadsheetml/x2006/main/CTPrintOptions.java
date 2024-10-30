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

public interface CTPrintOptions extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPrintOptions.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctprintoptions943atype");
  
  boolean getHorizontalCentered();
  
  XmlBoolean xgetHorizontalCentered();
  
  boolean isSetHorizontalCentered();
  
  void setHorizontalCentered(boolean paramBoolean);
  
  void xsetHorizontalCentered(XmlBoolean paramXmlBoolean);
  
  void unsetHorizontalCentered();
  
  boolean getVerticalCentered();
  
  XmlBoolean xgetVerticalCentered();
  
  boolean isSetVerticalCentered();
  
  void setVerticalCentered(boolean paramBoolean);
  
  void xsetVerticalCentered(XmlBoolean paramXmlBoolean);
  
  void unsetVerticalCentered();
  
  boolean getHeadings();
  
  XmlBoolean xgetHeadings();
  
  boolean isSetHeadings();
  
  void setHeadings(boolean paramBoolean);
  
  void xsetHeadings(XmlBoolean paramXmlBoolean);
  
  void unsetHeadings();
  
  boolean getGridLines();
  
  XmlBoolean xgetGridLines();
  
  boolean isSetGridLines();
  
  void setGridLines(boolean paramBoolean);
  
  void xsetGridLines(XmlBoolean paramXmlBoolean);
  
  void unsetGridLines();
  
  boolean getGridLinesSet();
  
  XmlBoolean xgetGridLinesSet();
  
  boolean isSetGridLinesSet();
  
  void setGridLinesSet(boolean paramBoolean);
  
  void xsetGridLinesSet(XmlBoolean paramXmlBoolean);
  
  void unsetGridLinesSet();
  
  public static final class Factory {
    public static CTPrintOptions newInstance() {
      return (CTPrintOptions)POIXMLTypeLoader.newInstance(CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions newInstance(XmlOptions param1XmlOptions) {
      return (CTPrintOptions)POIXMLTypeLoader.newInstance(CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(String param1String) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1String, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1String, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(File param1File) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1File, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1File, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(URL param1URL) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1URL, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1URL, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1InputStream, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1InputStream, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1Reader, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1Reader, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(Node param1Node) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1Node, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1Node, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static CTPrintOptions parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1XMLInputStream, CTPrintOptions.type, null);
    }
    
    public static CTPrintOptions parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPrintOptions)POIXMLTypeLoader.parse(param1XMLInputStream, CTPrintOptions.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPrintOptions.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPrintOptions.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPrintOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */