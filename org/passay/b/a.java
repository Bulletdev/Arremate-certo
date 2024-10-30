/*    */ package org.passay.b;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import org.passay.B;
/*    */ import org.passay.F;
/*    */ import org.passay.v;
/*    */ import org.springframework.context.MessageSource;
/*    */ import org.springframework.context.NoSuchMessageException;
/*    */ import org.springframework.context.support.MessageSourceAccessor;
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
/*    */ public class a
/*    */   implements v
/*    */ {
/*    */   private final MessageSourceAccessor a;
/* 25 */   private final v b = (v)new B();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public a(MessageSource paramMessageSource) {
/* 33 */     this.a = new MessageSourceAccessor(paramMessageSource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public a(MessageSource paramMessageSource, Locale paramLocale) {
/* 43 */     this.a = new MessageSourceAccessor(paramMessageSource, paramLocale);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String a(F paramF) {
/*    */     try {
/* 56 */       return this.a.getMessage(paramF.getErrorCode(), paramF.h());
/* 57 */     } catch (NoSuchMessageException noSuchMessageException) {
/* 58 */       return this.b.a(paramF);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */