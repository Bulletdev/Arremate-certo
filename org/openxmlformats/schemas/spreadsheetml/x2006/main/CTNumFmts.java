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

public interface CTNumFmts extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTNumFmts.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctnumfmtsb58btype");
  
  List<CTNumFmt> getNumFmtList();
  
  CTNumFmt[] getNumFmtArray();
  
  CTNumFmt getNumFmtArray(int paramInt);
  
  int sizeOfNumFmtArray();
  
  void setNumFmtArray(CTNumFmt[] paramArrayOfCTNumFmt);
  
  void setNumFmtArray(int paramInt, CTNumFmt paramCTNumFmt);
  
  CTNumFmt insertNewNumFmt(int paramInt);
  
  CTNumFmt addNewNumFmt();
  
  void removeNumFmt(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTNumFmts newInstance() {
      return (CTNumFmts)POIXMLTypeLoader.newInstance(CTNumFmts.type, null);
    }
    
    public static CTNumFmts newInstance(XmlOptions param1XmlOptions) {
      return (CTNumFmts)POIXMLTypeLoader.newInstance(CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(String param1String) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1String, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1String, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(File param1File) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1File, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1File, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(URL param1URL) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1URL, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1URL, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1InputStream, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1InputStream, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(Reader param1Reader) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1Reader, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1Reader, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1XMLStreamReader, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(Node param1Node) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1Node, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1Node, CTNumFmts.type, param1XmlOptions);
    }
    
    public static CTNumFmts parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumFmts.type, null);
    }
    
    public static CTNumFmts parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTNumFmts)POIXMLTypeLoader.parse(param1XMLInputStream, CTNumFmts.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumFmts.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTNumFmts.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTNumFmts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */