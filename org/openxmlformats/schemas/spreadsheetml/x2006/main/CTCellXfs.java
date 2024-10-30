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

public interface CTCellXfs extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCellXfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellxfs1322type");
  
  List<CTXf> getXfList();
  
  CTXf[] getXfArray();
  
  CTXf getXfArray(int paramInt);
  
  int sizeOfXfArray();
  
  void setXfArray(CTXf[] paramArrayOfCTXf);
  
  void setXfArray(int paramInt, CTXf paramCTXf);
  
  CTXf insertNewXf(int paramInt);
  
  CTXf addNewXf();
  
  void removeXf(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTCellXfs newInstance() {
      return (CTCellXfs)POIXMLTypeLoader.newInstance(CTCellXfs.type, null);
    }
    
    public static CTCellXfs newInstance(XmlOptions param1XmlOptions) {
      return (CTCellXfs)POIXMLTypeLoader.newInstance(CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(String param1String) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1String, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1String, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(File param1File) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1File, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1File, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(URL param1URL) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1URL, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1URL, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1InputStream, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1InputStream, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1Reader, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1Reader, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(Node param1Node) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1Node, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1Node, CTCellXfs.type, param1XmlOptions);
    }
    
    public static CTCellXfs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellXfs.type, null);
    }
    
    public static CTCellXfs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCellXfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellXfs.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellXfs.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellXfs.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCellXfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */