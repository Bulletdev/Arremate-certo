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

public interface CTLineProperties extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLineProperties.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlinepropertiesd5e2type");
  
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
  
  CTPatternFillProperties getPattFill();
  
  boolean isSetPattFill();
  
  void setPattFill(CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties addNewPattFill();
  
  void unsetPattFill();
  
  CTPresetLineDashProperties getPrstDash();
  
  boolean isSetPrstDash();
  
  void setPrstDash(CTPresetLineDashProperties paramCTPresetLineDashProperties);
  
  CTPresetLineDashProperties addNewPrstDash();
  
  void unsetPrstDash();
  
  CTDashStopList getCustDash();
  
  boolean isSetCustDash();
  
  void setCustDash(CTDashStopList paramCTDashStopList);
  
  CTDashStopList addNewCustDash();
  
  void unsetCustDash();
  
  CTLineJoinRound getRound();
  
  boolean isSetRound();
  
  void setRound(CTLineJoinRound paramCTLineJoinRound);
  
  CTLineJoinRound addNewRound();
  
  void unsetRound();
  
  CTLineJoinBevel getBevel();
  
  boolean isSetBevel();
  
  void setBevel(CTLineJoinBevel paramCTLineJoinBevel);
  
  CTLineJoinBevel addNewBevel();
  
  void unsetBevel();
  
  CTLineJoinMiterProperties getMiter();
  
  boolean isSetMiter();
  
  void setMiter(CTLineJoinMiterProperties paramCTLineJoinMiterProperties);
  
  CTLineJoinMiterProperties addNewMiter();
  
  void unsetMiter();
  
  CTLineEndProperties getHeadEnd();
  
  boolean isSetHeadEnd();
  
  void setHeadEnd(CTLineEndProperties paramCTLineEndProperties);
  
  CTLineEndProperties addNewHeadEnd();
  
  void unsetHeadEnd();
  
  CTLineEndProperties getTailEnd();
  
  boolean isSetTailEnd();
  
  void setTailEnd(CTLineEndProperties paramCTLineEndProperties);
  
  CTLineEndProperties addNewTailEnd();
  
  void unsetTailEnd();
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  int getW();
  
  STLineWidth xgetW();
  
  boolean isSetW();
  
  void setW(int paramInt);
  
  void xsetW(STLineWidth paramSTLineWidth);
  
  void unsetW();
  
  STLineCap.Enum getCap();
  
  STLineCap xgetCap();
  
  boolean isSetCap();
  
  void setCap(STLineCap.Enum paramEnum);
  
  void xsetCap(STLineCap paramSTLineCap);
  
  void unsetCap();
  
  STCompoundLine.Enum getCmpd();
  
  STCompoundLine xgetCmpd();
  
  boolean isSetCmpd();
  
  void setCmpd(STCompoundLine.Enum paramEnum);
  
  void xsetCmpd(STCompoundLine paramSTCompoundLine);
  
  void unsetCmpd();
  
  STPenAlignment.Enum getAlgn();
  
  STPenAlignment xgetAlgn();
  
  boolean isSetAlgn();
  
  void setAlgn(STPenAlignment.Enum paramEnum);
  
  void xsetAlgn(STPenAlignment paramSTPenAlignment);
  
  void unsetAlgn();
  
  public static final class Factory {
    public static CTLineProperties newInstance() {
      return (CTLineProperties)POIXMLTypeLoader.newInstance(CTLineProperties.type, null);
    }
    
    public static CTLineProperties newInstance(XmlOptions param1XmlOptions) {
      return (CTLineProperties)POIXMLTypeLoader.newInstance(CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(String param1String) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1String, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1String, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(File param1File) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1File, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1File, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(URL param1URL) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1URL, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1URL, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1InputStream, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1InputStream, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1Reader, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1Reader, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(Node param1Node) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1Node, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1Node, CTLineProperties.type, param1XmlOptions);
    }
    
    public static CTLineProperties parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineProperties.type, null);
    }
    
    public static CTLineProperties parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLineProperties)POIXMLTypeLoader.parse(param1XMLInputStream, CTLineProperties.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineProperties.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLineProperties.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTLineProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */