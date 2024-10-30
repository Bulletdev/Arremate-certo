/*     */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.TypeInfoUtil;
/*     */ import com.sun.jna.platform.win32.COM.TypeLibUtil;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.Variant;
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
/*     */ public class TlbEnum
/*     */   extends TlbBase
/*     */ {
/*     */   public TlbEnum(int paramInt, String paramString, TypeLibUtil paramTypeLibUtil) {
/*  52 */     super(paramInt, paramTypeLibUtil, null);
/*     */     
/*  54 */     TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(paramInt);
/*  55 */     String str = typeLibDoc.getDocString();
/*     */     
/*  57 */     if (typeLibDoc.getName().length() > 0) {
/*  58 */       this.name = typeLibDoc.getName();
/*     */     }
/*  60 */     logInfo("Type of kind 'Enum' found: " + this.name);
/*     */     
/*  62 */     createPackageName(paramString);
/*  63 */     createClassName(this.name);
/*  64 */     setFilename(this.name);
/*     */ 
/*     */     
/*  67 */     TypeInfoUtil typeInfoUtil = paramTypeLibUtil.getTypeInfoUtil(paramInt);
/*  68 */     OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
/*     */     
/*  70 */     createJavaDocHeader(tYPEATTR.guid.toGuidString(), str);
/*     */     
/*  72 */     int i = tYPEATTR.cVars.intValue();
/*  73 */     for (byte b = 0; b < i; b++) {
/*     */       
/*  75 */       OaIdl.VARDESC vARDESC = typeInfoUtil.getVarDesc(b);
/*  76 */       Variant.VARIANT.ByReference byReference = vARDESC._vardesc.lpvarValue;
/*  77 */       Object object = byReference.getValue();
/*     */ 
/*     */       
/*  80 */       OaIdl.MEMBERID mEMBERID = vARDESC.memid;
/*     */ 
/*     */       
/*  83 */       TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(mEMBERID);
/*  84 */       this.content += "\t\t//" + typeInfoDoc.getName() + "\n";
/*  85 */       this
/*  86 */         .content = this.content + "\t\tpublic static final int " + typeInfoDoc.getName() + " = " + object.toString() + ";";
/*     */       
/*  88 */       if (b < i - 1) {
/*  89 */         this.content += "\n";
/*     */       }
/*     */       
/*  92 */       typeInfoUtil.ReleaseVarDesc(vARDESC);
/*     */     } 
/*     */     
/*  95 */     createContent(this.content);
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
/*     */   protected void createJavaDocHeader(String paramString1, String paramString2) {
/* 107 */     replaceVariable("uuid", paramString1);
/* 108 */     replaceVariable("helpstring", paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassTemplate() {
/* 118 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbEnum.template";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */