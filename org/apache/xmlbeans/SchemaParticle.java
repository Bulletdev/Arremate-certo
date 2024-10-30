package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.b;

public interface SchemaParticle {
  public static final int ALL = 1;
  
  public static final int CHOICE = 2;
  
  public static final int SEQUENCE = 3;
  
  public static final int ELEMENT = 4;
  
  public static final int WILDCARD = 5;
  
  public static final int STRICT = 1;
  
  public static final int LAX = 2;
  
  public static final int SKIP = 3;
  
  int getParticleType();
  
  BigInteger getMinOccurs();
  
  BigInteger getMaxOccurs();
  
  int getIntMinOccurs();
  
  int getIntMaxOccurs();
  
  boolean isSingleton();
  
  SchemaParticle[] getParticleChildren();
  
  SchemaParticle getParticleChild(int paramInt);
  
  int countOfParticleChild();
  
  boolean canStartWithElement(b paramb);
  
  QNameSet acceptedStartNames();
  
  boolean isSkippable();
  
  QNameSet getWildcardSet();
  
  int getWildcardProcess();
  
  b getName();
  
  SchemaType getType();
  
  boolean isNillable();
  
  String getDefaultText();
  
  XmlAnySimpleType getDefaultValue();
  
  boolean isDefault();
  
  boolean isFixed();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaParticle.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */