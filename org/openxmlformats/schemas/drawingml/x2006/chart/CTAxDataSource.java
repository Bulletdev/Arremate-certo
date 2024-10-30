package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTAxDataSource extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAxDataSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctaxdatasource1440type");
  
  CTMultiLvlStrRef getMultiLvlStrRef();
  
  boolean isSetMultiLvlStrRef();
  
  void setMultiLvlStrRef(CTMultiLvlStrRef paramCTMultiLvlStrRef);
  
  CTMultiLvlStrRef addNewMultiLvlStrRef();
  
  void unsetMultiLvlStrRef();
  
  CTNumRef getNumRef();
  
  boolean isSetNumRef();
  
  void setNumRef(CTNumRef paramCTNumRef);
  
  CTNumRef addNewNumRef();
  
  void unsetNumRef();
  
  CTNumData getNumLit();
  
  boolean isSetNumLit();
  
  void setNumLit(CTNumData paramCTNumData);
  
  CTNumData addNewNumLit();
  
  void unsetNumLit();
  
  CTStrRef getStrRef();
  
  boolean isSetStrRef();
  
  void setStrRef(CTStrRef paramCTStrRef);
  
  CTStrRef addNewStrRef();
  
  void unsetStrRef();
  
  CTStrData getStrLit();
  
  boolean isSetStrLit();
  
  void setStrLit(CTStrData paramCTStrData);
  
  CTStrData addNewStrLit();
  
  void unsetStrLit();
  
  public static final class Factory {
    public static CTAxDataSource newInstance() {
      return (CTAxDataSource)POIXMLTypeLoader.newInstance(CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource newInstance(XmlOptions param1XmlOptions) {
      return (CTAxDataSource)POIXMLTypeLoader.newInstance(CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(String param1String) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1String, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1String, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(File param1File) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1File, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1File, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(URL param1URL) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1URL, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1URL, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1InputStream, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1InputStream, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1Reader, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1Reader, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(Node param1Node) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1Node, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1Node, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static CTAxDataSource parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTAxDataSource.type, null);
    }
    
    public static CTAxDataSource parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAxDataSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTAxDataSource.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAxDataSource.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAxDataSource.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTAxDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */