/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import java.util.Date;
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
/*     */ public class COMLateBindingObject
/*     */   extends COMBindingBaseObject
/*     */ {
/*     */   public COMLateBindingObject(IDispatch paramIDispatch) {
/*  47 */     super(paramIDispatch);
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
/*     */   public COMLateBindingObject(Guid.CLSID paramCLSID, boolean paramBoolean) {
/*  59 */     super(paramCLSID, paramBoolean);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public COMLateBindingObject(String paramString, boolean paramBoolean) throws COMException {
/*  74 */     super(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IDispatch getAutomationProperty(String paramString) {
/*  85 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/*  86 */     oleMethod(2, byReference, paramString);
/*     */     
/*  88 */     return (IDispatch)byReference.getValue();
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
/*     */   
/*     */   protected IDispatch getAutomationProperty(String paramString, Variant.VARIANT paramVARIANT) {
/* 101 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 102 */     oleMethod(2, byReference, paramString, paramVARIANT);
/*     */     
/* 104 */     return (IDispatch)byReference.getValue();
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected IDispatch getAutomationProperty(String paramString, COMLateBindingObject paramCOMLateBindingObject) {
/* 120 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 121 */     oleMethod(2, byReference, paramString);
/*     */     
/* 123 */     return (IDispatch)byReference.getValue();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected IDispatch getAutomationProperty(String paramString, COMLateBindingObject paramCOMLateBindingObject, Variant.VARIANT paramVARIANT) {
/* 141 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 142 */     oleMethod(2, byReference, paramString, paramVARIANT);
/*     */     
/* 144 */     return (IDispatch)byReference.getValue();
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected IDispatch getAutomationProperty(String paramString, IDispatch paramIDispatch) {
/* 160 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 161 */     oleMethod(2, byReference, paramString);
/*     */     
/* 163 */     return (IDispatch)byReference.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean getBooleanProperty(String paramString) {
/* 174 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 175 */     oleMethod(2, byReference, paramString);
/*     */     
/* 177 */     return byReference.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Date getDateProperty(String paramString) {
/* 188 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 189 */     oleMethod(2, byReference, paramString);
/*     */     
/* 191 */     return byReference.dateValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getIntProperty(String paramString) {
/* 202 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 203 */     oleMethod(2, byReference, paramString);
/*     */     
/* 205 */     return byReference.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected short getShortProperty(String paramString) {
/* 216 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 217 */     oleMethod(2, byReference, paramString);
/*     */     
/* 219 */     return byReference.shortValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getStringProperty(String paramString) {
/* 230 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 231 */     oleMethod(2, byReference, paramString);
/*     */     
/* 233 */     String str = byReference.stringValue();
/*     */     
/* 235 */     OleAuto.INSTANCE.VariantClear((Variant.VARIANT)byReference);
/*     */     
/* 237 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString) {
/* 248 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 249 */     oleMethod(1, byReference, paramString);
/*     */     
/* 251 */     return (Variant.VARIANT)byReference;
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
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString, Variant.VARIANT paramVARIANT) {
/* 264 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 265 */     oleMethod(1, byReference, paramString, paramVARIANT);
/*     */     
/* 267 */     return (Variant.VARIANT)byReference;
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
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString, Variant.VARIANT[] paramArrayOfVARIANT) {
/* 280 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 281 */     oleMethod(1, byReference, paramString, paramArrayOfVARIANT);
/*     */     
/* 283 */     return (Variant.VARIANT)byReference;
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2) {
/* 298 */     return invoke(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2, Variant.VARIANT paramVARIANT3) {
/* 316 */     return invoke(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2, paramVARIANT3 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Variant.VARIANT invoke(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2, Variant.VARIANT paramVARIANT3, Variant.VARIANT paramVARIANT4) {
/* 336 */     return invoke(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2, paramVARIANT3, paramVARIANT4 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, IDispatch paramIDispatch) {
/* 344 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramIDispatch, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, COMLateBindingObject paramCOMLateBindingObject) {
/* 352 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramCOMLateBindingObject.getIDispatch(), paramString);
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
/*     */   
/*     */   protected void invokeNoReply(String paramString, Variant.VARIANT paramVARIANT) {
/* 365 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, IDispatch paramIDispatch, Variant.VARIANT paramVARIANT) {
/* 374 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramIDispatch, paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, IDispatch paramIDispatch, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2) {
/* 383 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramIDispatch, paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, COMLateBindingObject paramCOMLateBindingObject, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2) {
/* 393 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramCOMLateBindingObject.getIDispatch(), paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, COMLateBindingObject paramCOMLateBindingObject, Variant.VARIANT paramVARIANT) {
/* 403 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramCOMLateBindingObject.getIDispatch(), paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void invokeNoReply(String paramString, IDispatch paramIDispatch, Variant.VARIANT[] paramArrayOfVARIANT) {
/* 414 */     oleMethod(1, (Variant.VARIANT.ByReference)null, paramIDispatch, paramString, paramArrayOfVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void invokeNoReply(String paramString) {
/* 425 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 426 */     oleMethod(1, byReference, paramString);
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
/*     */   protected void invokeNoReply(String paramString, Variant.VARIANT[] paramArrayOfVARIANT) {
/* 438 */     Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
/* 439 */     oleMethod(1, byReference, paramString, paramArrayOfVARIANT);
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
/*     */ 
/*     */   
/*     */   protected void invokeNoReply(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2) {
/* 453 */     invokeNoReply(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void invokeNoReply(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2, Variant.VARIANT paramVARIANT3) {
/* 470 */     invokeNoReply(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2, paramVARIANT3 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void invokeNoReply(String paramString, Variant.VARIANT paramVARIANT1, Variant.VARIANT paramVARIANT2, Variant.VARIANT paramVARIANT3, Variant.VARIANT paramVARIANT4) {
/* 489 */     invokeNoReply(paramString, new Variant.VARIANT[] { paramVARIANT1, paramVARIANT2, paramVARIANT3, paramVARIANT4 });
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
/*     */   protected void setProperty(String paramString, boolean paramBoolean) {
/* 501 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramBoolean));
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
/*     */   protected void setProperty(String paramString, Date paramDate) {
/* 513 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramDate));
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
/*     */   protected void setProperty(String paramString, Dispatch paramDispatch) {
/* 525 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramDispatch));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void setProperty(String paramString, IDispatch paramIDispatch) {
/* 533 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramIDispatch));
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
/*     */   protected void setProperty(String paramString, int paramInt) {
/* 545 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramInt));
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
/*     */   protected void setProperty(String paramString, short paramShort) {
/* 557 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, new Variant.VARIANT(paramShort));
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
/*     */   protected void setProperty(String paramString1, String paramString2) {
/* 569 */     Variant.VARIANT vARIANT = new Variant.VARIANT(paramString2);
/*     */     try {
/* 571 */       oleMethod(4, (Variant.VARIANT.ByReference)null, paramString1, vARIANT);
/*     */     } finally {
/* 573 */       OleAuto.INSTANCE.VariantClear(vARIANT);
/*     */     } 
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
/*     */   protected void setProperty(String paramString, Variant.VARIANT paramVARIANT) {
/* 586 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void setProperty(String paramString, IDispatch paramIDispatch, Variant.VARIANT paramVARIANT) {
/* 595 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramIDispatch, paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void setProperty(String paramString, COMLateBindingObject paramCOMLateBindingObject, Variant.VARIANT paramVARIANT) {
/* 605 */     oleMethod(4, (Variant.VARIANT.ByReference)null, paramCOMLateBindingObject
/* 606 */         .getIDispatch(), paramString, paramVARIANT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Variant.VARIANT toVariant() {
/* 615 */     return new Variant.VARIANT(getIDispatch());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\COMLateBindingObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */