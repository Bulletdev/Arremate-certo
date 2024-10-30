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

public interface CTHMerge extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTHMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cthmerge1bf8type");
  
  STMerge.Enum getVal();
  
  STMerge xgetVal();
  
  boolean isSetVal();
  
  void setVal(STMerge.Enum paramEnum);
  
  void xsetVal(STMerge paramSTMerge);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTHMerge newInstance() {
      return (CTHMerge)POIXMLTypeLoader.newInstance(CTHMerge.type, null);
    }
    
    public static CTHMerge newInstance(XmlOptions param1XmlOptions) {
      return (CTHMerge)POIXMLTypeLoader.newInstance(CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(String param1String) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1String, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1String, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(File param1File) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1File, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1File, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(URL param1URL) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1URL, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1URL, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1InputStream, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1InputStream, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(Reader param1Reader) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1Reader, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1Reader, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(Node param1Node) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1Node, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1Node, CTHMerge.type, param1XmlOptions);
    }
    
    public static CTHMerge parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1XMLInputStream, CTHMerge.type, null);
    }
    
    public static CTHMerge parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTHMerge)POIXMLTypeLoader.parse(param1XMLInputStream, CTHMerge.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHMerge.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTHMerge.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTHMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */