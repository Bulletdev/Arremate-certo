package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTOutlinePr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTOutlinePr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctoutlineprc483type");
  
  boolean getApplyStyles();
  
  XmlBoolean xgetApplyStyles();
  
  boolean isSetApplyStyles();
  
  void setApplyStyles(boolean paramBoolean);
  
  void xsetApplyStyles(XmlBoolean paramXmlBoolean);
  
  void unsetApplyStyles();
  
  boolean getSummaryBelow();
  
  XmlBoolean xgetSummaryBelow();
  
  boolean isSetSummaryBelow();
  
  void setSummaryBelow(boolean paramBoolean);
  
  void xsetSummaryBelow(XmlBoolean paramXmlBoolean);
  
  void unsetSummaryBelow();
  
  boolean getSummaryRight();
  
  XmlBoolean xgetSummaryRight();
  
  boolean isSetSummaryRight();
  
  void setSummaryRight(boolean paramBoolean);
  
  void xsetSummaryRight(XmlBoolean paramXmlBoolean);
  
  void unsetSummaryRight();
  
  boolean getShowOutlineSymbols();
  
  XmlBoolean xgetShowOutlineSymbols();
  
  boolean isSetShowOutlineSymbols();
  
  void setShowOutlineSymbols(boolean paramBoolean);
  
  void xsetShowOutlineSymbols(XmlBoolean paramXmlBoolean);
  
  void unsetShowOutlineSymbols();
  
  public static final class Factory {
    public static CTOutlinePr newInstance() {
      return (CTOutlinePr)POIXMLTypeLoader.newInstance(CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr newInstance(XmlOptions param1XmlOptions) {
      return (CTOutlinePr)POIXMLTypeLoader.newInstance(CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(String param1String) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1String, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1String, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(File param1File) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1File, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1File, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(URL param1URL) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1URL, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1URL, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1InputStream, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1InputStream, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1Reader, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1Reader, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(Node param1Node) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1Node, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1Node, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static CTOutlinePr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1XMLInputStream, CTOutlinePr.type, null);
    }
    
    public static CTOutlinePr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTOutlinePr)POIXMLTypeLoader.parse(param1XMLInputStream, CTOutlinePr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOutlinePr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTOutlinePr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTOutlinePr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */