package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.AttachedToolbarsType;
import com.microsoft.schemas.office.visio.x2012.main.CustomMenusFileType;
import com.microsoft.schemas.office.visio.x2012.main.CustomToolbarsFileType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DynamicGridEnabledType;
import com.microsoft.schemas.office.visio.x2012.main.GlueSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectBkgndsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectMastersType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectShapesType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectStylesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapAnglesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapExtensionsType;
import com.microsoft.schemas.office.visio.x2012.main.SnapSettingsType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class DocumentSettingsTypeImpl extends XmlComplexContentImpl implements DocumentSettingsType {
  private static final b GLUESETTINGS$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "GlueSettings");
  
  private static final b SNAPSETTINGS$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "SnapSettings");
  
  private static final b SNAPEXTENSIONS$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "SnapExtensions");
  
  private static final b SNAPANGLES$6 = new b("http://schemas.microsoft.com/office/visio/2012/main", "SnapAngles");
  
  private static final b DYNAMICGRIDENABLED$8 = new b("http://schemas.microsoft.com/office/visio/2012/main", "DynamicGridEnabled");
  
  private static final b PROTECTSTYLES$10 = new b("http://schemas.microsoft.com/office/visio/2012/main", "ProtectStyles");
  
  private static final b PROTECTSHAPES$12 = new b("http://schemas.microsoft.com/office/visio/2012/main", "ProtectShapes");
  
  private static final b PROTECTMASTERS$14 = new b("http://schemas.microsoft.com/office/visio/2012/main", "ProtectMasters");
  
  private static final b PROTECTBKGNDS$16 = new b("http://schemas.microsoft.com/office/visio/2012/main", "ProtectBkgnds");
  
  private static final b CUSTOMMENUSFILE$18 = new b("http://schemas.microsoft.com/office/visio/2012/main", "CustomMenusFile");
  
  private static final b CUSTOMTOOLBARSFILE$20 = new b("http://schemas.microsoft.com/office/visio/2012/main", "CustomToolbarsFile");
  
  private static final b ATTACHEDTOOLBARS$22 = new b("http://schemas.microsoft.com/office/visio/2012/main", "AttachedToolbars");
  
  private static final b TOPPAGE$24 = new b("", "TopPage");
  
  private static final b DEFAULTTEXTSTYLE$26 = new b("", "DefaultTextStyle");
  
  private static final b DEFAULTLINESTYLE$28 = new b("", "DefaultLineStyle");
  
  private static final b DEFAULTFILLSTYLE$30 = new b("", "DefaultFillStyle");
  
  private static final b DEFAULTGUIDESTYLE$32 = new b("", "DefaultGuideStyle");
  
  public DocumentSettingsTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public GlueSettingsType getGlueSettings() {
    synchronized (monitor()) {
      check_orphaned();
      GlueSettingsType glueSettingsType = null;
      glueSettingsType = (GlueSettingsType)get_store().find_element_user(GLUESETTINGS$0, 0);
      if (glueSettingsType == null)
        return null; 
      return glueSettingsType;
    } 
  }
  
  public boolean isSetGlueSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(GLUESETTINGS$0) != 0);
    } 
  }
  
  public void setGlueSettings(GlueSettingsType paramGlueSettingsType) {
    synchronized (monitor()) {
      check_orphaned();
      GlueSettingsType glueSettingsType = null;
      glueSettingsType = (GlueSettingsType)get_store().find_element_user(GLUESETTINGS$0, 0);
      if (glueSettingsType == null)
        glueSettingsType = (GlueSettingsType)get_store().add_element_user(GLUESETTINGS$0); 
      glueSettingsType.set((XmlObject)paramGlueSettingsType);
    } 
  }
  
  public GlueSettingsType addNewGlueSettings() {
    synchronized (monitor()) {
      check_orphaned();
      GlueSettingsType glueSettingsType = null;
      glueSettingsType = (GlueSettingsType)get_store().add_element_user(GLUESETTINGS$0);
      return glueSettingsType;
    } 
  }
  
  public void unsetGlueSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(GLUESETTINGS$0, 0);
    } 
  }
  
  public SnapSettingsType getSnapSettings() {
    synchronized (monitor()) {
      check_orphaned();
      SnapSettingsType snapSettingsType = null;
      snapSettingsType = (SnapSettingsType)get_store().find_element_user(SNAPSETTINGS$2, 0);
      if (snapSettingsType == null)
        return null; 
      return snapSettingsType;
    } 
  }
  
  public boolean isSetSnapSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPSETTINGS$2) != 0);
    } 
  }
  
  public void setSnapSettings(SnapSettingsType paramSnapSettingsType) {
    synchronized (monitor()) {
      check_orphaned();
      SnapSettingsType snapSettingsType = null;
      snapSettingsType = (SnapSettingsType)get_store().find_element_user(SNAPSETTINGS$2, 0);
      if (snapSettingsType == null)
        snapSettingsType = (SnapSettingsType)get_store().add_element_user(SNAPSETTINGS$2); 
      snapSettingsType.set((XmlObject)paramSnapSettingsType);
    } 
  }
  
  public SnapSettingsType addNewSnapSettings() {
    synchronized (monitor()) {
      check_orphaned();
      SnapSettingsType snapSettingsType = null;
      snapSettingsType = (SnapSettingsType)get_store().add_element_user(SNAPSETTINGS$2);
      return snapSettingsType;
    } 
  }
  
  public void unsetSnapSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPSETTINGS$2, 0);
    } 
  }
  
  public SnapExtensionsType getSnapExtensions() {
    synchronized (monitor()) {
      check_orphaned();
      SnapExtensionsType snapExtensionsType = null;
      snapExtensionsType = (SnapExtensionsType)get_store().find_element_user(SNAPEXTENSIONS$4, 0);
      if (snapExtensionsType == null)
        return null; 
      return snapExtensionsType;
    } 
  }
  
  public boolean isSetSnapExtensions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPEXTENSIONS$4) != 0);
    } 
  }
  
  public void setSnapExtensions(SnapExtensionsType paramSnapExtensionsType) {
    synchronized (monitor()) {
      check_orphaned();
      SnapExtensionsType snapExtensionsType = null;
      snapExtensionsType = (SnapExtensionsType)get_store().find_element_user(SNAPEXTENSIONS$4, 0);
      if (snapExtensionsType == null)
        snapExtensionsType = (SnapExtensionsType)get_store().add_element_user(SNAPEXTENSIONS$4); 
      snapExtensionsType.set((XmlObject)paramSnapExtensionsType);
    } 
  }
  
  public SnapExtensionsType addNewSnapExtensions() {
    synchronized (monitor()) {
      check_orphaned();
      SnapExtensionsType snapExtensionsType = null;
      snapExtensionsType = (SnapExtensionsType)get_store().add_element_user(SNAPEXTENSIONS$4);
      return snapExtensionsType;
    } 
  }
  
  public void unsetSnapExtensions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPEXTENSIONS$4, 0);
    } 
  }
  
  public SnapAnglesType getSnapAngles() {
    synchronized (monitor()) {
      check_orphaned();
      SnapAnglesType snapAnglesType = null;
      snapAnglesType = (SnapAnglesType)get_store().find_element_user(SNAPANGLES$6, 0);
      if (snapAnglesType == null)
        return null; 
      return snapAnglesType;
    } 
  }
  
  public boolean isSetSnapAngles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SNAPANGLES$6) != 0);
    } 
  }
  
  public void setSnapAngles(SnapAnglesType paramSnapAnglesType) {
    synchronized (monitor()) {
      check_orphaned();
      SnapAnglesType snapAnglesType = null;
      snapAnglesType = (SnapAnglesType)get_store().find_element_user(SNAPANGLES$6, 0);
      if (snapAnglesType == null)
        snapAnglesType = (SnapAnglesType)get_store().add_element_user(SNAPANGLES$6); 
      snapAnglesType.set((XmlObject)paramSnapAnglesType);
    } 
  }
  
  public SnapAnglesType addNewSnapAngles() {
    synchronized (monitor()) {
      check_orphaned();
      SnapAnglesType snapAnglesType = null;
      snapAnglesType = (SnapAnglesType)get_store().add_element_user(SNAPANGLES$6);
      return snapAnglesType;
    } 
  }
  
  public void unsetSnapAngles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SNAPANGLES$6, 0);
    } 
  }
  
  public DynamicGridEnabledType getDynamicGridEnabled() {
    synchronized (monitor()) {
      check_orphaned();
      DynamicGridEnabledType dynamicGridEnabledType = null;
      dynamicGridEnabledType = (DynamicGridEnabledType)get_store().find_element_user(DYNAMICGRIDENABLED$8, 0);
      if (dynamicGridEnabledType == null)
        return null; 
      return dynamicGridEnabledType;
    } 
  }
  
  public boolean isSetDynamicGridEnabled() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DYNAMICGRIDENABLED$8) != 0);
    } 
  }
  
  public void setDynamicGridEnabled(DynamicGridEnabledType paramDynamicGridEnabledType) {
    synchronized (monitor()) {
      check_orphaned();
      DynamicGridEnabledType dynamicGridEnabledType = null;
      dynamicGridEnabledType = (DynamicGridEnabledType)get_store().find_element_user(DYNAMICGRIDENABLED$8, 0);
      if (dynamicGridEnabledType == null)
        dynamicGridEnabledType = (DynamicGridEnabledType)get_store().add_element_user(DYNAMICGRIDENABLED$8); 
      dynamicGridEnabledType.set((XmlObject)paramDynamicGridEnabledType);
    } 
  }
  
  public DynamicGridEnabledType addNewDynamicGridEnabled() {
    synchronized (monitor()) {
      check_orphaned();
      DynamicGridEnabledType dynamicGridEnabledType = null;
      dynamicGridEnabledType = (DynamicGridEnabledType)get_store().add_element_user(DYNAMICGRIDENABLED$8);
      return dynamicGridEnabledType;
    } 
  }
  
  public void unsetDynamicGridEnabled() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DYNAMICGRIDENABLED$8, 0);
    } 
  }
  
  public ProtectStylesType getProtectStyles() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectStylesType protectStylesType = null;
      protectStylesType = (ProtectStylesType)get_store().find_element_user(PROTECTSTYLES$10, 0);
      if (protectStylesType == null)
        return null; 
      return protectStylesType;
    } 
  }
  
  public boolean isSetProtectStyles() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTSTYLES$10) != 0);
    } 
  }
  
  public void setProtectStyles(ProtectStylesType paramProtectStylesType) {
    synchronized (monitor()) {
      check_orphaned();
      ProtectStylesType protectStylesType = null;
      protectStylesType = (ProtectStylesType)get_store().find_element_user(PROTECTSTYLES$10, 0);
      if (protectStylesType == null)
        protectStylesType = (ProtectStylesType)get_store().add_element_user(PROTECTSTYLES$10); 
      protectStylesType.set((XmlObject)paramProtectStylesType);
    } 
  }
  
  public ProtectStylesType addNewProtectStyles() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectStylesType protectStylesType = null;
      protectStylesType = (ProtectStylesType)get_store().add_element_user(PROTECTSTYLES$10);
      return protectStylesType;
    } 
  }
  
  public void unsetProtectStyles() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTSTYLES$10, 0);
    } 
  }
  
  public ProtectShapesType getProtectShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectShapesType protectShapesType = null;
      protectShapesType = (ProtectShapesType)get_store().find_element_user(PROTECTSHAPES$12, 0);
      if (protectShapesType == null)
        return null; 
      return protectShapesType;
    } 
  }
  
  public boolean isSetProtectShapes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTSHAPES$12) != 0);
    } 
  }
  
  public void setProtectShapes(ProtectShapesType paramProtectShapesType) {
    synchronized (monitor()) {
      check_orphaned();
      ProtectShapesType protectShapesType = null;
      protectShapesType = (ProtectShapesType)get_store().find_element_user(PROTECTSHAPES$12, 0);
      if (protectShapesType == null)
        protectShapesType = (ProtectShapesType)get_store().add_element_user(PROTECTSHAPES$12); 
      protectShapesType.set((XmlObject)paramProtectShapesType);
    } 
  }
  
  public ProtectShapesType addNewProtectShapes() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectShapesType protectShapesType = null;
      protectShapesType = (ProtectShapesType)get_store().add_element_user(PROTECTSHAPES$12);
      return protectShapesType;
    } 
  }
  
  public void unsetProtectShapes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTSHAPES$12, 0);
    } 
  }
  
  public ProtectMastersType getProtectMasters() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectMastersType protectMastersType = null;
      protectMastersType = (ProtectMastersType)get_store().find_element_user(PROTECTMASTERS$14, 0);
      if (protectMastersType == null)
        return null; 
      return protectMastersType;
    } 
  }
  
  public boolean isSetProtectMasters() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTMASTERS$14) != 0);
    } 
  }
  
  public void setProtectMasters(ProtectMastersType paramProtectMastersType) {
    synchronized (monitor()) {
      check_orphaned();
      ProtectMastersType protectMastersType = null;
      protectMastersType = (ProtectMastersType)get_store().find_element_user(PROTECTMASTERS$14, 0);
      if (protectMastersType == null)
        protectMastersType = (ProtectMastersType)get_store().add_element_user(PROTECTMASTERS$14); 
      protectMastersType.set((XmlObject)paramProtectMastersType);
    } 
  }
  
  public ProtectMastersType addNewProtectMasters() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectMastersType protectMastersType = null;
      protectMastersType = (ProtectMastersType)get_store().add_element_user(PROTECTMASTERS$14);
      return protectMastersType;
    } 
  }
  
  public void unsetProtectMasters() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTMASTERS$14, 0);
    } 
  }
  
  public ProtectBkgndsType getProtectBkgnds() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectBkgndsType protectBkgndsType = null;
      protectBkgndsType = (ProtectBkgndsType)get_store().find_element_user(PROTECTBKGNDS$16, 0);
      if (protectBkgndsType == null)
        return null; 
      return protectBkgndsType;
    } 
  }
  
  public boolean isSetProtectBkgnds() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PROTECTBKGNDS$16) != 0);
    } 
  }
  
  public void setProtectBkgnds(ProtectBkgndsType paramProtectBkgndsType) {
    synchronized (monitor()) {
      check_orphaned();
      ProtectBkgndsType protectBkgndsType = null;
      protectBkgndsType = (ProtectBkgndsType)get_store().find_element_user(PROTECTBKGNDS$16, 0);
      if (protectBkgndsType == null)
        protectBkgndsType = (ProtectBkgndsType)get_store().add_element_user(PROTECTBKGNDS$16); 
      protectBkgndsType.set((XmlObject)paramProtectBkgndsType);
    } 
  }
  
  public ProtectBkgndsType addNewProtectBkgnds() {
    synchronized (monitor()) {
      check_orphaned();
      ProtectBkgndsType protectBkgndsType = null;
      protectBkgndsType = (ProtectBkgndsType)get_store().add_element_user(PROTECTBKGNDS$16);
      return protectBkgndsType;
    } 
  }
  
  public void unsetProtectBkgnds() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PROTECTBKGNDS$16, 0);
    } 
  }
  
  public CustomMenusFileType getCustomMenusFile() {
    synchronized (monitor()) {
      check_orphaned();
      CustomMenusFileType customMenusFileType = null;
      customMenusFileType = (CustomMenusFileType)get_store().find_element_user(CUSTOMMENUSFILE$18, 0);
      if (customMenusFileType == null)
        return null; 
      return customMenusFileType;
    } 
  }
  
  public boolean isSetCustomMenusFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMMENUSFILE$18) != 0);
    } 
  }
  
  public void setCustomMenusFile(CustomMenusFileType paramCustomMenusFileType) {
    synchronized (monitor()) {
      check_orphaned();
      CustomMenusFileType customMenusFileType = null;
      customMenusFileType = (CustomMenusFileType)get_store().find_element_user(CUSTOMMENUSFILE$18, 0);
      if (customMenusFileType == null)
        customMenusFileType = (CustomMenusFileType)get_store().add_element_user(CUSTOMMENUSFILE$18); 
      customMenusFileType.set((XmlObject)paramCustomMenusFileType);
    } 
  }
  
  public CustomMenusFileType addNewCustomMenusFile() {
    synchronized (monitor()) {
      check_orphaned();
      CustomMenusFileType customMenusFileType = null;
      customMenusFileType = (CustomMenusFileType)get_store().add_element_user(CUSTOMMENUSFILE$18);
      return customMenusFileType;
    } 
  }
  
  public void unsetCustomMenusFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMMENUSFILE$18, 0);
    } 
  }
  
  public CustomToolbarsFileType getCustomToolbarsFile() {
    synchronized (monitor()) {
      check_orphaned();
      CustomToolbarsFileType customToolbarsFileType = null;
      customToolbarsFileType = (CustomToolbarsFileType)get_store().find_element_user(CUSTOMTOOLBARSFILE$20, 0);
      if (customToolbarsFileType == null)
        return null; 
      return customToolbarsFileType;
    } 
  }
  
  public boolean isSetCustomToolbarsFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMTOOLBARSFILE$20) != 0);
    } 
  }
  
  public void setCustomToolbarsFile(CustomToolbarsFileType paramCustomToolbarsFileType) {
    synchronized (monitor()) {
      check_orphaned();
      CustomToolbarsFileType customToolbarsFileType = null;
      customToolbarsFileType = (CustomToolbarsFileType)get_store().find_element_user(CUSTOMTOOLBARSFILE$20, 0);
      if (customToolbarsFileType == null)
        customToolbarsFileType = (CustomToolbarsFileType)get_store().add_element_user(CUSTOMTOOLBARSFILE$20); 
      customToolbarsFileType.set((XmlObject)paramCustomToolbarsFileType);
    } 
  }
  
  public CustomToolbarsFileType addNewCustomToolbarsFile() {
    synchronized (monitor()) {
      check_orphaned();
      CustomToolbarsFileType customToolbarsFileType = null;
      customToolbarsFileType = (CustomToolbarsFileType)get_store().add_element_user(CUSTOMTOOLBARSFILE$20);
      return customToolbarsFileType;
    } 
  }
  
  public void unsetCustomToolbarsFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMTOOLBARSFILE$20, 0);
    } 
  }
  
  public AttachedToolbarsType getAttachedToolbars() {
    synchronized (monitor()) {
      check_orphaned();
      AttachedToolbarsType attachedToolbarsType = null;
      attachedToolbarsType = (AttachedToolbarsType)get_store().find_element_user(ATTACHEDTOOLBARS$22, 0);
      if (attachedToolbarsType == null)
        return null; 
      return attachedToolbarsType;
    } 
  }
  
  public boolean isSetAttachedToolbars() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ATTACHEDTOOLBARS$22) != 0);
    } 
  }
  
  public void setAttachedToolbars(AttachedToolbarsType paramAttachedToolbarsType) {
    synchronized (monitor()) {
      check_orphaned();
      AttachedToolbarsType attachedToolbarsType = null;
      attachedToolbarsType = (AttachedToolbarsType)get_store().find_element_user(ATTACHEDTOOLBARS$22, 0);
      if (attachedToolbarsType == null)
        attachedToolbarsType = (AttachedToolbarsType)get_store().add_element_user(ATTACHEDTOOLBARS$22); 
      attachedToolbarsType.set((XmlObject)paramAttachedToolbarsType);
    } 
  }
  
  public AttachedToolbarsType addNewAttachedToolbars() {
    synchronized (monitor()) {
      check_orphaned();
      AttachedToolbarsType attachedToolbarsType = null;
      attachedToolbarsType = (AttachedToolbarsType)get_store().add_element_user(ATTACHEDTOOLBARS$22);
      return attachedToolbarsType;
    } 
  }
  
  public void unsetAttachedToolbars() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ATTACHEDTOOLBARS$22, 0);
    } 
  }
  
  public long getTopPage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPPAGE$24);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTopPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TOPPAGE$24);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTopPage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TOPPAGE$24) != null);
    } 
  }
  
  public void setTopPage(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TOPPAGE$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TOPPAGE$24); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTopPage(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TOPPAGE$24);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(TOPPAGE$24); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTopPage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TOPPAGE$24);
    } 
  }
  
  public long getDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTTEXTSTYLE$26) != null);
    } 
  }
  
  public void setDefaultTextStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTTEXTSTYLE$26); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDefaultTextStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTTEXTSTYLE$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DEFAULTTEXTSTYLE$26); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDefaultTextStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTTEXTSTYLE$26);
    } 
  }
  
  public long getDefaultLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTLINESTYLE$28);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDefaultLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTLINESTYLE$28);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDefaultLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTLINESTYLE$28) != null);
    } 
  }
  
  public void setDefaultLineStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTLINESTYLE$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTLINESTYLE$28); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDefaultLineStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTLINESTYLE$28);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DEFAULTLINESTYLE$28); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDefaultLineStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTLINESTYLE$28);
    } 
  }
  
  public long getDefaultFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDefaultFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDefaultFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTFILLSTYLE$30) != null);
    } 
  }
  
  public void setDefaultFillStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTFILLSTYLE$30); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDefaultFillStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTFILLSTYLE$30);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DEFAULTFILLSTYLE$30); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDefaultFillStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTFILLSTYLE$30);
    } 
  }
  
  public long getDefaultGuideStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDefaultGuideStyle() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDefaultGuideStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTGUIDESTYLE$32) != null);
    } 
  }
  
  public void setDefaultGuideStyle(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTGUIDESTYLE$32); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDefaultGuideStyle(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTGUIDESTYLE$32);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DEFAULTGUIDESTYLE$32); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDefaultGuideStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTGUIDESTYLE$32);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\DocumentSettingsTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */