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

public interface CTNumDataSource extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumDataSource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumdatasourcef0bbtype");
  
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
  
  public static final class Factory {
    public static CTNumDataSource newInstance() {
      return (CTNumDataSource)POIXMLTypeLoader.newInstance(CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource newInstance(XmlOptions param1XmlOptions) {
      return (CTNumDataSource)POIXMLTypeLoader.newInstance(CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(String param1String) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1String, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1String, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(File param1File) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1File, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1File, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(URL param1URL) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1URL, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1URL, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1InputStream, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1InputStream, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1Reader, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1Reader, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(Node param1Node) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1Node, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1Node, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static CTNumDataSource parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumDataSource.type, null);
    }
    
    public static CTNumDataSource parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumDataSource)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumDataSource.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumDataSource.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumDataSource.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTNumDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */