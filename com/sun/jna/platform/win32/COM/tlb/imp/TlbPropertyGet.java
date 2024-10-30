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
/*    */ public class TlbPropertyGet
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbPropertyGet(int paramInt1, int paramInt2, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 52 */     super(paramInt2, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 54 */     this.methodName = "get" + getMethodName();
/*    */     
/* 56 */     replaceVariable("helpstring", this.docStr);
/* 57 */     replaceVariable("returntype", this.returnType);
/* 58 */     replaceVariable("methodname", this.methodName);
/* 59 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 60 */     replaceVariable("memberid", String.valueOf(this.memberid));
/* 61 */     replaceVariable("functionCount", String.valueOf(paramInt1));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 71 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyGet.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbPropertyGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */