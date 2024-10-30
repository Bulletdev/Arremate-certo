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

public interface CTPageSetUpPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPageSetUpPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpagesetuppr24cftype");
  
  boolean getAutoPageBreaks();
  
  XmlBoolean xgetAutoPageBreaks();
  
  boolean isSetAutoPageBreaks();
  
  void setAutoPageBreaks(boolean paramBoolean);
  
  void xsetAutoPageBreaks(XmlBoolean paramXmlBoolean);
  
  void unsetAutoPageBreaks();
  
  boolean getFitToPage();
  
  XmlBoolean xgetFitToPage();
  
  boolean isSetFitToPage();
  
  void setFitToPage(boolean paramBoolean);
  
  void xsetFitToPage(XmlBoolean paramXmlBoolean);
  
  void unsetFitToPage();
  
  public static final class Factory {
    public static CTPageSetUpPr newInstance() {
      return (CTPageSetUpPr)POIXMLTypeLoader.newInstance(CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr newInstance(XmlOptions param1XmlOptions) {
      return (CTPageSetUpPr)POIXMLTypeLoader.newInstance(CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(String param1String) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1String, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1String, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(File param1File) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1File, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1File, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(URL param1URL) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1URL, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1URL, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1InputStream, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1InputStream, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1Reader, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1Reader, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(Node param1Node) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1Node, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1Node, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static CTPageSetUpPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageSetUpPr.type, null);
    }
    
    public static CTPageSetUpPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPageSetUpPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTPageSetUpPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageSetUpPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPageSetUpPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTPageSetUpPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */