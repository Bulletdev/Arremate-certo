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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.w3c.dom.Node;

public interface CTSlideMaster extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideMaster.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidemasterd8fctype");
  
  CTCommonSlideData getCSld();
  
  void setCSld(CTCommonSlideData paramCTCommonSlideData);
  
  CTCommonSlideData addNewCSld();
  
  CTColorMapping getClrMap();
  
  void setClrMap(CTColorMapping paramCTColorMapping);
  
  CTColorMapping addNewClrMap();
  
  CTSlideLayoutIdList getSldLayoutIdLst();
  
  boolean isSetSldLayoutIdLst();
  
  void setSldLayoutIdLst(CTSlideLayoutIdList paramCTSlideLayoutIdList);
  
  CTSlideLayoutIdList addNewSldLayoutIdLst();
  
  void unsetSldLayoutIdLst();
  
  CTSlideTransition getTransition();
  
  boolean isSetTransition();
  
  void setTransition(CTSlideTransition paramCTSlideTransition);
  
  CTSlideTransition addNewTransition();
  
  void unsetTransition();
  
  CTSlideTiming getTiming();
  
  boolean isSetTiming();
  
  void setTiming(CTSlideTiming paramCTSlideTiming);
  
  CTSlideTiming addNewTiming();
  
  void unsetTiming();
  
  CTHeaderFooter getHf();
  
  boolean isSetHf();
  
  void setHf(CTHeaderFooter paramCTHeaderFooter);
  
  CTHeaderFooter addNewHf();
  
  void unsetHf();
  
  CTSlideMasterTextStyles getTxStyles();
  
  boolean isSetTxStyles();
  
  void setTxStyles(CTSlideMasterTextStyles paramCTSlideMasterTextStyles);
  
  CTSlideMasterTextStyles addNewTxStyles();
  
  void unsetTxStyles();
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  boolean getPreserve();
  
  XmlBoolean xgetPreserve();
  
  boolean isSetPreserve();
  
  void setPreserve(boolean paramBoolean);
  
  void xsetPreserve(XmlBoolean paramXmlBoolean);
  
  void unsetPreserve();
  
  public static final class Factory {
    public static CTSlideMaster newInstance() {
      return (CTSlideMaster)POIXMLTypeLoader.newInstance(CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideMaster)POIXMLTypeLoader.newInstance(CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(String param1String) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1String, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1String, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(File param1File) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1File, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1File, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1URL, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1URL, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1InputStream, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1InputStream, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1Reader, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1Reader, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(Node param1Node) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1Node, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1Node, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static CTSlideMaster parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMaster.type, null);
    }
    
    public static CTSlideMaster parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideMaster)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMaster.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMaster.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMaster.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */