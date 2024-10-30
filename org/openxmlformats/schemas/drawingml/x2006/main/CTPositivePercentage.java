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

public interface CTPositivePercentage extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPositivePercentage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpositivepercentage2f8etype");
  
  int getVal();
  
  STPositivePercentage xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STPositivePercentage paramSTPositivePercentage);
  
  public static final class Factory {
    public static CTPositivePercentage newInstance() {
      return (CTPositivePercentage)POIXMLTypeLoader.newInstance(CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage newInstance(XmlOptions param1XmlOptions) {
      return (CTPositivePercentage)POIXMLTypeLoader.newInstance(CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(String param1String) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1String, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1String, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(File param1File) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1File, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1File, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(URL param1URL) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1URL, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1URL, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1InputStream, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1InputStream, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1Reader, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1Reader, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(Node param1Node) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1Node, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1Node, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static CTPositivePercentage parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositivePercentage.type, null);
    }
    
    public static CTPositivePercentage parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPositivePercentage)POIXMLTypeLoader.parse(param1XMLInputStream, CTPositivePercentage.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositivePercentage.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPositivePercentage.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPositivePercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */