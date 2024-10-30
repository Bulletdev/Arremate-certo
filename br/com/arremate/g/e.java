/*    */ package br.com.arremate.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */   extends Exception
/*    */ {
/*    */   public e(String paramString1, String paramString2, String paramString3) {
/* 10 */     super(String.join("", new CharSequence[] { "O seu último lance (", paramString3, ") para o item já se encontra dentro da margem de ", paramString1, "% | 1º colocado (", paramString2, ")" }));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\g\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */