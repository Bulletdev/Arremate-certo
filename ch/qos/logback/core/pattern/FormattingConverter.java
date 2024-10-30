/*    */ package ch.qos.logback.core.pattern;
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
/*    */ public abstract class FormattingConverter<E>
/*    */   extends Converter<E>
/*    */ {
/*    */   static final int INITIAL_BUF_SIZE = 256;
/*    */   static final int MAX_CAPACITY = 1024;
/*    */   FormatInfo formattingInfo;
/*    */   
/*    */   public final FormatInfo getFormattingInfo() {
/* 24 */     return this.formattingInfo;
/*    */   }
/*    */   
/*    */   public final void setFormattingInfo(FormatInfo paramFormatInfo) {
/* 28 */     if (this.formattingInfo != null) {
/* 29 */       throw new IllegalStateException("FormattingInfo has been already set");
/*    */     }
/* 31 */     this.formattingInfo = paramFormatInfo;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void write(StringBuilder paramStringBuilder, E paramE) {
/* 36 */     String str = convert(paramE);
/*    */     
/* 38 */     if (this.formattingInfo == null) {
/* 39 */       paramStringBuilder.append(str);
/*    */       
/*    */       return;
/*    */     } 
/* 43 */     int i = this.formattingInfo.getMin();
/* 44 */     int j = this.formattingInfo.getMax();
/*    */     
/* 46 */     if (str == null) {
/* 47 */       if (0 < i) {
/* 48 */         SpacePadder.spacePad(paramStringBuilder, i);
/*    */       }
/*    */       return;
/*    */     } 
/* 52 */     int k = str.length();
/*    */     
/* 54 */     if (k > j) {
/* 55 */       if (this.formattingInfo.isLeftTruncate()) {
/* 56 */         paramStringBuilder.append(str.substring(k - j));
/*    */       } else {
/* 58 */         paramStringBuilder.append(str.substring(0, j));
/*    */       } 
/* 60 */     } else if (k < i) {
/* 61 */       if (this.formattingInfo.isLeftPad()) {
/* 62 */         SpacePadder.leftPad(paramStringBuilder, str, i);
/*    */       } else {
/* 64 */         SpacePadder.rightPad(paramStringBuilder, str, i);
/*    */       } 
/*    */     } else {
/* 67 */       paramStringBuilder.append(str);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\FormattingConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */