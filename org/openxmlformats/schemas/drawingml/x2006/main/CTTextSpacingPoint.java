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

public interface CTTextSpacingPoint extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTextSpacingPoint.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttextspacingpoint6cf5type");
  
  int getVal();
  
  STTextSpacingPoint xgetVal();
  
  void setVal(int paramInt);
  
  void xsetVal(STTextSpacingPoint paramSTTextSpacingPoint);
  
  public static final class Factory {
    public static CTTextSpacingPoint newInstance() {
      return (CTTextSpacingPoint)POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint newInstance(XmlOptions param1XmlOptions) {
      return (CTTextSpacingPoint)POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(String param1String) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1String, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1String, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(File param1File) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1File, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1File, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(URL param1URL) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1URL, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1URL, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1InputStream, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1Reader, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1Reader, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(Node param1Node) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1Node, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1Node, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static CTTextSpacingPoint parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacingPoint.type, null);
    }
    
    public static CTTextSpacingPoint parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTextSpacingPoint)POIXMLTypeLoader.parse(param1XMLInputStream, CTTextSpacingPoint.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacingPoint.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTextSpacingPoint.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTTextSpacingPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */