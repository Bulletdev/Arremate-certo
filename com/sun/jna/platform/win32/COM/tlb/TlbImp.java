/*     */ package com.sun.jna.platform.win32.COM.tlb;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.TypeLibUtil;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbBase;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbCmdlineArgs;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbCoClass;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbConst;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbDispInterface;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbEnum;
/*     */ import com.sun.jna.platform.win32.COM.tlb.imp.TlbInterface;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
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
/*     */ public class TlbImp
/*     */   implements TlbConst
/*     */ {
/*     */   private TypeLibUtil typeLibUtil;
/*     */   private File comRootDir;
/*     */   private File outputDir;
/*     */   private TlbCmdlineArgs cmdlineArgs;
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  67 */     new TlbImp(paramArrayOfString);
/*     */   }
/*     */   
/*     */   public TlbImp(String[] paramArrayOfString) {
/*  71 */     this.cmdlineArgs = new TlbCmdlineArgs(paramArrayOfString);
/*     */     
/*  73 */     if (this.cmdlineArgs.isTlbId()) {
/*  74 */       String str = this.cmdlineArgs.getRequiredParam("tlb.id");
/*     */       
/*  76 */       int i = this.cmdlineArgs.getIntParam("tlb.major.version");
/*     */       
/*  78 */       int j = this.cmdlineArgs.getIntParam("tlb.minor.version");
/*     */ 
/*     */ 
/*     */       
/*  82 */       this.typeLibUtil = new TypeLibUtil(str, i, j);
/*     */       
/*  84 */       startCOM2Java();
/*  85 */     } else if (this.cmdlineArgs.isTlbFile()) {
/*  86 */       String str = this.cmdlineArgs.getRequiredParam("tlb.file");
/*     */ 
/*     */       
/*  89 */       this.typeLibUtil = new TypeLibUtil(str);
/*  90 */       startCOM2Java();
/*     */     } else {
/*  92 */       this.cmdlineArgs.showCmdHelp();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startCOM2Java() {
/*     */     try {
/* 101 */       createDir();
/*     */       
/* 103 */       String str = this.cmdlineArgs.getBindingMode();
/*     */       
/* 105 */       int i = this.typeLibUtil.getTypeInfoCount();
/* 106 */       for (byte b = 0; b < i; b++) {
/* 107 */         OaIdl.TYPEKIND tYPEKIND = this.typeLibUtil.getTypeInfoType(b);
/*     */         
/* 109 */         if (tYPEKIND.value == 0) {
/* 110 */           createCOMEnum(b, getPackageName(), this.typeLibUtil);
/* 111 */         } else if (tYPEKIND.value == 1) {
/* 112 */           logInfo("'TKIND_RECORD' objects are currently not supported!");
/* 113 */         } else if (tYPEKIND.value == 2) {
/* 114 */           logInfo("'TKIND_MODULE' objects are currently not supported!");
/* 115 */         } else if (tYPEKIND.value == 3) {
/* 116 */           createCOMInterface(b, getPackageName(), this.typeLibUtil);
/*     */         }
/* 118 */         else if (tYPEKIND.value == 4) {
/* 119 */           createCOMDispInterface(b, getPackageName(), this.typeLibUtil);
/*     */         }
/* 121 */         else if (tYPEKIND.value == 5) {
/* 122 */           createCOMCoClass(b, getPackageName(), this.typeLibUtil, str);
/*     */         }
/* 124 */         else if (tYPEKIND.value == 6) {
/* 125 */           logInfo("'TKIND_ALIAS' objects are currently not supported!");
/* 126 */         } else if (tYPEKIND.value == 7) {
/* 127 */           logInfo("'TKIND_UNION' objects are currently not supported!");
/*     */         } 
/*     */       } 
/*     */       
/* 131 */       logInfo(i + " files sucessfully written to: " + this.comRootDir
/* 132 */           .toString());
/* 133 */     } catch (Exception exception) {
/* 134 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void createDir() throws FileNotFoundException {
/* 139 */     String str1 = this.cmdlineArgs.getParam("output.dir");
/*     */     
/* 141 */     String str2 = "_jnaCOM_" + System.currentTimeMillis() + "\\myPackage\\" + this.typeLibUtil.getName().toLowerCase() + "\\";
/*     */     
/* 143 */     if (str1 != null) {
/* 144 */       this.comRootDir = new File(str1 + "\\" + str2);
/*     */     } else {
/* 146 */       String str = System.getProperty("java.io.tmpdir");
/* 147 */       this.comRootDir = new File(str + "\\" + str2);
/*     */     } 
/*     */     
/* 150 */     if (this.comRootDir.exists()) {
/* 151 */       this.comRootDir.delete();
/*     */     }
/* 153 */     if (this.comRootDir.mkdirs()) {
/* 154 */       logInfo("Output directory sucessfully created.");
/*     */     } else {
/* 156 */       throw new FileNotFoundException("Output directory NOT sucessfully created to: " + this.comRootDir
/*     */           
/* 158 */           .toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getPackageName() {
/* 163 */     return "myPackage." + this.typeLibUtil.getName().toLowerCase();
/*     */   }
/*     */   
/*     */   private void writeTextFile(String paramString1, String paramString2) throws IOException {
/* 167 */     String str = this.comRootDir + File.separator + paramString1;
/* 168 */     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
/*     */     
/* 170 */     bufferedOutputStream.write(paramString2.getBytes());
/* 171 */     bufferedOutputStream.close();
/*     */   }
/*     */   
/*     */   private void writeTlbClass(TlbBase paramTlbBase) throws IOException {
/* 175 */     StringBuffer stringBuffer = paramTlbBase.getClassBuffer();
/* 176 */     writeTextFile(paramTlbBase.getFilename(), stringBuffer.toString());
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
/*     */   private void createCOMEnum(int paramInt, String paramString, TypeLibUtil paramTypeLibUtil) throws IOException {
/* 190 */     TlbEnum tlbEnum = new TlbEnum(paramInt, paramString, paramTypeLibUtil);
/* 191 */     writeTlbClass((TlbBase)tlbEnum);
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
/*     */   private void createCOMInterface(int paramInt, String paramString, TypeLibUtil paramTypeLibUtil) throws IOException {
/* 205 */     TlbInterface tlbInterface = new TlbInterface(paramInt, paramString, paramTypeLibUtil);
/*     */     
/* 207 */     writeTlbClass((TlbBase)tlbInterface);
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
/*     */   private void createCOMDispInterface(int paramInt, String paramString, TypeLibUtil paramTypeLibUtil) throws IOException {
/* 221 */     TlbDispInterface tlbDispInterface = new TlbDispInterface(paramInt, paramString, paramTypeLibUtil);
/*     */     
/* 223 */     writeTlbClass((TlbBase)tlbDispInterface);
/*     */   }
/*     */ 
/*     */   
/*     */   private void createCOMCoClass(int paramInt, String paramString1, TypeLibUtil paramTypeLibUtil, String paramString2) throws IOException {
/* 228 */     TlbCoClass tlbCoClass = new TlbCoClass(paramInt, getPackageName(), paramTypeLibUtil, paramString2);
/*     */     
/* 230 */     writeTlbClass((TlbBase)tlbCoClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void logInfo(String paramString) {
/* 240 */     System.out.println(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\TlbImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */