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
/*    */ 
/*    */ public class TlbPropertyPutStub
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbPropertyPutStub(int paramInt, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 54 */     super(paramInt, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 56 */     TypeInfoUtil.TypeInfoDoc typeInfoDoc = paramTypeInfoUtil.getDocumentation(paramFUNCDESC.memid);
/* 57 */     String str1 = typeInfoDoc.getDocString();
/* 58 */     String str2 = "set" + typeInfoDoc.getName();
/* 59 */     String[] arrayOfString = paramTypeInfoUtil.getNames(paramFUNCDESC.memid, this.paramCount + 1);
/*    */     
/* 61 */     for (byte b = 0; b < this.paramCount; b++) {
/* 62 */       OaIdl.ELEMDESC eLEMDESC = paramFUNCDESC.lprgelemdescParam.elemDescArg[b];
/* 63 */       String str = getType(eLEMDESC);
/* 64 */       this
/* 65 */         .methodparams = this.methodparams + str + " " + replaceJavaKeyword(arrayOfString[b].toLowerCase());
/*    */ 
/*    */       
/* 68 */       if (b < this.paramCount - 1) {
/* 69 */         this.methodparams += ", ";
/*    */       }
/*    */     } 
/*    */     
/* 73 */     replaceVariable("helpstring", str1);
/* 74 */     replaceVariable("methodname", str2);
/* 75 */     replaceVariable("methodparams", this.methodparams);
/* 76 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 77 */     replaceVariable("memberid", String.valueOf(this.memberid));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 87 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbPropertyPutStub.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbPropertyPutStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */