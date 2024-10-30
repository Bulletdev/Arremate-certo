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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTableColumn extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTableColumn.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttablecolumn08a3type");
  
  CTTableFormula getCalculatedColumnFormula();
  
  boolean isSetCalculatedColumnFormula();
  
  void setCalculatedColumnFormula(CTTableFormula paramCTTableFormula);
  
  CTTableFormula addNewCalculatedColumnFormula();
  
  void unsetCalculatedColumnFormula();
  
  CTTableFormula getTotalsRowFormula();
  
  boolean isSetTotalsRowFormula();
  
  void setTotalsRowFormula(CTTableFormula paramCTTableFormula);
  
  CTTableFormula addNewTotalsRowFormula();
  
  void unsetTotalsRowFormula();
  
  CTXmlColumnPr getXmlColumnPr();
  
  boolean isSetXmlColumnPr();
  
  void setXmlColumnPr(CTXmlColumnPr paramCTXmlColumnPr);
  
  CTXmlColumnPr addNewXmlColumnPr();
  
  void unsetXmlColumnPr();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  long getId();
  
  XmlUnsignedInt xgetId();
  
  void setId(long paramLong);
  
  void xsetId(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getUniqueName();
  
  STXstring xgetUniqueName();
  
  boolean isSetUniqueName();
  
  void setUniqueName(String paramString);
  
  void xsetUniqueName(STXstring paramSTXstring);
  
  void unsetUniqueName();
  
  String getName();
  
  STXstring xgetName();
  
  void setName(String paramString);
  
  void xsetName(STXstring paramSTXstring);
  
  STTotalsRowFunction$Enum getTotalsRowFunction();
  
  STTotalsRowFunction xgetTotalsRowFunction();
  
  boolean isSetTotalsRowFunction();
  
  void setTotalsRowFunction(STTotalsRowFunction$Enum paramSTTotalsRowFunction$Enum);
  
  void xsetTotalsRowFunction(STTotalsRowFunction paramSTTotalsRowFunction);
  
  void unsetTotalsRowFunction();
  
  String getTotalsRowLabel();
  
  STXstring xgetTotalsRowLabel();
  
  boolean isSetTotalsRowLabel();
  
  void setTotalsRowLabel(String paramString);
  
  void xsetTotalsRowLabel(STXstring paramSTXstring);
  
  void unsetTotalsRowLabel();
  
  long getQueryTableFieldId();
  
  XmlUnsignedInt xgetQueryTableFieldId();
  
  boolean isSetQueryTableFieldId();
  
  void setQueryTableFieldId(long paramLong);
  
  void xsetQueryTableFieldId(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetQueryTableFieldId();
  
  long getHeaderRowDxfId();
  
  STDxfId xgetHeaderRowDxfId();
  
  boolean isSetHeaderRowDxfId();
  
  void setHeaderRowDxfId(long paramLong);
  
  void xsetHeaderRowDxfId(STDxfId paramSTDxfId);
  
  void unsetHeaderRowDxfId();
  
  long getDataDxfId();
  
  STDxfId xgetDataDxfId();
  
  boolean isSetDataDxfId();
  
  void setDataDxfId(long paramLong);
  
  void xsetDataDxfId(STDxfId paramSTDxfId);
  
  void unsetDataDxfId();
  
  long getTotalsRowDxfId();
  
  STDxfId xgetTotalsRowDxfId();
  
  boolean isSetTotalsRowDxfId();
  
  void setTotalsRowDxfId(long paramLong);
  
  void xsetTotalsRowDxfId(STDxfId paramSTDxfId);
  
  void unsetTotalsRowDxfId();
  
  String getHeaderRowCellStyle();
  
  STXstring xgetHeaderRowCellStyle();
  
  boolean isSetHeaderRowCellStyle();
  
  void setHeaderRowCellStyle(String paramString);
  
  void xsetHeaderRowCellStyle(STXstring paramSTXstring);
  
  void unsetHeaderRowCellStyle();
  
  String getDataCellStyle();
  
  STXstring xgetDataCellStyle();
  
  boolean isSetDataCellStyle();
  
  void setDataCellStyle(String paramString);
  
  void xsetDataCellStyle(STXstring paramSTXstring);
  
  void unsetDataCellStyle();
  
  String getTotalsRowCellStyle();
  
  STXstring xgetTotalsRowCellStyle();
  
  boolean isSetTotalsRowCellStyle();
  
  void setTotalsRowCellStyle(String paramString);
  
  void xsetTotalsRowCellStyle(STXstring paramSTXstring);
  
  void unsetTotalsRowCellStyle();
  
  public static final class Factory {
    public static CTTableColumn newInstance() {
      return (CTTableColumn)POIXMLTypeLoader.newInstance(CTTableColumn.type, null);
    }
    
    public static CTTableColumn newInstance(XmlOptions param1XmlOptions) {
      return (CTTableColumn)POIXMLTypeLoader.newInstance(CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(String param1String) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1String, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1String, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(File param1File) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1File, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1File, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(URL param1URL) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1URL, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1URL, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1InputStream, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1InputStream, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1Reader, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1Reader, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(Node param1Node) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1Node, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1Node, CTTableColumn.type, param1XmlOptions);
    }
    
    public static CTTableColumn parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableColumn.type, null);
    }
    
    public static CTTableColumn parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTableColumn)POIXMLTypeLoader.parse(param1XMLInputStream, CTTableColumn.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableColumn.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTableColumn.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTTableColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */