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

public interface CTPresetLineDashProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPresetLineDashProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpresetlinedashproperties4553type");
  
  STPresetLineDashVal.Enum getVal();
  
  STPresetLineDashVal xgetVal();
  
  boolean isSetVal();
  
  void setVal(STPresetLineDashVal.Enum paramEnum);
  
  void xsetVal(STPresetLineDashVal paramSTPresetLineDashVal);
  
  void unsetVal();
  
  public static final class Factory {
    public static CTPresetLineDashProperties newInstance() {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.newInstance(CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.newInstance(CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(String param1String) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1String, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1String, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(File param1File) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1File, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1File, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1URL, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1URL, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1InputStream, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1InputStream, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1Reader, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1Reader, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(Node param1Node) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1Node, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1Node, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static CTPresetLineDashProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresetLineDashProperties.type, null);
    }
    
    public static CTPresetLineDashProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPresetLineDashProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTPresetLineDashProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresetLineDashProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPresetLineDashProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPresetLineDashProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */