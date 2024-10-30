/*    */ package br.com.arremate.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends Exception
/*    */ {
/*    */   public a(String paramString1, String paramString2, String paramString3) {
/* 10 */     super(String.join("", new CharSequence[] { "O ", paramString1, "º colocado (", paramString3, ") já está fora da margem de 10% em relação ao primeiro colocado. | 1º colocado (", paramString2, ")" }));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */