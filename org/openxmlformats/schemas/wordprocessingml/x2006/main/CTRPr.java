package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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

public interface CTRPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTRPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctrpr097etype");
  
  CTString getRStyle();
  
  boolean isSetRStyle();
  
  void setRStyle(CTString paramCTString);
  
  CTString addNewRStyle();
  
  void unsetRStyle();
  
  CTFonts getRFonts();
  
  boolean isSetRFonts();
  
  void setRFonts(CTFonts paramCTFonts);
  
  CTFonts addNewRFonts();
  
  void unsetRFonts();
  
  CTOnOff getB();
  
  boolean isSetB();
  
  void setB(CTOnOff paramCTOnOff);
  
  CTOnOff addNewB();
  
  void unsetB();
  
  CTOnOff getBCs();
  
  boolean isSetBCs();
  
  void setBCs(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBCs();
  
  void unsetBCs();
  
  CTOnOff getI();
  
  boolean isSetI();
  
  void setI(CTOnOff paramCTOnOff);
  
  CTOnOff addNewI();
  
  void unsetI();
  
  CTOnOff getICs();
  
  boolean isSetICs();
  
  void setICs(CTOnOff paramCTOnOff);
  
  CTOnOff addNewICs();
  
  void unsetICs();
  
  CTOnOff getCaps();
  
  boolean isSetCaps();
  
  void setCaps(CTOnOff paramCTOnOff);
  
  CTOnOff addNewCaps();
  
  void unsetCaps();
  
  CTOnOff getSmallCaps();
  
  boolean isSetSmallCaps();
  
  void setSmallCaps(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSmallCaps();
  
  void unsetSmallCaps();
  
  CTOnOff getStrike();
  
  boolean isSetStrike();
  
  void setStrike(CTOnOff paramCTOnOff);
  
  CTOnOff addNewStrike();
  
  void unsetStrike();
  
  CTOnOff getDstrike();
  
  boolean isSetDstrike();
  
  void setDstrike(CTOnOff paramCTOnOff);
  
  CTOnOff addNewDstrike();
  
  void unsetDstrike();
  
  CTOnOff getOutline();
  
  boolean isSetOutline();
  
  void setOutline(CTOnOff paramCTOnOff);
  
  CTOnOff addNewOutline();
  
  void unsetOutline();
  
  CTOnOff getShadow();
  
  boolean isSetShadow();
  
  void setShadow(CTOnOff paramCTOnOff);
  
  CTOnOff addNewShadow();
  
  void unsetShadow();
  
  CTOnOff getEmboss();
  
  boolean isSetEmboss();
  
  void setEmboss(CTOnOff paramCTOnOff);
  
  CTOnOff addNewEmboss();
  
  void unsetEmboss();
  
  CTOnOff getImprint();
  
  boolean isSetImprint();
  
  void setImprint(CTOnOff paramCTOnOff);
  
  CTOnOff addNewImprint();
  
  void unsetImprint();
  
  CTOnOff getNoProof();
  
  boolean isSetNoProof();
  
  void setNoProof(CTOnOff paramCTOnOff);
  
  CTOnOff addNewNoProof();
  
  void unsetNoProof();
  
  CTOnOff getSnapToGrid();
  
  boolean isSetSnapToGrid();
  
  void setSnapToGrid(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSnapToGrid();
  
  void unsetSnapToGrid();
  
  CTOnOff getVanish();
  
  boolean isSetVanish();
  
  void setVanish(CTOnOff paramCTOnOff);
  
  CTOnOff addNewVanish();
  
  void unsetVanish();
  
  CTOnOff getWebHidden();
  
  boolean isSetWebHidden();
  
  void setWebHidden(CTOnOff paramCTOnOff);
  
  CTOnOff addNewWebHidden();
  
  void unsetWebHidden();
  
  CTColor getColor();
  
  boolean isSetColor();
  
  void setColor(CTColor paramCTColor);
  
  CTColor addNewColor();
  
  void unsetColor();
  
  CTSignedTwipsMeasure getSpacing();
  
  boolean isSetSpacing();
  
  void setSpacing(CTSignedTwipsMeasure paramCTSignedTwipsMeasure);
  
  CTSignedTwipsMeasure addNewSpacing();
  
  void unsetSpacing();
  
  CTTextScale getW();
  
  boolean isSetW();
  
  void setW(CTTextScale paramCTTextScale);
  
  CTTextScale addNewW();
  
  void unsetW();
  
  CTHpsMeasure getKern();
  
  boolean isSetKern();
  
  void setKern(CTHpsMeasure paramCTHpsMeasure);
  
  CTHpsMeasure addNewKern();
  
  void unsetKern();
  
  CTSignedHpsMeasure getPosition();
  
  boolean isSetPosition();
  
  void setPosition(CTSignedHpsMeasure paramCTSignedHpsMeasure);
  
  CTSignedHpsMeasure addNewPosition();
  
  void unsetPosition();
  
  CTHpsMeasure getSz();
  
  boolean isSetSz();
  
  void setSz(CTHpsMeasure paramCTHpsMeasure);
  
  CTHpsMeasure addNewSz();
  
  void unsetSz();
  
  CTHpsMeasure getSzCs();
  
  boolean isSetSzCs();
  
  void setSzCs(CTHpsMeasure paramCTHpsMeasure);
  
  CTHpsMeasure addNewSzCs();
  
  void unsetSzCs();
  
  CTHighlight getHighlight();
  
  boolean isSetHighlight();
  
  void setHighlight(CTHighlight paramCTHighlight);
  
  CTHighlight addNewHighlight();
  
  void unsetHighlight();
  
  CTUnderline getU();
  
  boolean isSetU();
  
  void setU(CTUnderline paramCTUnderline);
  
  CTUnderline addNewU();
  
  void unsetU();
  
  CTTextEffect getEffect();
  
  boolean isSetEffect();
  
  void setEffect(CTTextEffect paramCTTextEffect);
  
  CTTextEffect addNewEffect();
  
  void unsetEffect();
  
  CTBorder getBdr();
  
  boolean isSetBdr();
  
  void setBdr(CTBorder paramCTBorder);
  
  CTBorder addNewBdr();
  
  void unsetBdr();
  
  CTShd getShd();
  
  boolean isSetShd();
  
  void setShd(CTShd paramCTShd);
  
  CTShd addNewShd();
  
  void unsetShd();
  
  CTFitText getFitText();
  
  boolean isSetFitText();
  
  void setFitText(CTFitText paramCTFitText);
  
  CTFitText addNewFitText();
  
  void unsetFitText();
  
  CTVerticalAlignRun getVertAlign();
  
  boolean isSetVertAlign();
  
  void setVertAlign(CTVerticalAlignRun paramCTVerticalAlignRun);
  
  CTVerticalAlignRun addNewVertAlign();
  
  void unsetVertAlign();
  
  CTOnOff getRtl();
  
  boolean isSetRtl();
  
  void setRtl(CTOnOff paramCTOnOff);
  
  CTOnOff addNewRtl();
  
  void unsetRtl();
  
  CTOnOff getCs();
  
  boolean isSetCs();
  
  void setCs(CTOnOff paramCTOnOff);
  
  CTOnOff addNewCs();
  
  void unsetCs();
  
  CTEm getEm();
  
  boolean isSetEm();
  
  void setEm(CTEm paramCTEm);
  
  CTEm addNewEm();
  
  void unsetEm();
  
  CTLanguage getLang();
  
  boolean isSetLang();
  
  void setLang(CTLanguage paramCTLanguage);
  
  CTLanguage addNewLang();
  
  void unsetLang();
  
  CTEastAsianLayout getEastAsianLayout();
  
  boolean isSetEastAsianLayout();
  
  void setEastAsianLayout(CTEastAsianLayout paramCTEastAsianLayout);
  
  CTEastAsianLayout addNewEastAsianLayout();
  
  void unsetEastAsianLayout();
  
  CTOnOff getSpecVanish();
  
  boolean isSetSpecVanish();
  
  void setSpecVanish(CTOnOff paramCTOnOff);
  
  CTOnOff addNewSpecVanish();
  
  void unsetSpecVanish();
  
  CTOnOff getOMath();
  
  boolean isSetOMath();
  
  void setOMath(CTOnOff paramCTOnOff);
  
  CTOnOff addNewOMath();
  
  void unsetOMath();
  
  CTRPrChange getRPrChange();
  
  boolean isSetRPrChange();
  
  void setRPrChange(CTRPrChange paramCTRPrChange);
  
  CTRPrChange addNewRPrChange();
  
  void unsetRPrChange();
  
  public static final class Factory {
    public static CTRPr newInstance() {
      return (CTRPr)POIXMLTypeLoader.newInstance(CTRPr.type, null);
    }
    
    public static CTRPr newInstance(XmlOptions param1XmlOptions) {
      return (CTRPr)POIXMLTypeLoader.newInstance(CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(String param1String) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1String, CTRPr.type, null);
    }
    
    public static CTRPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1String, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(File param1File) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1File, CTRPr.type, null);
    }
    
    public static CTRPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1File, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(URL param1URL) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1URL, CTRPr.type, null);
    }
    
    public static CTRPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1URL, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1InputStream, CTRPr.type, null);
    }
    
    public static CTRPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1InputStream, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1Reader, CTRPr.type, null);
    }
    
    public static CTRPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTRPr)POIXMLTypeLoader.parse(param1Reader, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPr.type, null);
    }
    
    public static CTRPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(Node param1Node) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1Node, CTRPr.type, null);
    }
    
    public static CTRPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTRPr)POIXMLTypeLoader.parse(param1Node, CTRPr.type, param1XmlOptions);
    }
    
    public static CTRPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTRPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPr.type, null);
    }
    
    public static CTRPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTRPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTRPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTRPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTRPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */