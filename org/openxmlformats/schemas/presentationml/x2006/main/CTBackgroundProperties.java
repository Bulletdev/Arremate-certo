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
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.w3c.dom.Node;

public interface CTBackgroundProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBackgroundProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbackgroundpropertiesb184type");
  
  CTNoFillProperties getNoFill();
  
  boolean isSetNoFill();
  
  void setNoFill(CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties addNewNoFill();
  
  void unsetNoFill();
  
  CTSolidColorFillProperties getSolidFill();
  
  boolean isSetSolidFill();
  
  void setSolidFill(CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void unsetSolidFill();
  
  CTGradientFillProperties getGradFill();
  
  boolean isSetGradFill();
  
  void setGradFill(CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties addNewGradFill();
  
  void unsetGradFill();
  
  CTBlipFillProperties getBlipFill();
  
  boolean isSetBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  void unsetBlipFill();
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTGroupFillProperties getGrpFill();
  
  boolean isSetGrpFill();
  
  void setGrpFill(CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties addNewGrpFill();
  
  void unsetGrpFill();
  
  CTEffectList getEffectLst();
  
  boolean isSetEffectLst();
  
  void setEffectLst(CTEffectList paramCTEffectList);
  
  CTEffectList addNewEffectLst();
  
  void unsetEffectLst();
  
  CTEffectContainer getEffectDag();
  
  boolean isSetEffectDag();
  
  void setEffectDag(CTEffectContainer paramCTEffectContainer);
  
  CTEffectContainer addNewEffectDag();
  
  void unsetEffectDag();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getShadeToTitle();
  
  XmlBoolean xgetShadeToTitle();
  
  boolean isSetShadeToTitle();
  
  void setShadeToTitle(boolean paramBoolean);
  
  void xsetShadeToTitle(XmlBoolean paramXmlBoolean);
  
  void unsetShadeToTitle();
  
  public static final class Factory {
    public static CTBackgroundProperties newInstance() {
      return (CTBackgroundProperties)POIXMLTypeLoader.newInstance(CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTBackgroundProperties)POIXMLTypeLoader.newInstance(CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(String param1String) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1String, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1String, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(File param1File) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1File, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1File, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1URL, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1URL, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1InputStream, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1InputStream, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1Reader, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1Reader, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(Node param1Node) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1Node, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1Node, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static CTBackgroundProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackgroundProperties.type, null);
    }
    
    public static CTBackgroundProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBackgroundProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackgroundProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackgroundProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackgroundProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTBackgroundProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */