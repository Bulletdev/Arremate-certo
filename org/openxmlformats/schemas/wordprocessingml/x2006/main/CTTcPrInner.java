package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTcPrInner extends CTTcPrBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTcPrInner.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttcprinnerc56dtype");
  
  CTTrackChange getCellIns();
  
  boolean isSetCellIns();
  
  void setCellIns(CTTrackChange paramCTTrackChange);
  
  CTTrackChange addNewCellIns();
  
  void unsetCellIns();
  
  CTTrackChange getCellDel();
  
  boolean isSetCellDel();
  
  void setCellDel(CTTrackChange paramCTTrackChange);
  
  CTTrackChange addNewCellDel();
  
  void unsetCellDel();
  
  CTCellMergeTrackChange getCellMerge();
  
  boolean isSetCellMerge();
  
  void setCellMerge(CTCellMergeTrackChange paramCTCellMergeTrackChange);
  
  CTCellMergeTrackChange addNewCellMerge();
  
  void unsetCellMerge();
  
  public static final class Factory {
    public static CTTcPrInner newInstance() {
      return (CTTcPrInner)POIXMLTypeLoader.newInstance(CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner newInstance(XmlOptions param1XmlOptions) {
      return (CTTcPrInner)POIXMLTypeLoader.newInstance(CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(String param1String) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1String, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1String, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(File param1File) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1File, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1File, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(URL param1URL) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1URL, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1URL, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1InputStream, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1InputStream, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1Reader, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1Reader, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(Node param1Node) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1Node, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1Node, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static CTTcPrInner parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPrInner.type, null);
    }
    
    public static CTTcPrInner parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTcPrInner)POIXMLTypeLoader.parse(param1XMLInputStream, CTTcPrInner.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPrInner.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTcPrInner.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTcPrInner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */