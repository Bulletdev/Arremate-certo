package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTStrData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTStrData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctstrdatad58btype");
  
  CTUnsignedInt getPtCount();
  
  boolean isSetPtCount();
  
  void setPtCount(CTUnsignedInt paramCTUnsignedInt);
  
  CTUnsignedInt addNewPtCount();
  
  void unsetPtCount();
  
  List<CTStrVal> getPtList();
  
  CTStrVal[] getPtArray();
  
  CTStrVal getPtArray(int paramInt);
  
  int sizeOfPtArray();
  
  void setPtArray(CTStrVal[] paramArrayOfCTStrVal);
  
  void setPtArray(int paramInt, CTStrVal paramCTStrVal);
  
  CTStrVal insertNewPt(int paramInt);
  
  CTStrVal addNewPt();
  
  void removePt(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTStrData newInstance() {
      return (CTStrData)POIXMLTypeLoader.newInstance(CTStrData.type, null);
    }
    
    public static CTStrData newInstance(XmlOptions param1XmlOptions) {
      return (CTStrData)POIXMLTypeLoader.newInstance(CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(String param1String) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1String, CTStrData.type, null);
    }
    
    public static CTStrData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1String, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(File param1File) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1File, CTStrData.type, null);
    }
    
    public static CTStrData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1File, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(URL param1URL) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1URL, CTStrData.type, null);
    }
    
    public static CTStrData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1URL, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1InputStream, CTStrData.type, null);
    }
    
    public static CTStrData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1InputStream, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1Reader, CTStrData.type, null);
    }
    
    public static CTStrData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTStrData)POIXMLTypeLoader.parse(param1Reader, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrData.type, null);
    }
    
    public static CTStrData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(Node param1Node) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1Node, CTStrData.type, null);
    }
    
    public static CTStrData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTStrData)POIXMLTypeLoader.parse(param1Node, CTStrData.type, param1XmlOptions);
    }
    
    public static CTStrData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTStrData)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrData.type, null);
    }
    
    public static CTStrData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTStrData)POIXMLTypeLoader.parse(param1XMLInputStream, CTStrData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTStrData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTStrData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */