/*     */ package org.apache.xmlbeans.impl.jam.internal.reflect;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MClass;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MField;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMember;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MMethod;
/*     */ import org.apache.xmlbeans.impl.jam.mutable.MParameter;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
/*     */ import org.apache.xmlbeans.impl.jam.provider.JamClassPopulator;
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
/*     */ public class ReflectClassBuilder
/*     */   extends JamClassBuilder
/*     */   implements JamClassPopulator
/*     */ {
/*     */   private ClassLoader mLoader;
/*  41 */   private ReflectTigerDelegate mTigerDelegate = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectClassBuilder(ClassLoader paramClassLoader) {
/*  47 */     if (paramClassLoader == null) throw new IllegalArgumentException("null rcl"); 
/*  48 */     this.mLoader = paramClassLoader;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(ElementContext paramElementContext) {
/*  55 */     super.init(paramElementContext);
/*  56 */     initDelegate(paramElementContext);
/*     */   }
/*     */   public MClass build(String paramString1, String paramString2) {
/*     */     Class clazz;
/*  60 */     assertInitialized();
/*  61 */     if (getLogger().isVerbose(this)) {
/*  62 */       getLogger().verbose("trying to build '" + paramString1 + "' '" + paramString2 + "'");
/*     */     }
/*     */     
/*     */     try {
/*  66 */       String str = (paramString1.trim().length() > 0) ? (paramString1 + '.' + paramString2) : paramString2;
/*     */ 
/*     */       
/*  69 */       clazz = this.mLoader.loadClass(str);
/*  70 */     } catch (ClassNotFoundException classNotFoundException) {
/*  71 */       getLogger().verbose(classNotFoundException, this);
/*  72 */       return null;
/*     */     } 
/*  74 */     MClass mClass = createClassToBuild(paramString1, paramString2, null, this);
/*  75 */     mClass.setArtifact(clazz);
/*  76 */     return mClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populate(MClass paramMClass) {
/*  83 */     assertInitialized();
/*  84 */     Class clazz1 = (Class)paramMClass.getArtifact();
/*  85 */     paramMClass.setModifiers(clazz1.getModifiers());
/*  86 */     paramMClass.setIsInterface(clazz1.isInterface());
/*  87 */     if (this.mTigerDelegate != null) paramMClass.setIsEnumType(this.mTigerDelegate.isEnum(clazz1));
/*     */     
/*  89 */     Class clazz2 = clazz1.getSuperclass();
/*  90 */     if (clazz2 != null) paramMClass.setSuperclass(clazz2.getName());
/*     */     
/*  92 */     Class[] arrayOfClass1 = clazz1.getInterfaces();
/*  93 */     for (byte b1 = 0; b1 < arrayOfClass1.length; ) { paramMClass.addInterface(arrayOfClass1[b1].getName()); b1++; }
/*     */     
/*  95 */     Field[] arrayOfField = null;
/*     */     try {
/*  97 */       arrayOfField = clazz1.getFields();
/*  98 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 101 */     if (arrayOfField != null) {
/* 102 */       for (byte b = 0; b < arrayOfField.length; ) { populate(paramMClass.addNewField(), arrayOfField[b]); b++; }
/*     */     
/*     */     }
/* 105 */     Method[] arrayOfMethod = clazz1.getDeclaredMethods();
/* 106 */     for (byte b2 = 0; b2 < arrayOfMethod.length; ) { populate(paramMClass.addNewMethod(), arrayOfMethod[b2]); b2++; }
/*     */     
/* 108 */     if (this.mTigerDelegate != null) this.mTigerDelegate.populateAnnotationTypeIfNecessary(clazz1, paramMClass, this);
/*     */ 
/*     */     
/* 111 */     Constructor[] arrayOfConstructor = (Constructor[])clazz1.getDeclaredConstructors();
/* 112 */     for (byte b3 = 0; b3 < arrayOfConstructor.length; ) { populate(paramMClass.addNewConstructor(), arrayOfConstructor[b3]); b3++; }
/*     */     
/* 114 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(paramMClass, clazz1);
/*     */ 
/*     */ 
/*     */     
/* 118 */     Class[] arrayOfClass2 = clazz1.getDeclaredClasses();
/* 119 */     if (arrayOfClass2 != null) {
/* 120 */       for (byte b = 0; b < arrayOfClass2.length; b++) {
/* 121 */         if (this.mTigerDelegate != null)
/*     */         {
/* 123 */           if (this.mTigerDelegate.getEnclosingConstructor(arrayOfClass2[b]) != null || this.mTigerDelegate.getEnclosingMethod(arrayOfClass2[b]) != null)
/*     */             continue; 
/*     */         }
/* 126 */         String str = arrayOfClass2[b].getName();
/* 127 */         int i = str.lastIndexOf('$');
/* 128 */         str = str.substring(i + 1);
/*     */         
/* 130 */         char c = str.charAt(0);
/* 131 */         if ('0' > c || c > '9') {
/*     */ 
/*     */ 
/*     */           
/* 135 */           MClass mClass = paramMClass.addNewInnerClass(str);
/* 136 */           mClass.setArtifact(arrayOfClass2[b]);
/* 137 */           populate(mClass);
/*     */         } 
/*     */         continue;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initDelegate(ElementContext paramElementContext) {
/* 148 */     this.mTigerDelegate = ReflectTigerDelegate.create(paramElementContext);
/*     */   }
/*     */   
/*     */   private void populate(MField paramMField, Field paramField) {
/* 152 */     paramMField.setArtifact(paramField);
/* 153 */     paramMField.setSimpleName(paramField.getName());
/* 154 */     paramMField.setType(paramField.getType().getName());
/* 155 */     paramMField.setModifiers(paramField.getModifiers());
/* 156 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(paramMField, paramField); 
/*     */   }
/*     */   
/*     */   private void populate(MConstructor paramMConstructor, Constructor paramConstructor) {
/* 160 */     paramMConstructor.setArtifact(paramConstructor);
/* 161 */     paramMConstructor.setSimpleName(paramConstructor.getName());
/* 162 */     paramMConstructor.setModifiers(paramConstructor.getModifiers());
/* 163 */     Class[] arrayOfClass1 = paramConstructor.getExceptionTypes();
/* 164 */     addThrows((MInvokable)paramMConstructor, arrayOfClass1);
/* 165 */     Class[] arrayOfClass2 = paramConstructor.getParameterTypes();
/* 166 */     for (byte b = 0; b < arrayOfClass2.length; b++) {
/* 167 */       MParameter mParameter = addParameter((MInvokable)paramMConstructor, b, arrayOfClass2[b]);
/* 168 */       if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(mParameter, paramConstructor, b); 
/*     */     } 
/* 170 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(paramMConstructor, paramConstructor); 
/*     */   }
/*     */   
/*     */   private void populate(MMethod paramMMethod, Method paramMethod) {
/* 174 */     paramMMethod.setArtifact(paramMethod);
/* 175 */     paramMMethod.setSimpleName(paramMethod.getName());
/* 176 */     paramMMethod.setModifiers(paramMethod.getModifiers());
/* 177 */     paramMMethod.setReturnType(paramMethod.getReturnType().getName());
/* 178 */     Class[] arrayOfClass1 = paramMethod.getExceptionTypes();
/* 179 */     addThrows((MInvokable)paramMMethod, arrayOfClass1);
/* 180 */     Class[] arrayOfClass2 = paramMethod.getParameterTypes();
/* 181 */     for (byte b = 0; b < arrayOfClass2.length; b++) {
/* 182 */       MParameter mParameter = addParameter((MInvokable)paramMMethod, b, arrayOfClass2[b]);
/* 183 */       if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations(mParameter, paramMethod, b); 
/*     */     } 
/* 185 */     if (this.mTigerDelegate != null) this.mTigerDelegate.extractAnnotations((MMember)paramMMethod, paramMethod); 
/*     */   }
/*     */   
/*     */   private void addThrows(MInvokable paramMInvokable, Class[] paramArrayOfClass) {
/* 189 */     for (byte b = 0; b < paramArrayOfClass.length; b++) {
/* 190 */       paramMInvokable.addException(paramArrayOfClass[b].getName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MParameter addParameter(MInvokable paramMInvokable, int paramInt, Class paramClass) {
/* 198 */     MParameter mParameter = paramMInvokable.addNewParameter();
/* 199 */     mParameter.setSimpleName("param" + paramInt);
/* 200 */     mParameter.setType(paramClass.getName());
/* 201 */     return mParameter;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\reflect\ReflectClassBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */