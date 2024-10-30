/*    */ package ch.qos.logback.core.pattern;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.regex.Pattern;
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
/*    */ public class ReplacingCompositeConverter<E>
/*    */   extends CompositeConverter<E>
/*    */ {
/*    */   Pattern pattern;
/*    */   String regex;
/*    */   String replacement;
/*    */   
/*    */   public void start() {
/* 26 */     List<String> list = getOptionList();
/* 27 */     if (list == null) {
/* 28 */       addError("at least two options are expected whereas you have declared none");
/*    */       
/*    */       return;
/*    */     } 
/* 32 */     int i = list.size();
/*    */     
/* 34 */     if (i < 2) {
/* 35 */       addError("at least two options are expected whereas you have declared only " + i + "as [" + list + "]");
/*    */       return;
/*    */     } 
/* 38 */     this.regex = list.get(0);
/* 39 */     this.pattern = Pattern.compile(this.regex);
/* 40 */     this.replacement = list.get(1);
/* 41 */     super.start();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String transform(E paramE, String paramString) {
/* 46 */     if (!this.started)
/* 47 */       return paramString; 
/* 48 */     return this.pattern.matcher(paramString).replaceAll(this.replacement);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\ReplacingCompositeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */