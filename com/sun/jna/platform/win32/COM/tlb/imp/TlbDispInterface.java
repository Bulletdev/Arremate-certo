/*     */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.TypeInfoUtil;
/*     */ import com.sun.jna.platform.win32.COM.TypeLibUtil;
/*     */ import com.sun.jna.platform.win32.OaIdl;
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
/*     */ public class TlbDispInterface
/*     */   extends TlbBase
/*     */ {
/*     */   public TlbDispInterface(int paramInt, String paramString, TypeLibUtil paramTypeLibUtil) {
/*  53 */     super(paramInt, paramTypeLibUtil, null);
/*     */     
/*  55 */     TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(paramInt);
/*  56 */     String str = typeLibDoc.getDocString();
/*     */     
/*  58 */     if (typeLibDoc.getName().length() > 0) {
/*  59 */       this.name = typeLibDoc.getName();
/*     */     }
/*  61 */     logInfo("Type of kind 'DispInterface' found: " + this.name);
/*     */     
/*  63 */     createPackageName(paramString);
/*  64 */     createClassName(this.name);
/*  65 */     setFilename(this.name);
/*     */ 
/*     */     
/*  68 */     TypeInfoUtil typeInfoUtil = paramTypeLibUtil.getTypeInfoUtil(paramInt);
/*  69 */     OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
/*     */     
/*  71 */     createJavaDocHeader(tYPEATTR.guid.toGuidString(), str);
/*     */     
/*  73 */     int i = tYPEATTR.cFuncs.intValue();
/*  74 */     for (byte b = 0; b < i; b++) {
/*     */       
/*  76 */       OaIdl.FUNCDESC fUNCDESC = typeInfoUtil.getFuncDesc(b);
/*     */ 
/*     */       
/*  79 */       OaIdl.MEMBERID mEMBERID = fUNCDESC.memid;
/*     */ 
/*     */       
/*  82 */       TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil.getDocumentation(mEMBERID);
/*  83 */       String str1 = typeInfoDoc.getName();
/*  84 */       TlbFunctionStub tlbFunctionStub = null;
/*     */       
/*  86 */       if (!isReservedMethod(str1)) {
/*  87 */         TlbPropertyPutStub tlbPropertyPutStub; if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
/*  88 */           tlbFunctionStub = new TlbFunctionStub(paramInt, paramTypeLibUtil, fUNCDESC, typeInfoUtil);
/*  89 */         } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
/*  90 */           TlbPropertyGetStub tlbPropertyGetStub = new TlbPropertyGetStub(paramInt, paramTypeLibUtil, fUNCDESC, typeInfoUtil);
/*  91 */         } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value) {
/*  92 */           tlbPropertyPutStub = new TlbPropertyPutStub(paramInt, paramTypeLibUtil, fUNCDESC, typeInfoUtil);
/*  93 */         } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) {
/*  94 */           tlbPropertyPutStub = new TlbPropertyPutStub(paramInt, paramTypeLibUtil, fUNCDESC, typeInfoUtil);
/*     */         } 
/*     */         
/*  97 */         this.content += tlbPropertyPutStub.getClassBuffer();
/*     */         
/*  99 */         if (b < i - 1) {
/* 100 */           this.content += "\n";
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 105 */       typeInfoUtil.ReleaseFuncDesc(fUNCDESC);
/*     */     } 
/*     */     
/* 108 */     createContent(this.content);
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
/* 120 */     replaceVariable("uuid", paramString1);
/* 121 */     replaceVariable("helpstring", paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassTemplate() {
/* 131 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbDispInterface.template";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbDispInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */