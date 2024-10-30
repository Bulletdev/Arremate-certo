package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPageBreak extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPageBreak.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagebreakeb4ftype");
  
  List<CTBreak> getBrkList();
  
  CTBreak[] getBrkArray();
  
  CTBreak getBrkArray(int paramInt);
  
  int sizeOfBrkArray();
  
  void setBrkArray(CTBreak[] paramArrayOfCTBreak);
  
  void setBrkArray(int paramInt, CTBreak paramCTBreak);
  
  CTBreak insertNewBrk(int paramInt);
  
  CTBreak addNewBrk();
  
  void removeBrk(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  long getManualBreakCount();
  
  XmlUnsignedInt xgetManualBreakCount();
  
  boolean isSetManualBreakCount();
  
  void setManualBreakCount(long paramLong);
  
  void xsetManualBreakCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetManualBreakCount();
  
  public static final class Factory {
    public static CTPageBreak newInstance() {
      return (CTPageBreak)POIXMLTypeLoader.newInstance(CTPageBreak.type, null);
    }
    
    public static CTPageBreak newInstance(XmlOptions param1XmlOptions) {
      return (CTPageBreak)POIXMLTypeLoader.newInstance(CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(String param1String) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1String, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1String, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(File param1File) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1File, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1File, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(URL param1URL) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1URL, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1URL, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1InputStream, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1InputStream, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1Reader, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1Reader, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(Node param1Node) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1Node, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1Node, CTPageBreak.type, param1XmlOptions);
    }
    
    public static CTPageBreak parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageBreak.type, null);
    }
    
    public static CTPageBreak parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPageBreak)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageBreak.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageBreak.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageBreak.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPageBreak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */