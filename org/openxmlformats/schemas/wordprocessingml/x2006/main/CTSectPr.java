package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTSectPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSectPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsectpr1123type");
  
  List<CTHdrFtrRef> getHeaderReferenceList();
  
  CTHdrFtrRef[] getHeaderReferenceArray();
  
  CTHdrFtrRef getHeaderReferenceArray(int paramInt);
  
  int sizeOfHeaderReferenceArray();
  
  void setHeaderReferenceArray(CTHdrFtrRef[] paramArrayOfCTHdrFtrRef);
  
  void setHeaderReferenceArray(int paramInt, CTHdrFtrRef paramCTHdrFtrRef);
  
  CTHdrFtrRef insertNewHeaderReference(int paramInt);
  
  CTHdrFtrRef addNewHeaderReference();
  
  void removeHeaderReference(int paramInt);
  
  List<CTHdrFtrRef> getFooterReferenceList();
  
  CTHdrFtrRef[] getFooterReferenceArray();
  
  CTHdrFtrRef getFooterReferenceArray(int paramInt);
  
  int sizeOfFooterReferenceArray();
  
  void setFooterReferenceArray(CTHdrFtrRef[] paramArrayOfCTHdrFtrRef);
  
  void setFooterReferenceArray(int paramInt, CTHdrFtrRef paramCTHdrFtrRef);
  
  CTHdrFtrRef insertNewFooterReference(int paramInt);
  
  CTHdrFtrRef addNewFooterReference();
  
  void removeFooterReference(int paramInt);
  
  CTFtnProps getFootnotePr();
  
  boolean isSetFootnotePr();
  
  void setFootnotePr(CTFtnProps paramCTFtnProps);
  
  CTFtnProps addNewFootnotePr();
  
  void unsetFootnotePr();
  
  CTEdnProps getEndnotePr();
  
  boolean isSetEndnotePr();
  
  void setEndnotePr(CTEdnProps paramCTEdnProps);
  
  CTEdnProps addNewEndnotePr();
  
  void unsetEndnotePr();
  
  CTSectType getType();
  
  boolean isSetType();
  
  void setType(CTSectType paramCTSectType);
  
  CTSectType addNewType();
  
  void unsetType();
  
  CTPageSz getPgSz();
  
  boolean isSetPgSz();
  
  void setPgSz(CTPageSz paramCTPageSz);
  
  CTPageSz addNewPgSz();
  
  void unsetPgSz();
  
  CTPageMar getPgMar();
  
  boolean isSetPgMar();
  
  void setPgMar(CTPageMar paramCTPageMar);
  
  CTPageMar addNewPgMar();
  
  void unsetPgMar();
  
  CTPaperSource getPaperSrc();
  
  boolean isSetPaperSrc();
  
  void setPaperSrc(CTPaperSource paramCTPaperSource);
  
  CTPaperSource addNewPaperSrc();
  
  void unsetPaperSrc();
  
  CTPageBorders getPgBorders();
  
  boolean isSetPgBorders();
  
  void setPgBorders(CTPageBorders paramCTPageBorders);
  
  CTPageBorders addNewPgBorders();
  
  void unsetPgBorders();
  
  CTLineNumber getLnNumType();
  
  boolean isSetLnNumType();
  
  void setLnNumType(CTLineNumber paramCTLineNumber);
  
  CTLineNumber addNewLnNumType();
  
  void unsetLnNumType();
  
  CTPageNumber getPgNumType();
  
  boolean isSetPgNumType();
  
  void setPgNumType(CTPageNumber paramCTPageNumber);
  
  CTPageNumber addNewPgNumType();
  
  void unsetPgNumType();
  
  CTColumns getCols();
  
  boolean isSetCols();
  
  void setCols(CTColumns paramCTColumns);
  
  CTColumns addNewCols();
  
  void unsetCols();
  
  CTOnOff getFormProt();
  
  boolean isSetFormProt();
  
  void setFormProt(CTOnOff paramCTOnOff);
  
  CTOnOff addNewFormProt();
  
  void unsetFormProt();
  
  CTVerticalJc getVAlign();
  
  boolean isSetVAlign();
  
  void setVAlign(CTVerticalJc paramCTVerticalJc);
  
  CTVerticalJc addNewVAlign();
  
  void unsetVAlign();
  
  CTOnOff getNoEndnote();
  
  boolean isSetNoEndnote();
  
  void setNoEndnote(CTOnOff paramCTOnOff);
  
  CTOnOff addNewNoEndnote();
  
  void unsetNoEndnote();
  
  CTOnOff getTitlePg();
  
  boolean isSetTitlePg();
  
  void setTitlePg(CTOnOff paramCTOnOff);
  
  CTOnOff addNewTitlePg();
  
  void unsetTitlePg();
  
  CTTextDirection getTextDirection();
  
  boolean isSetTextDirection();
  
  void setTextDirection(CTTextDirection paramCTTextDirection);
  
  CTTextDirection addNewTextDirection();
  
  void unsetTextDirection();
  
  CTOnOff getBidi();
  
  boolean isSetBidi();
  
  void setBidi(CTOnOff paramCTOnOff);
  
  CTOnOff addNewBidi();
  
  void unsetBidi();
  
  CTOnOff getRtlGutter();
  
  boolean isSetRtlGutter();
  
  void setRtlGutter(CTOnOff paramCTOnOff);
  
  CTOnOff addNewRtlGutter();
  
  void unsetRtlGutter();
  
  CTDocGrid getDocGrid();
  
  boolean isSetDocGrid();
  
  void setDocGrid(CTDocGrid paramCTDocGrid);
  
  CTDocGrid addNewDocGrid();
  
  void unsetDocGrid();
  
  CTRel getPrinterSettings();
  
  boolean isSetPrinterSettings();
  
  void setPrinterSettings(CTRel paramCTRel);
  
  CTRel addNewPrinterSettings();
  
  void unsetPrinterSettings();
  
  CTSectPrChange getSectPrChange();
  
  boolean isSetSectPrChange();
  
  void setSectPrChange(CTSectPrChange paramCTSectPrChange);
  
  CTSectPrChange addNewSectPrChange();
  
  void unsetSectPrChange();
  
  byte[] getRsidRPr();
  
  STLongHexNumber xgetRsidRPr();
  
  boolean isSetRsidRPr();
  
  void setRsidRPr(byte[] paramArrayOfbyte);
  
  void xsetRsidRPr(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidRPr();
  
  byte[] getRsidDel();
  
  STLongHexNumber xgetRsidDel();
  
  boolean isSetRsidDel();
  
  void setRsidDel(byte[] paramArrayOfbyte);
  
  void xsetRsidDel(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidDel();
  
  byte[] getRsidR();
  
  STLongHexNumber xgetRsidR();
  
  boolean isSetRsidR();
  
  void setRsidR(byte[] paramArrayOfbyte);
  
  void xsetRsidR(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidR();
  
  byte[] getRsidSect();
  
  STLongHexNumber xgetRsidSect();
  
  boolean isSetRsidSect();
  
  void setRsidSect(byte[] paramArrayOfbyte);
  
  void xsetRsidSect(STLongHexNumber paramSTLongHexNumber);
  
  void unsetRsidSect();
  
  public static final class Factory {
    public static CTSectPr newInstance() {
      return (CTSectPr)POIXMLTypeLoader.newInstance(CTSectPr.type, null);
    }
    
    public static CTSectPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSectPr)POIXMLTypeLoader.newInstance(CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(String param1String) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1String, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1String, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(File param1File) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1File, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1File, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1URL, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1URL, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1InputStream, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1InputStream, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1Reader, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1Reader, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(Node param1Node) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1Node, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1Node, CTSectPr.type, param1XmlOptions);
    }
    
    public static CTSectPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSectPr.type, null);
    }
    
    public static CTSectPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSectPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSectPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSectPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSectPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSectPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */