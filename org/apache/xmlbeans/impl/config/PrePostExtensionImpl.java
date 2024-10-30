/*     */ package org.apache.xmlbeans.impl.config;
/*     */ 
/*     */ import org.apache.xmlbeans.PrePostExtension;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
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
/*     */ public class PrePostExtensionImpl
/*     */   implements PrePostExtension
/*     */ {
/*  29 */   private static JClass[] PARAMTYPES_PREPOST = null;
/*  30 */   private static final String[] PARAMTYPES_STRING = new String[] { "int", "org.apache.xmlbeans.XmlObject", "javax.xml.namespace.QName", "boolean", "int" };
/*     */   
/*     */   private static final String SIGNATURE;
/*     */   
/*     */   static {
/*  35 */     String str = "(";
/*  36 */     for (byte b = 0; b < PARAMTYPES_STRING.length; b++) {
/*     */       
/*  38 */       String str1 = PARAMTYPES_STRING[b];
/*  39 */       if (b != 0)
/*  40 */         str = str + ", "; 
/*  41 */       str = str + str1;
/*     */     } 
/*  43 */     SIGNATURE = str + ")";
/*     */   }
/*     */   
/*     */   private NameSet _xbeanSet;
/*     */   private JClass _delegateToClass;
/*     */   private String _delegateToClassName;
/*     */   private JMethod _preSet;
/*     */   private JMethod _postSet;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   static PrePostExtensionImpl newInstance(JamClassLoader paramJamClassLoader, NameSet paramNameSet, Extensionconfig.PrePostSet paramPrePostSet) {
/*  54 */     if (paramPrePostSet == null) {
/*  55 */       return null;
/*     */     }
/*  57 */     PrePostExtensionImpl prePostExtensionImpl = new PrePostExtensionImpl();
/*     */     
/*  59 */     prePostExtensionImpl._xbeanSet = paramNameSet;
/*  60 */     prePostExtensionImpl._delegateToClassName = paramPrePostSet.getStaticHandler();
/*  61 */     prePostExtensionImpl._delegateToClass = InterfaceExtensionImpl.validateClass(paramJamClassLoader, prePostExtensionImpl._delegateToClassName, (XmlObject)paramPrePostSet);
/*     */     
/*  63 */     if (prePostExtensionImpl._delegateToClass == null) {
/*     */       
/*  65 */       BindingConfigImpl.warning("Handler class '" + paramPrePostSet.getStaticHandler() + "' not found on classpath, skip validation.", (XmlObject)paramPrePostSet);
/*  66 */       return prePostExtensionImpl;
/*     */     } 
/*     */     
/*  69 */     if (!prePostExtensionImpl.lookAfterPreAndPost(paramJamClassLoader, (XmlObject)paramPrePostSet)) {
/*  70 */       return null;
/*     */     }
/*  72 */     return prePostExtensionImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean lookAfterPreAndPost(JamClassLoader paramJamClassLoader, XmlObject paramXmlObject) {
/*  77 */     assert this._delegateToClass != null : "Delegate to class handler expected.";
/*  78 */     boolean bool = true;
/*     */     
/*  80 */     initParamPrePost(paramJamClassLoader);
/*     */     
/*  82 */     this._preSet = InterfaceExtensionImpl.getMethod(this._delegateToClass, "preSet", PARAMTYPES_PREPOST);
/*  83 */     if (this._preSet == null);
/*     */ 
/*     */     
/*  86 */     if (this._preSet != null && !this._preSet.getReturnType().equals(paramJamClassLoader.loadClass("boolean"))) {
/*     */ 
/*     */       
/*  89 */       BindingConfigImpl.warning("Method '" + this._delegateToClass.getSimpleName() + ".preSet" + SIGNATURE + "' " + "should return boolean to be considered for a preSet handler.", paramXmlObject);
/*     */ 
/*     */       
/*  92 */       this._preSet = null;
/*     */     } 
/*     */     
/*  95 */     this._postSet = InterfaceExtensionImpl.getMethod(this._delegateToClass, "postSet", PARAMTYPES_PREPOST);
/*  96 */     if (this._postSet == null);
/*     */ 
/*     */     
/*  99 */     if (this._preSet == null && this._postSet == null) {
/*     */       
/* 101 */       BindingConfigImpl.error("prePostSet handler specified '" + this._delegateToClass.getSimpleName() + "' but no preSet" + SIGNATURE + " or " + "postSet" + SIGNATURE + " methods found.", paramXmlObject);
/*     */ 
/*     */       
/* 104 */       bool = false;
/*     */     } 
/*     */     
/* 107 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initParamPrePost(JamClassLoader paramJamClassLoader) {
/* 112 */     if (PARAMTYPES_PREPOST == null) {
/*     */       
/* 114 */       PARAMTYPES_PREPOST = new JClass[PARAMTYPES_STRING.length];
/* 115 */       for (byte b = 0; b < PARAMTYPES_PREPOST.length; b++) {
/*     */         
/* 117 */         PARAMTYPES_PREPOST[b] = paramJamClassLoader.loadClass(PARAMTYPES_STRING[b]);
/* 118 */         if (PARAMTYPES_PREPOST[b] == null)
/*     */         {
/* 120 */           throw new IllegalStateException("JAM should have access to the following types " + SIGNATURE);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet getNameSet() {
/* 129 */     return this._xbeanSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 134 */     return this._xbeanSet.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPreCall() {
/* 139 */     return (this._preSet != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPostCall() {
/* 144 */     return (this._postSet != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStaticHandler() {
/* 149 */     return this._delegateToClassName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHandlerNameForJavaSource() {
/* 158 */     if (this._delegateToClass == null) {
/* 159 */       return null;
/*     */     }
/* 161 */     return InterfaceExtensionImpl.emitType(this._delegateToClass);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean hasNameSetIntersection(PrePostExtensionImpl paramPrePostExtensionImpl) {
/* 166 */     return !NameSet.EMPTY.equals(this._xbeanSet.intersect(paramPrePostExtensionImpl._xbeanSet));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\PrePostExtensionImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */