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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSdtCell extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtCell.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtcell626dtype");
  
  CTSdtPr getSdtPr();
  
  boolean isSetSdtPr();
  
  void setSdtPr(CTSdtPr paramCTSdtPr);
  
  CTSdtPr addNewSdtPr();
  
  void unsetSdtPr();
  
  CTSdtEndPr getSdtEndPr();
  
  boolean isSetSdtEndPr();
  
  void setSdtEndPr(CTSdtEndPr paramCTSdtEndPr);
  
  CTSdtEndPr addNewSdtEndPr();
  
  void unsetSdtEndPr();
  
  CTSdtContentCell getSdtContent();
  
  boolean isSetSdtContent();
  
  void setSdtContent(CTSdtContentCell paramCTSdtContentCell);
  
  CTSdtContentCell addNewSdtContent();
  
  void unsetSdtContent();
  
  public static final class Factory {
    public static CTSdtCell newInstance() {
      return (CTSdtCell)POIXMLTypeLoader.newInstance(CTSdtCell.type, null);
    }
    
    public static CTSdtCell newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtCell)POIXMLTypeLoader.newInstance(CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(String param1String) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1String, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1String, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(File param1File) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1File, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1File, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1URL, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1URL, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1InputStream, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1InputStream, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1Reader, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1Reader, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(Node param1Node) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1Node, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1Node, CTSdtCell.type, param1XmlOptions);
    }
    
    public static CTSdtCell parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtCell.type, null);
    }
    
    public static CTSdtCell parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtCell)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtCell.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtCell.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtCell.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */