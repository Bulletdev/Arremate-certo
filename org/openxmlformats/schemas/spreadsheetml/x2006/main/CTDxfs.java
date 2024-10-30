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

public interface CTDxfs extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDxfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdxfsb26atype");
  
  List<CTDxf> getDxfList();
  
  CTDxf[] getDxfArray();
  
  CTDxf getDxfArray(int paramInt);
  
  int sizeOfDxfArray();
  
  void setDxfArray(CTDxf[] paramArrayOfCTDxf);
  
  void setDxfArray(int paramInt, CTDxf paramCTDxf);
  
  CTDxf insertNewDxf(int paramInt);
  
  CTDxf addNewDxf();
  
  void removeDxf(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTDxfs newInstance() {
      return (CTDxfs)POIXMLTypeLoader.newInstance(CTDxfs.type, null);
    }
    
    public static CTDxfs newInstance(XmlOptions param1XmlOptions) {
      return (CTDxfs)POIXMLTypeLoader.newInstance(CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(String param1String) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1String, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1String, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(File param1File) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1File, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1File, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(URL param1URL) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1URL, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1URL, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1InputStream, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1InputStream, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1Reader, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1Reader, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(Node param1Node) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1Node, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1Node, CTDxfs.type, param1XmlOptions);
    }
    
    public static CTDxfs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTDxfs.type, null);
    }
    
    public static CTDxfs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDxfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTDxfs.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDxfs.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDxfs.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDxfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */