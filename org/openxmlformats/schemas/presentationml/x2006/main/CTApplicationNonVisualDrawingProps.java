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
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.w3c.dom.Node;

public interface CTApplicationNonVisualDrawingProps extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTApplicationNonVisualDrawingProps.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctapplicationnonvisualdrawingprops2fb6type");
  
  CTPlaceholder getPh();
  
  boolean isSetPh();
  
  void setPh(CTPlaceholder paramCTPlaceholder);
  
  CTPlaceholder addNewPh();
  
  void unsetPh();
  
  CTAudioCD getAudioCd();
  
  boolean isSetAudioCd();
  
  void setAudioCd(CTAudioCD paramCTAudioCD);
  
  CTAudioCD addNewAudioCd();
  
  void unsetAudioCd();
  
  CTEmbeddedWAVAudioFile getWavAudioFile();
  
  boolean isSetWavAudioFile();
  
  void setWavAudioFile(CTEmbeddedWAVAudioFile paramCTEmbeddedWAVAudioFile);
  
  CTEmbeddedWAVAudioFile addNewWavAudioFile();
  
  void unsetWavAudioFile();
  
  CTAudioFile getAudioFile();
  
  boolean isSetAudioFile();
  
  void setAudioFile(CTAudioFile paramCTAudioFile);
  
  CTAudioFile addNewAudioFile();
  
  void unsetAudioFile();
  
  CTVideoFile getVideoFile();
  
  boolean isSetVideoFile();
  
  void setVideoFile(CTVideoFile paramCTVideoFile);
  
  CTVideoFile addNewVideoFile();
  
  void unsetVideoFile();
  
  CTQuickTimeFile getQuickTimeFile();
  
  boolean isSetQuickTimeFile();
  
  void setQuickTimeFile(CTQuickTimeFile paramCTQuickTimeFile);
  
  CTQuickTimeFile addNewQuickTimeFile();
  
  void unsetQuickTimeFile();
  
  CTCustomerDataList getCustDataLst();
  
  boolean isSetCustDataLst();
  
  void setCustDataLst(CTCustomerDataList paramCTCustomerDataList);
  
  CTCustomerDataList addNewCustDataLst();
  
  void unsetCustDataLst();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getIsPhoto();
  
  XmlBoolean xgetIsPhoto();
  
  boolean isSetIsPhoto();
  
  void setIsPhoto(boolean paramBoolean);
  
  void xsetIsPhoto(XmlBoolean paramXmlBoolean);
  
  void unsetIsPhoto();
  
  boolean getUserDrawn();
  
  XmlBoolean xgetUserDrawn();
  
  boolean isSetUserDrawn();
  
  void setUserDrawn(boolean paramBoolean);
  
  void xsetUserDrawn(XmlBoolean paramXmlBoolean);
  
  void unsetUserDrawn();
  
  public static final class Factory {
    public static CTApplicationNonVisualDrawingProps newInstance() {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps newInstance(XmlOptions param1XmlOptions) {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(String param1String) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1String, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1String, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(File param1File) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1File, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1File, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(URL param1URL) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1URL, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1URL, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1InputStream, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1InputStream, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(Reader param1Reader) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Reader, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Reader, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLStreamReader, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(Node param1Node) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Node, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1Node, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static CTApplicationNonVisualDrawingProps parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTApplicationNonVisualDrawingProps)POIXMLTypeLoader.parse(param1XMLInputStream, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTApplicationNonVisualDrawingProps.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTApplicationNonVisualDrawingProps.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTApplicationNonVisualDrawingProps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */