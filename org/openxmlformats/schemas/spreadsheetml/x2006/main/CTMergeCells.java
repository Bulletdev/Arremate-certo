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

public interface CTMergeCells extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTMergeCells.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctmergecells1242type");
  
  List<CTMergeCell> getMergeCellList();
  
  CTMergeCell[] getMergeCellArray();
  
  CTMergeCell getMergeCellArray(int paramInt);
  
  int sizeOfMergeCellArray();
  
  void setMergeCellArray(CTMergeCell[] paramArrayOfCTMergeCell);
  
  void setMergeCellArray(int paramInt, CTMergeCell paramCTMergeCell);
  
  CTMergeCell insertNewMergeCell(int paramInt);
  
  CTMergeCell addNewMergeCell();
  
  void removeMergeCell(int paramInt);
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTMergeCells newInstance() {
      return (CTMergeCells)POIXMLTypeLoader.newInstance(CTMergeCells.type, null);
    }
    
    public static CTMergeCells newInstance(XmlOptions param1XmlOptions) {
      return (CTMergeCells)POIXMLTypeLoader.newInstance(CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(String param1String) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1String, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1String, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(File param1File) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1File, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1File, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(URL param1URL) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1URL, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1URL, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1InputStream, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1InputStream, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(Reader param1Reader) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1Reader, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1Reader, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1XMLStreamReader, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(Node param1Node) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1Node, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1Node, CTMergeCells.type, param1XmlOptions);
    }
    
    public static CTMergeCells parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1XMLInputStream, CTMergeCells.type, null);
    }
    
    public static CTMergeCells parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTMergeCells)POIXMLTypeLoader.parse(param1XMLInputStream, CTMergeCells.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMergeCells.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTMergeCells.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTMergeCells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */