/*     */ package org.apache.xmlbeans.impl.config;
/*     */ 
/*     */ import org.apache.xmlbeans.InterfaceExtension;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JMethod;
/*     */ import org.apache.xmlbeans.impl.jam.JParameter;
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
/*     */ public class InterfaceExtensionImpl
/*     */   implements InterfaceExtension
/*     */ {
/*     */   private NameSet _xbeanSet;
/*     */   private String _interfaceClassName;
/*     */   private String _delegateToClassName;
/*     */   private MethodSignatureImpl[] _methods;
/*     */   
/*     */   static InterfaceExtensionImpl newInstance(JamClassLoader paramJamClassLoader, NameSet paramNameSet, Extensionconfig.Interface paramInterface) {
/*  35 */     InterfaceExtensionImpl interfaceExtensionImpl = new InterfaceExtensionImpl();
/*     */     
/*  37 */     interfaceExtensionImpl._xbeanSet = paramNameSet;
/*  38 */     JClass jClass1 = validateInterface(paramJamClassLoader, paramInterface.getName(), (XmlObject)paramInterface);
/*     */ 
/*     */     
/*  41 */     if (jClass1 == null) {
/*     */       
/*  43 */       BindingConfigImpl.error("Interface '" + paramInterface.getStaticHandler() + "' not found.", (XmlObject)paramInterface);
/*  44 */       return null;
/*     */     } 
/*     */     
/*  47 */     interfaceExtensionImpl._interfaceClassName = jClass1.getQualifiedName();
/*     */     
/*  49 */     interfaceExtensionImpl._delegateToClassName = paramInterface.getStaticHandler();
/*  50 */     JClass jClass2 = validateClass(paramJamClassLoader, interfaceExtensionImpl._delegateToClassName, (XmlObject)paramInterface);
/*     */     
/*  52 */     if (jClass2 == null) {
/*     */       
/*  54 */       BindingConfigImpl.warning("Handler class '" + paramInterface.getStaticHandler() + "' not found on classpath, skip validation.", (XmlObject)paramInterface);
/*  55 */       return interfaceExtensionImpl;
/*     */     } 
/*     */     
/*  58 */     if (!interfaceExtensionImpl.validateMethods(jClass1, jClass2, (XmlObject)paramInterface)) {
/*  59 */       return null;
/*     */     }
/*  61 */     return interfaceExtensionImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   private static JClass validateInterface(JamClassLoader paramJamClassLoader, String paramString, XmlObject paramXmlObject) {
/*  66 */     return validateJava(paramJamClassLoader, paramString, true, paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   static JClass validateClass(JamClassLoader paramJamClassLoader, String paramString, XmlObject paramXmlObject) {
/*  71 */     return validateJava(paramJamClassLoader, paramString, false, paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   static JClass validateJava(JamClassLoader paramJamClassLoader, String paramString, boolean paramBoolean, XmlObject paramXmlObject) {
/*  76 */     if (paramJamClassLoader == null) {
/*  77 */       return null;
/*     */     }
/*  79 */     String str = paramBoolean ? "Interface" : "Class";
/*  80 */     JClass jClass = paramJamClassLoader.loadClass(paramString);
/*     */     
/*  82 */     if (jClass == null || jClass.isUnresolvedType()) {
/*     */       
/*  84 */       BindingConfigImpl.error(str + " '" + paramString + "' not found.", paramXmlObject);
/*  85 */       return null;
/*     */     } 
/*     */     
/*  88 */     if ((paramBoolean && !jClass.isInterface()) || (!paramBoolean && jClass.isInterface()))
/*     */     {
/*     */       
/*  91 */       BindingConfigImpl.error("'" + paramString + "' must be " + (paramBoolean ? "an interface" : "a class") + ".", paramXmlObject);
/*     */     }
/*     */ 
/*     */     
/*  95 */     if (!jClass.isPublic())
/*     */     {
/*  97 */       BindingConfigImpl.error(str + " '" + paramString + "' is not public.", paramXmlObject);
/*     */     }
/*     */     
/* 100 */     return jClass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean validateMethods(JClass paramJClass1, JClass paramJClass2, XmlObject paramXmlObject) {
/* 106 */     boolean bool = true;
/*     */     
/* 108 */     JMethod[] arrayOfJMethod = paramJClass1.getMethods();
/* 109 */     this._methods = new MethodSignatureImpl[arrayOfJMethod.length];
/*     */     
/* 111 */     for (byte b = 0; b < arrayOfJMethod.length; b++) {
/*     */       
/* 113 */       JMethod jMethod = validateMethod(paramJClass1, paramJClass2, arrayOfJMethod[b], paramXmlObject);
/* 114 */       if (jMethod != null) {
/* 115 */         this._methods[b] = new MethodSignatureImpl(getStaticHandler(), jMethod);
/*     */       } else {
/* 117 */         bool = false;
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   private JMethod validateMethod(JClass paramJClass1, JClass paramJClass2, JMethod paramJMethod, XmlObject paramXmlObject) {
/* 126 */     String str = paramJMethod.getSimpleName();
/* 127 */     JParameter[] arrayOfJParameter = paramJMethod.getParameters();
/* 128 */     JClass jClass = paramJMethod.getReturnType();
/*     */     
/* 130 */     JClass[] arrayOfJClass1 = new JClass[arrayOfJParameter.length + 1];
/* 131 */     arrayOfJClass1[0] = jClass.forName("org.apache.xmlbeans.XmlObject");
/* 132 */     for (byte b1 = 1; b1 < arrayOfJClass1.length; b1++)
/*     */     {
/* 134 */       arrayOfJClass1[b1] = arrayOfJParameter[b1 - 1].getType();
/*     */     }
/*     */     
/* 137 */     JMethod jMethod = null;
/* 138 */     jMethod = getMethod(paramJClass2, str, arrayOfJClass1);
/* 139 */     if (jMethod == null) {
/*     */       
/* 141 */       BindingConfigImpl.error("Handler class '" + paramJClass2.getQualifiedName() + "' does not contain method " + str + "(" + listTypes(arrayOfJClass1) + ")", paramXmlObject);
/* 142 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 146 */     JClass[] arrayOfJClass2 = paramJMethod.getExceptionTypes();
/* 147 */     JClass[] arrayOfJClass3 = jMethod.getExceptionTypes();
/* 148 */     if (arrayOfJClass3.length != arrayOfJClass2.length) {
/*     */       
/* 150 */       BindingConfigImpl.error("Handler method '" + paramJClass2.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJClass1) + ")' must declare the same exceptions as the interface method '" + paramJClass1.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJParameter), paramXmlObject);
/*     */       
/* 152 */       return null;
/*     */     } 
/*     */     
/* 155 */     for (byte b2 = 0; b2 < arrayOfJClass3.length; b2++) {
/*     */       
/* 157 */       if (arrayOfJClass3[b2] != arrayOfJClass2[b2]) {
/*     */         
/* 159 */         BindingConfigImpl.error("Handler method '" + paramJClass2.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJClass1) + ")' must declare the same exceptions as the interface method '" + paramJClass1.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJParameter), paramXmlObject);
/*     */         
/* 161 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     if (!jMethod.isPublic() || !jMethod.isStatic()) {
/*     */       
/* 167 */       BindingConfigImpl.error("Method '" + paramJClass2.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJClass1) + ")' must be declared public and static.", paramXmlObject);
/* 168 */       return null;
/*     */     } 
/*     */     
/* 171 */     if (!jClass.equals(jMethod.getReturnType())) {
/*     */       
/* 173 */       BindingConfigImpl.error("Return type for method '" + jMethod.getReturnType() + " " + paramJClass2.getQualifiedName() + "." + str + "(" + listTypes(arrayOfJClass1) + ")' does not match the return type of the interface method :'" + jClass + "'.", paramXmlObject);
/*     */       
/* 175 */       return null;
/*     */     } 
/*     */     
/* 178 */     return paramJMethod;
/*     */   }
/*     */ 
/*     */   
/*     */   static JMethod getMethod(JClass paramJClass, String paramString, JClass[] paramArrayOfJClass) {
/* 183 */     JMethod[] arrayOfJMethod = paramJClass.getMethods();
/* 184 */     for (byte b = 0; b < arrayOfJMethod.length; b++) {
/*     */       
/* 186 */       JMethod jMethod = arrayOfJMethod[b];
/* 187 */       if (paramString.equals(jMethod.getSimpleName())) {
/*     */ 
/*     */         
/* 190 */         JParameter[] arrayOfJParameter = jMethod.getParameters();
/*     */ 
/*     */         
/* 193 */         if (arrayOfJParameter.length == paramArrayOfJClass.length)
/*     */         
/*     */         { 
/* 196 */           for (byte b1 = 0; b1 < arrayOfJParameter.length; b1++) {
/*     */             
/* 198 */             JParameter jParameter = arrayOfJParameter[b1];
/* 199 */             if (!jParameter.getType().equals(paramArrayOfJClass[b1]));
/*     */           } 
/*     */ 
/*     */           
/* 203 */           return jMethod; } 
/*     */       } 
/* 205 */     }  return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String listTypes(JClass[] paramArrayOfJClass) {
/* 210 */     StringBuffer stringBuffer = new StringBuffer();
/* 211 */     for (byte b = 0; b < paramArrayOfJClass.length; b++) {
/*     */       
/* 213 */       JClass jClass = paramArrayOfJClass[b];
/* 214 */       if (b > 0)
/* 215 */         stringBuffer.append(", "); 
/* 216 */       stringBuffer.append(emitType(jClass));
/*     */     } 
/* 218 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static String listTypes(JParameter[] paramArrayOfJParameter) {
/* 223 */     StringBuffer stringBuffer = new StringBuffer();
/* 224 */     for (byte b = 0; b < paramArrayOfJParameter.length; b++) {
/*     */       
/* 226 */       JClass jClass = paramArrayOfJParameter[b].getType();
/* 227 */       if (b > 0)
/* 228 */         stringBuffer.append(", "); 
/* 229 */       stringBuffer.append(emitType(jClass));
/*     */     } 
/* 231 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String emitType(JClass paramJClass) {
/* 236 */     if (paramJClass.isArrayType()) {
/* 237 */       return emitType(paramJClass.getArrayComponentType()) + "[]";
/*     */     }
/* 239 */     return paramJClass.getQualifiedName().replace('$', '.');
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 245 */     return this._xbeanSet.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStaticHandler() {
/* 250 */     return this._delegateToClassName;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getInterface() {
/* 255 */     return this._interfaceClassName;
/*     */   }
/*     */ 
/*     */   
/*     */   public InterfaceExtension.MethodSignature[] getMethods() {
/* 260 */     return (InterfaceExtension.MethodSignature[])this._methods;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 265 */     StringBuffer stringBuffer = new StringBuffer();
/* 266 */     stringBuffer.append("  static handler: ").append(this._delegateToClassName).append("\n");
/* 267 */     stringBuffer.append("  interface: ").append(this._interfaceClassName).append("\n");
/* 268 */     stringBuffer.append("  name set: ").append(this._xbeanSet).append("\n");
/*     */     
/* 270 */     for (byte b = 0; b < this._methods.length; b++) {
/* 271 */       stringBuffer.append("  method[").append(b).append("]=").append(this._methods[b]).append("\n");
/*     */     }
/* 273 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   static class MethodSignatureImpl
/*     */     implements InterfaceExtension.MethodSignature
/*     */   {
/*     */     private String _intfName;
/* 280 */     private final int NOTINITIALIZED = -1;
/* 281 */     private int _hashCode = -1;
/*     */     
/*     */     private String _signature;
/*     */     
/*     */     private String _name;
/*     */     private String _return;
/*     */     private String[] _params;
/*     */     private String[] _exceptions;
/*     */     
/*     */     MethodSignatureImpl(String param1String, JMethod param1JMethod) {
/* 291 */       if (param1String == null || param1JMethod == null) {
/* 292 */         throw new IllegalArgumentException("Interface: " + param1String + " method: " + param1JMethod);
/*     */       }
/* 294 */       this._intfName = param1String;
/* 295 */       this._hashCode = -1;
/* 296 */       this._signature = null;
/*     */       
/* 298 */       this._name = param1JMethod.getSimpleName();
/* 299 */       this._return = param1JMethod.getReturnType().getQualifiedName().replace('$', '.');
/*     */       
/* 301 */       JParameter[] arrayOfJParameter = param1JMethod.getParameters();
/* 302 */       this._params = new String[arrayOfJParameter.length];
/* 303 */       for (byte b1 = 0; b1 < arrayOfJParameter.length; b1++) {
/* 304 */         this._params[b1] = arrayOfJParameter[b1].getType().getQualifiedName().replace('$', '.');
/*     */       }
/* 306 */       JClass[] arrayOfJClass = param1JMethod.getExceptionTypes();
/* 307 */       this._exceptions = new String[arrayOfJClass.length];
/* 308 */       for (byte b2 = 0; b2 < arrayOfJClass.length; b2++) {
/* 309 */         this._exceptions[b2] = arrayOfJClass[b2].getQualifiedName().replace('$', '.');
/*     */       }
/*     */     }
/*     */     
/*     */     String getInterfaceName() {
/* 314 */       return this._intfName;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/* 319 */       return this._name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getReturnType() {
/* 324 */       return this._return;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getParameterTypes() {
/* 329 */       return this._params;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] getExceptionTypes() {
/* 334 */       return this._exceptions;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 339 */       if (!(param1Object instanceof MethodSignatureImpl)) {
/* 340 */         return false;
/*     */       }
/* 342 */       MethodSignatureImpl methodSignatureImpl = (MethodSignatureImpl)param1Object;
/*     */       
/* 344 */       if (!methodSignatureImpl.getName().equals(getName())) {
/* 345 */         return false;
/*     */       }
/* 347 */       String[] arrayOfString1 = getParameterTypes();
/* 348 */       String[] arrayOfString2 = methodSignatureImpl.getParameterTypes();
/*     */       
/* 350 */       if (arrayOfString2.length != arrayOfString1.length) {
/* 351 */         return false;
/*     */       }
/* 353 */       for (byte b = 0; b < arrayOfString1.length; b++) {
/*     */         
/* 355 */         if (!arrayOfString2[b].equals(arrayOfString1[b])) {
/* 356 */           return false;
/*     */         }
/*     */       } 
/* 359 */       if (!this._intfName.equals(methodSignatureImpl._intfName)) {
/* 360 */         return false;
/*     */       }
/* 362 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 367 */       if (this._hashCode != -1) {
/* 368 */         return this._hashCode;
/*     */       }
/* 370 */       int i = getName().hashCode();
/*     */       
/* 372 */       String[] arrayOfString = getParameterTypes();
/*     */       
/* 374 */       for (byte b = 0; b < arrayOfString.length; b++) {
/*     */         
/* 376 */         i *= 19;
/* 377 */         i += arrayOfString[b].hashCode();
/*     */       } 
/*     */       
/* 380 */       i += 21 * this._intfName.hashCode();
/*     */       
/* 382 */       this._hashCode = i;
/* 383 */       return this._hashCode;
/*     */     }
/*     */ 
/*     */     
/*     */     String getSignature() {
/* 388 */       if (this._signature != null) {
/* 389 */         return this._signature;
/*     */       }
/* 391 */       StringBuffer stringBuffer = new StringBuffer(60);
/* 392 */       stringBuffer.append(this._name).append("(");
/* 393 */       for (byte b = 0; b < this._params.length; b++)
/* 394 */         stringBuffer.append((b == 0) ? "" : " ,").append(this._params[b]); 
/* 395 */       stringBuffer.append(")");
/*     */       
/* 397 */       this._signature = stringBuffer.toString();
/*     */       
/* 399 */       return this._signature;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 404 */       StringBuffer stringBuffer = new StringBuffer();
/*     */       
/* 406 */       stringBuffer.append(getReturnType()).append(" ").append(getSignature());
/*     */       
/* 408 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\InterfaceExtensionImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */