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

public interface CTFixedPercentage extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFixedPercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctfixedpercentagea2dftype");
  
  int getVal();
  
  STFixedPercentage xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STFixedPercentage paramSTFixedPercentage);
  
  public static final class Factory {
    public static CTFixedPercentage newInstance() {
      return (CTFixedPercentage)POIXMLTypeLoader.newInstance(CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage newInstance(XmlOptions param1XmlOptions) {
      return (CTFixedPercentage)POIXMLTypeLoader.newInstance(CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(String param1String) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1String, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1String, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(File param1File) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1File, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1File, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(URL param1URL) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1URL, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1URL, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1InputStream, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1Reader, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1Reader, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(Node param1Node) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1Node, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1Node, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static CTFixedPercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTFixedPercentage.type, null);
    }
    
    public static CTFixedPercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFixedPercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTFixedPercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFixedPercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFixedPercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTFixedPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */