package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.w3c.dom.Node;

public interface CTBackground extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBackground.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbackground36f7type");
  
  CTBackgroundProperties getBgPr();
  
  boolean isSetBgPr();
  
  void setBgPr(CTBackgroundProperties paramCTBackgroundProperties);
  
  CTBackgroundProperties addNewBgPr();
  
  void unsetBgPr();
  
  CTStyleMatrixReference getBgRef();
  
  boolean isSetBgRef();
  
  void setBgRef(CTStyleMatrixReference paramCTStyleMatrixReference);
  
  CTStyleMatrixReference addNewBgRef();
  
  void unsetBgRef();
  
  STBlackWhiteMode.Enum getBwMode();
  
  STBlackWhiteMode xgetBwMode();
  
  boolean isSetBwMode();
  
  void setBwMode(STBlackWhiteMode.Enum paramEnum);
  
  void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode);
  
  void unsetBwMode();
  
  public static final class Factory {
    public static CTBackground newInstance() {
      return (CTBackground)POIXMLTypeLoader.newInstance(CTBackground.type, null);
    }
    
    public static CTBackground newInstance(XmlOptions param1XmlOptions) {
      return (CTBackground)POIXMLTypeLoader.newInstance(CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(String param1String) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1String, CTBackground.type, null);
    }
    
    public static CTBackground parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1String, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(File param1File) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1File, CTBackground.type, null);
    }
    
    public static CTBackground parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1File, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(URL param1URL) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1URL, CTBackground.type, null);
    }
    
    public static CTBackground parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1URL, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1InputStream, CTBackground.type, null);
    }
    
    public static CTBackground parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1InputStream, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1Reader, CTBackground.type, null);
    }
    
    public static CTBackground parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackground)POIXMLTypeLoader.parse(param1Reader, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackground.type, null);
    }
    
    public static CTBackground parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(Node param1Node) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1Node, CTBackground.type, null);
    }
    
    public static CTBackground parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackground)POIXMLTypeLoader.parse(param1Node, CTBackground.type, param1XmlOptions);
    }
    
    public static CTBackground parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBackground)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackground.type, null);
    }
    
    public static CTBackground parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBackground)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackground.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackground.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackground.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */