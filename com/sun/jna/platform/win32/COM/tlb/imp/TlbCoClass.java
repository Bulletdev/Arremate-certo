/*     */ package com.sun.jna.platform.win32.COM.tlb.imp;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.ITypeInfo;
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
/*     */ public class TlbCoClass
/*     */   extends TlbBase
/*     */ {
/*     */   public TlbCoClass(int paramInt, String paramString1, TypeLibUtil paramTypeLibUtil, String paramString2) {
/*  54 */     super(paramInt, paramTypeLibUtil, null);
/*     */     
/*  56 */     TypeInfoUtil typeInfoUtil = paramTypeLibUtil.getTypeInfoUtil(paramInt);
/*     */     
/*  58 */     TypeLibUtil.TypeLibDoc typeLibDoc = this.typeLibUtil.getDocumentation(paramInt);
/*  59 */     String str1 = typeLibDoc.getDocString();
/*     */     
/*  61 */     if (typeLibDoc.getName().length() > 0) {
/*  62 */       this.name = typeLibDoc.getName();
/*     */     }
/*  64 */     logInfo("Type of kind 'CoClass' found: " + this.name);
/*     */     
/*  66 */     createPackageName(paramString1);
/*  67 */     createClassName(this.name);
/*  68 */     setFilename(this.name);
/*     */     
/*  70 */     String str2 = (this.typeLibUtil.getLibAttr()).guid.toGuidString();
/*  71 */     int i = (this.typeLibUtil.getLibAttr()).wMajorVerNum.intValue();
/*  72 */     int j = (this.typeLibUtil.getLibAttr()).wMinorVerNum.intValue();
/*  73 */     String str3 = i + "." + j;
/*  74 */     String str4 = (typeInfoUtil.getTypeAttr()).guid.toGuidString();
/*     */     
/*  76 */     createJavaDocHeader(str2, str3, str1);
/*  77 */     createCLSID(str4);
/*  78 */     createCLSIDName(this.name);
/*     */ 
/*     */     
/*  81 */     OaIdl.TYPEATTR tYPEATTR = typeInfoUtil.getTypeAttr();
/*  82 */     int k = tYPEATTR.cImplTypes.intValue();
/*  83 */     String str5 = "";
/*     */     
/*  85 */     for (byte b = 0; b < k; b++) {
/*  86 */       OaIdl.HREFTYPE hREFTYPE = typeInfoUtil.getRefTypeOfImplType(b);
/*     */       
/*  88 */       ITypeInfo iTypeInfo = typeInfoUtil.getRefTypeInfo(hREFTYPE);
/*  89 */       TypeInfoUtil typeInfoUtil1 = new TypeInfoUtil(iTypeInfo);
/*  90 */       createFunctions(typeInfoUtil1, paramString2);
/*     */       
/*  92 */       TypeInfoUtil.TypeInfoDoc typeInfoDoc = typeInfoUtil1.getDocumentation(new OaIdl.MEMBERID(-1));
/*  93 */       str5 = str5 + typeInfoDoc.getName();
/*     */       
/*  95 */       if (b < k - 1) {
/*  96 */         str5 = str5 + ", ";
/*     */       }
/*     */     } 
/*  99 */     createInterfaces(str5);
/* 100 */     createContent(this.content);
/*     */   }
/*     */   
/*     */   protected void createFunctions(TypeInfoUtil paramTypeInfoUtil, String paramString) {
/* 104 */     OaIdl.TYPEATTR tYPEATTR = paramTypeInfoUtil.getTypeAttr();
/* 105 */     int i = tYPEATTR.cFuncs.intValue();
/* 106 */     for (byte b = 0; b < i; b++) {
/*     */       TlbPropertyPut tlbPropertyPut;
/* 108 */       OaIdl.FUNCDESC fUNCDESC = paramTypeInfoUtil.getFuncDesc(b);
/*     */       
/* 110 */       TlbFunctionVTable tlbFunctionVTable = null;
/* 111 */       if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_FUNC.value) {
/* 112 */         if (isVTableMode()) {
/* 113 */           tlbFunctionVTable = new TlbFunctionVTable(b, this.index, this.typeLibUtil, fUNCDESC, paramTypeInfoUtil);
/*     */         } else {
/* 115 */           TlbFunctionDispId tlbFunctionDispId = new TlbFunctionDispId(b, this.index, this.typeLibUtil, fUNCDESC, paramTypeInfoUtil);
/*     */         } 
/* 117 */       } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYGET.value) {
/* 118 */         TlbPropertyGet tlbPropertyGet = new TlbPropertyGet(b, this.index, this.typeLibUtil, fUNCDESC, paramTypeInfoUtil);
/* 119 */       } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUT.value) {
/* 120 */         tlbPropertyPut = new TlbPropertyPut(b, this.index, this.typeLibUtil, fUNCDESC, paramTypeInfoUtil);
/* 121 */       } else if (fUNCDESC.invkind.value == OaIdl.INVOKEKIND.INVOKE_PROPERTYPUTREF.value) {
/* 122 */         tlbPropertyPut = new TlbPropertyPut(b, this.index, this.typeLibUtil, fUNCDESC, paramTypeInfoUtil);
/*     */       } 
/*     */       
/* 125 */       if (!isReservedMethod(tlbPropertyPut.getMethodName())) {
/*     */         
/* 127 */         this.content += tlbPropertyPut.getClassBuffer();
/*     */         
/* 129 */         if (b < i - 1) {
/* 130 */           this.content += "\n";
/*     */         }
/*     */       } 
/*     */       
/* 134 */       paramTypeInfoUtil.ReleaseFuncDesc(fUNCDESC);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void createJavaDocHeader(String paramString1, String paramString2, String paramString3) {
/* 140 */     replaceVariable("uuid", paramString1);
/* 141 */     replaceVariable("version", paramString2);
/* 142 */     replaceVariable("helpstring", paramString3);
/*     */   }
/*     */   
/*     */   protected void createCLSIDName(String paramString) {
/* 146 */     replaceVariable("clsidname", paramString.toUpperCase());
/*     */   }
/*     */   
/*     */   protected void createCLSID(String paramString) {
/* 150 */     replaceVariable("clsid", paramString);
/*     */   }
/*     */   
/*     */   protected void createInterfaces(String paramString) {
/* 154 */     replaceVariable("interfaces", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getClassTemplate() {
/* 164 */     return "com/sun/jna/platform/win32/COM/tlb/imp/TlbCoClass.template";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\tlb\imp\TlbCoClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */