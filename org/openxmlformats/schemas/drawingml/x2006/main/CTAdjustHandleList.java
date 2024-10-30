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

public interface CTAdjustHandleList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTAdjustHandleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctadjusthandlelistfdb0type");
  
  List<CTXYAdjustHandle> getAhXYList();
  
  CTXYAdjustHandle[] getAhXYArray();
  
  CTXYAdjustHandle getAhXYArray(int paramInt);
  
  int sizeOfAhXYArray();
  
  void setAhXYArray(CTXYAdjustHandle[] paramArrayOfCTXYAdjustHandle);
  
  void setAhXYArray(int paramInt, CTXYAdjustHandle paramCTXYAdjustHandle);
  
  CTXYAdjustHandle insertNewAhXY(int paramInt);
  
  CTXYAdjustHandle addNewAhXY();
  
  void removeAhXY(int paramInt);
  
  List<CTPolarAdjustHandle> getAhPolarList();
  
  CTPolarAdjustHandle[] getAhPolarArray();
  
  CTPolarAdjustHandle getAhPolarArray(int paramInt);
  
  int sizeOfAhPolarArray();
  
  void setAhPolarArray(CTPolarAdjustHandle[] paramArrayOfCTPolarAdjustHandle);
  
  void setAhPolarArray(int paramInt, CTPolarAdjustHandle paramCTPolarAdjustHandle);
  
  CTPolarAdjustHandle insertNewAhPolar(int paramInt);
  
  CTPolarAdjustHandle addNewAhPolar();
  
  void removeAhPolar(int paramInt);
  
  public static final class Factory {
    public static CTAdjustHandleList newInstance() {
      return (CTAdjustHandleList)POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList newInstance(XmlOptions param1XmlOptions) {
      return (CTAdjustHandleList)POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(String param1String) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1String, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1String, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(File param1File) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1File, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1File, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(URL param1URL) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1URL, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1URL, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1InputStream, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1InputStream, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1Reader, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1Reader, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(Node param1Node) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1Node, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1Node, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static CTAdjustHandleList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTAdjustHandleList.type, null);
    }
    
    public static CTAdjustHandleList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTAdjustHandleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTAdjustHandleList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAdjustHandleList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTAdjustHandleList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTAdjustHandleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */