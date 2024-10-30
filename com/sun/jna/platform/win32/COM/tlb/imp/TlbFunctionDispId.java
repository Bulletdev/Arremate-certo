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
/*     */ public class TlbFunctionDispId
/*     */   extends TlbAbstractMethod
/*     */ {
/*     */   public TlbFunctionDispId(int paramInt1, int paramInt2, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/*  53 */     super(paramInt2, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*     */     
/*  55 */     String str, arrayOfString[] = paramTypeInfoUtil.getNames(paramFUNCDESC.memid, this.paramCount + 1);
/*     */     
/*  57 */     for (byte b = 0; b < this.paramCount; b++) {
/*  58 */       OaIdl.ELEMDESC eLEMDESC = paramFUNCDESC.lprgelemdescParam.elemDescArg[b];
/*  59 */       String str1 = arrayOfString[b + 1].toLowerCase();
/*  60 */       String str2 = getType(eLEMDESC.tdesc);
/*  61 */       String str3 = replaceJavaKeyword(str1);
/*  62 */       this.methodparams += str2 + " " + str3;
/*     */ 
/*     */       
/*  65 */       if (str2.equals("VARIANT")) {
/*  66 */         this.methodvariables += str3;
/*     */       } else {
/*  68 */         this.methodvariables += "new VARIANT(" + str3 + ")";
/*     */       } 
/*     */       
/*  71 */       if (b < this.paramCount - 1) {
/*  72 */         this.methodparams += ", ";
/*  73 */         this.methodvariables += ", ";
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  78 */     if (this.returnType.equalsIgnoreCase("VARIANT")) {
/*  79 */       str = "pResult";
/*     */     } else {
/*  81 */       str = "((" + this.returnType + ") pResult.getValue())";
/*     */     } 
/*  83 */     replaceVariable("helpstring", this.docStr);
/*  84 */     replaceVariable("returntype", this.returnType);
/*  85 */     replaceVariable("returnvalue", str);
/*  86 */     replaceVariable("methodname", this.methodName);
/*  87 */     replaceVariable("methodparams", this.methodparams);
/*  88 */     replaceVariable("methodvariables", this.methodvariables);
/*  89 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/*  90 */     replaceVariable("memberid", String.valueOf(this.memberid));
/*  91 */     replaceVariable("functionCount", String.valueOf(paramInt1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassTemplate() {
/* 101 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbFunctionDispId.template";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbFunctionDispId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */