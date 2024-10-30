/*     */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.TypeInfoUtil;
/*     */ import com.sun.jna.platform.win32.COM.TypeLibUtil;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public abstract class TlbBase
/*     */ {
/*     */   public static final String CR = "\n";
/*     */   public static final String CRCR = "\n\n";
/*     */   public static final String TAB = "\t";
/*     */   public static final String TABTAB = "\t\t";
/*     */   protected TypeLibUtil typeLibUtil;
/*     */   protected TypeInfoUtil typeInfoUtil;
/*     */   protected int index;
/*     */   protected StringBuffer templateBuffer;
/*     */   protected StringBuffer classBuffer;
/*  73 */   protected String content = "";
/*     */   
/*  75 */   protected String filename = "DefaultFilename";
/*     */   
/*  77 */   protected String name = "DefaultName";
/*     */ 
/*     */   
/*  80 */   public static String[] IUNKNOWN_METHODS = new String[] { "QueryInterface", "AddRef", "Release" };
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static String[] IDISPATCH_METHODS = new String[] { "GetTypeInfoCount", "GetTypeInfo", "GetIDsOfNames", "Invoke" };
/*     */ 
/*     */   
/*  87 */   protected String bindingMode = "dispid";
/*     */   
/*     */   public TlbBase(int paramInt, TypeLibUtil paramTypeLibUtil, TypeInfoUtil paramTypeInfoUtil) {
/*  90 */     this(paramInt, paramTypeLibUtil, paramTypeInfoUtil, "dispid");
/*     */   }
/*     */   
/*     */   public TlbBase(int paramInt, TypeLibUtil paramTypeLibUtil, TypeInfoUtil paramTypeInfoUtil, String paramString) {
/*  94 */     this.index = paramInt;
/*  95 */     this.typeLibUtil = paramTypeLibUtil;
/*  96 */     this.typeInfoUtil = paramTypeInfoUtil;
/*  97 */     this.bindingMode = paramString;
/*     */     
/*  99 */     String str = getClassTemplate();
/*     */     try {
/* 101 */       readTemplateFile(str);
/* 102 */       this.classBuffer = this.templateBuffer;
/* 103 */     } catch (IOException iOException) {
/* 104 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logError(String paramString) {
/* 115 */     log("ERROR", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logInfo(String paramString) {
/* 125 */     log("INFO", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuffer getClassBuffer() {
/* 134 */     return this.classBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createContent(String paramString) {
/* 144 */     replaceVariable("content", paramString);
/*     */   }
/*     */   
/*     */   public void setFilename(String paramString) {
/* 148 */     if (!paramString.endsWith("java"))
/* 149 */       paramString = paramString + ".java"; 
/* 150 */     this.filename = paramString;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 154 */     return this.filename;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 158 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {
/* 162 */     this.name = paramString;
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
/*     */   protected void log(String paramString1, String paramString2) {
/* 174 */     String str = paramString1 + " " + getTime() + " : " + paramString2;
/* 175 */     System.out.println(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getTime() {
/* 184 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/* 185 */     return simpleDateFormat.format(new Date());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getClassTemplate();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void readTemplateFile(String paramString) throws IOException {
/* 204 */     this.templateBuffer = new StringBuffer();
/* 205 */     BufferedReader bufferedReader = null;
/*     */     
/*     */     try {
/* 208 */       InputStream inputStream = getClass().getClassLoader().getResourceAsStream(paramString);
/* 209 */       bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
/* 210 */       String str = null;
/* 211 */       while ((str = bufferedReader.readLine()) != null)
/* 212 */         this.templateBuffer.append(str + "\n"); 
/*     */     } finally {
/* 214 */       if (bufferedReader != null) {
/* 215 */         bufferedReader.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void replaceVariable(String paramString1, String paramString2) {
/* 228 */     if (paramString2 == null) {
/* 229 */       paramString2 = "";
/*     */     }
/* 231 */     Pattern pattern = Pattern.compile("\\$\\{" + paramString1 + "\\}");
/* 232 */     Matcher matcher = pattern.matcher(this.classBuffer);
/* 233 */     String str1 = paramString2;
/* 234 */     String str2 = "";
/*     */     
/* 236 */     while (matcher.find()) {
/* 237 */       str2 = matcher.replaceAll(str1);
/*     */     }
/*     */     
/* 240 */     if (str2.length() > 0)
/* 241 */       this.classBuffer = new StringBuffer(str2); 
/*     */   }
/*     */   
/*     */   protected void createPackageName(String paramString) {
/* 245 */     replaceVariable("packagename", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createClassName(String paramString) {
/* 255 */     replaceVariable("classname", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isReservedMethod(String paramString) {
/*     */     byte b;
/* 266 */     for (b = 0; b < IUNKNOWN_METHODS.length; b++) {
/* 267 */       if (IUNKNOWN_METHODS[b].equalsIgnoreCase(paramString)) {
/* 268 */         return true;
/*     */       }
/*     */     } 
/* 271 */     for (b = 0; b < IDISPATCH_METHODS.length; b++) {
/* 272 */       if (IDISPATCH_METHODS[b].equalsIgnoreCase(paramString)) {
/* 273 */         return true;
/*     */       }
/*     */     } 
/* 276 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isVTableMode() {
/* 280 */     if (this.bindingMode.equalsIgnoreCase("vtable")) {
/* 281 */       return true;
/*     */     }
/* 283 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isDispIdMode() {
/* 287 */     if (this.bindingMode.equalsIgnoreCase("dispid")) {
/* 288 */       return true;
/*     */     }
/* 290 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */