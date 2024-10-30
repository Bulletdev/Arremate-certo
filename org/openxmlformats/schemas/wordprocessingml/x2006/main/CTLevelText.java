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

public interface CTLevelText extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLevelText.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctleveltext0621type");
  
  String getVal();
  
  STString xgetVal();
  
  boolean isSetVal();
  
  void setVal(String paramString);
  
  void xsetVal(STString paramSTString);
  
  void unsetVal();
  
  STOnOff.Enum getNull();
  
  STOnOff xgetNull();
  
  boolean isSetNull();
  
  void setNull(STOnOff.Enum paramEnum);
  
  void xsetNull(STOnOff paramSTOnOff);
  
  void unsetNull();
  
  public static final class Factory {
    public static CTLevelText newInstance() {
      return (CTLevelText)POIXMLTypeLoader.newInstance(CTLevelText.type, null);
    }
    
    public static CTLevelText newInstance(XmlOptions param1XmlOptions) {
      return (CTLevelText)POIXMLTypeLoader.newInstance(CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(String param1String) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1String, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1String, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(File param1File) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1File, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1File, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(URL param1URL) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1URL, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1URL, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1InputStream, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1InputStream, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1Reader, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1Reader, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(Node param1Node) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1Node, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1Node, CTLevelText.type, param1XmlOptions);
    }
    
    public static CTLevelText parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1XMLInputStream, CTLevelText.type, null);
    }
    
    public static CTLevelText parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLevelText)POIXMLTypeLoader.parse(param1XMLInputStream, CTLevelText.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLevelText.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLevelText.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTLevelText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */