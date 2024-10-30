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
/*    */ public class SpacePadder
/*    */ {
/* 18 */   static final String[] SPACES = new String[] { " ", "  ", "    ", "        ", "                ", "                                " };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final void leftPad(StringBuilder paramStringBuilder, String paramString, int paramInt) {
/* 24 */     int i = 0;
/* 25 */     if (paramString != null) {
/* 26 */       i = paramString.length();
/*    */     }
/* 28 */     if (i < paramInt) {
/* 29 */       spacePad(paramStringBuilder, paramInt - i);
/*    */     }
/* 31 */     if (paramString != null) {
/* 32 */       paramStringBuilder.append(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static final void rightPad(StringBuilder paramStringBuilder, String paramString, int paramInt) {
/* 37 */     int i = 0;
/* 38 */     if (paramString != null) {
/* 39 */       i = paramString.length();
/*    */     }
/* 41 */     if (paramString != null) {
/* 42 */       paramStringBuilder.append(paramString);
/*    */     }
/* 44 */     if (i < paramInt) {
/* 45 */       spacePad(paramStringBuilder, paramInt - i);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static final void spacePad(StringBuilder paramStringBuilder, int paramInt) {
/* 53 */     while (paramInt >= 32) {
/* 54 */       paramStringBuilder.append(SPACES[5]);
/* 55 */       paramInt -= 32;
/*    */     } 
/*    */     
/* 58 */     for (byte b = 4; b >= 0; b--) {
/* 59 */       if ((paramInt & 1 << b) != 0)
/* 60 */         paramStringBuilder.append(SPACES[b]); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\SpacePadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */