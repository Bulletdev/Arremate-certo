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
/*    */ public class TlbPropertyGetStub
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbPropertyGetStub(int paramInt, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 53 */     super(paramInt, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 55 */     TypeInfoUtil.TypeInfoDoc typeInfoDoc = paramTypeInfoUtil.getDocumentation(paramFUNCDESC.memid);
/* 56 */     String str1 = typeInfoDoc.getDocString();
/* 57 */     String str2 = "get" + typeInfoDoc.getName();
/*    */     
/* 59 */     replaceVariable("helpstring", str1);
/* 60 */     replaceVariable("returntype", this.returnType);
/* 61 */     replaceVariable("methodname", str2);
/* 62 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 63 */     replaceVariable("memberid", String.valueOf(this.memberid));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 73 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyGetStub.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbPropertyGetStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */