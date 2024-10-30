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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

public interface CTSlide extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlide.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslided7betype");
  
  CTCommonSlideData getCSld();
  
  void setCSld(CTCommonSlideData paramCTCommonSlideData);
  
  CTCommonSlideData addNewCSld();
  
  CTColorMappingOverride getClrMapOvr();
  
  boolean isSetClrMapOvr();
  
  void setClrMapOvr(CTColorMappingOverride paramCTColorMappingOverride);
  
  CTColorMappingOverride addNewClrMapOvr();
  
  void unsetClrMapOvr();
  
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
  
  CTExtensionListModify getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionListModify paramCTExtensionListModify);
  
  CTExtensionListModify addNewExtLst();
  
  void unsetExtLst();
  
  boolean getShowMasterSp();
  
  XmlBoolean xgetShowMasterSp();
  
  boolean isSetShowMasterSp();
  
  void setShowMasterSp(boolean paramBoolean);
  
  void xsetShowMasterSp(XmlBoolean paramXmlBoolean);
  
  void unsetShowMasterSp();
  
  boolean getShowMasterPhAnim();
  
  XmlBoolean xgetShowMasterPhAnim();
  
  boolean isSetShowMasterPhAnim();
  
  void setShowMasterPhAnim(boolean paramBoolean);
  
  void xsetShowMasterPhAnim(XmlBoolean paramXmlBoolean);
  
  void unsetShowMasterPhAnim();
  
  boolean getShow();
  
  XmlBoolean xgetShow();
  
  boolean isSetShow();
  
  void setShow(boolean paramBoolean);
  
  void xsetShow(XmlBoolean paramXmlBoolean);
  
  void unsetShow();
  
  public static final class Factory {
    public static CTSlide newInstance() {
      return (CTSlide)POIXMLTypeLoader.newInstance(CTSlide.type, null);
    }
    
    public static CTSlide newInstance(XmlOptions param1XmlOptions) {
      return (CTSlide)POIXMLTypeLoader.newInstance(CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(String param1String) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1String, CTSlide.type, null);
    }
    
    public static CTSlide parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1String, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(File param1File) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1File, CTSlide.type, null);
    }
    
    public static CTSlide parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1File, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(URL param1URL) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1URL, CTSlide.type, null);
    }
    
    public static CTSlide parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1URL, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1InputStream, CTSlide.type, null);
    }
    
    public static CTSlide parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1InputStream, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1Reader, CTSlide.type, null);
    }
    
    public static CTSlide parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlide)POIXMLTypeLoader.parse(param1Reader, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlide.type, null);
    }
    
    public static CTSlide parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(Node param1Node) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1Node, CTSlide.type, null);
    }
    
    public static CTSlide parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlide)POIXMLTypeLoader.parse(param1Node, CTSlide.type, param1XmlOptions);
    }
    
    public static CTSlide parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlide)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlide.type, null);
    }
    
    public static CTSlide parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlide)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlide.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlide.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlide.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */