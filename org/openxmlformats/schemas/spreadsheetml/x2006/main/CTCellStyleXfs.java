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

public interface CTCellStyleXfs extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCellStyleXfs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcellstylexfsa81ftype");
  
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
    public static CTCellStyleXfs newInstance() {
      return (CTCellStyleXfs)POIXMLTypeLoader.newInstance(CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs newInstance(XmlOptions param1XmlOptions) {
      return (CTCellStyleXfs)POIXMLTypeLoader.newInstance(CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(String param1String) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1String, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1String, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(File param1File) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1File, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1File, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(URL param1URL) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1URL, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1URL, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1InputStream, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1InputStream, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1Reader, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1Reader, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(Node param1Node) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1Node, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1Node, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static CTCellStyleXfs parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellStyleXfs.type, null);
    }
    
    public static CTCellStyleXfs parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCellStyleXfs)POIXMLTypeLoader.parse(param1XMLInputStream, CTCellStyleXfs.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellStyleXfs.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCellStyleXfs.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCellStyleXfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */