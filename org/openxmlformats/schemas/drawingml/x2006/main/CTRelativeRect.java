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

public interface CTRelativeRect extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRelativeRect.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrelativerecta4ebtype");
  
  int getL();
  
  STPercentage xgetL();
  
  boolean isSetL();
  
  void setL(int paramInt);
  
  void xsetL(STPercentage paramSTPercentage);
  
  void unsetL();
  
  int getT();
  
  STPercentage xgetT();
  
  boolean isSetT();
  
  void setT(int paramInt);
  
  void xsetT(STPercentage paramSTPercentage);
  
  void unsetT();
  
  int getR();
  
  STPercentage xgetR();
  
  boolean isSetR();
  
  void setR(int paramInt);
  
  void xsetR(STPercentage paramSTPercentage);
  
  void unsetR();
  
  int getB();
  
  STPercentage xgetB();
  
  boolean isSetB();
  
  void setB(int paramInt);
  
  void xsetB(STPercentage paramSTPercentage);
  
  void unsetB();
  
  public static final class Factory {
    public static CTRelativeRect newInstance() {
      return (CTRelativeRect)POIXMLTypeLoader.newInstance(CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect newInstance(XmlOptions param1XmlOptions) {
      return (CTRelativeRect)POIXMLTypeLoader.newInstance(CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(String param1String) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1String, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1String, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(File param1File) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1File, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1File, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(URL param1URL) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1URL, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1URL, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1InputStream, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1InputStream, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1Reader, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1Reader, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(Node param1Node) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1Node, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1Node, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static CTRelativeRect parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelativeRect.type, null);
    }
    
    public static CTRelativeRect parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRelativeRect)POIXMLTypeLoader.parse(param1XMLInputStream, CTRelativeRect.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelativeRect.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRelativeRect.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTRelativeRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */