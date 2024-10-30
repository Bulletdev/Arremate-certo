package org.apache.xmlbeans.impl.jam.mutable;

import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JProperty;

public interface MClass extends JClass, MMember {
  void setIsInterface(boolean paramBoolean);
  
  void setIsAnnotationType(boolean paramBoolean);
  
  void setIsEnumType(boolean paramBoolean);
  
  void setSuperclass(String paramString);
  
  void setSuperclassUnqualified(String paramString);
  
  void setSuperclass(JClass paramJClass);
  
  void addInterface(String paramString);
  
  void addInterfaceUnqualified(String paramString);
  
  void addInterface(JClass paramJClass);
  
  void removeInterface(String paramString);
  
  void removeInterface(JClass paramJClass);
  
  MConstructor addNewConstructor();
  
  void removeConstructor(MConstructor paramMConstructor);
  
  MConstructor[] getMutableConstructors();
  
  MField addNewField();
  
  void removeField(MField paramMField);
  
  MField[] getMutableFields();
  
  MMethod addNewMethod();
  
  void removeMethod(MMethod paramMMethod);
  
  MMethod[] getMutableMethods();
  
  JProperty addNewProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2);
  
  void removeProperty(JProperty paramJProperty);
  
  JProperty addNewDeclaredProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2);
  
  void removeDeclaredProperty(JProperty paramJProperty);
  
  MClass addNewInnerClass(String paramString);
  
  void removeInnerClass(MClass paramMClass);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\mutable\MClass.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */