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
/*    */ public class TlbFunctionVTable
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbFunctionVTable(int paramInt1, int paramInt2, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 53 */     super(paramInt2, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 55 */     String[] arrayOfString = paramTypeInfoUtil.getNames(paramFUNCDESC.memid, this.paramCount + 1);
/*    */ 
/*    */     
/* 58 */     if (this.paramCount > 0) {
/* 59 */       this.methodvariables = ", ";
/*    */     }
/* 61 */     for (byte b = 0; b < this.paramCount; b++) {
/* 62 */       OaIdl.ELEMDESC eLEMDESC = paramFUNCDESC.lprgelemdescParam.elemDescArg[b];
/* 63 */       String str = arrayOfString[b + 1].toLowerCase();
/* 64 */       this
/* 65 */         .methodparams = this.methodparams + getType(eLEMDESC.tdesc) + " " + replaceJavaKeyword(str);
/* 66 */       this.methodvariables += str;
/*    */ 
/*    */       
/* 69 */       if (b < this.paramCount - 1) {
/* 70 */         this.methodparams += ", ";
/* 71 */         this.methodvariables += ", ";
/*    */       } 
/*    */     } 
/*    */     
/* 75 */     replaceVariable("helpstring", this.docStr);
/* 76 */     replaceVariable("returntype", this.returnType);
/* 77 */     replaceVariable("methodname", this.methodName);
/* 78 */     replaceVariable("methodparams", this.methodparams);
/* 79 */     replaceVariable("methodvariables", this.methodvariables);
/* 80 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 81 */     replaceVariable("memberid", String.valueOf(this.memberid));
/* 82 */     replaceVariable("functionCount", String.valueOf(paramInt1));
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 87 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbFunctionVTable.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbFunctionVTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */