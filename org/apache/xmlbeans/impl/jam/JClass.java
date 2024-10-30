package org.apache.xmlbeans.impl.jam;

public interface JClass extends JMember {
  JPackage getContainingPackage();
  
  JClass getSuperclass();
  
  JClass[] getInterfaces();
  
  JField[] getFields();
  
  JField[] getDeclaredFields();
  
  JMethod[] getMethods();
  
  JMethod[] getDeclaredMethods();
  
  JConstructor[] getConstructors();
  
  JProperty[] getProperties();
  
  JProperty[] getDeclaredProperties();
  
  boolean isInterface();
  
  boolean isAnnotationType();
  
  boolean isPrimitiveType();
  
  boolean isBuiltinType();
  
  Class getPrimitiveClass();
  
  boolean isFinal();
  
  boolean isStatic();
  
  boolean isAbstract();
  
  boolean isVoidType();
  
  boolean isObjectType();
  
  boolean isArrayType();
  
  JClass getArrayComponentType();
  
  int getArrayDimensions();
  
  boolean isAssignableFrom(JClass paramJClass);
  
  boolean equals(Object paramObject);
  
  JClass[] getClasses();
  
  JClass getContainingClass();
  
  String getFieldDescriptor();
  
  boolean isEnumType();
  
  JamClassLoader getClassLoader();
  
  JClass forName(String paramString);
  
  JClass[] getImportedClasses();
  
  JPackage[] getImportedPackages();
  
  boolean isUnresolvedType();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\JClass.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */