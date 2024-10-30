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

public interface CTGroupShapeProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGroupShapeProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgroupshapeproperties8690type");
  
  CTGroupTransform2D getXfrm();
  
  boolean isSetXfrm();
  
  void setXfrm(CTGroupTransform2D paramCTGroupTransform2D);
  
  CTGroupTransform2D addNewXfrm();
  
  void unsetXfrm();
  
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
  
  CTScene3D getScene3D();
  
  boolean isSetScene3D();
  
  void setScene3D(CTScene3D paramCTScene3D);
  
  CTScene3D addNewScene3D();
  
  void unsetScene3D();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STBlackWhiteMode$Enum getBwMode();
  
  STBlackWhiteMode xgetBwMode();
  
  boolean isSetBwMode();
  
  void setBwMode(STBlackWhiteMode$Enum paramSTBlackWhiteMode$Enum);
  
  void xsetBwMode(STBlackWhiteMode paramSTBlackWhiteMode);
  
  void unsetBwMode();
  
  public static final class Factory {
    public static CTGroupShapeProperties newInstance() {
      return (CTGroupShapeProperties)POIXMLTypeLoader.newInstance(CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTGroupShapeProperties)POIXMLTypeLoader.newInstance(CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(String param1String) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1String, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1String, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(File param1File) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1File, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1File, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1URL, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1URL, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1InputStream, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1InputStream, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1Reader, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1Reader, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(Node param1Node) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1Node, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1Node, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static CTGroupShapeProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShapeProperties.type, null);
    }
    
    public static CTGroupShapeProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGroupShapeProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTGroupShapeProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShapeProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGroupShapeProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGroupShapeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */