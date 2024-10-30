package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTCfRule extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCfRule.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcfrule3548type");
  
  List<String> getFormulaList();
  
  String[] getFormulaArray();
  
  String getFormulaArray(int paramInt);
  
  List<STFormula> xgetFormulaList();
  
  STFormula[] xgetFormulaArray();
  
  STFormula xgetFormulaArray(int paramInt);
  
  int sizeOfFormulaArray();
  
  void setFormulaArray(String[] paramArrayOfString);
  
  void setFormulaArray(int paramInt, String paramString);
  
  void xsetFormulaArray(STFormula[] paramArrayOfSTFormula);
  
  void xsetFormulaArray(int paramInt, STFormula paramSTFormula);
  
  void insertFormula(int paramInt, String paramString);
  
  void addFormula(String paramString);
  
  STFormula insertNewFormula(int paramInt);
  
  STFormula addNewFormula();
  
  void removeFormula(int paramInt);
  
  CTColorScale getColorScale();
  
  boolean isSetColorScale();
  
  void setColorScale(CTColorScale paramCTColorScale);
  
  CTColorScale addNewColorScale();
  
  void unsetColorScale();
  
  CTDataBar getDataBar();
  
  boolean isSetDataBar();
  
  void setDataBar(CTDataBar paramCTDataBar);
  
  CTDataBar addNewDataBar();
  
  void unsetDataBar();
  
  CTIconSet getIconSet();
  
  boolean isSetIconSet();
  
  void setIconSet(CTIconSet paramCTIconSet);
  
  CTIconSet addNewIconSet();
  
  void unsetIconSet();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STCfType.Enum getType();
  
  STCfType xgetType();
  
  boolean isSetType();
  
  void setType(STCfType.Enum paramEnum);
  
  void xsetType(STCfType paramSTCfType);
  
  void unsetType();
  
  long getDxfId();
  
  STDxfId xgetDxfId();
  
  boolean isSetDxfId();
  
  void setDxfId(long paramLong);
  
  void xsetDxfId(STDxfId paramSTDxfId);
  
  void unsetDxfId();
  
  int getPriority();
  
  XmlInt xgetPriority();
  
  void setPriority(int paramInt);
  
  void xsetPriority(XmlInt paramXmlInt);
  
  boolean getStopIfTrue();
  
  XmlBoolean xgetStopIfTrue();
  
  boolean isSetStopIfTrue();
  
  void setStopIfTrue(boolean paramBoolean);
  
  void xsetStopIfTrue(XmlBoolean paramXmlBoolean);
  
  void unsetStopIfTrue();
  
  boolean getAboveAverage();
  
  XmlBoolean xgetAboveAverage();
  
  boolean isSetAboveAverage();
  
  void setAboveAverage(boolean paramBoolean);
  
  void xsetAboveAverage(XmlBoolean paramXmlBoolean);
  
  void unsetAboveAverage();
  
  boolean getPercent();
  
  XmlBoolean xgetPercent();
  
  boolean isSetPercent();
  
  void setPercent(boolean paramBoolean);
  
  void xsetPercent(XmlBoolean paramXmlBoolean);
  
  void unsetPercent();
  
  boolean getBottom();
  
  XmlBoolean xgetBottom();
  
  boolean isSetBottom();
  
  void setBottom(boolean paramBoolean);
  
  void xsetBottom(XmlBoolean paramXmlBoolean);
  
  void unsetBottom();
  
  STConditionalFormattingOperator.Enum getOperator();
  
  STConditionalFormattingOperator xgetOperator();
  
  boolean isSetOperator();
  
  void setOperator(STConditionalFormattingOperator.Enum paramEnum);
  
  void xsetOperator(STConditionalFormattingOperator paramSTConditionalFormattingOperator);
  
  void unsetOperator();
  
  String getText();
  
  XmlString xgetText();
  
  boolean isSetText();
  
  void setText(String paramString);
  
  void xsetText(XmlString paramXmlString);
  
  void unsetText();
  
  STTimePeriod$Enum getTimePeriod();
  
  STTimePeriod xgetTimePeriod();
  
  boolean isSetTimePeriod();
  
  void setTimePeriod(STTimePeriod$Enum paramSTTimePeriod$Enum);
  
  void xsetTimePeriod(STTimePeriod paramSTTimePeriod);
  
  void unsetTimePeriod();
  
  long getRank();
  
  XmlUnsignedInt xgetRank();
  
  boolean isSetRank();
  
  void setRank(long paramLong);
  
  void xsetRank(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetRank();
  
  int getStdDev();
  
  XmlInt xgetStdDev();
  
  boolean isSetStdDev();
  
  void setStdDev(int paramInt);
  
  void xsetStdDev(XmlInt paramXmlInt);
  
  void unsetStdDev();
  
  boolean getEqualAverage();
  
  XmlBoolean xgetEqualAverage();
  
  boolean isSetEqualAverage();
  
  void setEqualAverage(boolean paramBoolean);
  
  void xsetEqualAverage(XmlBoolean paramXmlBoolean);
  
  void unsetEqualAverage();
  
  public static final class Factory {
    public static CTCfRule newInstance() {
      return (CTCfRule)POIXMLTypeLoader.newInstance(CTCfRule.type, null);
    }
    
    public static CTCfRule newInstance(XmlOptions param1XmlOptions) {
      return (CTCfRule)POIXMLTypeLoader.newInstance(CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(String param1String) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1String, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1String, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(File param1File) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1File, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1File, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(URL param1URL) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1URL, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1URL, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1InputStream, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1InputStream, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1Reader, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1Reader, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(Node param1Node) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1Node, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1Node, CTCfRule.type, param1XmlOptions);
    }
    
    public static CTCfRule parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1XMLInputStream, CTCfRule.type, null);
    }
    
    public static CTCfRule parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCfRule)POIXMLTypeLoader.parse(param1XMLInputStream, CTCfRule.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCfRule.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCfRule.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCfRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */