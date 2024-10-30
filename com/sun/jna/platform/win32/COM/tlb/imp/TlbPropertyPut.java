/*    */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.TypeInfoUtil;
/*    */ import com.sun.jna.platform.win32.COM.TypeLibUtil;
/*    */ import com.sun.jna.platform.win32.OaIdl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TlbPropertyPut
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbPropertyPut(int paramInt1, int paramInt2, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 53 */     super(paramInt2, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 55 */     this.methodName = "set" + getMethodName();
/* 56 */     String[] arrayOfString = paramTypeInfoUtil.getNames(paramFUNCDESC.memid, this.paramCount + 1);
/*    */     
/* 58 */     if (this.paramCount > 0) {
/* 59 */       this.methodvariables += ", ";
/*    */     }
/* 61 */     for (byte b = 0; b < this.paramCount; b++) {
/* 62 */       OaIdl.ELEMDESC eLEMDESC = paramFUNCDESC.lprgelemdescParam.elemDescArg[b];
/* 63 */       String str = getType(eLEMDESC);
/* 64 */       this
/* 65 */         .methodparams = this.methodparams + str + " " + replaceJavaKeyword(arrayOfString[b].toLowerCase());
/* 66 */       this.methodvariables += replaceJavaKeyword(arrayOfString[b].toLowerCase());
/*    */ 
/*    */       
/* 69 */       if (b < this.paramCount - 1) {
/* 70 */         this.methodparams += ", ";
/* 71 */         this.methodvariables += ", ";
/*    */       } 
/*    */     } 
/*    */     
/* 75 */     replaceVariable("helpstring", this.docStr);
/* 76 */     replaceVariable("methodname", this.methodName);
/* 77 */     replaceVariable("methodparams", this.methodparams);
/* 78 */     replaceVariable("methodvariables", this.methodvariables);
/* 79 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 80 */     replaceVariable("memberid", String.valueOf(this.memberid));
/* 81 */     replaceVariable("functionCount", String.valueOf(paramInt1));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 91 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyPut.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbPropertyPut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */