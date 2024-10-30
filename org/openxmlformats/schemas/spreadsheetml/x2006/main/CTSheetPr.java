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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSheetPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSheetPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsheetpr3ae0type");
  
  CTColor getTabColor();
  
  boolean isSetTabColor();
  
  void setTabColor(CTColor paramCTColor);
  
  CTColor addNewTabColor();
  
  void unsetTabColor();
  
  CTOutlinePr getOutlinePr();
  
  boolean isSetOutlinePr();
  
  void setOutlinePr(CTOutlinePr paramCTOutlinePr);
  
  CTOutlinePr addNewOutlinePr();
  
  void unsetOutlinePr();
  
  CTPageSetUpPr getPageSetUpPr();
  
  boolean isSetPageSetUpPr();
  
  void setPageSetUpPr(CTPageSetUpPr paramCTPageSetUpPr);
  
  CTPageSetUpPr addNewPageSetUpPr();
  
  void unsetPageSetUpPr();
  
  boolean getSyncHorizontal();
  
  XmlBoolean xgetSyncHorizontal();
  
  boolean isSetSyncHorizontal();
  
  void setSyncHorizontal(boolean paramBoolean);
  
  void xsetSyncHorizontal(XmlBoolean paramXmlBoolean);
  
  void unsetSyncHorizontal();
  
  boolean getSyncVertical();
  
  XmlBoolean xgetSyncVertical();
  
  boolean isSetSyncVertical();
  
  void setSyncVertical(boolean paramBoolean);
  
  void xsetSyncVertical(XmlBoolean paramXmlBoolean);
  
  void unsetSyncVertical();
  
  String getSyncRef();
  
  STRef xgetSyncRef();
  
  boolean isSetSyncRef();
  
  void setSyncRef(String paramString);
  
  void xsetSyncRef(STRef paramSTRef);
  
  void unsetSyncRef();
  
  boolean getTransitionEvaluation();
  
  XmlBoolean xgetTransitionEvaluation();
  
  boolean isSetTransitionEvaluation();
  
  void setTransitionEvaluation(boolean paramBoolean);
  
  void xsetTransitionEvaluation(XmlBoolean paramXmlBoolean);
  
  void unsetTransitionEvaluation();
  
  boolean getTransitionEntry();
  
  XmlBoolean xgetTransitionEntry();
  
  boolean isSetTransitionEntry();
  
  void setTransitionEntry(boolean paramBoolean);
  
  void xsetTransitionEntry(XmlBoolean paramXmlBoolean);
  
  void unsetTransitionEntry();
  
  boolean getPublished();
  
  XmlBoolean xgetPublished();
  
  boolean isSetPublished();
  
  void setPublished(boolean paramBoolean);
  
  void xsetPublished(XmlBoolean paramXmlBoolean);
  
  void unsetPublished();
  
  String getCodeName();
  
  XmlString xgetCodeName();
  
  boolean isSetCodeName();
  
  void setCodeName(String paramString);
  
  void xsetCodeName(XmlString paramXmlString);
  
  void unsetCodeName();
  
  boolean getFilterMode();
  
  XmlBoolean xgetFilterMode();
  
  boolean isSetFilterMode();
  
  void setFilterMode(boolean paramBoolean);
  
  void xsetFilterMode(XmlBoolean paramXmlBoolean);
  
  void unsetFilterMode();
  
  boolean getEnableFormatConditionsCalculation();
  
  XmlBoolean xgetEnableFormatConditionsCalculation();
  
  boolean isSetEnableFormatConditionsCalculation();
  
  void setEnableFormatConditionsCalculation(boolean paramBoolean);
  
  void xsetEnableFormatConditionsCalculation(XmlBoolean paramXmlBoolean);
  
  void unsetEnableFormatConditionsCalculation();
  
  public static final class Factory {
    public static CTSheetPr newInstance() {
      return (CTSheetPr)POIXMLTypeLoader.newInstance(CTSheetPr.type, null);
    }
    
    public static CTSheetPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSheetPr)POIXMLTypeLoader.newInstance(CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(String param1String) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1String, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1String, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(File param1File) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1File, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1File, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1URL, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1URL, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1InputStream, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1Reader, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1Reader, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(Node param1Node) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1Node, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1Node, CTSheetPr.type, param1XmlOptions);
    }
    
    public static CTSheetPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetPr.type, null);
    }
    
    public static CTSheetPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSheetPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSheetPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSheetPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSheetPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */