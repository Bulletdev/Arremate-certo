/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
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
/*     */ public final class ArrayClassImpl
/*     */   extends BuiltinClassImpl
/*     */ {
/*     */   private int mDimensions;
/*     */   private JClass mComponentType;
/*     */   
/*     */   public static JClass createClassForFD(String paramString, JamClassLoader paramJamClassLoader) {
/*  44 */     if (!paramString.startsWith("[")) {
/*  45 */       throw new IllegalArgumentException("must be an array type fd: " + paramString);
/*     */     }
/*     */     
/*  48 */     if (paramString.endsWith(";")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  53 */       int j = paramString.indexOf("L");
/*  54 */       if (j != -1 && j < paramString.length() - 2) {
/*  55 */         String str1 = paramString.substring(j + 1, paramString.length() - 1);
/*  56 */         return (JClass)new ArrayClassImpl(paramJamClassLoader.loadClass(str1), j);
/*     */       } 
/*     */       
/*  59 */       throw new IllegalArgumentException("array type field descriptor '" + paramString + "' is malformed");
/*     */     } 
/*     */ 
/*     */     
/*  63 */     int i = paramString.lastIndexOf("[") + 1;
/*  64 */     String str = paramString.substring(i, i + 1);
/*  65 */     JClass jClass = paramJamClassLoader.loadClass(str);
/*  66 */     if (jClass == null)
/*     */     {
/*     */       
/*  69 */       throw new IllegalArgumentException("array type field descriptor '" + paramString + "' is malformed");
/*     */     }
/*     */     
/*  72 */     return (JClass)new ArrayClassImpl(jClass, i);
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
/*     */   public static String normalizeArrayName(String paramString) {
/*  84 */     if (paramString.startsWith("[")) return paramString; 
/*  85 */     if (paramString.endsWith("]")) {
/*  86 */       int i = paramString.indexOf('[');
/*  87 */       if (i != -1) {
/*  88 */         String str1 = paramString.substring(0, i);
/*  89 */         String str2 = PrimitiveClassImpl.getPrimitiveClassForName(str1);
/*  90 */         if (str2 == null) str2 = 'L' + str1 + ';'; 
/*  91 */         StringWriter stringWriter = new StringWriter();
/*     */         while (true) {
/*  93 */           stringWriter.write(91);
/*  94 */           i = paramString.indexOf('[', i + 1);
/*  95 */           if (i == -1)
/*  96 */           { stringWriter.write(str2);
/*  97 */             return stringWriter.toString(); } 
/*     */         } 
/*     */       } 
/* 100 */     }  throw new IllegalArgumentException("'" + paramString + "' does not name an array");
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
/*     */   
/*     */   private ArrayClassImpl(JClass paramJClass, int paramInt) {
/* 114 */     super(((ElementImpl)paramJClass).getContext());
/* 115 */     if (paramInt < 1) {
/* 116 */       throw new IllegalArgumentException("dimensions=" + paramInt);
/*     */     }
/* 118 */     if (paramJClass == null) {
/* 119 */       throw new IllegalArgumentException("null componentType");
/*     */     }
/* 121 */     this.mComponentType = paramJClass;
/* 122 */     this.mDimensions = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSimpleName() {
/* 131 */     String str = getQualifiedName();
/* 132 */     int i = str.lastIndexOf('.');
/* 133 */     return (i == -1) ? str : str.substring(i + 1);
/*     */   }
/*     */   
/*     */   public String getQualifiedName() {
/* 137 */     StringWriter stringWriter = new StringWriter();
/* 138 */     stringWriter.write(this.mComponentType.getQualifiedName());
/* 139 */     for (byte b = 0; b < this.mDimensions; ) { stringWriter.write("[]"); b++; }
/* 140 */      return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArrayType() {
/* 146 */     return true;
/*     */   } public JClass getArrayComponentType() {
/* 148 */     return this.mComponentType;
/*     */   } public int getArrayDimensions() {
/* 150 */     return this.mDimensions;
/*     */   }
/*     */   public JClass getSuperclass() {
/* 153 */     return getClassLoader().loadClass("java.lang.Object");
/*     */   }
/*     */   
/*     */   public boolean isAssignableFrom(JClass paramJClass) {
/* 157 */     return (paramJClass.isArrayType() && paramJClass.getArrayDimensions() == this.mDimensions && this.mComponentType.isAssignableFrom(paramJClass.getArrayComponentType()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFieldDescriptor() {
/* 164 */     StringWriter stringWriter = new StringWriter();
/* 165 */     for (byte b = 0; b < this.mDimensions; ) { stringWriter.write("["); b++; }
/* 166 */      if (this.mComponentType.isPrimitiveType()) {
/* 167 */       stringWriter.write(this.mComponentType.getFieldDescriptor());
/*     */     } else {
/* 169 */       stringWriter.write("L");
/* 170 */       stringWriter.write(this.mComponentType.getQualifiedName());
/* 171 */       stringWriter.write(";");
/*     */     } 
/* 173 */     return stringWriter.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\ArrayClassImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */