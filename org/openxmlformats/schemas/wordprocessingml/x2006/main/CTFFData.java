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

public interface CTFFData extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTFFData.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctffdataaa7etype");
  
  List<CTFFName> getNameList();
  
  CTFFName[] getNameArray();
  
  CTFFName getNameArray(int paramInt);
  
  int sizeOfNameArray();
  
  void setNameArray(CTFFName[] paramArrayOfCTFFName);
  
  void setNameArray(int paramInt, CTFFName paramCTFFName);
  
  CTFFName insertNewName(int paramInt);
  
  CTFFName addNewName();
  
  void removeName(int paramInt);
  
  List<CTOnOff> getEnabledList();
  
  CTOnOff[] getEnabledArray();
  
  CTOnOff getEnabledArray(int paramInt);
  
  int sizeOfEnabledArray();
  
  void setEnabledArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setEnabledArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewEnabled(int paramInt);
  
  CTOnOff addNewEnabled();
  
  void removeEnabled(int paramInt);
  
  List<CTOnOff> getCalcOnExitList();
  
  CTOnOff[] getCalcOnExitArray();
  
  CTOnOff getCalcOnExitArray(int paramInt);
  
  int sizeOfCalcOnExitArray();
  
  void setCalcOnExitArray(CTOnOff[] paramArrayOfCTOnOff);
  
  void setCalcOnExitArray(int paramInt, CTOnOff paramCTOnOff);
  
  CTOnOff insertNewCalcOnExit(int paramInt);
  
  CTOnOff addNewCalcOnExit();
  
  void removeCalcOnExit(int paramInt);
  
  List<CTMacroName> getEntryMacroList();
  
  CTMacroName[] getEntryMacroArray();
  
  CTMacroName getEntryMacroArray(int paramInt);
  
  int sizeOfEntryMacroArray();
  
  void setEntryMacroArray(CTMacroName[] paramArrayOfCTMacroName);
  
  void setEntryMacroArray(int paramInt, CTMacroName paramCTMacroName);
  
  CTMacroName insertNewEntryMacro(int paramInt);
  
  CTMacroName addNewEntryMacro();
  
  void removeEntryMacro(int paramInt);
  
  List<CTMacroName> getExitMacroList();
  
  CTMacroName[] getExitMacroArray();
  
  CTMacroName getExitMacroArray(int paramInt);
  
  int sizeOfExitMacroArray();
  
  void setExitMacroArray(CTMacroName[] paramArrayOfCTMacroName);
  
  void setExitMacroArray(int paramInt, CTMacroName paramCTMacroName);
  
  CTMacroName insertNewExitMacro(int paramInt);
  
  CTMacroName addNewExitMacro();
  
  void removeExitMacro(int paramInt);
  
  List<CTFFHelpText> getHelpTextList();
  
  CTFFHelpText[] getHelpTextArray();
  
  CTFFHelpText getHelpTextArray(int paramInt);
  
  int sizeOfHelpTextArray();
  
  void setHelpTextArray(CTFFHelpText[] paramArrayOfCTFFHelpText);
  
  void setHelpTextArray(int paramInt, CTFFHelpText paramCTFFHelpText);
  
  CTFFHelpText insertNewHelpText(int paramInt);
  
  CTFFHelpText addNewHelpText();
  
  void removeHelpText(int paramInt);
  
  List<CTFFStatusText> getStatusTextList();
  
  CTFFStatusText[] getStatusTextArray();
  
  CTFFStatusText getStatusTextArray(int paramInt);
  
  int sizeOfStatusTextArray();
  
  void setStatusTextArray(CTFFStatusText[] paramArrayOfCTFFStatusText);
  
  void setStatusTextArray(int paramInt, CTFFStatusText paramCTFFStatusText);
  
  CTFFStatusText insertNewStatusText(int paramInt);
  
  CTFFStatusText addNewStatusText();
  
  void removeStatusText(int paramInt);
  
  List<CTFFCheckBox> getCheckBoxList();
  
  CTFFCheckBox[] getCheckBoxArray();
  
  CTFFCheckBox getCheckBoxArray(int paramInt);
  
  int sizeOfCheckBoxArray();
  
  void setCheckBoxArray(CTFFCheckBox[] paramArrayOfCTFFCheckBox);
  
  void setCheckBoxArray(int paramInt, CTFFCheckBox paramCTFFCheckBox);
  
  CTFFCheckBox insertNewCheckBox(int paramInt);
  
  CTFFCheckBox addNewCheckBox();
  
  void removeCheckBox(int paramInt);
  
  List<CTFFDDList> getDdListList();
  
  CTFFDDList[] getDdListArray();
  
  CTFFDDList getDdListArray(int paramInt);
  
  int sizeOfDdListArray();
  
  void setDdListArray(CTFFDDList[] paramArrayOfCTFFDDList);
  
  void setDdListArray(int paramInt, CTFFDDList paramCTFFDDList);
  
  CTFFDDList insertNewDdList(int paramInt);
  
  CTFFDDList addNewDdList();
  
  void removeDdList(int paramInt);
  
  List<CTFFTextInput> getTextInputList();
  
  CTFFTextInput[] getTextInputArray();
  
  CTFFTextInput getTextInputArray(int paramInt);
  
  int sizeOfTextInputArray();
  
  void setTextInputArray(CTFFTextInput[] paramArrayOfCTFFTextInput);
  
  void setTextInputArray(int paramInt, CTFFTextInput paramCTFFTextInput);
  
  CTFFTextInput insertNewTextInput(int paramInt);
  
  CTFFTextInput addNewTextInput();
  
  void removeTextInput(int paramInt);
  
  public static final class Factory {
    public static CTFFData newInstance() {
      return (CTFFData)POIXMLTypeLoader.newInstance(CTFFData.type, null);
    }
    
    public static CTFFData newInstance(XmlOptions param1XmlOptions) {
      return (CTFFData)POIXMLTypeLoader.newInstance(CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(String param1String) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1String, CTFFData.type, null);
    }
    
    public static CTFFData parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1String, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(File param1File) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1File, CTFFData.type, null);
    }
    
    public static CTFFData parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1File, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(URL param1URL) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1URL, CTFFData.type, null);
    }
    
    public static CTFFData parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1URL, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1InputStream, CTFFData.type, null);
    }
    
    public static CTFFData parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1InputStream, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(Reader param1Reader) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1Reader, CTFFData.type, null);
    }
    
    public static CTFFData parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTFFData)POIXMLTypeLoader.parse(param1Reader, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFFData.type, null);
    }
    
    public static CTFFData parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1XMLStreamReader, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(Node param1Node) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1Node, CTFFData.type, null);
    }
    
    public static CTFFData parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTFFData)POIXMLTypeLoader.parse(param1Node, CTFFData.type, param1XmlOptions);
    }
    
    public static CTFFData parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTFFData)POIXMLTypeLoader.parse(param1XMLInputStream, CTFFData.type, null);
    }
    
    public static CTFFData parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTFFData)POIXMLTypeLoader.parse(param1XMLInputStream, CTFFData.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFFData.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTFFData.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTFFData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */