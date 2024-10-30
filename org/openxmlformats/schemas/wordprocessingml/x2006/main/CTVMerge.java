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

public interface CTVMerge extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTVMerge.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctvmergee086type");
  
  STMerge.Enum getVal();
  
  STMerge xgetVal();
  
  boolean isSetVal();
  
  void setVal(STMerge.Enum paramEnum);
  
  void xsetVal(STMerge paramSTMerge);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTVMerge newInstance() {
      return (CTVMerge)POIXMLTypeLoader.newInstance(CTVMerge.type, null);
    }
    
    public static CTVMerge newInstance(XmlOptions param1XmlOptions) {
      return (CTVMerge)POIXMLTypeLoader.newInstance(CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(String param1String) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1String, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1String, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(File param1File) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1File, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1File, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(URL param1URL) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1URL, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1URL, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1InputStream, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1InputStream, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(Reader param1Reader) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1Reader, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1Reader, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1XMLStreamReader, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(Node param1Node) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1Node, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1Node, CTVMerge.type, param1XmlOptions);
    }
    
    public static CTVMerge parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1XMLInputStream, CTVMerge.type, null);
    }
    
    public static CTVMerge parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTVMerge)POIXMLTypeLoader.parse(param1XMLInputStream, CTVMerge.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVMerge.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTVMerge.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTVMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */