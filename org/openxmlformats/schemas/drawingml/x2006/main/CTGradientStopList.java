package org.openxmlformats.schemas.drawingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTGradientStopList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGradientStopList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgradientstoplist7eabtype");
  
  List<CTGradientStop> getGsList();
  
  CTGradientStop[] getGsArray();
  
  CTGradientStop getGsArray(int paramInt);
  
  int sizeOfGsArray();
  
  void setGsArray(CTGradientStop[] paramArrayOfCTGradientStop);
  
  void setGsArray(int paramInt, CTGradientStop paramCTGradientStop);
  
  CTGradientStop insertNewGs(int paramInt);
  
  CTGradientStop addNewGs();
  
  void removeGs(int paramInt);
  
  public static final class Factory {
    public static CTGradientStopList newInstance() {
      return (CTGradientStopList)POIXMLTypeLoader.newInstance(CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList newInstance(XmlOptions param1XmlOptions) {
      return (CTGradientStopList)POIXMLTypeLoader.newInstance(CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(String param1String) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1String, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1String, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(File param1File) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1File, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1File, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(URL param1URL) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1URL, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1URL, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1InputStream, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1InputStream, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1Reader, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1Reader, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(Node param1Node) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1Node, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1Node, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static CTGradientStopList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientStopList.type, null);
    }
    
    public static CTGradientStopList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGradientStopList)POIXMLTypeLoader.parse(param1XMLInputStream, CTGradientStopList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientStopList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGradientStopList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGradientStopList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */