package com.microsoft.schemas.office.office.impl;

import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.STExt;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTLockImpl extends XmlComplexContentImpl implements CTLock {
  private static final b EXT$0 = new b("urn:schemas-microsoft-com:vml", "ext");
  
  private static final b POSITION$2 = new b("", "position");
  
  private static final b SELECTION$4 = new b("", "selection");
  
  private static final b GROUPING$6 = new b("", "grouping");
  
  private static final b UNGROUPING$8 = new b("", "ungrouping");
  
  private static final b ROTATION$10 = new b("", "rotation");
  
  private static final b CROPPING$12 = new b("", "cropping");
  
  private static final b VERTICIES$14 = new b("", "verticies");
  
  private static final b ADJUSTHANDLES$16 = new b("", "adjusthandles");
  
  private static final b TEXT$18 = new b("", "text");
  
  private static final b ASPECTRATIO$20 = new b("", "aspectratio");
  
  private static final b SHAPETYPE$22 = new b("", "shapetype");
  
  public CTLockImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STExt.Enum getExt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$0);
      if (simpleValue == null)
        return null; 
      return (STExt.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STExt xgetExt() {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$0);
      return sTExt;
    } 
  }
  
  public boolean isSetExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EXT$0) != null);
    } 
  }
  
  public void setExt(STExt.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EXT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EXT$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetExt(STExt paramSTExt) {
    synchronized (monitor()) {
      check_orphaned();
      STExt sTExt = null;
      sTExt = (STExt)get_store().find_attribute_user(EXT$0);
      if (sTExt == null)
        sTExt = (STExt)get_store().add_attribute_user(EXT$0); 
      sTExt.set((XmlObject)paramSTExt);
    } 
  }
  
  public void unsetExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EXT$0);
    } 
  }
  
  public STTrueFalse.Enum getPosition() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$2);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(POSITION$2);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(POSITION$2) != null);
    } 
  }
  
  public void setPosition(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POSITION$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POSITION$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetPosition(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(POSITION$2);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(POSITION$2); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetPosition() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(POSITION$2);
    } 
  }
  
  public STTrueFalse.Enum getSelection() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTION$4);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetSelection() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SELECTION$4);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetSelection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SELECTION$4) != null);
    } 
  }
  
  public void setSelection(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SELECTION$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SELECTION$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetSelection(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SELECTION$4);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(SELECTION$4); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetSelection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SELECTION$4);
    } 
  }
  
  public STTrueFalse.Enum getGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GROUPING$6);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(GROUPING$6);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(GROUPING$6) != null);
    } 
  }
  
  public void setGrouping(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(GROUPING$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(GROUPING$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetGrouping(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(GROUPING$6);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(GROUPING$6); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetGrouping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(GROUPING$6);
    } 
  }
  
  public STTrueFalse.Enum getUngrouping() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNGROUPING$8);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetUngrouping() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(UNGROUPING$8);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetUngrouping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNGROUPING$8) != null);
    } 
  }
  
  public void setUngrouping(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNGROUPING$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNGROUPING$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUngrouping(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(UNGROUPING$8);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(UNGROUPING$8); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetUngrouping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNGROUPING$8);
    } 
  }
  
  public STTrueFalse.Enum getRotation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTATION$10);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetRotation() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ROTATION$10);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetRotation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ROTATION$10) != null);
    } 
  }
  
  public void setRotation(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ROTATION$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ROTATION$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRotation(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ROTATION$10);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ROTATION$10); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetRotation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ROTATION$10);
    } 
  }
  
  public STTrueFalse.Enum getCropping() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CROPPING$12);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetCropping() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CROPPING$12);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetCropping() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CROPPING$12) != null);
    } 
  }
  
  public void setCropping(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CROPPING$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CROPPING$12); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCropping(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(CROPPING$12);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(CROPPING$12); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetCropping() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CROPPING$12);
    } 
  }
  
  public STTrueFalse.Enum getVerticies() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICIES$14);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetVerticies() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(VERTICIES$14);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetVerticies() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTICIES$14) != null);
    } 
  }
  
  public void setVerticies(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICIES$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTICIES$14); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVerticies(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(VERTICIES$14);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(VERTICIES$14); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetVerticies() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTICIES$14);
    } 
  }
  
  public STTrueFalse.Enum getAdjusthandles() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ADJUSTHANDLES$16);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAdjusthandles() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ADJUSTHANDLES$16);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAdjusthandles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ADJUSTHANDLES$16) != null);
    } 
  }
  
  public void setAdjusthandles(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ADJUSTHANDLES$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ADJUSTHANDLES$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAdjusthandles(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ADJUSTHANDLES$16);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ADJUSTHANDLES$16); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAdjusthandles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ADJUSTHANDLES$16);
    } 
  }
  
  public STTrueFalse.Enum getText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXT$18);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetText() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TEXT$18);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXT$18) != null);
    } 
  }
  
  public void setText(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXT$18); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetText(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(TEXT$18);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(TEXT$18); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXT$18);
    } 
  }
  
  public STTrueFalse.Enum getAspectratio() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASPECTRATIO$20);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetAspectratio() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ASPECTRATIO$20);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetAspectratio() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASPECTRATIO$20) != null);
    } 
  }
  
  public void setAspectratio(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASPECTRATIO$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASPECTRATIO$20); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAspectratio(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(ASPECTRATIO$20);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(ASPECTRATIO$20); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetAspectratio() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASPECTRATIO$20);
    } 
  }
  
  public STTrueFalse.Enum getShapetype() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHAPETYPE$22);
      if (simpleValue == null)
        return null; 
      return (STTrueFalse.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTrueFalse xgetShapetype() {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SHAPETYPE$22);
      return sTTrueFalse;
    } 
  }
  
  public boolean isSetShapetype() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHAPETYPE$22) != null);
    } 
  }
  
  public void setShapetype(STTrueFalse.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHAPETYPE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHAPETYPE$22); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetShapetype(STTrueFalse paramSTTrueFalse) {
    synchronized (monitor()) {
      check_orphaned();
      STTrueFalse sTTrueFalse = null;
      sTTrueFalse = (STTrueFalse)get_store().find_attribute_user(SHAPETYPE$22);
      if (sTTrueFalse == null)
        sTTrueFalse = (STTrueFalse)get_store().add_attribute_user(SHAPETYPE$22); 
      sTTrueFalse.set((XmlObject)paramSTTrueFalse);
    } 
  }
  
  public void unsetShapetype() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHAPETYPE$22);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\impl\CTLockImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */