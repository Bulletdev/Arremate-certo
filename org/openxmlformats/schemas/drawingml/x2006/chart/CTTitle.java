package org.openxmlformats.schemas.drawingml.x2006.chart;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

public interface CTTitle extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTitle.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttitleb54etype");
  
  CTTx getTx();
  
  boolean isSetTx();
  
  void setTx(CTTx paramCTTx);
  
  CTTx addNewTx();
  
  void unsetTx();
  
  CTLayout getLayout();
  
  boolean isSetLayout();
  
  void setLayout(CTLayout paramCTLayout);
  
  CTLayout addNewLayout();
  
  void unsetLayout();
  
  CTBoolean getOverlay();
  
  boolean isSetOverlay();
  
  void setOverlay(CTBoolean paramCTBoolean);
  
  CTBoolean addNewOverlay();
  
  void unsetOverlay();
  
  CTShapeProperties getSpPr();
  
  boolean isSetSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  void unsetSpPr();
  
  CTTextBody getTxPr();
  
  boolean isSetTxPr();
  
  void setTxPr(CTTextBody paramCTTextBody);
  
  CTTextBody addNewTxPr();
  
  void unsetTxPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTTitle newInstance() {
      return (CTTitle)POIXMLTypeLoader.newInstance(CTTitle.type, null);
    }
    
    public static CTTitle newInstance(XmlOptions param1XmlOptions) {
      return (CTTitle)POIXMLTypeLoader.newInstance(CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(String param1String) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1String, CTTitle.type, null);
    }
    
    public static CTTitle parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1String, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(File param1File) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1File, CTTitle.type, null);
    }
    
    public static CTTitle parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1File, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(URL param1URL) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1URL, CTTitle.type, null);
    }
    
    public static CTTitle parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1URL, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1InputStream, CTTitle.type, null);
    }
    
    public static CTTitle parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1InputStream, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1Reader, CTTitle.type, null);
    }
    
    public static CTTitle parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTitle)POIXMLTypeLoader.parse(param1Reader, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTitle.type, null);
    }
    
    public static CTTitle parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(Node param1Node) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1Node, CTTitle.type, null);
    }
    
    public static CTTitle parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTitle)POIXMLTypeLoader.parse(param1Node, CTTitle.type, param1XmlOptions);
    }
    
    public static CTTitle parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTitle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTitle.type, null);
    }
    
    public static CTTitle parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTitle)POIXMLTypeLoader.parse(param1XMLInputStream, CTTitle.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTitle.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTitle.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */