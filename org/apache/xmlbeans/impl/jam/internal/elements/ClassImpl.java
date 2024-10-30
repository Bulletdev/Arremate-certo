/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JComment;
/*     */ import org.apache.xmlbeans.impl.jam.JConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.JField;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JPackage;
/*     */ import org.apache.xmlbeans.impl.jam.JProperty;
/*     */ import org.apache.xmlbeans.impl.jam.JSourcePosition;
/*     */ import org.apache.xmlbeans.impl.jam.internal.JamClassLoaderImpl;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRefContext;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.UnqualifiedJClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
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
/*     */ public class ClassImpl
/*     */   extends MemberImpl
/*     */   implements JClassRef, JClassRefContext, MClass
/*     */ {
/*     */   public static final int NEW = 1;
/*     */   public static final int UNPOPULATED = 2;
/*     */   public static final int POPULATING = 3;
/*     */   public static final int UNINITIALIZED = 4;
/*     */   public static final int INITIALIZING = 5;
/*     */   public static final int LOADED = 6;
/*  69 */   private int mState = 1;
/*     */   
/*     */   private boolean mIsAnnotationType = false;
/*     */   
/*     */   private boolean mIsInterface = false;
/*     */   private boolean mIsEnum = false;
/*  75 */   private String mPackageName = null;
/*     */   
/*  77 */   private JClassRef mSuperClassRef = null;
/*  78 */   private ArrayList mInterfaceRefs = null;
/*     */   
/*  80 */   private ArrayList mFields = null;
/*  81 */   private ArrayList mMethods = null;
/*  82 */   private ArrayList mConstructors = null;
/*  83 */   private ArrayList mProperties = null;
/*  84 */   private ArrayList mDeclaredProperties = null;
/*  85 */   private ArrayList mInnerClasses = null;
/*     */   
/*  87 */   private String[] mImports = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JamClassPopulator mPopulator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassImpl(String paramString1, String paramString2, ElementContext paramElementContext, String[] paramArrayOfString, JamClassPopulator paramJamClassPopulator) {
/* 103 */     super(paramElementContext);
/* 104 */     super.setSimpleName(paramString2);
/* 105 */     this.mPackageName = paramString1.trim();
/* 106 */     this.mImports = paramArrayOfString;
/* 107 */     this.mPopulator = paramJamClassPopulator;
/* 108 */     setState(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassImpl(String paramString1, String paramString2, ElementContext paramElementContext, String[] paramArrayOfString) {
/* 116 */     super(paramElementContext);
/* 117 */     super.setSimpleName(paramString2);
/* 118 */     this.mPackageName = paramString1.trim();
/* 119 */     this.mImports = paramArrayOfString;
/* 120 */     this.mPopulator = null;
/* 121 */     setState(4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ClassImpl(String paramString1, String paramString2, String[] paramArrayOfString, ClassImpl paramClassImpl) {
/* 129 */     super(paramClassImpl);
/* 130 */     super.setSimpleName(paramString2);
/* 131 */     this.mPackageName = paramString1.trim();
/* 132 */     this.mImports = paramArrayOfString;
/* 133 */     this.mPopulator = null;
/* 134 */     setState(4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JPackage getContainingPackage() {
/* 143 */     return getClassLoader().getPackage(this.mPackageName);
/*     */   }
/*     */   
/*     */   public JClass getSuperclass() {
/* 147 */     ensureLoaded();
/* 148 */     if (this.mSuperClassRef == null) {
/* 149 */       return null;
/*     */     }
/* 151 */     return this.mSuperClassRef.getRefClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public JClass[] getInterfaces() {
/* 156 */     ensureLoaded();
/* 157 */     if (this.mInterfaceRefs == null || this.mInterfaceRefs.size() == 0) {
/* 158 */       return new JClass[0];
/*     */     }
/* 160 */     JClass[] arrayOfJClass = new JClass[this.mInterfaceRefs.size()];
/* 161 */     for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 162 */       arrayOfJClass[b] = ((JClassRef)this.mInterfaceRefs.get(b)).getRefClass();
/*     */     }
/* 164 */     return arrayOfJClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public JField[] getFields() {
/* 169 */     ensureLoaded();
/* 170 */     ArrayList arrayList = new ArrayList();
/* 171 */     addFieldsRecursively((JClass)this, arrayList);
/* 172 */     JField[] arrayOfJField = new JField[arrayList.size()];
/* 173 */     arrayList.toArray((Object[])arrayOfJField);
/* 174 */     return arrayOfJField;
/*     */   }
/*     */   
/*     */   public JField[] getDeclaredFields() {
/* 178 */     ensureLoaded();
/* 179 */     return (JField[])getMutableFields();
/*     */   }
/*     */   
/*     */   public JMethod[] getMethods() {
/* 183 */     ensureLoaded();
/* 184 */     ArrayList arrayList = new ArrayList();
/* 185 */     addMethodsRecursively((JClass)this, arrayList);
/* 186 */     JMethod[] arrayOfJMethod = new JMethod[arrayList.size()];
/* 187 */     arrayList.toArray((Object[])arrayOfJMethod);
/* 188 */     return arrayOfJMethod;
/*     */   }
/*     */   
/*     */   public JProperty[] getProperties() {
/* 192 */     ensureLoaded();
/* 193 */     if (this.mProperties == null) return new JProperty[0]; 
/* 194 */     JProperty[] arrayOfJProperty = new JProperty[this.mProperties.size()];
/* 195 */     this.mProperties.toArray((Object[])arrayOfJProperty);
/* 196 */     return arrayOfJProperty;
/*     */   }
/*     */   
/*     */   public JProperty[] getDeclaredProperties() {
/* 200 */     ensureLoaded();
/* 201 */     if (this.mDeclaredProperties == null) return new JProperty[0]; 
/* 202 */     JProperty[] arrayOfJProperty = new JProperty[this.mDeclaredProperties.size()];
/* 203 */     this.mDeclaredProperties.toArray((Object[])arrayOfJProperty);
/* 204 */     return arrayOfJProperty;
/*     */   }
/*     */   
/*     */   public JMethod[] getDeclaredMethods() {
/* 208 */     ensureLoaded();
/* 209 */     return (JMethod[])getMutableMethods();
/*     */   }
/*     */   
/*     */   public JConstructor[] getConstructors() {
/* 213 */     ensureLoaded();
/* 214 */     return (JConstructor[])getMutableConstructors();
/*     */   }
/*     */   
/*     */   public boolean isInterface() {
/* 218 */     ensureLoaded();
/* 219 */     return this.mIsInterface;
/*     */   }
/*     */   
/*     */   public boolean isAnnotationType() {
/* 223 */     ensureLoaded();
/* 224 */     return this.mIsAnnotationType;
/*     */   }
/*     */   
/*     */   public boolean isEnumType() {
/* 228 */     ensureLoaded();
/* 229 */     return this.mIsEnum;
/*     */   }
/*     */   
/*     */   public int getModifiers() {
/* 233 */     ensureLoaded();
/* 234 */     return super.getModifiers();
/*     */   }
/*     */   
/*     */   public boolean isFinal() {
/* 238 */     return Modifier.isFinal(getModifiers());
/*     */   } public boolean isStatic() {
/* 240 */     return Modifier.isStatic(getModifiers());
/*     */   } public boolean isAbstract() {
/* 242 */     return Modifier.isAbstract(getModifiers());
/*     */   }
/*     */   public boolean isAssignableFrom(JClass paramJClass) {
/* 245 */     ensureLoaded();
/* 246 */     if (isPrimitiveType() || paramJClass.isPrimitiveType()) {
/* 247 */       return getQualifiedName().equals(paramJClass.getQualifiedName());
/*     */     }
/* 249 */     return isAssignableFromRecursively(paramJClass);
/*     */   }
/*     */   
/*     */   public JClass[] getClasses() {
/* 253 */     ensureLoaded();
/* 254 */     if (this.mInnerClasses == null) return new JClass[0]; 
/* 255 */     JClass[] arrayOfJClass = new JClass[this.mInnerClasses.size()];
/* 256 */     this.mInnerClasses.toArray((Object[])arrayOfJClass);
/* 257 */     return arrayOfJClass;
/*     */   }
/*     */   
/*     */   public String getFieldDescriptor() {
/* 261 */     return getQualifiedName();
/*     */   }
/*     */   
/*     */   public JClass forName(String paramString) {
/* 265 */     return getClassLoader().loadClass(paramString);
/*     */   }
/*     */   
/*     */   public JPackage[] getImportedPackages() {
/* 269 */     ensureLoaded();
/* 270 */     TreeSet treeSet = new TreeSet();
/* 271 */     JClass[] arrayOfJClass = getImportedClasses();
/* 272 */     for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 273 */       JPackage jPackage = arrayOfJClass[b].getContainingPackage();
/* 274 */       if (jPackage != null) treeSet.add(jPackage); 
/*     */     } 
/* 276 */     String[] arrayOfString = getImportSpecs();
/* 277 */     if (arrayOfString != null) {
/* 278 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/* 279 */         if (arrayOfString[b1].endsWith(".*")) {
/* 280 */           treeSet.add(getClassLoader().getPackage(arrayOfString[b1].substring(0, arrayOfString[b1].length() - 2)));
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 285 */     JPackage[] arrayOfJPackage = new JPackage[treeSet.size()];
/* 286 */     treeSet.toArray(arrayOfJPackage);
/* 287 */     return arrayOfJPackage;
/*     */   }
/*     */   
/*     */   public JClass[] getImportedClasses() {
/* 291 */     ensureLoaded();
/* 292 */     String[] arrayOfString = getImportSpecs();
/* 293 */     if (arrayOfString == null) return new JClass[0]; 
/* 294 */     ArrayList arrayList = new ArrayList();
/* 295 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 296 */       if (!arrayOfString[b].endsWith("*"))
/* 297 */         arrayList.add(getClassLoader().loadClass(arrayOfString[b])); 
/*     */     } 
/* 299 */     JClass[] arrayOfJClass = new JClass[arrayList.size()];
/* 300 */     arrayList.toArray(arrayOfJClass);
/* 301 */     return arrayOfJClass;
/*     */   }
/*     */   public void accept(MVisitor paramMVisitor) {
/* 304 */     paramMVisitor.visit(this);
/*     */   } public void accept(JVisitor paramJVisitor) {
/* 306 */     paramJVisitor.visit((JClass)this);
/*     */   }
/*     */   public void setSimpleName(String paramString) {
/* 309 */     throw new UnsupportedOperationException("Class names cannot be changed");
/*     */   }
/*     */   
/* 312 */   public Class getPrimitiveClass() { return null; }
/* 313 */   public boolean isPrimitiveType() { return false; }
/* 314 */   public boolean isBuiltinType() { return false; }
/* 315 */   public boolean isVoidType() { return false; } public boolean isUnresolvedType() {
/* 316 */     return false;
/*     */   } public boolean isObjectType() {
/* 318 */     return getQualifiedName().equals("java.lang.Object");
/*     */   }
/*     */   
/* 321 */   public boolean isArrayType() { return false; }
/* 322 */   public JClass getArrayComponentType() { return null; } public int getArrayDimensions() {
/* 323 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JAnnotation[] getAnnotations() {
/* 329 */     ensureLoaded();
/* 330 */     return super.getAnnotations();
/*     */   }
/*     */   
/*     */   public JAnnotation getAnnotation(Class paramClass) {
/* 334 */     ensureLoaded();
/* 335 */     return super.getAnnotation(paramClass);
/*     */   }
/*     */   
/*     */   public JAnnotation getAnnotation(String paramString) {
/* 339 */     ensureLoaded();
/* 340 */     return super.getAnnotation(paramString);
/*     */   }
/*     */   
/*     */   public JAnnotationValue getAnnotationValue(String paramString) {
/* 344 */     ensureLoaded();
/* 345 */     return super.getAnnotationValue(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAnnotationProxy(Class paramClass) {
/* 350 */     ensureLoaded();
/* 351 */     return super.getAnnotationProxy(paramClass);
/*     */   }
/*     */   
/*     */   public JComment getComment() {
/* 355 */     ensureLoaded();
/* 356 */     return super.getComment();
/*     */   }
/*     */   
/*     */   public JAnnotation[] getAllJavadocTags() {
/* 360 */     ensureLoaded();
/* 361 */     return super.getAllJavadocTags();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JSourcePosition getSourcePosition() {
/* 368 */     ensureLoaded();
/* 369 */     return super.getSourcePosition();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuperclass(String paramString) {
/* 379 */     if (paramString == null) {
/* 380 */       this.mSuperClassRef = null;
/*     */     } else {
/* 382 */       if (paramString.equals(getQualifiedName())) {
/* 383 */         throw new IllegalArgumentException("A class cannot be it's own superclass: '" + paramString + "'");
/*     */       }
/*     */       
/* 386 */       this.mSuperClassRef = QualifiedJClassRef.create(paramString, this);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSuperclassUnqualified(String paramString) {
/* 391 */     this.mSuperClassRef = UnqualifiedJClassRef.create(paramString, this);
/*     */   }
/*     */   
/*     */   public void setSuperclass(JClass paramJClass) {
/* 395 */     if (paramJClass == null) {
/* 396 */       this.mSuperClassRef = null;
/*     */     } else {
/* 398 */       setSuperclass(paramJClass.getQualifiedName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInterface(JClass paramJClass) {
/* 403 */     if (paramJClass == null) throw new IllegalArgumentException("null interf");
/*     */     
/* 405 */     addInterface(paramJClass.getQualifiedName());
/*     */   }
/*     */   
/*     */   public void addInterface(String paramString) {
/* 409 */     if (this.mInterfaceRefs == null) this.mInterfaceRefs = new ArrayList(); 
/* 410 */     if (paramString.equals(getQualifiedName())) {
/* 411 */       throw new IllegalArgumentException("A class cannot implement itself: '" + paramString + "'");
/*     */     }
/*     */     
/* 414 */     this.mInterfaceRefs.add(QualifiedJClassRef.create(paramString, this));
/*     */   }
/*     */   
/*     */   public void addInterfaceUnqualified(String paramString) {
/* 418 */     if (this.mInterfaceRefs == null) this.mInterfaceRefs = new ArrayList(); 
/* 419 */     this.mInterfaceRefs.add(UnqualifiedJClassRef.create(paramString, this));
/*     */   }
/*     */   
/*     */   public void removeInterface(JClass paramJClass) {
/* 423 */     if (paramJClass == null) throw new IllegalArgumentException("null interf"); 
/* 424 */     removeInterface(paramJClass.getQualifiedName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeInterface(String paramString) {
/* 429 */     if (paramString == null) throw new IllegalArgumentException("null classname"); 
/* 430 */     if (this.mInterfaceRefs == null)
/* 431 */       return;  for (byte b = 0; b < this.mInterfaceRefs.size(); b++) {
/* 432 */       if (paramString.equals(((JClassRef)this.mInterfaceRefs.get(b)).getQualifiedName()))
/*     */       {
/* 434 */         this.mInterfaceRefs.remove(b);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public MConstructor addNewConstructor() {
/* 440 */     if (this.mConstructors == null) this.mConstructors = new ArrayList(); 
/* 441 */     ConstructorImpl constructorImpl = new ConstructorImpl(this);
/* 442 */     this.mConstructors.add(constructorImpl);
/* 443 */     return constructorImpl;
/*     */   }
/*     */   
/*     */   public void removeConstructor(MConstructor paramMConstructor) {
/* 447 */     if (this.mConstructors == null)
/* 448 */       return;  this.mConstructors.remove(paramMConstructor);
/*     */   }
/*     */   
/*     */   public MConstructor[] getMutableConstructors() {
/* 452 */     if (this.mConstructors == null || this.mConstructors.size() == 0) {
/* 453 */       return new MConstructor[0];
/*     */     }
/* 455 */     MConstructor[] arrayOfMConstructor = new MConstructor[this.mConstructors.size()];
/* 456 */     this.mConstructors.toArray((Object[])arrayOfMConstructor);
/* 457 */     return arrayOfMConstructor;
/*     */   }
/*     */   
/*     */   public MField addNewField() {
/* 461 */     if (this.mFields == null) this.mFields = new ArrayList(); 
/* 462 */     FieldImpl fieldImpl = new FieldImpl(defaultName(this.mFields.size()), this, "java.lang.Object");
/*     */     
/* 464 */     this.mFields.add(fieldImpl);
/* 465 */     return fieldImpl;
/*     */   }
/*     */   
/*     */   public void removeField(MField paramMField) {
/* 469 */     if (this.mFields == null)
/* 470 */       return;  this.mFields.remove(paramMField);
/*     */   }
/*     */   
/*     */   public MField[] getMutableFields() {
/* 474 */     if (this.mFields == null || this.mFields.size() == 0) {
/* 475 */       return new MField[0];
/*     */     }
/* 477 */     MField[] arrayOfMField = new MField[this.mFields.size()];
/* 478 */     this.mFields.toArray((Object[])arrayOfMField);
/* 479 */     return arrayOfMField;
/*     */   }
/*     */   
/*     */   public MMethod addNewMethod() {
/* 483 */     if (this.mMethods == null) this.mMethods = new ArrayList(); 
/* 484 */     MethodImpl methodImpl = new MethodImpl(defaultName(this.mMethods.size()), this);
/* 485 */     this.mMethods.add(methodImpl);
/* 486 */     return methodImpl;
/*     */   }
/*     */   
/*     */   public void removeMethod(MMethod paramMMethod) {
/* 490 */     if (this.mMethods == null)
/* 491 */       return;  this.mMethods.remove(paramMMethod);
/*     */   }
/*     */   
/*     */   public MMethod[] getMutableMethods() {
/* 495 */     if (this.mMethods == null || this.mMethods.size() == 0) {
/* 496 */       return new MMethod[0];
/*     */     }
/* 498 */     MMethod[] arrayOfMMethod = new MMethod[this.mMethods.size()];
/* 499 */     this.mMethods.toArray((Object[])arrayOfMMethod);
/* 500 */     return arrayOfMMethod;
/*     */   }
/*     */   
/*     */   public JProperty addNewProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2) {
/* 504 */     if (this.mProperties == null) this.mProperties = new ArrayList(); 
/* 505 */     String str = (paramJMethod1 != null) ? paramJMethod1.getReturnType().getFieldDescriptor() : paramJMethod2.getParameters()[0].getType().getFieldDescriptor();
/*     */ 
/*     */     
/* 508 */     PropertyImpl propertyImpl = new PropertyImpl(paramString, paramJMethod1, paramJMethod2, str);
/* 509 */     this.mProperties.add(propertyImpl);
/* 510 */     return propertyImpl;
/*     */   }
/*     */   
/*     */   public void removeProperty(JProperty paramJProperty) {
/* 514 */     if (this.mProperties != null) this.mProperties.remove(paramJProperty); 
/*     */   }
/*     */   
/*     */   public JProperty addNewDeclaredProperty(String paramString, JMethod paramJMethod1, JMethod paramJMethod2) {
/* 518 */     if (this.mDeclaredProperties == null) this.mDeclaredProperties = new ArrayList(); 
/* 519 */     String str = (paramJMethod1 != null) ? paramJMethod1.getReturnType().getFieldDescriptor() : paramJMethod2.getParameters()[0].getType().getFieldDescriptor();
/*     */ 
/*     */     
/* 522 */     PropertyImpl propertyImpl = new PropertyImpl(paramString, paramJMethod1, paramJMethod2, str);
/* 523 */     this.mDeclaredProperties.add(propertyImpl);
/* 524 */     return propertyImpl;
/*     */   }
/*     */   
/*     */   public void removeDeclaredProperty(JProperty paramJProperty) {
/* 528 */     if (this.mDeclaredProperties != null) this.mDeclaredProperties.remove(paramJProperty);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MClass addNewInnerClass(String paramString) {
/* 535 */     int i = paramString.lastIndexOf('.');
/* 536 */     if (i == -1) i = paramString.lastIndexOf('$'); 
/* 537 */     if (i != -1) paramString = paramString.substring(i + 1); 
/* 538 */     ClassImpl classImpl = new ClassImpl(this.mPackageName, getSimpleName() + "$" + paramString, getImportSpecs(), this);
/*     */ 
/*     */ 
/*     */     
/* 542 */     if (this.mInnerClasses == null) this.mInnerClasses = new ArrayList(); 
/* 543 */     this.mInnerClasses.add(classImpl);
/* 544 */     classImpl.setState(6);
/* 545 */     ((JamClassLoaderImpl)getClassLoader()).addToCache((JClass)classImpl);
/* 546 */     return classImpl;
/*     */   }
/*     */   
/*     */   public void removeInnerClass(MClass paramMClass) {
/* 550 */     if (this.mInnerClasses == null)
/* 551 */       return;  this.mInnerClasses.remove(paramMClass);
/*     */   }
/*     */   public void setIsInterface(boolean paramBoolean) {
/* 554 */     this.mIsInterface = paramBoolean;
/*     */   } public void setIsAnnotationType(boolean paramBoolean) {
/* 556 */     this.mIsAnnotationType = paramBoolean;
/*     */   } public void setIsEnumType(boolean paramBoolean) {
/* 558 */     this.mIsEnum = paramBoolean;
/*     */   }
/*     */   public String getQualifiedName() {
/* 561 */     return ((this.mPackageName.length() > 0) ? (this.mPackageName + '.') : "") + this.mSimpleName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass getRefClass() {
/* 568 */     return (JClass)this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPackageName() {
/* 574 */     return this.mPackageName;
/*     */   }
/*     */   
/*     */   public String[] getImportSpecs() {
/* 578 */     ensureLoaded();
/* 579 */     if (this.mImports == null) return new String[0]; 
/* 580 */     return this.mImports;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(int paramInt) {
/* 587 */     this.mState = paramInt;
/*     */   }
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
/*     */   public static void validateClassName(String paramString) throws IllegalArgumentException {
/* 600 */     if (paramString == null) {
/* 601 */       throw new IllegalArgumentException("null class name specified");
/*     */     }
/* 603 */     if (!Character.isJavaIdentifierStart(paramString.charAt(0))) {
/* 604 */       throw new IllegalArgumentException("Invalid first character in class name: " + paramString);
/*     */     }
/*     */     
/* 607 */     for (byte b = 1; b < paramString.length(); b++) {
/* 608 */       char c = paramString.charAt(b);
/* 609 */       if (c == '.') {
/* 610 */         if (paramString.charAt(b - 1) == '.') {
/* 611 */           throw new IllegalArgumentException("'..' not allowed in class name: " + paramString);
/*     */         }
/*     */         
/* 614 */         if (b == paramString.length() - 1) {
/* 615 */           throw new IllegalArgumentException("'.' not allowed at end of class name: " + paramString);
/*     */         
/*     */         }
/*     */       }
/* 619 */       else if (!Character.isJavaIdentifierPart(c)) {
/* 620 */         throw new IllegalArgumentException("Illegal character '" + c + "' in class name: " + paramString);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isAssignableFromRecursively(JClass paramJClass) {
/* 631 */     if (getQualifiedName().equals(paramJClass.getQualifiedName())) return true;
/*     */     
/* 633 */     JClass[] arrayOfJClass = paramJClass.getInterfaces();
/* 634 */     if (arrayOfJClass != null) {
/* 635 */       for (byte b = 0; b < arrayOfJClass.length; b++) {
/* 636 */         if (isAssignableFromRecursively(arrayOfJClass[b])) return true;
/*     */       
/*     */       } 
/*     */     }
/* 640 */     paramJClass = paramJClass.getSuperclass();
/* 641 */     if (paramJClass != null && 
/* 642 */       isAssignableFromRecursively(paramJClass)) return true;
/*     */     
/* 644 */     return false;
/*     */   }
/*     */   
/*     */   private void addFieldsRecursively(JClass paramJClass, Collection paramCollection) {
/* 648 */     JField[] arrayOfJField = paramJClass.getDeclaredFields();
/* 649 */     for (byte b1 = 0; b1 < arrayOfJField.length; ) { paramCollection.add(arrayOfJField[b1]); b1++; }
/* 650 */      JClass[] arrayOfJClass = paramJClass.getInterfaces();
/* 651 */     for (byte b2 = 0; b2 < arrayOfJClass.length; b2++) {
/* 652 */       addFieldsRecursively(arrayOfJClass[b2], paramCollection);
/*     */     }
/* 654 */     paramJClass = paramJClass.getSuperclass();
/* 655 */     if (paramJClass != null) addFieldsRecursively(paramJClass, paramCollection); 
/*     */   }
/*     */   
/*     */   private void addMethodsRecursively(JClass paramJClass, Collection paramCollection) {
/* 659 */     JMethod[] arrayOfJMethod = paramJClass.getDeclaredMethods();
/* 660 */     for (byte b1 = 0; b1 < arrayOfJMethod.length; ) { paramCollection.add(arrayOfJMethod[b1]); b1++; }
/* 661 */      JClass[] arrayOfJClass = paramJClass.getInterfaces();
/* 662 */     for (byte b2 = 0; b2 < arrayOfJClass.length; b2++) {
/* 663 */       addMethodsRecursively(arrayOfJClass[b2], paramCollection);
/*     */     }
/* 665 */     paramJClass = paramJClass.getSuperclass();
/* 666 */     if (paramJClass != null) addMethodsRecursively(paramJClass, paramCollection); 
/*     */   }
/*     */   
/*     */   public void ensureLoaded() {
/* 670 */     if (this.mState == 6)
/* 671 */       return;  if (this.mState == 2) {
/* 672 */       if (this.mPopulator == null) throw new IllegalStateException("null populator"); 
/* 673 */       setState(3);
/* 674 */       this.mPopulator.populate(this);
/* 675 */       setState(4);
/*     */     } 
/* 677 */     if (this.mState == 4) {
/* 678 */       setState(5);
/* 679 */       ((JamClassLoaderImpl)getClassLoader()).initialize(this);
/*     */     } 
/* 681 */     setState(6);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */