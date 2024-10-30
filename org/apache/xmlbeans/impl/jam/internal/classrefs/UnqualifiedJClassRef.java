/*     */ package org.apache.xmlbeans.impl.jam.internal.classrefs;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
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
/*     */ public class UnqualifiedJClassRef
/*     */   implements JClassRef
/*     */ {
/*     */   private static final boolean VERBOSE = false;
/*     */   private static final String PREFIX = "[UnqualifiedJClassRef]";
/*     */   private String mUnqualifiedClassname;
/*  37 */   private String mQualifiedClassname = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JClassRefContext mContext;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JClassRef create(String paramString, JClassRefContext paramJClassRefContext) {
/*  48 */     throw new IllegalStateException("Unqualified names currently disabled.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnqualifiedJClassRef(String paramString, JClassRefContext paramJClassRefContext) {
/*  58 */     if (paramJClassRefContext == null) throw new IllegalArgumentException("null ctx"); 
/*  59 */     if (paramString == null) throw new IllegalArgumentException("null ucname"); 
/*  60 */     this.mContext = paramJClassRefContext;
/*  61 */     this.mUnqualifiedClassname = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JClass getRefClass() {
/*  71 */     return this.mContext.getClassLoader().loadClass(getQualifiedName());
/*     */   }
/*     */   public String getQualifiedName() {
/*     */     String str1;
/*  75 */     if (this.mQualifiedClassname != null) return this.mQualifiedClassname;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     byte b = 0;
/*  81 */     int i = this.mUnqualifiedClassname.indexOf('[');
/*  82 */     if (i != -1) {
/*  83 */       str1 = this.mUnqualifiedClassname.substring(0, i);
/*     */       do {
/*  85 */         b++;
/*  86 */         i = this.mUnqualifiedClassname.indexOf('[', i + 1);
/*  87 */       } while (i != -1);
/*     */     } else {
/*  89 */       str1 = this.mUnqualifiedClassname;
/*     */     } 
/*     */     
/*  92 */     String str2 = qualifyName(str1);
/*  93 */     if (str2 == null) {
/*  94 */       throw new IllegalStateException("unable to handle unqualified java type reference '" + str1 + " [" + this.mUnqualifiedClassname + "]'. " + "This is still partially NYI.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     if (b > 0) {
/* 102 */       StringWriter stringWriter = new StringWriter();
/* 103 */       for (byte b1 = 0; b1 < b; ) { stringWriter.write(91); b1++; }
/* 104 */        stringWriter.write(76);
/* 105 */       stringWriter.write(str2);
/* 106 */       stringWriter.write(59);
/*     */       
/* 108 */       this.mQualifiedClassname = stringWriter.toString();
/*     */     } else {
/* 110 */       this.mQualifiedClassname = str2;
/*     */     } 
/* 112 */     return this.mQualifiedClassname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String qualifyName(String paramString) {
/* 119 */     String str = null;
/* 120 */     if ((str = checkExplicitImport(paramString)) != null) return str; 
/* 121 */     if ((str = checkJavaLang(paramString)) != null) return str; 
/* 122 */     if ((str = checkSamePackage(paramString)) != null) return str; 
/* 123 */     if ((str = checkAlreadyQualified(paramString)) != null) return str; 
/* 124 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String checkSamePackage(String paramString) {
/* 131 */     String str = this.mContext.getPackageName() + "." + paramString;
/* 132 */     JClass jClass = this.mContext.getClassLoader().loadClass(str);
/*     */ 
/*     */     
/* 135 */     return jClass.isUnresolvedType() ? null : jClass.getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String checkJavaLang(String paramString) {
/* 142 */     String str = "java.lang." + paramString;
/* 143 */     JClass jClass = this.mContext.getClassLoader().loadClass(str);
/*     */ 
/*     */     
/* 146 */     return jClass.isUnresolvedType() ? null : jClass.getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String checkAlreadyQualified(String paramString) {
/* 153 */     JClass jClass = this.mContext.getClassLoader().loadClass(paramString);
/*     */     
/* 155 */     return jClass.isUnresolvedType() ? null : jClass.getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String checkExplicitImport(String paramString) {
/* 164 */     String[] arrayOfString = this.mContext.getImportSpecs();
/*     */ 
/*     */     
/* 167 */     for (byte b = 0; b < arrayOfString.length; b++) {
/*     */       
/* 169 */       String str = lastSegment(arrayOfString[b]);
/*     */ 
/*     */       
/* 172 */       if (str.equals(paramString)) return arrayOfString[b]; 
/*     */     } 
/* 174 */     return null;
/*     */   }
/*     */   
/*     */   private static String lastSegment(String paramString) {
/* 178 */     int i = paramString.lastIndexOf(".");
/* 179 */     if (i == -1) return paramString; 
/* 180 */     return paramString.substring(i + 1);
/*     */   }
/*     */   
/*     */   private static String firstSegment(String paramString) {
/* 184 */     int i = paramString.indexOf(".");
/* 185 */     if (i == -1) return paramString; 
/* 186 */     return paramString.substring(0, i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\classrefs\UnqualifiedJClassRef.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */