package org.apache.xmlbeans.impl.jam;

public interface JAnnotationValue {
  String getName();
  
  JClass getType();
  
  JAnnotation asAnnotation();
  
  JClass asClass();
  
  String asString();
  
  int asInt() throws NumberFormatException;
  
  boolean asBoolean() throws IllegalArgumentException;
  
  long asLong() throws NumberFormatException;
  
  short asShort() throws NumberFormatException;
  
  double asDouble() throws NumberFormatException;
  
  float asFloat() throws NumberFormatException;
  
  byte asByte() throws NumberFormatException;
  
  char asChar() throws IllegalArgumentException;
  
  JClass[] asClassArray();
  
  JAnnotation[] asAnnotationArray();
  
  String[] asStringArray();
  
  int[] asIntArray() throws NumberFormatException;
  
  boolean[] asBooleanArray() throws IllegalArgumentException;
  
  short[] asShortArray() throws NumberFormatException;
  
  long[] asLongArray() throws NumberFormatException;
  
  double[] asDoubleArray() throws NumberFormatException;
  
  float[] asFloatArray() throws NumberFormatException;
  
  byte[] asByteArray() throws NumberFormatException;
  
  char[] asCharArray() throws IllegalArgumentException;
  
  boolean isDefaultValueUsed();
  
  Object getValue();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JAnnotationValue.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */