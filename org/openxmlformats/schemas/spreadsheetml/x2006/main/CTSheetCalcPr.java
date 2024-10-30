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

public interface CTSheetCalcPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetCalcPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetcalcprc6d5type");
  
  boolean getFullCalcOnLoad();
  
  XmlBoolean xgetFullCalcOnLoad();
  
  boolean isSetFullCalcOnLoad();
  
  void setFullCalcOnLoad(boolean paramBoolean);
  
  void xsetFullCalcOnLoad(XmlBoolean paramXmlBoolean);
  
  void unsetFullCalcOnLoad();
  
  public static final class Factory {
    public static CTSheetCalcPr newInstance() {
      return (CTSheetCalcPr)POIXMLTypeLoader.newInstance(CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetCalcPr)POIXMLTypeLoader.newInstance(CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(String param1String) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1String, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1String, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(File param1File) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1File, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1File, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1URL, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1URL, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1Reader, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1Reader, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(Node param1Node) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1Node, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1Node, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static CTSheetCalcPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetCalcPr.type, null);
    }
    
    public static CTSheetCalcPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetCalcPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetCalcPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetCalcPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetCalcPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetCalcPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */