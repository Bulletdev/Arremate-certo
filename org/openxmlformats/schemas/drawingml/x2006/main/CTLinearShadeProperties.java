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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTLinearShadeProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLinearShadeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinearshadeproperties7f0ctype");
  
  int getAng();
  
  STPositiveFixedAngle xgetAng();
  
  boolean isSetAng();
  
  void setAng(int paramInt);
  
  void xsetAng(STPositiveFixedAngle paramSTPositiveFixedAngle);
  
  void unsetAng();
  
  boolean getScaled();
  
  XmlBoolean xgetScaled();
  
  boolean isSetScaled();
  
  void setScaled(boolean paramBoolean);
  
  void xsetScaled(XmlBoolean paramXmlBoolean);
  
  void unsetScaled();
  
  public static final class Factory {
    public static CTLinearShadeProperties newInstance() {
      return (CTLinearShadeProperties)POIXMLTypeLoader.newInstance(CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTLinearShadeProperties)POIXMLTypeLoader.newInstance(CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(String param1String) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1String, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1String, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(File param1File) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1File, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1File, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1URL, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1URL, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1InputStream, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1InputStream, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1Reader, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1Reader, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(Node param1Node) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1Node, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1Node, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static CTLinearShadeProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLinearShadeProperties.type, null);
    }
    
    public static CTLinearShadeProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLinearShadeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLinearShadeProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLinearShadeProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLinearShadeProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTLinearShadeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */