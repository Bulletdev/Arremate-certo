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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBoolean extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBoolean.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbooleancc3etype");
  
  boolean getVal();
  
  XmlBoolean xgetVal();
  
  boolean isSetVal();
  
  void setVal(boolean paramBoolean);
  
  void xsetVal(XmlBoolean paramXmlBoolean);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTBoolean newInstance() {
      return (CTBoolean)POIXMLTypeLoader.newInstance(CTBoolean.type, null);
    }
    
    public static CTBoolean newInstance(XmlOptions param1XmlOptions) {
      return (CTBoolean)POIXMLTypeLoader.newInstance(CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(String param1String) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1String, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1String, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(File param1File) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1File, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1File, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(URL param1URL) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1URL, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1URL, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1InputStream, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1InputStream, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1Reader, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1Reader, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(Node param1Node) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1Node, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1Node, CTBoolean.type, param1XmlOptions);
    }
    
    public static CTBoolean parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1XMLInputStream, CTBoolean.type, null);
    }
    
    public static CTBoolean parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBoolean)POIXMLTypeLoader.parse(param1XMLInputStream, CTBoolean.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBoolean.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBoolean.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTBoolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */