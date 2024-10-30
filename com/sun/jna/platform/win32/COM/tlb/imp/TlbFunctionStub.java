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
/*    */ public class TlbFunctionStub
/*    */   extends TlbAbstractMethod
/*    */ {
/*    */   public TlbFunctionStub(int paramInt, TypeLibUtil paramTypeLibUtil, OaIdl.FUNCDESC paramFUNCDESC, TypeInfoUtil paramTypeInfoUtil) {
/* 54 */     super(paramInt, paramTypeLibUtil, paramFUNCDESC, paramTypeInfoUtil);
/*    */     
/* 56 */     TypeInfoUtil.TypeInfoDoc typeInfoDoc = paramTypeInfoUtil.getDocumentation(paramFUNCDESC.memid);
/* 57 */     String str1 = typeInfoDoc.getName();
/* 58 */     String str2 = typeInfoDoc.getDocString();
/* 59 */     String[] arrayOfString = paramTypeInfoUtil.getNames(paramFUNCDESC.memid, this.paramCount + 1);
/*    */ 
/*    */     
/* 62 */     if (this.paramCount > 0) {
/* 63 */       this.methodvariables = ", ";
/*    */     }
/* 65 */     for (byte b = 0; b < this.paramCount; b++) {
/* 66 */       OaIdl.ELEMDESC eLEMDESC = paramFUNCDESC.lprgelemdescParam.elemDescArg[b];
/* 67 */       String str = arrayOfString[b + 1].toLowerCase();
/* 68 */       this
/* 69 */         .methodparams = this.methodparams + getType(eLEMDESC.tdesc) + " " + replaceJavaKeyword(str);
/* 70 */       this.methodvariables += str;
/*    */ 
/*    */       
/* 73 */       if (b < this.paramCount - 1) {
/* 74 */         this.methodparams += ", ";
/* 75 */         this.methodvariables += ", ";
/*    */       } 
/*    */     } 
/*    */     
/* 79 */     replaceVariable("helpstring", str2);
/* 80 */     replaceVariable("returntype", this.returnType);
/* 81 */     replaceVariable("methodname", str1);
/* 82 */     replaceVariable("methodparams", this.methodparams);
/* 83 */     replaceVariable("vtableid", String.valueOf(this.vtableId));
/* 84 */     replaceVariable("memberid", String.valueOf(this.memberid));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getClassTemplate() {
/* 94 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbFunctionStub.template";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbFunctionStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */