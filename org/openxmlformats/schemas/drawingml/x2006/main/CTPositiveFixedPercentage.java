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

public interface CTPositiveFixedPercentage extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPositiveFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpositivefixedpercentage8966type");
  
  int getVal();
  
  STPositiveFixedPercentage xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STPositiveFixedPercentage paramSTPositiveFixedPercentage);
  
  public static final class Factory {
    public static CTPositiveFixedPercentage newInstance() {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.newInstance(CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage newInstance(XmlOptions param1XmlOptions) {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.newInstance(CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(String param1String) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1String, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1String, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(File param1File) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1File, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1File, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(URL param1URL) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1URL, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1URL, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Reader, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Reader, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(Node param1Node) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Node, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1Node, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTPositiveFixedPercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositiveFixedPercentage.type, null);
    }
    
    public static CTPositiveFixedPercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPositiveFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositiveFixedPercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositiveFixedPercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPositiveFixedPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */