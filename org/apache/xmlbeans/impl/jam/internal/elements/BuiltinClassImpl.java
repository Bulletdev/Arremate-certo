/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.JField;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JPackage;
/*     */ import org.apache.xmlbeans.impl.jam.JProperty;
/*     */ import org.apache.xmlbeans.impl.jam.JSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
/*     */ import org.apache.xmlbeans.impl.jam.visitor.MVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BuiltinClassImpl
/*     */   extends AnnotatedElementImpl
/*     */   implements MClass
/*     */ {
/*     */   protected BuiltinClassImpl(ElementContext paramElementContext) {
/*  53 */     super(paramElementContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void accept(MVisitor paramMVisitor) {
/*  59 */     paramMVisitor.visit(this);
/*     */   } public void accept(JVisitor paramJVisitor) {
/*  61 */     paramJVisitor.visit((JClass)this);
/*     */   } public String getQualifiedName() {
/*  63 */     return this.mSimpleName;
/*     */   } public String getFieldDescriptor() {
/*  65 */     return this.mSimpleName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getModifiers() {
/*  70 */     return Object.class.getModifiers(); }
/*  71 */   public boolean isPublic() { return true; }
/*  72 */   public boolean isPackagePrivate() { return false; }
/*  73 */   public boolean isProtected() { return false; }
/*  74 */   public boolean isPrivate() { return false; }
/*  75 */   public JSourcePosition getSourcePosition() { return null; } public JClass getContainingClass() {
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass forName(String paramString) {
/*  82 */     return getClassLoader().loadClass(paramString);
/*     */   }
/*     */   
/*  85 */   public JClass getArrayComponentType() { return null; } public int getArrayDimensions() {
/*  86 */     return 0;
/*     */   }
/*  88 */   public JClass getSuperclass() { return null; }
/*  89 */   public JClass[] getInterfaces() { return (JClass[])NO_CLASS; }
/*  90 */   public JField[] getFields() { return (JField[])NO_FIELD; }
/*  91 */   public JField[] getDeclaredFields() { return (JField[])NO_FIELD; }
/*  92 */   public JConstructor[] getConstructors() { return (JConstructor[])NO_CONSTRUCTOR; }
/*  93 */   public JMethod[] getMethods() { return (JMethod[])NO_METHOD; }
/*  94 */   public JMethod[] getDeclaredMethods() { return (JMethod[])NO_METHOD; }
/*  95 */   public JPackage getContainingPackage() { return null; } public boolean isInterface() {
/*  96 */     return false;
/*     */   }
/*  98 */   public boolean isArrayType() { return false; }
/*  99 */   public boolean isAnnotationType() { return false; }
/* 100 */   public boolean isPrimitiveType() { return false; }
/* 101 */   public boolean isBuiltinType() { return true; }
/* 102 */   public boolean isUnresolvedType() { return false; }
/* 103 */   public boolean isObjectType() { return false; }
/* 104 */   public boolean isVoidType() { return false; }
/* 105 */   public boolean isEnumType() { return false; }
/* 106 */   public Class getPrimitiveClass() { return null; }
/* 107 */   public boolean isAbstract() { return false; }
/* 108 */   public boolean isFinal() { return false; }
/* 109 */   public boolean isStatic() { return false; }
/* 110 */   public JClass[] getClasses() { return (JClass[])NO_CLASS; }
/* 111 */   public JProperty[] getProperties() { return NO_PROPERTY; }
/* 112 */   public JProperty[] getDeclaredProperties() { return NO_PROPERTY; }
/* 113 */   public JPackage[] getImportedPackages() { return NO_PACKAGE; } public JClass[] getImportedClasses() {
/* 114 */     return (JClass[])NO_CLASS;
/*     */   }
/*     */ 
/*     */   
/*     */   public MField[] getMutableFields() {
/* 119 */     return (MField[])NO_FIELD; }
/* 120 */   public MConstructor[] getMutableConstructors() { return (MConstructor[])NO_CONSTRUCTOR; } public MMethod[] getMutableMethods() {
/* 121 */     return (MMethod[])NO_METHOD;
/*     */   }
/*     */   
/*     */   public void setSimpleName(String paramString) {
/* 125 */     nocando();
/*     */   }
/* 127 */   public void setIsAnnotationType(boolean paramBoolean) { nocando(); }
/* 128 */   public void setIsInterface(boolean paramBoolean) { nocando(); }
/* 129 */   public void setIsUnresolvedType(boolean paramBoolean) { nocando(); }
/* 130 */   public void setIsEnumType(boolean paramBoolean) { nocando(); }
/* 131 */   public void setSuperclass(String paramString) { nocando(); }
/* 132 */   public void setSuperclassUnqualified(String paramString) { nocando(); }
/* 133 */   public void setSuperclass(JClass paramJClass) { nocando(); }
/* 134 */   public void addInterface(String paramString) { nocando(); }
/* 135 */   public void addInterfaceUnqualified(String paramString) { nocando(); }
/* 136 */   public void addInterface(JClass paramJClass) { nocando(); }
/* 137 */   public void removeInterface(String paramString) { nocando(); }
/* 138 */   public void removeInterface(JClass paramJClass) { nocando(); }
/* 139 */   public MConstructor addNewConstructor() { nocando(); return null; }
/* 140 */   public void removeConstructor(MConstructor paramMConstructor) { nocando(); }
/* 141 */   public MField addNewField() { nocando(); return null; }
/* 142 */   public void removeField(MField paramMField) { nocando(); }
/* 143 */   public MMethod addNewMethod() { nocando(); return null; }
/* 144 */   public void removeMethod(MMethod paramMMethod) { nocando(); }
/* 145 */   public void setModifiers(int paramInt) { nocando(); }
/* 146 */   public MClass addNewInnerClass(String paramString) { nocando(); return null; } public void removeInnerClass(MClass paramMClass) {
/* 147 */     nocando();
/*     */   }
/*     */   public JProperty addNewProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2) {
/* 150 */     nocando();
/* 151 */     return null;
/*     */   } public void removeProperty(JProperty paramJProperty) {
/* 153 */     nocando();
/*     */   }
/*     */   public JProperty addNewDeclaredProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2) {
/* 156 */     nocando();
/* 157 */     return null;
/*     */   } public void removeDeclaredProperty(JProperty paramJProperty) {
/* 159 */     nocando();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 165 */     if (paramObject instanceof JClass) {
/* 166 */       return ((JClass)paramObject).getFieldDescriptor().equals(getFieldDescriptor());
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 172 */     return getFieldDescriptor().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void reallySetSimpleName(String paramString) {
/* 178 */     super.setSimpleName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void nocando() {
/* 185 */     throw new UnsupportedOperationException("Cannot alter builtin types");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\BuiltinClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */