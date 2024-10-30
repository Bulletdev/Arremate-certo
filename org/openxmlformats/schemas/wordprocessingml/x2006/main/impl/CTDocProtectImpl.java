package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTDocProtectImpl extends XmlComplexContentImpl implements CTDocProtect {
  private static final b EDIT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "edit");
  
  private static final b FORMATTING$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "formatting");
  
  private static final b ENFORCEMENT$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enforcement");
  
  private static final b CRYPTPROVIDERTYPE$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderType");
  
  private static final b CRYPTALGORITHMCLASS$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmClass");
  
  private static final b CRYPTALGORITHMTYPE$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmType");
  
  private static final b CRYPTALGORITHMSID$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptAlgorithmSid");
  
  private static final b CRYPTSPINCOUNT$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptSpinCount");
  
  private static final b CRYPTPROVIDER$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProvider");
  
  private static final b ALGIDEXT$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExt");
  
  private static final b ALGIDEXTSOURCE$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "algIdExtSource");
  
  private static final b CRYPTPROVIDERTYPEEXT$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExt");
  
  private static final b CRYPTPROVIDERTYPEEXTSOURCE$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cryptProviderTypeExtSource");
  
  private static final b HASH$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hash");
  
  private static final b SALT$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "salt");
  
  public CTDocProtectImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STDocProtect.Enum getEdit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDIT$0);
      if (simpleValue == null)
        return null; 
      return (STDocProtect.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STDocProtect xgetEdit() {
    synchronized (monitor()) {
      check_orphaned();
      STDocProtect sTDocProtect = null;
      sTDocProtect = (STDocProtect)get_store().find_attribute_user(EDIT$0);
      return sTDocProtect;
    } 
  }
  
  public boolean isSetEdit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(EDIT$0) != null);
    } 
  }
  
  public void setEdit(STDocProtect.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(EDIT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(EDIT$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEdit(STDocProtect paramSTDocProtect) {
    synchronized (monitor()) {
      check_orphaned();
      STDocProtect sTDocProtect = null;
      sTDocProtect = (STDocProtect)get_store().find_attribute_user(EDIT$0);
      if (sTDocProtect == null)
        sTDocProtect = (STDocProtect)get_store().add_attribute_user(EDIT$0); 
      sTDocProtect.set((XmlObject)paramSTDocProtect);
    } 
  }
  
  public void unsetEdit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(EDIT$0);
    } 
  }
  
  public STOnOff.Enum getFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATTING$2);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FORMATTING$2);
      return sTOnOff;
    } 
  }
  
  public boolean isSetFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FORMATTING$2) != null);
    } 
  }
  
  public void setFormatting(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FORMATTING$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FORMATTING$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetFormatting(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(FORMATTING$2);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(FORMATTING$2); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetFormatting() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FORMATTING$2);
    } 
  }
  
  public STOnOff.Enum getEnforcement() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENFORCEMENT$4);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetEnforcement() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(ENFORCEMENT$4);
      return sTOnOff;
    } 
  }
  
  public boolean isSetEnforcement() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ENFORCEMENT$4) != null);
    } 
  }
  
  public void setEnforcement(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ENFORCEMENT$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ENFORCEMENT$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetEnforcement(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(ENFORCEMENT$4);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(ENFORCEMENT$4); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetEnforcement() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ENFORCEMENT$4);
    } 
  }
  
  public STCryptProv.Enum getCryptProviderType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
      if (simpleValue == null)
        return null; 
      return (STCryptProv.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCryptProv xgetCryptProviderType() {
    synchronized (monitor()) {
      check_orphaned();
      STCryptProv sTCryptProv = null;
      sTCryptProv = (STCryptProv)get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
      return sTCryptProv;
    } 
  }
  
  public boolean isSetCryptProviderType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTPROVIDERTYPE$6) != null);
    } 
  }
  
  public void setCryptProviderType(STCryptProv.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTPROVIDERTYPE$6); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCryptProviderType(STCryptProv paramSTCryptProv) {
    synchronized (monitor()) {
      check_orphaned();
      STCryptProv sTCryptProv = null;
      sTCryptProv = (STCryptProv)get_store().find_attribute_user(CRYPTPROVIDERTYPE$6);
      if (sTCryptProv == null)
        sTCryptProv = (STCryptProv)get_store().add_attribute_user(CRYPTPROVIDERTYPE$6); 
      sTCryptProv.set((XmlObject)paramSTCryptProv);
    } 
  }
  
  public void unsetCryptProviderType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTPROVIDERTYPE$6);
    } 
  }
  
  public STAlgClass.Enum getCryptAlgorithmClass() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
      if (simpleValue == null)
        return null; 
      return (STAlgClass.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STAlgClass xgetCryptAlgorithmClass() {
    synchronized (monitor()) {
      check_orphaned();
      STAlgClass sTAlgClass = null;
      sTAlgClass = (STAlgClass)get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
      return sTAlgClass;
    } 
  }
  
  public boolean isSetCryptAlgorithmClass() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTALGORITHMCLASS$8) != null);
    } 
  }
  
  public void setCryptAlgorithmClass(STAlgClass.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTALGORITHMCLASS$8); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCryptAlgorithmClass(STAlgClass paramSTAlgClass) {
    synchronized (monitor()) {
      check_orphaned();
      STAlgClass sTAlgClass = null;
      sTAlgClass = (STAlgClass)get_store().find_attribute_user(CRYPTALGORITHMCLASS$8);
      if (sTAlgClass == null)
        sTAlgClass = (STAlgClass)get_store().add_attribute_user(CRYPTALGORITHMCLASS$8); 
      sTAlgClass.set((XmlObject)paramSTAlgClass);
    } 
  }
  
  public void unsetCryptAlgorithmClass() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTALGORITHMCLASS$8);
    } 
  }
  
  public STAlgType.Enum getCryptAlgorithmType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
      if (simpleValue == null)
        return null; 
      return (STAlgType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STAlgType xgetCryptAlgorithmType() {
    synchronized (monitor()) {
      check_orphaned();
      STAlgType sTAlgType = null;
      sTAlgType = (STAlgType)get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
      return sTAlgType;
    } 
  }
  
  public boolean isSetCryptAlgorithmType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTALGORITHMTYPE$10) != null);
    } 
  }
  
  public void setCryptAlgorithmType(STAlgType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTALGORITHMTYPE$10); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCryptAlgorithmType(STAlgType paramSTAlgType) {
    synchronized (monitor()) {
      check_orphaned();
      STAlgType sTAlgType = null;
      sTAlgType = (STAlgType)get_store().find_attribute_user(CRYPTALGORITHMTYPE$10);
      if (sTAlgType == null)
        sTAlgType = (STAlgType)get_store().add_attribute_user(CRYPTALGORITHMTYPE$10); 
      sTAlgType.set((XmlObject)paramSTAlgType);
    } 
  }
  
  public void unsetCryptAlgorithmType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTALGORITHMTYPE$10);
    } 
  }
  
  public BigInteger getCryptAlgorithmSid() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMSID$12);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetCryptAlgorithmSid() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(CRYPTALGORITHMSID$12);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetCryptAlgorithmSid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTALGORITHMSID$12) != null);
    } 
  }
  
  public void setCryptAlgorithmSid(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTALGORITHMSID$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTALGORITHMSID$12); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetCryptAlgorithmSid(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(CRYPTALGORITHMSID$12);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(CRYPTALGORITHMSID$12); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetCryptAlgorithmSid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTALGORITHMSID$12);
    } 
  }
  
  public BigInteger getCryptSpinCount() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTSPINCOUNT$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STDecimalNumber xgetCryptSpinCount() {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(CRYPTSPINCOUNT$14);
      return sTDecimalNumber;
    } 
  }
  
  public boolean isSetCryptSpinCount() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTSPINCOUNT$14) != null);
    } 
  }
  
  public void setCryptSpinCount(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTSPINCOUNT$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTSPINCOUNT$14); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetCryptSpinCount(STDecimalNumber paramSTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STDecimalNumber sTDecimalNumber = null;
      sTDecimalNumber = (STDecimalNumber)get_store().find_attribute_user(CRYPTSPINCOUNT$14);
      if (sTDecimalNumber == null)
        sTDecimalNumber = (STDecimalNumber)get_store().add_attribute_user(CRYPTSPINCOUNT$14); 
      sTDecimalNumber.set((XmlObject)paramSTDecimalNumber);
    } 
  }
  
  public void unsetCryptSpinCount() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTSPINCOUNT$14);
    } 
  }
  
  public String getCryptProvider() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDER$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetCryptProvider() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CRYPTPROVIDER$16);
      return sTString;
    } 
  }
  
  public boolean isSetCryptProvider() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTPROVIDER$16) != null);
    } 
  }
  
  public void setCryptProvider(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDER$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTPROVIDER$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCryptProvider(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CRYPTPROVIDER$16);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(CRYPTPROVIDER$16); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetCryptProvider() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTPROVIDER$16);
    } 
  }
  
  public byte[] getAlgIdExt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGIDEXT$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetAlgIdExt() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(ALGIDEXT$18);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetAlgIdExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGIDEXT$18) != null);
    } 
  }
  
  public void setAlgIdExt(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGIDEXT$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGIDEXT$18); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetAlgIdExt(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(ALGIDEXT$18);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(ALGIDEXT$18); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetAlgIdExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGIDEXT$18);
    } 
  }
  
  public String getAlgIdExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGIDEXTSOURCE$20);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetAlgIdExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(ALGIDEXTSOURCE$20);
      return sTString;
    } 
  }
  
  public boolean isSetAlgIdExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALGIDEXTSOURCE$20) != null);
    } 
  }
  
  public void setAlgIdExtSource(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALGIDEXTSOURCE$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALGIDEXTSOURCE$20); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetAlgIdExtSource(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(ALGIDEXTSOURCE$20);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(ALGIDEXTSOURCE$20); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetAlgIdExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALGIDEXTSOURCE$20);
    } 
  }
  
  public byte[] getCryptProviderTypeExt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public STLongHexNumber xgetCryptProviderTypeExt() {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
      return sTLongHexNumber;
    } 
  }
  
  public boolean isSetCryptProviderTypeExt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22) != null);
    } 
  }
  
  public void setCryptProviderTypeExt(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTPROVIDERTYPEEXT$22); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetCryptProviderTypeExt(STLongHexNumber paramSTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      STLongHexNumber sTLongHexNumber = null;
      sTLongHexNumber = (STLongHexNumber)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXT$22);
      if (sTLongHexNumber == null)
        sTLongHexNumber = (STLongHexNumber)get_store().add_attribute_user(CRYPTPROVIDERTYPEEXT$22); 
      sTLongHexNumber.set((XmlObject)paramSTLongHexNumber);
    } 
  }
  
  public void unsetCryptProviderTypeExt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTPROVIDERTYPEEXT$22);
    } 
  }
  
  public String getCryptProviderTypeExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetCryptProviderTypeExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
      return sTString;
    } 
  }
  
  public boolean isSetCryptProviderTypeExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24) != null);
    } 
  }
  
  public void setCryptProviderTypeExtSource(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCryptProviderTypeExtSource(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(CRYPTPROVIDERTYPEEXTSOURCE$24); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetCryptProviderTypeExtSource() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CRYPTPROVIDERTYPEEXTSOURCE$24);
    } 
  }
  
  public byte[] getHash() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASH$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetHash() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(HASH$26);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetHash() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HASH$26) != null);
    } 
  }
  
  public void setHash(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HASH$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HASH$26); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetHash(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(HASH$26);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(HASH$26); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetHash() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HASH$26);
    } 
  }
  
  public byte[] getSalt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALT$28);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetSalt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(SALT$28);
      return xmlBase64Binary;
    } 
  }
  
  public boolean isSetSalt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SALT$28) != null);
    } 
  }
  
  public void setSalt(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SALT$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SALT$28); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetSalt(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_attribute_user(SALT$28);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_attribute_user(SALT$28); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public void unsetSalt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SALT$28);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTDocProtectImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */