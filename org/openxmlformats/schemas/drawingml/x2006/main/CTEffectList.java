package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTEffectList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTEffectList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cteffectlist6featype");
  
  CTBlurEffect getBlur();
  
  boolean isSetBlur();
  
  void setBlur(CTBlurEffect paramCTBlurEffect);
  
  CTBlurEffect addNewBlur();
  
  void unsetBlur();
  
  CTFillOverlayEffect getFillOverlay();
  
  boolean isSetFillOverlay();
  
  void setFillOverlay(CTFillOverlayEffect paramCTFillOverlayEffect);
  
  CTFillOverlayEffect addNewFillOverlay();
  
  void unsetFillOverlay();
  
  CTGlowEffect getGlow();
  
  boolean isSetGlow();
  
  void setGlow(CTGlowEffect paramCTGlowEffect);
  
  CTGlowEffect addNewGlow();
  
  void unsetGlow();
  
  CTInnerShadowEffect getInnerShdw();
  
  boolean isSetInnerShdw();
  
  void setInnerShdw(CTInnerShadowEffect paramCTInnerShadowEffect);
  
  CTInnerShadowEffect addNewInnerShdw();
  
  void unsetInnerShdw();
  
  CTOuterShadowEffect getOuterShdw();
  
  boolean isSetOuterShdw();
  
  void setOuterShdw(CTOuterShadowEffect paramCTOuterShadowEffect);
  
  CTOuterShadowEffect addNewOuterShdw();
  
  void unsetOuterShdw();
  
  CTPresetShadowEffect getPrstShdw();
  
  boolean isSetPrstShdw();
  
  void setPrstShdw(CTPresetShadowEffect paramCTPresetShadowEffect);
  
  CTPresetShadowEffect addNewPrstShdw();
  
  void unsetPrstShdw();
  
  CTReflectionEffect getReflection();
  
  boolean isSetReflection();
  
  void setReflection(CTReflectionEffect paramCTReflectionEffect);
  
  CTReflectionEffect addNewReflection();
  
  void unsetReflection();
  
  CTSoftEdgesEffect getSoftEdge();
  
  boolean isSetSoftEdge();
  
  void setSoftEdge(CTSoftEdgesEffect paramCTSoftEdgesEffect);
  
  CTSoftEdgesEffect addNewSoftEdge();
  
  void unsetSoftEdge();
  
  public static final class Factory {
    public static CTEffectList newInstance() {
      return (CTEffectList)POIXMLTypeLoader.newInstance(CTEffectList.type, null);
    }
    
    public static CTEffectList newInstance(XmlOptions param1XmlOptions) {
      return (CTEffectList)POIXMLTypeLoader.newInstance(CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(String param1String) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1String, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1String, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(File param1File) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1File, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1File, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(URL param1URL) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1URL, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1URL, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1InputStream, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1InputStream, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1Reader, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1Reader, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(Node param1Node) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1Node, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1Node, CTEffectList.type, param1XmlOptions);
    }
    
    public static CTEffectList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectList.type, null);
    }
    
    public static CTEffectList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTEffectList)POIXMLTypeLoader.parse(param1XMLInputStream, CTEffectList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTEffectList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTEffectList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */