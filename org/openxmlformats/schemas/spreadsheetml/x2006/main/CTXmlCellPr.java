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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTXmlCellPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTXmlCellPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctxmlcellprf1datype");
  
  CTXmlPr getXmlPr();
  
  void setXmlPr(CTXmlPr paramCTXmlPr);
  
  CTXmlPr addNewXmlPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getUniqueName();
  
  STXstring xgetUniqueName();
  
  boolean isSetUniqueName();
  
  void setUniqueName(String paramString);
  
  void xsetUniqueName(STXstring paramSTXstring);
  
  void unsetUniqueName();
  
  public static final class Factory {
    public static CTXmlCellPr newInstance() {
      return (CTXmlCellPr)POIXMLTypeLoader.newInstance(CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr newInstance(XmlOptions param1XmlOptions) {
      return (CTXmlCellPr)POIXMLTypeLoader.newInstance(CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(String param1String) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1String, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1String, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(File param1File) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1File, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1File, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(URL param1URL) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1URL, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1URL, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1InputStream, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1Reader, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1Reader, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(Node param1Node) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1Node, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1Node, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static CTXmlCellPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlCellPr.type, null);
    }
    
    public static CTXmlCellPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTXmlCellPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTXmlCellPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlCellPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTXmlCellPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTXmlCellPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */