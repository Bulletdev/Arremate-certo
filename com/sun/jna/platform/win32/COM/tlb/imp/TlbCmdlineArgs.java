/*     */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*     */ 
/*     */ import java.util.Hashtable;
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
/*     */ public class TlbCmdlineArgs
/*     */   extends Hashtable<String, String>
/*     */   implements TlbConst
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public TlbCmdlineArgs(String[] paramArrayOfString) {
/*  32 */     readCmdArgs(paramArrayOfString);
/*     */   }
/*     */   
/*     */   public int getIntParam(String paramString) {
/*  36 */     String str = getRequiredParam(paramString);
/*  37 */     return Integer.parseInt(str);
/*     */   }
/*     */   
/*     */   public String getParam(String paramString) {
/*  41 */     return get(paramString);
/*     */   }
/*     */   
/*     */   public String getRequiredParam(String paramString) {
/*  45 */     String str = getParam(paramString);
/*  46 */     if (str == null) {
/*  47 */       throw new TlbParameterNotFoundException("Commandline parameter not found: " + paramString);
/*     */     }
/*     */     
/*  50 */     return str;
/*     */   }
/*     */   
/*     */   private void readCmdArgs(String[] paramArrayOfString) {
/*  54 */     if (paramArrayOfString.length < 2) {
/*  55 */       showCmdHelp();
/*     */     }
/*  57 */     for (byte b = 0; b < paramArrayOfString.length; ) {
/*  58 */       String str1 = paramArrayOfString[b];
/*  59 */       String str2 = paramArrayOfString[b + 1];
/*  60 */       if (str1.startsWith("-") && !str2.startsWith("-")) {
/*  61 */         put(str1.substring(1), str2);
/*  62 */         b += 2; continue;
/*     */       } 
/*  64 */       showCmdHelp();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTlbFile() {
/*  71 */     return containsKey("tlb.file");
/*     */   }
/*     */   
/*     */   public boolean isTlbId() {
/*  75 */     return containsKey("tlb.id");
/*     */   }
/*     */   
/*     */   public String getBindingMode() {
/*  79 */     if (containsKey("bind.mode")) {
/*  80 */       return getParam("bind.mode");
/*     */     }
/*  82 */     return "vtable";
/*     */   }
/*     */   
/*     */   public void showCmdHelp() {
/*  86 */     String str = "usage: TlbImp [-tlb.id -tlb.major.version -tlb.minor.version] [-tlb.file] [-bind.mode vTable, dispId] [-output.dir]\n\noptions:\n-tlb.id               The guid of the type library.\n-tlb.major.version    The major version of the type library.\n-tlb.minor.version    The minor version of the type library.\n-tlb.file             The file name containing the type library.\n-bind.mode            The binding mode used to create the Java code.\n-output.dir           The optional output directory, default is the user temp directory.\n\nsamples:\nMicrosoft Shell Controls And Automation:\n-tlb.file shell32.dll\n-tlb.id {50A7E9B0-70EF-11D1-B75A-00A0C90564FE} -tlb.major.version 1 -tlb.minor.version 0\n\nMicrosoft Word 12.0 Object Library:\n-tlb.id {00020905-0000-0000-C000-000000000046} -tlb.major.version 8 -tlb.minor.version 4\n\n";
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
/* 115 */     System.out.println(str);
/* 116 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbCmdlineArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */